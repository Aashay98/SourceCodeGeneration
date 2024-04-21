package com.ap.DAO;

import java.util.List;

import com.ap.Model.ComplainVO;

public interface ComplainDAO {

	public void insertComplain(ComplainVO complainvo);
	
	public List userViewComplain(ComplainVO complainvo);
	
	public List adminViewComplain();
	
	public List adminReply(ComplainVO complainvo);
	
	public List deleteUserReply(ComplainVO complainvo);
}
