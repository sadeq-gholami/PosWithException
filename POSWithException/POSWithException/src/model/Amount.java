package model;
/**
 * 
 * @author Sadeq
 *The class shows amount which contains the amount of money and the currency 
 */
public class Amount {
	private String currency;
	private int amount;
	/**
	 * creates an instance of Amount
	 * @param amount    the amount of money
	 * @param currency  the currency for money
	 */
	public Amount (int amount, String currency) {
		this.currency = currency;
		this.amount =  amount;
	}
	/**
	 * returns the amount of money
	 * @return amount of money
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * Performs subtraction on specified amount objects
	 * @param TermToSubtractWith the term that is the subtractor
	 * @return Difference after the subtraction operation
	 */
	public int amountSubtraction(Amount TermToSubtractWith) {
		int diff = this.amount - TermToSubtractWith.amount;
		return diff;
	}
	
	public String toString() {
		return this.amount + " " + this.currency;
	}
	
	/**
	 * returns currency 
	 * @return
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
}
