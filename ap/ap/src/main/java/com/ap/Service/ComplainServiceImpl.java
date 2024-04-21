package com.ap.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ap.DAO.ComplainDAO;
import com.ap.Model.ComplainVO;

@Service
public class ComplainServiceImpl implements ComplainService {
	@Autowired
	ComplainDAO complaindao;
	
	@Transactional
	public void insertComplain(ComplainVO complainvo)
	{
		this.complaindao.insertComplain(complainvo);
	}
	
	@Transactional
	public List userViewComplain(ComplainVO complainvo)
	{
		List complainlist=this.complaindao.userViewComplain(complainvo);
		return complainlist;
	}
	
	@Transactional
	public List adminViewComplain()
	{
		List complainlist=this.complaindao.adminViewComplain();
		return complainlist;
	}
	
	@Transactional
	public List adminReply(ComplainVO complainvo)
	{
		List replylist=this.complaindao.adminReply(complainvo);
		return replylist;
	}
	
	@Transactional
	public List deleteUserReply(ComplainVO complainvo)
	{
		List deletelist=this.complaindao.deleteUserReply(complainvo);
		return deletelist;
	}
}
