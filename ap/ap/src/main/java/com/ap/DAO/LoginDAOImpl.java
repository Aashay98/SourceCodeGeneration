package com.ap.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.Model.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List searchLoginId(String user)
	{	
		List loginlist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From LoginVO where username='"+user+"'");
		loginlist=q.list();
		
		return loginlist;
	}
	
	public void updatePassword(LoginVO loginvo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(loginvo);
	}
	
	public void insert(LoginVO loginvo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginvo);
	}

}
