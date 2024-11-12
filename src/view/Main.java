package view;

import model.Sale;

public class Main {

	public static void main(String[] args) {	
				
		Sale sale = new Sale();
		sale.createSaleItem("at", 2);
		sale.createSaleItem("ff", 1);
		sale.createSaleItem("msa", 2);
		
		for (Object item : sale.getItems()) {
			System.out.println(item);
		}
		
		sale.setPaymentMethod("dp");
		
		System.out.println(String.format("Total: %.2f", sale.getTotal()));
		System.out.println("Forma de pagamento escolhida: " + sale.getPayment());
		System.out.println(String.format("Valor a ser pago: %.2f", sale.getTotalPayment()));
		
		
		
	}
}