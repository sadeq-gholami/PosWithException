package model;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import POS.DTOs.*;
import dbHandler.*;

import java.util.ArrayList;
import java.util.List;
class SaleTest {

    @Test
    void testAddItemUpdateRunningTotal() {
        ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
        int quantity = 4;
        bread.setItemQuantity(quantity);
        Sale instance = new Sale();
        SaleDTO saleInfo = instance.addItem(bread);
        Amount runningTotal = saleInfo.getRunningTotal();
        int expRes = 4 * (int) Math.round(30+(0.2*30));
        int result = runningTotal.getAmount();
        assertEquals(expRes, result, "counted wrong running total");
    }
    @Test
    void testAddItemIsAddingItem() {
        ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
        int quantity = 4;
        bread.setItemQuantity(quantity);
        Sale instance = new Sale();
        SaleDTO saleInfo = instance.addItem(bread);
        List<ItemDTO> itemInfo = saleInfo.getItemInfo();
        assertNotNull(itemInfo, "the item that should be added is not added");
    }

    @Test
    void testAddItemNotReturningNull() {
        ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
        Sale instance = new Sale();
        SaleDTO saleInfo = instance.addItem(bread);
        assertNotNull(saleInfo, "the item that should be add is not added");
    }
    @Test
    void testcountNoDiscount() {

        ItemDTO bread = new ItemDTO("milk", new Amount(10 ,"kr"), 0.2, "123456789");
        int quantity = 1;
        bread.setItemQuantity(quantity);
        Sale instance = new Sale();
        RegistryCreator extSys = new RegistryCreator();
        CustomerRegistry instance2 = extSys.getCustomerRegistry();
        
        SaleDTO saleInfo = instance.addItem(bread);
        Amount priceAfterDiscount = instance.countDiscount("wrong ID", instance2);
        int result = priceAfterDiscount.getAmount();
    	int expRes = saleInfo.getRunningTotal().getAmount();
        assertEquals (expRes, result, "PriceAfterDiscount was not Correctly counted");
    }
    @Test
    void testCountPayment() {

        ItemDTO bread = new ItemDTO("bread", new Amount(100 ,"kr"), 0.2, "123456789");
        int quantity = 1;
        bread.setItemQuantity(quantity);
        Sale instance = new Sale();
        RegistryCreator extSys = new RegistryCreator();
        CustomerRegistry instance2 = extSys.getCustomerRegistry();
        
        SaleDTO saleInfo = instance.addItem(bread);
        Amount priceAfterDiscount = instance.countDiscount("wrong ID", instance2);
        Amount amountPayed = new Amount (200, "kr");
        Amount result = instance.countPayment(amountPayed);
        int expRes = 200 - priceAfterDiscount.getAmount();
        assertEquals(expRes, result.getAmount(), "count payment should calculate correctly when paying 100 kr for 1 item that cost 100 kr ");

    }


}







	


