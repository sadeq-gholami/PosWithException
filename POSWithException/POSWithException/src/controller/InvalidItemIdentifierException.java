package controller;
/**
 * 
 * @author sadeq
 *Thrown when trying to add an item with invalid identifier
 */
public class InvalidItemIdentifierException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1434758175423563758L;
	private String invalidIdentifier;
	/**
	 * creates an instance with a message that item with specified 
	 * identifier is not valid
	 * @param invalidIdentifier the item identifier that does not exist
	 */
	public InvalidItemIdentifierException(String invalidIdentifier) {
		super("the item with the identifer: "+
				invalidIdentifier + " does not exist");
		this.invalidIdentifier = invalidIdentifier;
	}
	/**
	 * 
	 * @return the item identifier that does not exist
	 */
	public String getInvalidIdentifer() {
		return this.invalidIdentifier;
	}


}
