package com.ap.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complain_table")
public class ComplainVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="ComplainSubject")
	private String complainSubject;
	
	@Column(name="ComplainDescription")
	private String complainDescription;
	
	@Column(name="Status")
	private boolean status=true;
	
	@Column(name="ComplainTime")
	private String complainTime;
	
	@Column(name="Reply")
	private String reply;
	
	@Column(name="ReplyTime")
	private String replyTime;

	@Column(name="ComplainStatus")
	private String complainStatus;
	
	@Column(name="FilePathName")
	private String filepathName;
	
	@Column(name="FilePath")
	private String filePath;
	
	@ManyToOne
	LoginVO loginvo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getComplainSubject() {
		return complainSubject;
	}

	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}

	public String getComplainDescription() {
		return complainDescription;
	}

	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComplainTime() {
		return complainTime;
	}

	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}

	
	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getFilepathName() {
		return filepathName;
	}

	public void setFilepathName(String filepathName) {
		this.filepathName = filepathName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LoginVO getLoginvo() {
		return loginvo;
	}

	public void setLoginvo(LoginVO loginvo) {
		this.loginvo = loginvo;
	}

	
	
	

}
