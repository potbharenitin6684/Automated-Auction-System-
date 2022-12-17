package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Product;
import com.masai.dao.SellerDAO;
import com.masai.dao.SellerDAOImpl;

public class UpdateProduct {
	 
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Name of item you want to update");
			String name = sc.next();
			
			System.out.println("Enter the name of Item you want to Update");
			String name1 = sc.next();
			
			System.out.println("Enter the price of item you want to Update");
			int price = sc.nextInt();
			
			
			System.out.println("Enter the Quantity of Item you want to Update");
			int qty = sc.nextInt();
			
			System.out.println("Enter the category of Item");
			String category = sc.next();
			
			
			
			
			
			
			SellerDAO s = new SellerDAOImpl();
			
			
			
			//make the objec and pass the data
			Product p  = new Product();
			p.setName(name1);
			p.setPrice(price);
			p.setQuantity(qty);
			p.setCategory(category);
			
			
			
			String result = s.updateproduct(p, name);
			System.out.println(result);
		}

}
