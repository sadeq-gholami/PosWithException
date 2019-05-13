package dbHandler;
import model.Receipt;
/**
* The interface to the printer, used for all printouts
* initiated by this program.
*/
public class Printer {
	Printer(){
	}
	/**
	* Prints the specified receipt. This dummy implementation
	* prints to <code>System.out</code> instead of a printer.
	* @param receipt  the receipt of the current sale to be printed
	*/
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt.createReceiptString());
	}
}