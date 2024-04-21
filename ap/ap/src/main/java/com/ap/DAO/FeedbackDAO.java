package com.ap.DAO;

import java.util.List;

import com.ap.Model.FeedbackVO;

public interface FeedbackDAO {
	
	public void insertUserFeedback(FeedbackVO feedbackvo);
	
	public List searchUserFeedback(FeedbackVO feedbackvo);
	
	public List deleteUserFeedback(FeedbackVO feedbackvo);
	
	public List searchAdminFeedback();

}
