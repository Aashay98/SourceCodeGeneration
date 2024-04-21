<!DOCTYPE html>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
  <!-- inject:css -->
  <link rel="stylesheet" href="adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="adminResources/images/logo-mini.png" />
  <script type="text/javascript">
  	function fn4()
  	{
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
		
		//******Confirm Password*******
		var k = document.getElementById("conpwd");
		var k1 = document.getElementById("sconpwd1");
		var k2 = document.getElementById("sconpwd2");	
	    
		if(k.value=="")
		{
			k.style.border="1px solid red";
	        k1.style.display="";
	        return false;
		}
		else if(k.value != h.value)
		{
	        k.style.border="1px solid red";
			k1.style.display="none";
	        k2.style.display="";
	        return false;
	    }
	    else
		{
	        k.style="display none";
			k1.style.display="none";
			k2.style.display="none";
	    }
  	}
  
  </script>
</head>

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
              <h4>Hello! let's get started</h4>
              <h6 class="font-weight-light">Change Password</h6>
              
              <f:form class="pt-3" action="/checkpassword" method="post" modelAttribute="LoginVO" onsubmit="return fn4()">
                <div class="form-group">
                  <f:input type="password" class="form-control form-control-lg" name="oldpassword" path="password" id="exampleInputEmail1" placeholder="Old Password"/>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="newpassword" id="pwd" placeholder="New Password" required>
               	  <span style="color: red;display: none" id="spwd1">Enter Password</span>
				  <span style="color: red;display: none" id="spwd2">Using Minimum 8 charcter</span>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="confirmpassword" id="conpwd" placeholder="Confirm Password" required>
                </div>
                <div class="form-group">
                  <input type="submit" value="SIGN IN" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" >
                </div>
                 </f:form>
                 
                <%
                	String erroroldpassword=(String)session.getAttribute("erroroldpassword");
                
                	                	
                	if(erroroldpassword!=null)
                	{
                		
                		out.println(erroroldpassword);
                		session.removeAttribute("erroroldpassword");
                	}
                	
                %>
             
               
          	
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
