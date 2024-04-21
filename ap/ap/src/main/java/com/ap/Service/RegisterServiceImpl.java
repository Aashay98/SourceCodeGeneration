package com.ap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ap.DAO.RegisterDAO;
import com.ap.Model.RegisterVO;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	RegisterDAO registerdao;

	@Transactional
	public void insertRegister(RegisterVO registervo)
	{
		this.registerdao.insertRegister(registervo);
	}
	
	@Transactional
	public List searchRegister(RegisterVO registervo)
	{
		List profilelist=this.registerdao.searchRegister(registervo);
		return profilelist;
	}

}
