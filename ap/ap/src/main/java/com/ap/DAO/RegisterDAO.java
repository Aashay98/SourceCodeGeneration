package com.ap.DAO;

import java.util.List;

import com.ap.Model.RegisterVO;

public interface RegisterDAO {
	
	public void insertRegister(RegisterVO registervo);

	public List searchRegister(RegisterVO registervo);
}
