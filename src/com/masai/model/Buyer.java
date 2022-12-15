package com.masai.model;

public class Buyer 
{
	private int BuyerId;
	private String Name;
	private String Email;
	private String Password;
	
	public Buyer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(int buyerId, String name, String email, String password) 
	{
		super();
		BuyerId = buyerId;
		Name = name;
		Email = email;
		Password = password;
	}
	public int getBuyerId() 
	{
		return BuyerId;
	}
	public void setBuyerId(int buyerId) 
	{
		BuyerId = buyerId;
	}
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public String getEmail() 
	{
		return Email;
	}
	public void setEmail(String email) 
	{
		Email = email;
	}
	public String getPassword() 
	{
		return Password;
	}
	public void setPassword(String password) 
	{
		Password = password;
	}
	
	@Override
	public String toString() 
	{
		return "Buyer [BuyerId=" + BuyerId + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + "]";
	}
}
