package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> list = new ArrayList<>();
	String payment, paymentCode;
	double discount, fees;

	public void setPaymentMethod(String code) {
		String[] paymentData = DataBase.selectPayment(code);
		this.paymentCode = code;
		this.payment = paymentData[0];
		this.fees = Double.parseDouble(paymentData[1]);
		this.discount = Double.parseDouble(paymentData[2]);
	}

	public String getPayment() {
		return payment;
	}

	public void createSaleItem(String code, int quantity) {
		SaleItem item = new SaleItem();
		item.createProduct(code, quantity);
		this.list.add(item);
	}

	public double getTotal() {
		double total = 0;

		for (SaleItem saleItem : list) {
			total += saleItem.getSubtotal();
		}
		return total;
	}

	public double getTotalPayment() {
		double total = this.getTotal();
		return total + (total * this.fees) - (total * this.discount);
	}
	

	public List<String> getItems() {
		List<String> itemStr = new ArrayList<>();
		for (SaleItem saleItem : list) {
			itemStr.add(saleItem.toString());
		}
		return itemStr;
	}
}