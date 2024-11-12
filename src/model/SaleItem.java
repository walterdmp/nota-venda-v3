package model;

public class SaleItem {
	private Product product;
	private int quantity;
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getSubtotal() {
		return product.getPrice() * quantity;
	}
	
	@Override
	public String toString() {
		String itemStr = String.format("%s %d %.2f", 
				this.getProduct().getDescription(), 
				this.getQuantity(),
				this.getSubtotal());
		
		return itemStr;
	}
		
		public void createProduct(String code, int quantity) {
			String[] productData = DataBase.selectProduct(code);
			
			this.quantity = quantity;
			this.product = new Product();
			product.setDescription(productData[0]);
			product.setPrice(Double.parseDouble(productData[1]));
		}
	}