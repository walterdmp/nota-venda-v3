package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private static Map<String, String[]> products = new HashMap<String, String[]>();
	private static Map<String, String[]> payments = new HashMap<String, String[]>();

	static {
		products.put("at", new String[] { "Arroz Tatiana", "30" });
		products.put("ff", new String[] { "Feijão Feijó", "20" });
		products.put("msa", new String[] { "Macarrão Santa Amália", "15" });
	}
	
	static {
		payments.put("cc", new String[] { "Cartão de crédito", "0.05", "0" });
		payments.put("cd", new String[] { "Cartão de débito", "0", "0" });
		payments.put("dp", new String[] { "Dinheiro / Pix", "0", "0.05" });
	}

	public static String[] selectProduct(String code) {
		return products.get(code);
	}
	
	public static String[] selectPayment(String code) {
		return payments.get(code);
	}
}
