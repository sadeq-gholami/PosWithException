package model;
//import se.kth.iv1500.POS.DTOs.SaleDTO;
//import se.kth.iv1500.POS.DTOs.ItemDTO;
import POS.DTOs.*;
import java.time.LocalDateTime;

/**
 *The receipt of a Sale
 */
public class Receipt {
	private final SaleDTO saleInfo;
	private int VATForEntireSale;
	//private StoreDTO storeInfo;
	
	/**
	* Creates a new instance.
	*
	* @param saleInfo The sale proved by this receipt.
	*/
	public Receipt(SaleDTO saleInfo) {
		this.saleInfo = saleInfo;
	}
	
	 /**
	 * Creates a well-formatted string with the entire content
	 * of the receipt.
	 *
	 * @return The well-formatted receipt string.
	 */
	 public String createReceiptString() {
		 StringBuilder builder = new StringBuilder();
		 appendLine(builder, "Sale Receipt");
		 endSection(builder);
	
		 LocalDateTime saleTime = LocalDateTime.now();
		 builder.append("Sale time: ");
		 appendLine(builder, saleTime.toString());
		 endSection(builder);
		 
		 for(ItemDTO next : saleInfo.getItemInfo()) {
			 builder.append("Bought item: ");
			 appendLine(builder, next.getName());
			 builder.append("Price: ");
			 appendLine(builder, next.getPrice().toString());
			 endSection(builder);
			 builder.append("Quantity: ");
			 appendLine(builder, next.getItemQuantity() + " ");
			 endSection(builder);
			 VATForEntireSale(next);
		 }
		 
		 builder.append("Total price: ");
		 appendLine(builder, saleInfo.getRunningTotal().toString());
		 endSection(builder);
		 
		 builder.append("Total price after discount: ");
		 Amount totalPriceAfterDiscount = saleInfo.getTotalPriceAfterDiscount();
		 appendLine(builder, totalPriceAfterDiscount.toString());
		 endSection(builder);
		 
		 builder.append("VAT for Entire Sale: ");
		 appendLine(builder, new Amount(VATForEntireSale, "kr").toString());
		 endSection(builder);
		 
		 builder.append("Amount paid: ");
		 appendLine(builder, calculateAmountPaid(saleInfo).toString());
		 endSection(builder);
		 
		 builder.append("Change: ");
		 appendLine(builder, saleInfo.getChange().toString());
		 endSection(builder);
		 
		 return builder.toString();
	 }
		 
		 private void appendLine(StringBuilder builder, String line) {
			 builder.append(line);
			 builder.append("\n");
		 }
			
		 private void endSection(StringBuilder builder) {
			 builder.append("\n");
		 }
		 
		 private Amount calculateAmountPaid(SaleDTO saleInfo) {
			 int change = saleInfo.getChange().getAmount();
			 int totalPriceafterDiscount = saleInfo.getTotalPriceAfterDiscount().getAmount();
			 int amountPaid = change + totalPriceafterDiscount;
			 return new Amount(amountPaid, "kr");
		 }
		 
		 private double vatForItem(ItemDTO item) {
			 Amount priceOfItem = item.getPrice();
		   	 int quantityOfItem = item.getItemQuantity();
			 int amountOfPrice = priceOfItem.getAmount();
		   	 double vatRate = item.getVateRate();
			 double VATForItem = quantityOfItem*(amountOfPrice * vatRate);
			 return VATForItem;
		 }
		 
		 private void VATForEntireSale(ItemDTO item) {
			double itemVat = vatForItem(item);
			VATForEntireSale += itemVat; 
		 }
}