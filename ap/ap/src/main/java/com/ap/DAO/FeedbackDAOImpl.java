package com.ap.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.Model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void insertUserFeedback(FeedbackVO feedbackvo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(feedbackvo);
	}
	
	public List searchUserFeedback(FeedbackVO feedbackvo)
	{
		List feedbacklist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From FeedbackVO where status=true and loginvo_loginId='"+feedbackvo.getLoginvo().getLoginId()+"'");
		feedbacklist=q.list();
		return feedbacklist;
	}
		
	public List deleteUserFeedback(FeedbackVO feedbackvo)
	{
		List deletefeedbacklist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From FeedbackVO where id='"+feedbackvo.getId()+"'");
		deletefeedbacklist=q.list();
		return deletefeedbacklist;
	}
	
	public List searchAdminFeedback()
	{
		List feedbacklist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From FeedbackVO where status=true");
		feedbacklist=q.list();
		return feedbacklist;
	}
	
}
