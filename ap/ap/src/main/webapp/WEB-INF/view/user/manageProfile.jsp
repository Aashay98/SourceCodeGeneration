<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>SourceCodeGeneration</title>
  
  <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/materialdesignicons.min.css" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>adminResources/css/vendor.bundle.base.css" />
  
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/style.css" />
  <!-- endinject -->
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/adminResources/images/logo-mini.png" />
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
                <img src="<%=request.getContextPath() %>/adminResources/images/logo.png" alt="logo">
              </div>
              <h4>Manage Profile</h4>
              <h6 class="font-weight-light"></h6>
              <f:form class="pt-3" action="updateRegister" modelAttribute="profilelist" method="post">
                
                <div class="form-group">
                  <f:input path="firstName" class="form-control form-control-lg" id="exampleInputFirstname1" placeholder="FirstName"/>
                </div>
             
             
                <div class="form-group">
                  <f:input path="lastName" class="form-control form-control-lg" id="exampleInputLastname1" placeholder="Lastname"/>
                </div>
                <div class="form-group">
                  <f:input path="loginVO.username" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="UserName"/>
                </div>
             
                <div class="form-group">
                  <f:input path="loginVO.password" class="form-control form-control-lg" id="exampleInputpassword1" placeholder="Password"/>
                </div>
                
                <div class="form-group">
                  <f:input path="mobileNumber" class="form-control form-control-lg" id="exampleInputPhonenumber1" placeholder="PhoneNumber"/>
                </div>
                
                <div class="form-group">
                  <f:input path="dateOfBirth" class="form-control form-control-lg" id="exampleInputPhonenumber1" placeholder="DateOfBirth"/>
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
                
               <f:hidden path="registerId"/>
              
              <input type="hidden" name="loginId" value=" ${profilelist.loginVO.loginId}">
                <div class="mt-3">
                    <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="Submit"/>
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
  <script src="<%=request.getContextPath() %>/adminResources/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="<%=request.getContextPath() %>/adminResources/js/off-canvas.js"></script>
  <script src="<%=request.getContextPath() %>/adminResources/js/hoverable-collapse.js"></script>
  <script src="<%=request.getContextPath() %>/adminResources/js/template.js"></script>
  <script src="<%=request.getContextPath() %>/adminResources/js/settings.js"></script>
  <script src="<%=request.getContextPath() %>/adminResources/js/todolist.js"></script>
  <!-- endinject -->
</body>

</html>

