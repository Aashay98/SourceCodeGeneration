package com.ap.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.Model.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List searchProject(ProjectVO projectvo)
	{
		List projectlist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ProjectVO where status=true and loginvo_loginId='"+projectvo.getLoginvo().getLoginId()+"' ");
		projectlist=q.list();
		
		return projectlist;
	}
	
	public List searchUserdeleteProject(ProjectVO projectvo)
	{
		List deletelist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ProjectVO where projectId='"+projectvo.getProjectId()+"' ");
		deletelist=q.list();
		
		return deletelist;
	}
	
	public void deleteProject(ProjectVO projectvo)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectvo);
	}

	public List searchAdminProject(ProjectVO projectvo)
	{
		List projectlist=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("From ProjectVO where status=true");
		projectlist=q.list();
		
		return projectlist;
	}
}
