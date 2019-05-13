package view;

import java.util.ArrayList;
import java.util.List;

import model.Amount;
import model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
	private List<Amount> totalAmounts = new ArrayList<>();
	
	@Override
	public void newTotalPrice(Amount totalPrice) {
		this.totalAmounts.add(totalPrice);
		showTotalIncome();
	}
	
	private void showTotalIncome() {
		int saleNo = 0;
		System.out.println();
		System.out.println("A notification from total revenue view;");
		for (Amount totalAmount : totalAmounts) {
			System.out.println("sale number: " + (saleNo++) + " | total Amount: " + totalAmount);
		}
		System.out.println("------------------------------------------------");
		System.out.println("total income: " + getTotalIncome());
		System.out.println();
	}
	private Amount getTotalIncome(){
		int totalIncome = 0;
		for (Amount totalAmount : totalAmounts) {
			totalIncome += totalAmount.getAmount();
		}
		return new Amount(totalIncome, "kr");
	}

}
