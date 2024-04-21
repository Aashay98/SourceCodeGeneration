package com.ap.DAO;

import java.util.List;

import com.ap.Model.LoginVO;

public interface LoginDAO {
	public List searchLoginId(String user);
	
	public void updatePassword(LoginVO loginvo);
	
	public void insert(LoginVO loginvo);

}
