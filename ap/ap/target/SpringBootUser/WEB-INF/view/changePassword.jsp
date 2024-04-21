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
              
              <f:form class="pt-3" action="/checkpassword" method="post" modelAttribute="LoginVO">
                <div class="form-group">
                  <f:input type="password" class="form-control form-control-lg" name="oldpassword" path="password" id="exampleInputEmail1" placeholder="Old Password"/>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="newpassword" id="exampleInputPassword1" placeholder="New Password" required>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="confirmpassword" id="exampleInputPassword1" placeholder="Confirm Password" required>
                </div>
                <div class="form-group">
                  <input type="submit" value="SIGN IN" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" >
                </div>
                 </f:form>
                 
                <%
                	String erroroldpassword=(String)session.getAttribute("erroroldpassword");
                	String errornewpassword=(String)session.getAttribute("errornewpassword");
                	                	
                	if(erroroldpassword!=null)
                	{
                		
                		out.println(erroroldpassword);
                		session.removeAttribute("erroroldpassword");
                	}
                	if(errornewpassword!=null)
                	{
                		
                		out.println(errornewpassword);
                		session.removeAttribute("errornewpassword");
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
