<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>SourceCodeGeneration</title>
  <!-- base:css -->
  <link rel="stylesheet" href="adminResources/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="adminResources/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="adminResources/images/logo-mini.png" />
  <script type="text/javascript">
  	function fn1()
  	{
  		//******First Name*******			
  	    var a = document.getElementById("fn");
  		var a1 = document.getElementById("sfn1");
  		var a2 = document.getElementById("sfn2");	
  	    
  		if(a.value=="")
  		{
  			a.style.border="1px solid red";
  	        a1.style.display="";
  	        return false;
  		}
  		else if(a.value.length < 3)
  		{
  	        a.style.border="1px solid red";
  			a1.style.display="none";
  	        a2.style.display="";
  	      	return false;
  	    }
  		
  	    else
  		{
  	        a.style="display none";
  			a1.style.display="none";
  			a2.style.display="none";
  	    }
  		
  		//******Last Name*******			
  	    var b = document.getElementById("ln");
  		var b1 = document.getElementById("sln1");
  		var b2 = document.getElementById("sln2");	
  	    
  		if(b.value=="")
  		{
  			b.style.border="1px solid red";
  	        b1.style.display="";
  	     	return false;
  		}
  		else if(b.value.length < 3)
  		{
  	        b.style.border="1px solid red";
  			b1.style.display="none";
  	        b2.style.display="";
  	      	return false;
  	    }
  		
  	    else
  		{
  	        b.style="display none";
  			b1.style.display="none";
  			b2.style.display="none";
  	    }
  		
  		
  		
  		//******Email*******			
  	    var d = document.getElementById("em");
  		var d1 = document.getElementById("sem1");
  		var d2 = document.getElementById("sem2");	
  		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  		
  		if(d.value=="")
  		{
  			d.style.border="1px solid red";
  	        d1.style.display="";
  	      	return false;
  		}
  		else if(!filter.test(d.value))
  		{
  			d.style.border="1px solid red";
  			d1.style.display="none";
  	        d2.style.display="";
  	        return false;
  	    }
  		
  	    else
  		{
  			d.style="display none";
  			d1.style.display="none";
  			d2.style.display="none";
  	    }

  		//******Phone Number*******
  		var e = document.getElementById("phon");
  		var e1 = document.getElementById("spn1");
  		var e2 = document.getElementById("spn2");	
  	    
  		if(e.value=="")
  		{
  			e.style.border="1px solid red";
  	        e1.style.display="";
  	     	return false;
  		}
  		else if(e.value.length < 10)
  		{
  	        e.style.border="1px solid red";
  			e1.style.display="none";
  	        e2.style.display="";
  	      	return false;
  	    }
  	    else
  		{
  	        e.style="display none";
  			e1.style.display="none";
  			e2.style.display="none";
  	    }
  		
  		//******Birth Date*******
  		var g = document.getElementById("dob");
  		var g1 = document.getElementById("sdob");
  	    
  		if(g.value=="")
  		{
  			g.style.border="1px solid red";
  	        g1.style.display="";
  	      	return false;
  		}
  	    else
  		{
  	        g.style="display none";
  			g1.style.display="none";
  			
  	    }
  		
  		//******Password*******
  		var h = document.getElementById("pwd");
  		var h1 = document.getElementById("spwd1");
  		var h2 = document.getElementById("spwd2");	
  	    
  		if(h.value=="")
  		{
  			h.style.border="1px solid red";
  	        h1.style.display="";
  	      	return false;
  		}
  		else if(h.value.length < 8)
  		{
  	        h.style.border="1px solid red";
  			h1.style.display="none";
  	        h2.style.display="";
  	      	return false;
  	    }
  	    else
  		{
  	        h.style="display none";
  			h1.style.display="none";
  			h2.style.display="none";
  	    }
  	}
  </script>
  
  
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left py-5 px-4 px-sm-5 border">
              <div class="brand-logo">
                <img src="adminResources/images/logo.png" alt="logo">
              </div>
              <h4>New here?</h4>
              <h6 class="font-weight-light">Signing up is easy. It only takes a few steps</h6>
              <f:form class="pt-3" action="registerStore" modelAttribute="RegisterVO" method="POST" onsubmit="return fn1()">
                
                <div class="form-group">
                  <f:input path="firstName" class="form-control form-control-lg" id="fn" placeholder="FirstName" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122'/>
               	  <span style="color: red;display: none" id="sfn1">Enter First Name</span>
				  <span style="color: red;display: none" id="sfn2">Enter Valid Name</span>
                </div>
             
             
                <div class="form-group">
                  <f:input path="lastName" class="form-control form-control-lg" id="ln" placeholder="Lastname" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122'/>
               	  <span style="color: red;display: none" id="sln1">Enter Last Name</span>
  				  <span style="color: red;display: none" id="sln2">Enter Valid Name</span>
                </div>
                <div class="form-group">
                  <f:input path="loginVO.username" class="form-control form-control-lg" id="em" placeholder="UserName"/>
                  <span style="color: red;display: none" id="sem1">Enter Email</span>
				  <span style="color: red;display: none" id="sem2">Email Address Not Valid</span>
                </div>
                
                <div class="form-group">
                  <f:input path="loginVO.password" class="form-control form-control-lg" id="pwd" placeholder="Password"/>
                  <span style="color: red;display: none" id="spwd1">Enter Password</span>
				  <span style="color: red;display: none" id="spwd2">Using Minimum 8 character</span>
                </div>
                
                <div class="form-group">
                  <f:input path="mobileNumber" class="form-control form-control-lg" id="phon" placeholder="PhoneNumber" onkeypress='return event.charCode>=48 && event.charCode<=57'/>
                  <span style="color: red;display: none" id="spn1">Enter phone number</span>
				  <span style="color: red;display: none" id="spn2">Enter Valid number</span>
                </div>
                
                <div class="form-group">
                  <f:input type="date" path="dateOfBirth" class="form-control form-control-lg" id="dob" placeholder="DateOfBirth"/>
                <span style="color: red;display: none" id="sdob">Enter your birth date</span>
                </div>
                
                
                <div class="form-group">
                  <f:select path="profession" class="form-control form-control-lg" id="exampleFormControlSelect2">
                     <f:option value="Profession">Profession</f:option>
                    <f:option value="Full Stack Developer">Full Stack Developer</f:option>
                    <f:option value="Software Developer">Software Developer</f:option>
                    <f:option value="Cloud Architect">Cloud Architect</f:option>
                    <f:option value="Software Engineer">Software Engineer</f:option>
                  </f:select>
                </div>
                
               
                <div class="mt-3">
                    <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="Submit"/>
              </div>
                <div class="text-center mt-4 font-weight-light">
                  Already have an account? <a href="login" class="text-primary">Login</a>
                </div>
              </f:form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- base:js -->
  <script src="adminResources/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="adminResources/js/off-canvas.js"></script>
  <script src="adminResources/js/hoverable-collapse.js"></script>
  <script src="adminResources/js/template.js"></script>
  <script src="adminResources/js/settings.js"></script>
  <script src="adminResources/js/todolist.js"></script>
  <!-- endinject -->
</body>

</html>