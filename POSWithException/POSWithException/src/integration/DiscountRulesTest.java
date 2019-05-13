package dbHandler;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import POS.DTOs.*;
import model.Amount;

import java.util.ArrayList;
import java.util.List;


 class DiscountRulesTest {


	 @Test
	 void testDiscountRateMember() {
		 Amount runningtotal = new Amount(200,"kr");
		 Amount MILKPRICE = new Amount (10,"kr");
		 double VAT10PERCENT = 0.1;
		 String MILKITEMIDENTIFIER = "123456789";
		 List<ItemDTO> itemlist = new ArrayList<>();
		 itemlist.add(new ItemDTO("bread",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));
		 itemlist.add(new ItemDTO("bread",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));
		 itemlist.add(new ItemDTO("bread",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));
		 itemlist.add(new ItemDTO("bread",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));
		 itemlist.add(new ItemDTO("milk",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));



		 Amount change = new Amount(0,"kr");
		 Amount totalPriceAfterDiscount = new Amount(0,"kr");

		 SaleDTO saleinfo = new SaleDTO(runningtotal,itemlist,change,totalPriceAfterDiscount);
		 DiscountRules instance = new DiscountRules();
		 double returnedObject = instance.discountRateMember(saleinfo);
		 double expRes = (0.1+ 0.2);
		 double result = returnedObject;
		 assertEquals (expRes, result, "Discount percentage that should be added is not added");
	 }
	 
	 @Test 
	void testDiscountRateNotMember() {
		Amount runningtotal = new Amount(200,"kr");
		Amount MILKPRICE = new Amount (10,"kr");
		double VAT10PERCENT = 0.1;
		String MILKITEMIDENTIFIER = "123456789";
		List<ItemDTO> itemlist = new ArrayList<>();
		itemlist.add(new ItemDTO("milk",MILKPRICE,VAT10PERCENT,MILKITEMIDENTIFIER));
		Amount change = new Amount(0,"kr");
		Amount totalPriceAfterDiscount = new Amount(0,"kr");
		SaleDTO saleinfo = new SaleDTO(runningtotal,itemlist,change,totalPriceAfterDiscount);
		DiscountRules instance = new DiscountRules();
		double returnedObject = instance.discountRateNotMember(saleinfo);
		double expRes = 0.05;
		double result = returnedObject;
		assertEquals (expRes, result, "Discount percentage that should be added is not added");
		 }


}
