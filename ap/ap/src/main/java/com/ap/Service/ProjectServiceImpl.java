package com.ap.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ap.DAO.ProjectDAO;
import com.ap.Model.ProjectVO;
import com.ap.Model.RegisterVO;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDAO projectdao;
	
	@Transactional
	public List searchProject(ProjectVO projectvo)
	{
		List projectlist=this.projectdao.searchProject(projectvo);
		return projectlist;
	}
	
	@Transactional
	public List searchUserdeleteProject(ProjectVO projectvo)
	{
		List deletelist=this.projectdao.searchUserdeleteProject(projectvo);
		return deletelist;
	}
	
	@Transactional
	public void deleteProject(ProjectVO projectvo)
	{
		this.projectdao.deleteProject(projectvo);
	}

	@Transactional
	public List searchAdminProject(ProjectVO projectvo)
	{
		List projectlist=this.projectdao.searchAdminProject(projectvo);
		return projectlist;
	}

}
