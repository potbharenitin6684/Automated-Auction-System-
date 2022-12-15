package com.masai.dao;

import com.masai.model.Administrator;

public interface AdminDao 
{
	public Administrator loginAdmin(String Name, String password);
}
