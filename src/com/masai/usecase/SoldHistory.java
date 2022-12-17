package com.masai.usecase;

import com.masai.bean.Product;
import com.masai.dao.SellerDAO;
import com.masai.dao.SellerDAOImpl;

public class SoldHistory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SellerDAO s = new SellerDAOImpl();
		
		Product p = s.SoldHistory();
		if(p!=null)
		{
			System.out.println(p);
		}
		else
			System.out.println("No Record Found");

	}
}
