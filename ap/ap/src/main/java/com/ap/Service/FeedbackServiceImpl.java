package com.ap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ap.DAO.FeedbackDAO;
import com.ap.Model.FeedbackVO;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDAO feedbackdao;
	
	@Transactional
	public void insertUserFeedback(FeedbackVO feedbackvo)
	{
		this.feedbackdao.insertUserFeedback(feedbackvo);
	}
	
	@Transactional
	public List searchUserFeedback(FeedbackVO feedbackvo)
	{
		List feedbacklist=this.feedbackdao.searchUserFeedback(feedbackvo);
		return feedbacklist;
	}
	
	@Transactional
	public List deleteUserFeedback(FeedbackVO feedbackvo)
	{
		List feedbacklist=this.feedbackdao.deleteUserFeedback(feedbackvo);
		return feedbacklist;
	}
	
	@Transactional
	public List searchAdminFeedback()
	{
		List adminfeedbacklist=this.feedbackdao.searchAdminFeedback();
		return adminfeedbacklist;
	}
	
}
