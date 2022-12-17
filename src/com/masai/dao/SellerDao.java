package com.masai.dao;

import com.masai.bean.Product;
import com.masai.bean.Seller;

public interface SellerDAO 
{
	public String registerSeller(Seller seller);
	
	public String ProductList(Product p);
	
	public String updateproduct(Product p ,String P_name);
	
	public String DeleteProduct(String P_name);
	
	public String AddProduct(Product P);
	
	public  Product SoldHistory();

}
