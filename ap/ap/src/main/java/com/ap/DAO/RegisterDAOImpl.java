package com.ap.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.Model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void insertRegister(RegisterVO registervo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(registervo);
	}
	
	public List searchRegister(RegisterVO registervo)
	{
		List profilelist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From RegisterVO where loginVO_loginId='"+registervo.getLoginVO().getLoginId()+"'");
		profilelist=q.list();
		
		return profilelist;
	}

}
