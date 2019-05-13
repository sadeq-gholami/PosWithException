package view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import dbHandler.*;
import model.*;
class ViewTest {
	private View instance;
	private ByteArrayOutputStream printOut;
	private PrintStream originalSysOut;
	
	@BeforeEach
	void setUp() throws IOException{
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister();
		Controller cont = new Controller(regCreator, extSys, cashRegister);
		instance = new View(cont);
		
		printOut = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream (printOut);
		originalSysOut = System.out;
		System.setOut (inMemSysOut);
	}

	@AfterEach
	void tearDown(){
		System.setOut(originalSysOut);
		printOut = null;
	}

		
	@Test
	void testRunFakeSale() {
		instance.runFakeSale();
		String result = printOut.toString();
		String expRes = "started";
		assertTrue(result.contains(expRes), "Wrong print out after calling startNewSale");
	}
	
	@Test
	void testRunFakeSaleAddItem() {
		instance.runFakeSale();
		String result = printOut.toString();
		String expRes = "item";
		assertTrue(result.contains(expRes), "Wrong print out after calling addItem()");
	}

}
