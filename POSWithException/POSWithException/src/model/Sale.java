package model;
import POS.DTOs.*;
import dbHandler.*;
import java.util.ArrayList;
import java.util.List;
public class Sale {
	private Amount runningTotal = new Amount(0,"kr");
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
	private Amount totalPriceAfterDiscount = new Amount (0, "kr");
	private SaleDTO saleInfo;
	
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
	/**
	 * Creates an instance of sale
	 */
	public Sale() {
		
	}
	/**
	 * adds a new observer to the list of sale observers which will be notified with total amount 
	 * when pay operation was handled. 
	 * @param saleObservers the observer that should be added to the list of sale observers
	 */
	public void addSaleObserver(SaleObserver saleObservers) {
		this.saleObservers.add(saleObservers);
	}
	
	private void notifyObservers(Amount totalPrice) {
		for(SaleObserver observer : this.saleObservers) {
			observer.newTotalPrice(totalPrice);
		}
	}
	
	/**
	 * adds an new item to the current sale, updates the running total including the VAT
	 * @param itemInfo an instance of <code>ItemDTO</code> that contains information about an item
	 * @return an instance of <code>SaleDTO</code> that contains information about current sale
	 */
	public SaleDTO addItem(ItemDTO itemInfo) {
		this.itemsInCurrentSale.add(itemInfo);
		int quantity = itemInfo.getItemQuantity();
		updateRunningTotal(itemInfo, quantity);
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		return saleInfo;
	}
	private void updateRunningTotal(ItemDTO itemInfo, int quantity) {
		Amount priceAfterVat = this.countItemPriceIncludinVAT(itemInfo);
		int amountOfPriceAfterVat = priceAfterVat.getAmount();
		int amountToUpdateRunningTotal = quantity *amountOfPriceAfterVat;
		this.runningTotal.addAmount(amountToUpdateRunningTotal);
	}
	private Amount countItemPriceIncludinVAT(ItemDTO itemInfo) {
		Amount priceOfItem = itemInfo.getPrice();
		int amountOfPrice = priceOfItem.getAmount();
		double vatRate = itemInfo.getVateRate();
		double priceIncludingVAT = amountOfPrice +(amountOfPrice * vatRate);
		int roundedPriceAfterVat = (int) Math.round(priceIncludingVAT);
		return new Amount(roundedPriceAfterVat,"kr");
	}
	/**
	 * Checks if the customer is a member or not and subtracts the amount discount from the total price   
	 * @param customerID A CustomerID as String that represent the customer identification
	 * @param customerRegistry Is a database where Customers are saved
	 * @return Amount Total price after discount. 
	 */
	public Amount countDiscount(String customerID,CustomerRegistry customerRegistry){
		DiscountRules discountRules = new DiscountRules();
		Amount totalAmount = this.runningTotal;
		double countedDiscount = totalAmount.getAmount();
		if(customerRegistry.isEligible(customerID)){
			countedDiscount = countedDiscount * (1- discountRules.discountRateMember(this.saleInfo));
		}
		else{
			countedDiscount = countedDiscount * (1 - discountRules.discountRateNotMember(this.saleInfo));
		}
		int roundedPriceAfterDiscount = (int) Math.round(countedDiscount);
		this.totalPriceAfterDiscount.addAmount(roundedPriceAfterDiscount);
		return this.totalPriceAfterDiscount;
	}
	
	/**
	 * calculates the change amount to return to a customer.
	 * And creates an instance of <code>SaleDTO</code> that contains information about current sale,
	 * including the change amount and notifies observer with the total price
	 * @param amountPaid by the customer
	 * @return returns the change amount
	 */
	public Amount countPayment(Amount amountPaid) {
		int amountInChange = amountPaid.amountSubtraction(this.totalPriceAfterDiscount);
		change = new Amount(amountInChange, "kr");
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		
		notifyObservers(this.runningTotal);
		return change;
	}
	
	/**
	* Prints a receipt for the current sale on the
	* specified printer.
	*  @param printer an instance of class printer 
	*/
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(saleInfo);
		printer.printReceipt(receipt);
	}
}
	
