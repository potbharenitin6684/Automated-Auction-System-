package com.masai.model;

import java.util.List;

public class Administrator
{
	private String userName;
	private String password;

	private List<Buyer> buyers;
	private List<Seller> sellers;

	public Administrator() 
	{
		super();
	}

	public Administrator(String userName, String password, List<Buyer> buyers, List<Seller> sellers) 
	{
		super();
		this.userName = userName;
		this.password = password;
		this.buyers = buyers;
		this.sellers = sellers;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public List<Buyer> getBuyers()
	{
		return buyers;
	}

	public void setBuyers(List<Buyer> buyers) 
	{
		this.buyers = buyers;
	}

	public List<Seller> getSellers() 
	{
		return sellers;
	}

	public void setSellers(List<Seller> sellers) 
	{
		this.sellers = sellers;
	}
}
