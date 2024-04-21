package com.ap.Service;

import java.util.List;

import com.ap.Model.ProjectVO;

public interface ProjectService {
	
	public List searchProject(ProjectVO projectvo);
	
	public List searchUserdeleteProject(ProjectVO projectvo);
	
	public void deleteProject(ProjectVO projectvo);
	
	public List searchAdminProject(ProjectVO projectvo);

}
