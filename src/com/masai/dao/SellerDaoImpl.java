package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Product;
import com.masai.bean.Seller;
import com.masai.utility.DButility;

public class SellerDAOImpl implements SellerDAO
{
	@Override
	public String registerSeller(Seller seller) 
	{
		String message = "Not Inserted..";
		try(Connection conn= DButility.provideConnection()) 
		{
			PreparedStatement ps= conn.prepareStatement("insert into Seller values(?,?,?,?)");
			
			ps.setInt(1, seller.getId());
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
	public String ProductList(Product p) 
	{
		String message = "NOT INSERTED..";
//		logic
		try (Connection conn = DButility.provideConnection()) 
		{
			PreparedStatement ps = conn
					.prepareStatement("insert into Product values(?,?,?,?,?,?);");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getPrice());
			ps.setInt(4, p.getQuantity());
			ps.setString(5, p.getCategory());
			ps.setInt(6, p.getSellerId());

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
	public String updateproduct(Product p, String  P_name) 
	{
		String message = "NOT UPDATED..";
//		logic
		try (Connection conn = DButility.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("update Product Set P_name = ?,P_price = ?, P_quantity = ?, P_categort = ?  Where P_name = ?;");
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setString(4, p.getCategory());
			ps.setString(5, P_name);

			int x = ps.executeUpdate();// Check this

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
	public String DeleteProduct(String P_name)
	{
		String message = "Instruction Failed";
		
		try (Connection conn = DButility.provideConnection()) 
		{
			PreparedStatement ps = conn.prepareStatement("Delete  From Product Where P_name = ?;");
			ps.setString(1, P_name);
			int x = ps.executeUpdate();// Check this

			if (x > 0)
				message = "Product Delected successfully";

		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		return message;
	}

	@Override
	public String AddProduct(Product P) 
	{
		String message = "NOT INSERTED..";
//		logic
		try (Connection conn = DButility.provideConnection()) 
		{
			PreparedStatement ps = conn
					.prepareStatement("insert into Product values(?,?,?,?,?,?);");
			ps.setInt(1, P.getId());
			ps.setString(2, P.getName());
			ps.setInt(3, P.getPrice());
			ps.setInt(4, P.getQuantity());
			ps.setString(5, P.getCategory());
			ps.setInt(6, P.getSellerId());

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
	public Product SoldHistory() 
	{
		Product p = null;
		try(Connection conn = DButility.provideConnection()) 
		{
			PreparedStatement ps=  conn.prepareStatement("select * from Product Inner Join Sold on  Product.P_id = Sold.Item_id");
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
}