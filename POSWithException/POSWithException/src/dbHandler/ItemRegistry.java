package dbHandler;
import POS.DTOs.*;
import model.Amount;

import java.util.ArrayList;
import java.util.List;
public class ItemRegistry {
	private List<ItemDTO> items = new ArrayList<>();
	
	private final Amount MILKPRICE = new Amount (10,"kr");
	private final Amount COCACOLAPRICE = new Amount (15,"kr");
	private final Amount BREADPRICE = new Amount (30,"kr");
	private final double VAT10PERCENT = 0.1;
	private final double VAT15PERCENT = 0.15;
	private final double VAT20PERCENT = 0.2;
	private final String MILKITEMIDENTIFIER = "123456789";
	private final String COCACOLAITEMIDENTIFIER = "987654321";
	private final String BREADITEMIDENTIFIER = "123654789";
	
	
	/**
	 * Creates an instance of Item registry
	 */
	public ItemRegistry(){
		addItem();
	}
	/**
	 * checks if an item with the scanned identification is in the data base
	 * @param itemIdentifier   the identification of an item 
	 * @return  an object of  <code >itemDTO</code> if there is an item with the same identification else <code>null</code>
	 * @throws ItemRegistryException Thrown when something goes wrong searching in database. Here while searching for a particular
     *  hardcoded, item identifier "12345"
	 */
	public ItemDTO findItem(String itemIdentifier) throws ItemRegistryException {			
		if (itemIdentifier.equals("12345")) {
			throw new ItemRegistryException ("Anable to perform matching"); 
		}
		
		ItemDTO itemInfo = null;
		for (ItemDTO item : items) {
			if (item.getItemIdentifier().equals(itemIdentifier)) {
				itemInfo =  item;
			}
		}
		return itemInfo;
	}
	
	private void addItem() {
		items.add(new ItemDTO("milk", MILKPRICE, VAT10PERCENT, MILKITEMIDENTIFIER));
		items.add(new ItemDTO("cocacola", COCACOLAPRICE,VAT15PERCENT, COCACOLAITEMIDENTIFIER));
		items.add(new ItemDTO("bread", BREADPRICE, VAT20PERCENT, BREADITEMIDENTIFIER));
		
		
	}
}
