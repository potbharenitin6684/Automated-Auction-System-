package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Buyer;
import com.masai.bean.Product;
import com.masai.utility.DButility;

public class BuyerDAOImpl implements BuyerDAO
{
	@Override
	public String registerBuyer(Buyer buyer) 
	{
		String message = "Not Inserted..";

		try(Connection conn= DButility.provideConnection()) 
		{
			PreparedStatement ps= conn.prepareStatement
					("insert into Buyer values(?,?,?,?)");
			ps.setInt(1, buyer.getId());
			ps.setString(2, buyer.getName());
			ps.setString(3, buyer.getEmail());
			ps.setString(4, buyer.getPassword());
			
			int x= ps.executeUpdate();
			if(x > 0)
				message = "Item Buyed Sucessfully !";
		} 
		catch (SQLException e) 
		{
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Product viewItemByCatagory(String catagory) 
	{
		Product p = null;
		
		try(Connection conn = DButility.provideConnection()) 
		{
				PreparedStatement ps=  conn.prepareStatement("select * from Product Where P_categort = ?");
				ps.setString(1, catagory);
				
				ResultSet rs =  ps.executeQuery();
				
				while(rs.next()) 
				{
					int id= rs.getInt("P_id");
					String name= rs.getString("P_name");
					int price = rs.getInt("P_price");
					int quantity = rs.getInt("P_quantity");
					String category = rs.getString("P_categort");
					int seller_id = rs.getInt("Seller_Id");

					p = new Product(id, name, price, quantity, category, seller_id);	
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return p;
	}

	@Override
	public Product SellersByCatagory(String catagory) 
	{
		Product p = null;
		
		try(Connection conn = DButility.provideConnection()) 
		{
				PreparedStatement ps=  conn.prepareStatement("select * from Product Where P_categort = ?");
				ps.setString(1, catagory);
				
				ResultSet rs =  ps.executeQuery();
				
				while(rs.next()) 
				{
					int id= rs.getInt("P_id");
					String name= rs.getString("P_name");
					int price = rs.getInt("P_price");
					int quantity = rs.getInt("P_quantity");
					String category = rs.getString("P_categort");
					int seller_id = rs.getInt("Seller_Id");
					
					p = new Product(id, name, price, quantity, category, seller_id);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return p;
	}

	@Override
	public String Buy(String Buyer_email, String Product_Name) 
	{
		String message = "Not Buyed..";
		try(Connection conn= DButility.provideConnection()) 
		{
			PreparedStatement ps= conn.prepareStatement
					(" insert into Sold values( (select B_id from Buyer where B_email = ?), (select P_id from Product where P_name = ?));");
		
			ps.setString(1, Buyer_email);
			ps.setString(2, Product_Name);
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Buyer Registered Sucessfully !";
			
		} 
		catch (SQLException e) 
		{
			message = e.getMessage();
		}

		return message;
	}
}

