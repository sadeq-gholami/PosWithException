package model;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class AmountTest {

	@Test
	void testAddAmount() {
		int amountOfOperand1 = 10;
		int amountOfOperand2 = 20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals (expRes, result, "Wrong addition result");
	}
	@Test
	void testAddAmountNegResult() {
		int amountOfOperand1 = 10;
		int amountOfOperand2 = -20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals (expRes, result, "Wrong addition result");
	}
	@Test
	void testAddAmountNZeorRes() {
		int amountOfOperand1 = 20;
		int amountOfOperand2 = -20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals (expRes, result, "Wrong addition result");
	}
	
	@Test
    void testAmountSubtraction() {
        int amountOfOperand1 = 20;
        int amountOfOperand2 = 10;
        Amount Operand1 = new Amount (amountOfOperand1, "kr");
        Amount Operand2 = new Amount (amountOfOperand2, "kr");

        int expRes = amountOfOperand1 - amountOfOperand2;
        int result = Operand1.amountSubtraction(Operand2);
        assertEquals (expRes, result, "Wrong subtraction result");
    }
    @Test
    void testAmountSubtractionNegResult() {
        int amountOfOperand1 = 20;
        int amountOfOperand2 = -10;
        Amount Operand1 = new Amount (amountOfOperand1, "kr");
        Amount Operand2 = new Amount (amountOfOperand2, "kr");

        int expRes = amountOfOperand1 - amountOfOperand2;
        int result = Operand1.amountSubtraction(Operand2);
        assertEquals (expRes, result, "Wrong subtraction result");
    }
    @Test
    void testAmountSubtractionNZeorRes() {
        int amountOfOperand1 = 20;
        int amountOfOperand2 = -20;
        Amount Operand1 = new Amount (amountOfOperand1, "kr");
        Amount Operand2 = new Amount (amountOfOperand2, "kr");

        int expRes = amountOfOperand1 - amountOfOperand2;
        int result = Operand1.amountSubtraction(Operand2);
        assertEquals (expRes, result, "Wrong subtraction result");
    }

    @Test
    public void toStringPositiveAmt() {
        int representedAmt = 10;
        Amount amount = new Amount(representedAmt, "kr");
        String expResult = representedAmt + " kr";
        String result = amount.toString();
        assertTrue("Wrong string returned by toString", expResult.equals(result));
        }

    @Test
    public void toStringNegativeAmt() {
        int representedAmt = -10;
        Amount amount = new Amount(representedAmt, "kr");
        String expResult = representedAmt + " kr";
        String result = amount.toString();
        assertTrue("Wrong string returned by toString", expResult.equals(result));
    }
    @Test
    public void toStringZeroAmt() {
        int representedAmt = 0;
        Amount amount = new Amount(representedAmt, "kr");
        String expResult = representedAmt+" kr";
        String result = amount.toString();
        assertTrue("Wrong string returned by toString", expResult.equals(result));
    }
}
