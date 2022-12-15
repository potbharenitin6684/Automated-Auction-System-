package com.masai.dao;

import java.util.List;

import com.masai.model.Product;
import com.masai.model.Seller;

public interface SellerDao 
{
	  public String RegisterSeller(Seller seller);
	    
		public List<Seller> getSeller()throws SellerException;
		
		public String ProductList(Product p);
		
		public String Updateproduct(Product p ,int id);
		
		public String DeleteProduct(Product p, int id);
}
