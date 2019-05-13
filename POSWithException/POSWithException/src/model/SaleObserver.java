package model;
/**
 * A listener interface for receiving notifications about some information in sale.
 * any class that needs this information implements this class and becomes notified.
 * @author sadeq
 *
 */
public interface SaleObserver {
	public void newTotalPrice(Amount totalPrice);
}
