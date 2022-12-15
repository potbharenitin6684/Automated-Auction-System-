package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.model.Buyer;
import com.masai.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao
{
	@Override
	public String RegisterBuyer(Buyer buyer) 
	{
		String message = "Not Inserted..";
		
        try(Connection conn= DBUtil.provideConnection()) 
        {
			
			PreparedStatement ps= conn.prepareStatement("insert into Buyer values(?,?,?,?)");
			
			ps.setInt(1, buyer.getBuyerId());
			ps.setString(2, buyer.getName());
			ps.setString(3, buyer.getEmail());
			ps.setString(4, buyer.getPassword());
			
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

	@Override
	public List<Buyer> getBuyer()throws BuyerException 
	{
		List<Buyer> b = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection())
		{	
            PreparedStatement ps=  conn.prepareStatement("select * from Buyer");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				int id= rs.getInt("BuyerId");
				String name= rs.getString("Name");
				String email = rs.getString("Email");
				String password = rs.getString("password");
				
				b.add(new Buyer(id, name, email, password));
			}
		
			if(b.size()==0) 
			{
				System.out.println("Not Records Found");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		return b;
	}	
}