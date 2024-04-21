package com.ap.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.Model.ComplainVO;

@Repository
public class ComplainDAOImpl implements ComplainDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void insertComplain(ComplainVO complainvo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(complainvo);
	}
	
	public List userViewComplain(ComplainVO complainvo)
	{
		List complainlist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ComplainVO where status=true and loginvo_loginId='"+complainvo.getLoginvo().getLoginId()+"'");
		complainlist=q.list();
		
		return complainlist;	
	}
	
	public List adminViewComplain()
	{
		List complainlist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ComplainVO where status=true");
		complainlist=q.list();
		
		return complainlist;	
	}
	
	public List adminReply(ComplainVO complainvo)
	{
		List replylist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ComplainVO where status=true and id='"+complainvo.getId()+"'");
		replylist=q.list();
		
		return replylist;	
	}

	public List deleteUserReply(ComplainVO complainvo)
	{
		List deletelist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ComplainVO where id='"+complainvo.getId()+"'");
		deletelist=q.list();
		
		return deletelist;	
	}
}
