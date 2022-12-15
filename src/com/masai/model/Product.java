package com.masai.model;

public class Product 
{
	private int productId;
	private String productName;
	private int productPrice;
	private int quantity;
	private String productCategory;
	private int SeelerId;
	
	public Product() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, int productPrice, int quantity,
			String productCategory, int seelerId)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.productCategory = productCategory;
		SeelerId = seelerId;
	}
	
	public int getProductId() 
	{
		return productId;
	}
	
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	
	public String getProductName() 
	{
		return productName;
	}
	
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	
	public int getProductPrice() 
	{
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) 
	{
		this.productPrice = productPrice;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public String getProductCategory() 
	{
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) 
	{
		this.productCategory = productCategory;
	}
	
	public int getSeelerId() 
	{
		return SeelerId;
	}
	
	public void setSeelerId(int seelerId) 
	{
		SeelerId = seelerId;
	}
	
	@Override
	public String toString() 
	{
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", quantity=" + quantity + ", productCategory=" + productCategory + ", SeelerId=" + SeelerId + "]";
	}
}