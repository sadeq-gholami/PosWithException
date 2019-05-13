package dbHandler;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



 class CustomerRegistryTest {
	
	 @Test 
	 void testisEligibleRightCustomerID(){
	String customerID = "ABC123";
	CustomerRegistry instance = new CustomerRegistry();
	boolean returnedObject = instance.isEligible(customerID);
	boolean expRes = true;
	boolean result = returnedObject;
	assertEquals (expRes, result, "Available customer was not found");
	 }
	
	 @Test 
	 void testisEligibleWrongCustomerID(){
	String customerID = "ABBBB3";
	CustomerRegistry instance = new CustomerRegistry();
	boolean returnedObject = instance.isEligible(customerID);
	boolean expRes = false;
	boolean result = returnedObject;
	assertEquals (expRes, result, "Available customer was found");
	 }

}
