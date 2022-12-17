package com.masai.usecase;

import com.masai.bean.Buyer;
import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;

public class GetBuyerUseCase1 {

	public static void main(String[] args) {
		
		AdminDAO ad = new AdminDAOImpl();
		
		Buyer b =  ad.getBuyer();
		
		if(b!=null)
		{
			System.out.println(b);
		}
		else
			System.out.println("No Record Found");
	}
}
