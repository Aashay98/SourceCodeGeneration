package com.amazon.ask.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class Basemethods  {
	
	public static String generatePassword() {

		int n = 4;
		// chose a Character random from this String 
        String AlphaNumericString = "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString .charAt(index)); 
        } 
  
        return sb.toString(); 
	}
	
	public static void sendMail(String receiver,String securityKey){

		final String from = "noreply.alexaproject@gmail.com";
		final String username = "user";
		final String password = "alexa@19";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mails.smtp.ssl.trust","smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));
			message.setSubject("Approve ");
			
			
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("Hello ,  " + username + " your OTP is " + securityKey );

			Transport.send(message);

			System.out.println("Sent message successfully....");

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
	}
	
	public static void sendProject(String receiver,String securityKey){

		final String from = "noreply.alexaproject@gmail.com";
		final String username = "user";
		final String password = "alexa@19";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mails.smtp.ssl.trust","smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));
			message.setSubject("Approve ");
			
			
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("Hello ,  " + username + " your project link is \n " + securityKey+"\n" );

			Transport.send(message);

			System.out.println("Sent message successfully....");

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
	}
	
		static String SUFFIX="/";
		static String link="";
		final static String accesskey = "";
		final static String secretkey = "";
		final static String bucketname = "aashay";
		
		static AmazonS3Client s3Client=new AmazonS3Client(new BasicAWSCredentials(accesskey,secretkey));
		
		public static  void EmailFolder(String email)
		{
			try
			{
				ObjectMetadata objectMetadata = new ObjectMetadata();
				objectMetadata.setContentLength(0);
				
				InputStream emptyContent=new ByteArrayInputStream(new byte[0]);		//create empty content
				
				PutObjectRequest putObjectRequest1 = new PutObjectRequest(bucketname, email+SUFFIX, emptyContent,objectMetadata);
				System.out.println("----file uploading---");
				
				AccessControlList acl=new AccessControlList();
				acl.grantPermission(GroupGrantee.AllUsers,Permission.Read);
				
				s3Client.putObject(putObjectRequest1);
				System.out.println("File uploaded");
				
				
				link=s3Client.generatePresignedUrl(bucketname, email, new Date()).toString();//here date is expiration date of url, so you have to define future date here
				System.out.println(link);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
		public static  void project(String email,String project)
		{
			try
			{
				String projectfolder=email+SUFFIX+project+SUFFIX;
				String src=projectfolder+"src"+SUFFIX+"com"+SUFFIX;
				String webinf=projectfolder+"WEB-INF"+SUFFIX+"view"+SUFFIX;
				
				ObjectMetadata objectMetadata = new ObjectMetadata();
				objectMetadata.setContentLength(0);
				
				InputStream emptyContent=new ByteArrayInputStream(new byte[0]);		//create empty content
				
				PutObjectRequest putObjectRequest1 = new PutObjectRequest(bucketname, src+"Controller"+SUFFIX,emptyContent,objectMetadata);
				PutObjectRequest putObjectRequest2 = new PutObjectRequest(bucketname, src+"DAO"+SUFFIX,emptyContent,objectMetadata);
				PutObjectRequest putObjectRequest3 = new PutObjectRequest(bucketname, src+"VO"+SUFFIX,emptyContent,objectMetadata);
				PutObjectRequest putObjectRequest4 = new PutObjectRequest(bucketname, webinf,emptyContent,objectMetadata);
				System.out.println("----file uploading---");
				
				AccessControlList acl=new AccessControlList();
				acl.grantPermission(GroupGrantee.AllUsers,Permission.Read);
				
				s3Client.putObject(putObjectRequest1);
				s3Client.putObject(putObjectRequest2);
				s3Client.putObject(putObjectRequest3);
				s3Client.putObject(putObjectRequest4);
				System.out.println("File uploaded");
				
				
				link=s3Client.generatePresignedUrl(bucketname, projectfolder, new Date()).toString();//here date is expiration date of url, so you have to define future date here
				System.out.println(link);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public static void Modules(String email,String project,String module)
		{
			String projectfolder=email+SUFFIX+project+SUFFIX;
			String webinf=projectfolder+"WEB-INF"+SUFFIX+"view"+SUFFIX;
			

			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(0);
			
			InputStream emptyContent=new ByteArrayInputStream(new byte[0]);		//create empty content
			
			PutObjectRequest putObjectRequest1 = new PutObjectRequest(bucketname, webinf+module+SUFFIX,emptyContent,objectMetadata);
			
			AccessControlList acl=new AccessControlList();
			acl.grantPermission(GroupGrantee.AllUsers,Permission.Read);
			
			s3Client.putObject(putObjectRequest1);
		}
		
		public static void GenrateCode(String email,String project,String module,String form, List fieldlist) throws IOException
		{
			try {
				String projectfolder=email+SUFFIX+project+SUFFIX;
				String webinf=projectfolder+"WEB-INF"+SUFFIX+"view"+SUFFIX+module+SUFFIX;
				String src=projectfolder+"src"+SUFFIX+"com"+SUFFIX;
				System.out.println("generate method");
				
				String indexjsp= GenerateIndexJsp(email,project,form,fieldlist);
				String formJsp=GenerateFormJsp(form,fieldlist,webinf);
				String searchJsp=GenerateSearchJsp(form,fieldlist,webinf);
				String VO=GenerateVO(form,fieldlist,src);
				String Controller=GenerateController(form,fieldlist,src);
				String DAO=GenerateDAO(form,fieldlist,src);
				String ssXML=GenerateSpringServletXML(email,project,form,fieldlist);
				String webXML=GenerateWebXML(webinf);
				
				String generatedCode="indexjsp="+indexjsp+"\n, formJsp="+formJsp+"\n, searchJsp="+searchJsp+"\n, VO="+VO+", Controller="+Controller+"\n, DAO"+DAO+"\n, ssXML="+ssXML+"\n, webxml="+webXML+"."; 
				sendProject(email,generatedCode );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

		public static String GenerateIndexJsp(String email,String project,String form, List fieldlist) throws IOException
		{
			String index=email+SUFFIX+project+SUFFIX;
			String filename=index+"index.jsp";
			System.out.println("filename:"+filename);
			System.out.println("Generate jsp");
			
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>");
			bw.newLine();
			bw.write("\"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			bw.newLine();
			bw.write("<html>");
			bw.newLine();
			bw.write("	<head>");
			bw.newLine();
			bw.write("	</head>");
			bw.newLine();
			bw.write("	<body>");
			bw.newLine();
			bw.write("	<a href=\"index.html\">Index</a>");
			
			bw.newLine();
			bw.write("		<a href=\"index.html\">Home</a>");
			bw.newLine();
			bw.write("	</body>");
			bw.newLine();
			bw.write("</html>");
			bw.newLine();
			
			bw.close();	
			s3Client.putObject(bucketname,filename,file1);
			
			link = s3Client.getUrl(bucketname, filename).toString();
			
			//acl.grantPermission(GroupGrantee.AllUsers,Permission.Read);
			return link;
		}

		public static String GenerateFormJsp(String form, List fieldlist,String webinf)throws IOException
		{
			String filename=webinf+form+".jsp";
			System.out.println("filename:"+filename);
			System.out.println("Generate jsp");
			
			File file1 = File.createTempFile("demo",".tmp" );
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>");
			bw.newLine();
			bw.write("\"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			bw.newLine();
			bw.write("<html>");
			bw.newLine();
			bw.write("	<head>");
			bw.newLine();
			bw.write("	</head>");
			bw.newLine();
			bw.write("	<body>");
			bw.newLine();
			bw.newLine();
			bw.write("		<%@taglib prefix=\"f\" uri=\"http://www.springframework.org/tags/form\"%>");
			bw.newLine();
			bw.write("		<form action=\""+form+"insert.html\" method=\"Post\" modelAttribute="+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"VO"+">");
			bw.newLine();
			  for(Object object:fieldlist){
		    	   Map fieldmap=(Map)object;
		    	    String fname=(String)fieldmap.get("fieldName");
		    	    String ftype=(String)fieldmap.get("fieldType");
		    	    System.out.println(fname);
		    	    System.out.println(ftype);

		    	    if(ftype.equals("text")||ftype.equals("password")||ftype.equals("email")||ftype.equals("number") )
		    	    {	
		    	    	bw.write("			"+fname.toUpperCase().charAt(0)+fname.substring(1).toLowerCase()+":");
		    	    	bw.newLine();
		    	    	bw.write("			<f:input path=\""+fname.toLowerCase()+"\" name=\""+fname.toLowerCase().trim().replace(" ", "")+"\">");
		    	    	bw.newLine();   
		    	    }
		    	    else if(ftype.equals("textarea"))
		    	    {
		    	    	bw.write("			"+fname.toUpperCase().charAt(0)+fname.substring(1).toLowerCase()+":");
		    	    	bw.newLine();
		    	    	bw.write("			<f:textarea path=\""+fname.toLowerCase()+"\" name=\""+fname.toLowerCase().trim().replace(" ", "")+"\"/>");
		    	    	bw.newLine();
		    	    }
		       }
			bw.newLine();
			bw.write("			<f:hidden path=\""+form+"id\"/>");
			bw.newLine();
			bw.write("			<input type=\"submit\" value=\"Submit\">");
			bw.newLine();
			bw.write("		</form>");
			bw.newLine();
			bw.write("	</body>");
			bw.newLine();
			bw.write("</html>");
			bw.newLine();
			
			bw.close();
			
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			
			link = s3Client.getUrl(bucketname, filename).toString();
			/*AccessControlList acl=new AccessControlList();
			link=s3Client.generatePresignedUrl(bucketname, webinf, new Date()).toString();
			acl.grantPermission(GroupGrantee.AllUsers,Permission.Read);*/
			return link;
		}
		public static String GenerateSearchJsp(String form, List fieldlist,String webinf)throws IOException
		{
			String filename=webinf+form+"search.jsp";
			System.out.println("filename:"+filename);
			System.out.println("Generate jsp");
			String formlower=form.toLowerCase();
			File file1 = File.createTempFile("demo",".tmp" );
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>");
			bw.newLine();
			bw.write("\"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			bw.newLine();
			bw.write("<html>");
			bw.newLine();
			bw.write("	<head>");
			bw.newLine();
			bw.write("	</head>");
			bw.newLine();
			bw.write("	<body>");
			bw.newLine();
			bw.newLine();
			bw.write("<table border='1'>");
			bw.newLine();
			bw.write("<tr>");
			bw.newLine();
			bw.write("<td>"+formlower+"Id"+"</td>");
			bw.newLine();
			for(Object object:fieldlist){
				
				Map fildVO = (Map)object;
				
				String fieldName = (String) fildVO.get("fieldname");
				
				System.out.println("field name:"+fieldName);
				
					bw.write("<td>"+fieldName+"</td>");
					bw.newLine();

			}	
			bw.write("</tr>");
			bw.newLine();	
			
			bw.write("<c:forEach items=\"${list}\" var=\"x\">");
			bw.newLine();
			bw.write("<tr>");
			bw.newLine();
			bw.write("<td>${x."+formlower+"Id}</td>");
			bw.newLine();
			for(Object object1:fieldlist){
				
				Map fildVO = (Map)object1;
				
				String fieldName = (String) fildVO.get("fieldname");
	
			bw.write("<td>${x."+fieldName+"}</td>");
			bw.newLine();

					}	
			bw.write("<td><a href=\"delete"+formlower+".html?"+formlower+"Id=${x."+formlower+"Id}\">DeleteData</a></td>");
			bw.newLine();
			bw.write("<td><a href=\"edit"+formlower+".html?"+formlower+"Id=${x."+formlower+"Id}\">EditData</a></td>");
			bw.newLine();
			bw.write("</tr>");
			bw.newLine();
			bw.write("</c:forEach>");
			bw.newLine();
			bw.write("</table>");
			bw.write("	</body>");
			bw.newLine();
			bw.write("</html>");
			bw.newLine();
			
			bw.close();
			
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
		public static String GenerateVO(String form,List fieldlist ,String src) throws IOException
		{
			String filename=src+"VO"+SUFFIX+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"VO"+".java";
			System.out.println("filename:"+filename);
					
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("@Entity");
			bw.newLine();
			bw.write("@Table(name=\""+form+"_table\")");
			bw.newLine();
			bw.write("public class "+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"VO {");
			bw.newLine();
			bw.write("	@Id");
			bw.newLine();
			bw.write("	@GeneratedValue(strategy=GenerationType.IDENTITY)");
			bw.newLine();
			bw.write("	@Column(name=\""+form.toLowerCase()+"Id\")");
			bw.newLine();
			bw.write("	private int "+form.toLowerCase()+"id;");
			bw.newLine();
			bw.write("	public int get"+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Id() {");
			bw.newLine();
			bw.write("		return "+form.toLowerCase()+"id;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.write("	public void set"+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Id(int "+form.toLowerCase()+"id) {");
			bw.newLine();
			bw.write("		this."+form.toLowerCase()+"id = "+form.toLowerCase()+"id;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			
			bw.write("	@Column(name=\"Status\")");
			bw.newLine();
			bw.write("	private boolean status=true;");
			bw.newLine();
			bw.write("	public boolean isStatus() {");
			bw.newLine();
			bw.write("		return status;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.write("	public void setStatus(boolean status) {");
			bw.newLine();
			bw.write("		this.status = status;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			
			 for(Object object:fieldlist){
		    	    Map fieldmap=(Map)object;
		    	    String fname=(String)fieldmap.get("fieldName");
		    	    bw.write("	@Column(name=\""+fname.toUpperCase().charAt(0)+fname.substring(1).toLowerCase()+"\")");
					bw.newLine();
					bw.write("	private String "+fname.toLowerCase()+";");
					bw.newLine();
					bw.write("	public int get"+fname.toUpperCase().charAt(0)+fname.substring(1).toLowerCase()+"() {");
					bw.newLine();
					bw.write("		return "+fname.toLowerCase()+";");
					bw.newLine();
					bw.write("	}");
					bw.newLine();
					bw.write("	public void set"+fname.toUpperCase().charAt(0)+fname.substring(1).toLowerCase()+"(String "+fname+") {");
					bw.newLine();
					bw.write("		this."+fname.toLowerCase()+" = "+fname.toLowerCase()+";");
					bw.newLine();
					bw.write("	}");
					bw.newLine();
		       }
			bw.write("}");
			
			bw.close();
			
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
		public static String GenerateController(String form,List fieldlist ,String src) throws IOException
		{
			String filename=src+"Controller"+SUFFIX+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Controller"+".java";
			System.out.println("filename:"+filename);
			
			String capitalvo=form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"VO";
			String capitaldao=form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"DAO";
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("@Controller");
			bw.newLine();
			bw.write("public class "+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Controller");
			bw.newLine();
			bw.write("{");
			bw.newLine();
			bw.write("	@Autowired");
			bw.newLine();
			bw.write("	"+capitaldao+" "+capitaldao.toLowerCase()+";");
			bw.newLine();
			bw.newLine();
			bw.write("	@GetMapping(value=\"index.html\")");
			bw.newLine();
			bw.write("	public ModelAndView insert"+form+"() {");
			bw.newLine();
			bw.write("		return new ModelAndView(\""+form+"\",\""+capitalvo+"\", new "+capitalvo+"());");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@PostMapping(value=\""+form+"insert.html\")");
			bw.newLine();
			bw.write("	public ModelAndView insert"+form+"(@ModelAttribute "+capitalvo+" "+capitalvo.toLowerCase()+") {");
			bw.newLine();
			bw.write("		this."+capitaldao.toLowerCase()+"."+form+"insert("+capitalvo.toLowerCase()+");");
			bw.newLine();
			bw.write("		return new ModelAndView(\"redirect:/"+form+"insert.html\");");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@GetMapping(value=\""+form+"search.html\")");
			bw.newLine();
			bw.write("	public ModelAndView search"+form+"(@ModelAttribute "+capitalvo+" "+capitalvo.toLowerCase()+") {");
			bw.newLine();
			bw.write("		List searchlist=this."+capitaldao.toLowerCase()+"."+form+"search();");
			bw.newLine();
			bw.write("		return new ModelAndView(\"search\",\"searchlist\",searchlist);");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@GetMapping(value=\" "+form+"delete.html \")");
			bw.newLine();
			bw.write("	public ModelAndView delete"+form+"(@ModelAttribute "+capitalvo+" "+capitalvo.toLowerCase()+",@RequestParam int "+form+"id) {");
			bw.newLine();
			bw.write("		"+capitalvo.toLowerCase()+".set"+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Id("+form+"id);");
			bw.newLine();
			bw.write("		List deletelist=this."+capitaldao.toLowerCase()+"."+form+"delete("+capitalvo.toLowerCase()+");");
			bw.newLine();
			bw.write("		"+capitalvo.toLowerCase()+"=("+capitalvo+")deletelist.get(0);");
			bw.newLine();
			bw.write("		"+capitalvo.toLowerCase()+".setStatus(false);");
			bw.newLine();
			bw.write("		this."+capitaldao.toLowerCase()+"."+form+"insert("+capitalvo.toLowerCase()+");");
			bw.newLine();
			bw.write("		return new ModelAndView(\"redirect:/"+form+"search\");");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@GetMapping(value=\""+form+"update.html\")");
			bw.newLine();
			bw.write("	public ModelAndView update"+form+"(@ModelAttribute "+capitalvo+" "+capitalvo.toLowerCase()+",@RequestParam int "+form+"id) {");
			bw.newLine();
			bw.write("		"+capitalvo.toLowerCase()+".set"+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Id("+form+"id));");
			bw.newLine();
			bw.write("		List updatelist=this."+capitaldao.toLowerCase()+"."+form+"delete("+capitalvo.toLowerCase()+");");
			bw.newLine();
			bw.write("		return new ModelAndView(\""+form+"\",\""+capitalvo+"\", updatelist.get(0));");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			bw.write("}");
			
			bw.close();
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
		public static String GenerateDAO(String form,List fieldlist ,String src) throws IOException
		{
			String filename=src+"DAO"+SUFFIX+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"DAO"+".java";
			System.out.println("filename:"+filename);
			
			String capitalvo=form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"VO";
			String lowervo=capitalvo.toLowerCase();
			String capitaldao=form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"DAO";
			
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			
			bw.write("@Repositiory");
			bw.newLine();
			bw.write("public class "+capitaldao+" {");
			bw.newLine();
			bw.write("	@Autowired");
			bw.newLine();
			bw.write("	SessionFactory sessionFactory;");
			bw.newLine();
			bw.newLine();
			bw.write("	public void "+form.toLowerCase()+"insert("+capitalvo+" "+lowervo+") throws Exception {");
			bw.newLine();
			bw.write(" 	Session session = sessionFactory.openSession();");	
			bw.newLine();
			bw.write("	Transaction transaction = session.beginTransaction();");
			bw.newLine();
			bw.write("	session.saveOrUpdate("+lowervo+");");
			bw.newLine();
			bw.write("	transaction.commit();");
			bw.newLine();
			bw.write("	session.close();");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	public void "+form.toLowerCase()+"search() throws Exception {");
			bw.newLine();
			bw.write("	List searchlist=new ArrayList();");
			bw.newLine();
			bw.write(" 	Session session = sessionFactory.openSession();");	
			bw.newLine();
			bw.write("	Transaction transaction = session.beginTransaction();");
			bw.newLine();
			bw.newLine();
			bw.write("	Query q=session.createQuery(\"From "+capitalvo+" where Status=true\");");
			bw.newLine();
			bw.write("	searchlist=q.list();");
			bw.newLine();
			bw.newLine();
			bw.write("	transaction.commit();");
			bw.newLine();
			bw.write("	session.close();");
			bw.newLine();
			bw.write("	return searchlist;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	public void "+form.toLowerCase()+"delete("+capitalvo+" "+lowervo+") throws Exception {");
			bw.newLine();
			bw.write("	List deletelist=new ArrayList();");
			bw.newLine();
			bw.write(" 	Session session = sessionFactory.openSession();");	
			bw.newLine();
			bw.write("	Transaction transaction = session.beginTransaction();");
			bw.newLine();
			bw.newLine();
			bw.write("	Query q=Session.createQuery(\"From "+capitalvo+" where "+form.toLowerCase()+"Id='\"+"+lowervo+".get"+form.toUpperCase().charAt(0)+form.substring(1).toLowerCase()+"Id()+\"'\");");
			bw.newLine();
			bw.write("	deletelist=q.list();");
			bw.newLine();
			bw.write("	transaction.commit();");
			bw.newLine();
			bw.write("	session.close();");
			bw.newLine();
			bw.write("	return deletelist;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("}");
			bw.close();
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
		
		public static String GenerateSpringServletXML(String email,String project,String form,List fieldlist) throws IOException
		{
			String webinf=email+SUFFIX+project+SUFFIX+"WEB-INF"+SUFFIX;
			String filename=webinf+"spring-servlet.xml";
			System.out.println("filename:"+filename);
			System.out.println("Generate jsp");
			
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			bw.newLine();
			bw.write("<beans xmlns=\"http://www.springframework.org/schema/beans\"");
			bw.newLine();
			bw.write("	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
			bw.newLine();
			bw.write("	xmlns:p=\"http://www.springframework.org/schema/p\"");
			bw.newLine();
			bw.write("	xmlns:context=\"http://www.springframework.org/schema/context\"");
			bw.newLine();
			bw.write("	xsi:schemaLocation=\"http://www.springframework.org/schema/beans"); 
			bw.newLine();
			bw.write("	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd");  
			bw.newLine();
			bw.write("	http://www.springframework.org/schema/context");
			bw.newLine();
			bw.write("	http://www.springframework.org/schema/context/spring-context-3.0.xsd\">");
			bw.newLine();
			bw.newLine();
			bw.write("	<context:component-scan base-package=\"com\"/><!-- base package name which contains con,dao,vo packages -->");
			bw.newLine();
			bw.newLine();
			bw.write("	<bean class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">");
			bw.newLine();
			bw.write("		<property name=\"prefix\" value=\"/WEB-INF/view/\" /><!--exclude index page all other jsp pages are include in WEB-INF folder-->");
			bw.newLine();
			bw.write("		<property name=\"suffix\" value=\".jsp\" /><!--extension of those pages-->");
			bw.newLine();
			bw.write("	</bean>");
			bw.newLine();
			bw.newLine();
			bw.write("	<bean id=\"dataSource\" class=\"org.apache.commons.dbcp2.BasicDataSource\">");
			bw.newLine();
			bw.write("		<property name=\"driverClassName\" value=\"com.mysql.jdbc.Driver\"/>");
			bw.newLine();
			bw.write("		<property name=\"url\" value=\"jdbc:mysql://localhost/db2\"/>");
			bw.newLine();
			bw.write("		<property name=\"username\" value=\"root\"/>");
			bw.newLine();
			bw.write("		<property name=\"password\" value=\"root\"/>");
			bw.newLine();
			bw.write("	</bean>");
			bw.newLine();
			bw.newLine();
			bw.write("	<bean id=\"sessionFactory\" class=\"org.springframework.orm.hibernate4.LocalSessionFactoryBean\">");
			bw.newLine();
			bw.write("		<property name=\"dataSource\" ref=\"dataSource\"/>");
			bw.newLine();
			bw.newLine();
			bw.write("		<property name=\"annotatedClasses\">");
			bw.newLine();
			bw.write("			<list>");
			bw.newLine();
			bw.write("				<value>com.VO.*</value><!--vo file destination-->");
			bw.newLine();
			bw.write("			</list>");
			bw.newLine();
			bw.write("		</property>");
			bw.newLine();
			bw.newLine();
			bw.write("		<property name=\"hibernateProperties\">");
			bw.newLine();
			bw.write("			<props>");
			bw.newLine();
			bw.write("				<prop key=\"hibernate.dialect\">org.hibernate.dialect.MySQLDialect</prop>");
			bw.newLine();
			bw.write("				<prop key=\"hibernate.show_sql\">true</prop>");
			bw.newLine();
			bw.write("				<prop key=\"hibernate.hbm2ddl.auto\">update</prop>");
			bw.newLine();
			bw.write("			</props>");
			bw.newLine();
			bw.write("		</property>");
			bw.newLine();
			bw.newLine();
			bw.write("	</bean>");
			bw.newLine();
			bw.write("</beans>");
			
			bw.close();
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
		
		public static String GenerateWebXML(String webinf) throws IOException
		{
			String filename=webinf+"web.xml";
			System.out.println("filename:"+filename);
			System.out.println("Generate jsp");
			
			File file1 = File.createTempFile("demo",".tmp" );
			BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			bw.newLine();
			bw.newLine();
			bw.write("<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
			bw.newLine();
			bw.write("	xmlns=\"http://java.sun.com/xml/ns/javaee\"");
			bw.newLine();
			bw.write("	xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\"");
			bw.newLine();
			bw.write("	version=\"2.5\">");
			bw.newLine();
			bw.newLine();
			bw.write("	<servlet>");
			bw.newLine();
			bw.write("		<servlet-name>spring</servlet-name><!--servlet name should be same as per file name-->");
			bw.newLine();
			bw.write("		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>");
			bw.newLine();
			bw.write("	</servlet>");
			bw.newLine();
			bw.newLine();
			bw.write("	<servlet-mapping>");
			bw.newLine();
			bw.write("		<servlet-name>spring</servlet-name><!--servlet name should be same as above-->");
			bw.newLine();
			bw.write("		<url-pattern>*.html</url-pattern><!--we can add mutliple url pattern-->");
			bw.newLine();
			bw.write("	</servlet-mapping>");
			bw.newLine();
			bw.newLine();
			bw.write("</web-app>");
					
			bw.close();
			s3Client.putObject(bucketname,filename,file1);
			
			System.out.println("form created");
			link = s3Client.getUrl(bucketname, filename).toString();
			return link;
		}
}
		
	