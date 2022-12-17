package com.masai.usecase;

import com.masai.bean.Seller;
import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;

public class GetSellerUseCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdminDAO ad = new AdminDAOImpl();
		
		Seller s = ad.getSeller();
		
		if(s != null)
			System.out.println(s);
		else
			System.out.println("No record Found");
	}

}
