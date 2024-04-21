package com.ap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ap.DAO.LoginDAO;
import com.ap.Model.LoginVO;


@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDAO logindao;
	
	@Transactional
	public List searchLoginId(String user)
	{
		List loginlist=this.logindao.searchLoginId(user);
		return loginlist;
	}

	@Transactional
	public void updatePassword(LoginVO loginvo)
	{
		this.logindao.updatePassword(loginvo);
	}
	
	@Transactional
	public void insert(LoginVO loginvo)
	{
		this.logindao.insert(loginvo);
	}
}
