package POS.DTOs;

import model.Amount;

/**
 * 
 * @author Sadeq
 *contains information about one item
 */
public class ItemDTO {
	private String name ;
	private Amount price;
	private double vatRate;
	private String itemIdentifier;
	private int itemQuantity;
	
	/**
	 * creates a new instans representing a new item; 
	 * @param  name      		the name of an item
	 * @param  price     		the price of an item
	 * @param  vatRate 	 		the rate of VAT in percent for every item
	 * @param  itemIdentifier 	the identification of an item  
	 */
	public ItemDTO(String name, Amount price, double vatRate, String itemIdentifier) {
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * returns the name of an item 
	 *@return the name of an item  
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * returns the price of an item 
	 *@return the name of an item  
	 */
	public Amount getPrice() {
		return this.price;
	}
	
	/**
	 * returns the VAT Rate of an item 
	 *@return the VAT rate of an item  
	 */
	public double getVateRate() {
		return this.vatRate;
	}
	
	/**
	 * returns the identification of an item 
	 *@return the identification of an item  
	 */
	public String  getItemIdentifier() {
		return this.itemIdentifier;
	}
	/**
	 * sets the number of items that should be added to a sale
	 * @param itemQuantity the number of items to be added
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemQuantity() {
		return this.itemQuantity;
	}
}
