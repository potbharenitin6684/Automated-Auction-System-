package com.masai.dao;

import java.util.List;

import com.masai.model.Buyer;

public interface BuyerDao
{
	public String RegisterBuyer(Buyer buyer);
	
	public List<Buyer> getBuyer()throws BuyerException;
}
