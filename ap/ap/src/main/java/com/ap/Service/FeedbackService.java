package com.ap.Service;

import java.util.List;

import com.ap.Model.FeedbackVO;

public interface FeedbackService {

	public void insertUserFeedback(FeedbackVO feedbackvo);
	
	public List searchUserFeedback(FeedbackVO feedbackvo);
	
	public List deleteUserFeedback(FeedbackVO feedbackvo);
	
	public List searchAdminFeedback();
}
