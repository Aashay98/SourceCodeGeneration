package com.ap.Service;

import java.util.List;

import com.ap.Model.RegisterVO;

public interface RegisterService {

	public void insertRegister(RegisterVO registervo);
	
	public List searchRegister(RegisterVO registervo);
}
