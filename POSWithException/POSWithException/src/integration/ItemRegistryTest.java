package dbHandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import POS.DTOs.*;
class ItemRegistryTest {

	@Test
	void testFindItem() throws ItemRegistryException {
		String breadIdentifier = "123654789";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO returnedObject = instance.findItem(breadIdentifier);
		String expRes = breadIdentifier;
		String result = returnedObject.getItemIdentifier();
		assertEquals (expRes, result, "Available item was not found");
	}
	
	@Test
	void testFindItemWithWrongId() throws ItemRegistryException {
		String wrongId = "someWrongId";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO expRes = null;
		ItemDTO result = instance.findItem(wrongId);
		assertEquals (expRes, result, "An item with wrong identification was found");
	}
	
	@Test
	void testFindItemThrowsException()  {
		try {
			String specifiedId = "12345";
			ItemRegistry instance = new ItemRegistry ();
			instance.findItem(specifiedId);
			fail("the specified hardcoded identifier didnot cause exeption");
			
		}catch(ItemRegistryException exc) {
			assertTrue(exc.getMessage().contains("Anable to perform matching"), "wrong exception message");
		}
	}



}
