package com.ap.Service;

import java.util.List;

import com.ap.Model.LoginVO;

public interface LoginService {
	
	public void insert(LoginVO loginvo);
	
	public List searchLoginId(String user);

	public void updatePassword(LoginVO loginvo);
}
