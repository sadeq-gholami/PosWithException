/**
 * 
 */
package controller;

import model.*;
import POS.DTOs.*;
import dbHandler.*;

public class Controller {
	    private Sale sale;
	    private ExternalSystemGenerator extSys;
	    private CashRegister cashRegister;
	    private RegistryCreator regCreator;
	   /**
	    * Creates an instance of Controller which connects all the calls from view to classes in model and
	    * classes in integration layer
	    * @param regCreator		a reference to object <code>registryCreator</code> 
	    * @param extSys			a reference to object <code>ExternalSystemGenerator</code>
	    * @param cashRegister	a reference to object <code>CashRegister</code>
	    */
	    public Controller(RegistryCreator regCreator, ExternalSystemGenerator extSys, CashRegister cashRegister) {
	    	this.cashRegister = cashRegister;
	    	this.extSys = extSys;
	    	this.regCreator = regCreator;
	    }
	    
	    /**
	     * Starts a new sale by making an instance of Sale object.
	     * @return a reference to object of class Sale
	     */
	    public Sale startNewSale() {
	        this.sale = new Sale();
	        return this.sale;
	    }
	   
	    
	    /**
	     * adds an item to the current sale
	     * @param itemIdentifier   the identification of an item
	     * @param itemQuantity     the number of items 
	     * @return returns an object of type <code>SaleDTO</code>which contains information about the price of an item, VAT rate and running total
	     * @throws InvalidItemIdentifierException Thrown when trying to add an item with invalid identifier 
	     * @throws OperationFaliureException thrown when an operation is failed
	     */
	    public SaleDTO addItem(String itemIdentifier, int itemQuantity)throws InvalidItemIdentifierException, OperationFaliureException {
	    	ItemRegistry itemRegistry =  regCreator.getItemRegistry();
	    	try {
	    		ItemDTO itemInfo = itemRegistry.findItem(itemIdentifier);
	    		if (itemInfo !=null) {
	    			itemInfo.setItemQuantity(itemQuantity);
	    			return this.sale.addItem(itemInfo);
	    		}
	    		throw new InvalidItemIdentifierException(itemIdentifier);
	    	}
	    	catch (ItemRegistryException exc) {
	    		throw new OperationFaliureException("unable to add item, try again", exc);
	    	}
	    }
	    /**
	     * adds an sale observer among the observer list of the sale 
	     * which will be notified with the total price when a pay
	     * operation has been handled
	     * @param obs the observer that should be added
	     */
	    public void addSaleObserver(SaleObserver obs) {
	    	this.sale.addSaleObserver(obs);
	    }
	    
	    /**
	     * Starts a discount request in current sale
	     * @param CustomerID is a string that represent the Customer identification
	     * @return the object Amount and contains the total price
	     */
	    public Amount discountRequest(String CustomerID){
	    	CustomerRegistry customerRegistry = regCreator.getCustomerRegistry();
	        Amount totalPriceAfterDiscount = sale.countDiscount(CustomerID, customerRegistry);
	    	return totalPriceAfterDiscount;
		}
	    
	     
	    /**
	     * Handles sale payment. Updates the cash register here
	     * the payment was performed and records the payment.
	     * Calculates change. Prints the receipt.
	     * @param amtPaid the amount paid
	     * @return the amount of change for customer to recieve
	     */
	    public Amount pay(Amount amtPaid) {
	    	Amount change = sale.countPayment(amtPaid);
	    	CashPayment payment = new CashPayment(amtPaid);
	    	cashRegister.recordPayment(payment);
	    	Printer printer = extSys.getPrinter();
	    	sale.printReceipt(printer);
	    	return change;
	    }
}
