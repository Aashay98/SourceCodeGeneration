package com.amazon.ask.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Db {

	static Connection cn=null;
	static final String HOSTNAME="jdbc:mysql://.us-east-1.rds.amazonaws.com/db1";
	static final String USERNAME="";
	static final String PASSWORD="";
	
	
	/*insert to last added value */
	public List search(String email)
	{
		List ls=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME,USERNAME,PASSWORD);
			Statement s = cn.createStatement();
			System.out.println("search");
			System.out.println("emaildbp="+email);
			ResultSet rs=s.executeQuery("Select * from login where username='"+email+"' and status=true");
			while(rs.next())
			{
				String un=rs.getString(5);
				int id=rs.getInt(1);
				ls.add(un);		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}/*for specific key*/
	
	
	
	
	public void insert(String email,String project,String module,String fieldname,String fieldType,String form)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME,USERNAME,PASSWORD);
			Statement s = cn.createStatement();
			System.out.println("search");
			System.out.println("emaildbp="+email);
			s.executeUpdate("Insert into project_table(Field_Name,Field_Type,Form_Name,Module_Name,Project_Name,status,loginVO_loginId) values('"+fieldname+"','"+fieldType+"','"+form+"','"+module+"','"+project+"',true,(select loginId from login where username = '"+email+"'))");
			s.close();
			cn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}/*for specific key*/
	
/*public List search()
	{
		List ls=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME,USERNAME,PASSWORD);
			Statement s = cn.createStatement();
			System.out.println("search");
			
			ResultSet rs=s.executeQuery("Select * from rds");
			while(rs.next())
			{
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				int id=rs.getInt(1);
				ls.add(fn);		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}
	for all values*/
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Db db=new Db();
		//int y=db.insert("aashay");
		//System.out.println(y);
		List ls1=db.search(k);
		String speech="";
		  for(int i=0;i<ls1.size();i++)
	        {
	        	
	        	if (i == 0 ) {
					speech  = (String) ls1.get(0);
					System.out.println("in get 0:"+speech);
				}else{
					speech = speech + " , "+ ls1.get(i);	
					System.out.println("in get i:"+speech);
				}
	        }

		  

	}*/

}
