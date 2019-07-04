package com.training.bean;

public class ComplexBean2 {
	private String userName;
	private String password;
	private String product;
	private String title;
	private int price;
	private int quantity;

	public ComplexBean2() {
	}

	public ComplexBean2(String userName, String password,String product,String title,int price,int quantity) {
		super();
		this.userName = userName;
		this.password = password;
		this.product = product;
		this.title=title;
		this.price=price;
		this.quantity=quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ComplexBean1 [userName=" + userName + ", password=" + password + ",product=" + product + "title=" + title + ",price=" + price + ",quantity=" + quantity + "]";
		//return "ComplexBean1 [userName=" + userName + ", password=" + password + "]";
	}

}
