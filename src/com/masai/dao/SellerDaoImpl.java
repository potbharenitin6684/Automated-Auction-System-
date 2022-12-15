package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.model.Product;
import com.masai.model.Seller;
import com.masai.utility.DBUtil;

public  class SellerDaoImpl implements SellerDao
{
	@Override
	public String RegisterSeller(Seller seller) 
	{
		String message = "Not Inserted..";
	
		try(Connection conn= DBUtil.provideConnection())
		{	
			PreparedStatement ps= conn.prepareStatement("insert into Seller values(?,?,?,?)");	
	
			ps.setInt(1, seller.getSellerId());
			ps.setString(2, seller.getName());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPassword());
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Seller Registered Sucessfully !";
			
		} 
		catch (SQLException e) 
		{
			message = e.getMessage();
		}

		return message;
	}
	
	@Override
	public List<Seller> getSeller() throws SellerException 
	{	
		List<Seller> s = new ArrayList<>();
		
        try (Connection conn = DBUtil.provideConnection())
        {
        	PreparedStatement ps=  conn.prepareStatement("select * from Seller");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				int id= rs.getInt("SellerId");
				String name= rs.getString("Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				
				s.add(new Seller(id, name, email, password));
			}
			
			if(s.size()==0) 
			{
				System.out.println("No Record Found");
			}
		} 
        catch (Exception e) 
        {
    		e.printStackTrace();
    	}	

		// TODO Auto-generated method stub
		
        return s;
	}
	
	@Override
	public String ProductList(Product p) 
	{	
		String message = "NOT INSERTED..";
		
		try (Connection conn = DBUtil.provideConnection()) 
		{
			PreparedStatement ps = conn.prepareStatement("insert into Product values(?,?,?,?,?,?);");
			
			ps.setInt(1, p.getProductId());
			ps.setString(2, p.getProductName());
			ps.setInt(3, p.getProductPrice());
			ps.setInt(4, p.getQuantity());
			ps.setString(5, p.getProductCategory());
			ps.setInt(6, p.getSeelerId());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Item successfully listed";

		}
		catch (SQLException e) 
		{
			e.getMessage();
		}
		return message;
	}
	
	@Override
	public String Updateproduct(Product p, int id)
	{	
		String message = "NOT UPDATED..";

		try (Connection conn = DBUtil.provideConnection()) 
		{
			PreparedStatement ps = conn.prepareStatement("update Product Set P_name = ?,p_price = ?, p_quanitity = 5, P_categort = ?  Where P_Id = ?;");
			
			ps.setString(1, p.getProductName());
			ps.setInt(2, p.getProductPrice());
			ps.setString(3, p.getProductCategory());
			ps.setInt(5, p.getProductId());
			
			int x = ps.executeUpdate();

			if (x > 0)
				message = "Item updated successfully";

		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		
		return message;
	}

	@Override
	public String DeleteProduct(Product p, int id) 
	{	
        String message = "Not Deleted";
		
		try (Connection conn = DBUtil.provideConnection()) 
		{
			PreparedStatement ps = conn.prepareStatement("Delete  From Product Where productId = ?;");
			ps.setInt(1, p.getProductId());
			
			int x = ps.executeUpdate();

			if (x > 0)
				message = "Product Delected successfully";
		} 
		catch (SQLException e)
		{
			e.getMessage();
		}
		
		return message;
	}
}
