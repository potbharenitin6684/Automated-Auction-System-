package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Product;
import com.masai.dao.SellerDAO;
import com.masai.dao.SellerDAOImpl;

public class AddProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Product Name");
		String name = sc.next();
		
		System.out.println("Enter Product Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Product Quantity");
		int  quantity = sc.nextInt();
		
		System.out.println("Enter Product Category");
		String category = sc.next();
		
		System.out.println("Enter Seller Id");
		int  S_id = sc.nextInt();
		
		SellerDAO s = new SellerDAOImpl();
		
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setCategory(category);
		p.setSellerId(S_id);
		
	
		 String result = s.ProductList(p);
		 System.out.println(result);
				
	}

}
