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
  	function fn2()
  	{
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
              <h6 class="font-weight-light">UserName</h6>
              <f:form class="pt-3" action="/addusernamefp" method="post" modelAttribute="LoginVO" onsubmit="return fn2()">
                <div class="form-group">
                  <f:input type="email" path="username" class="form-control form-control-lg" id="em" placeholder="Username" required="required"/>
                  <span style="color: red;display: none" id="sem1">Enter Email</span>
				  <span style="color: red;display: none" id="sem2">Email Address Not Valid</span>
                </div>      
                <div class="form-group">
                  <input type="submit" value="Submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" >
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
