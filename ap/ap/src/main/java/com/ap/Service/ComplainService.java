package com.ap.Service;

import java.util.List;

import com.ap.Model.ComplainVO;

public interface ComplainService {
	
public void insertComplain(ComplainVO complainvo);

public List userViewComplain(ComplainVO complainvo);

public List adminViewComplain();

public List adminReply(ComplainVO complainvo);

public List deleteUserReply(ComplainVO complainvo);

}
