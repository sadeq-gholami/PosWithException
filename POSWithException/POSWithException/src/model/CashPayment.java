package model;
import POS.DTOs.*;
/**
* Represents one specific payment for one specific sale.
* The sale is payed with cash.
*/
public class CashPayment {
	private Amount amtPaid;
	/**
	* Creates a new instance. The customer handed over
	* the specified amount.
	*
	* @param amtPaid The amount of cash that was handed
	* over by the customer.
	*/
	public CashPayment(Amount amtPaid) {
		this.amtPaid = amtPaid;
	}
}