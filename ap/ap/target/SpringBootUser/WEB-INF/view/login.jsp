<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>SourceCodeGeneration</title>
  
  <link rel="stylesheet" href="static/adminResources/css/materialdesignicons.min.css" type="text/css">
  <link rel="stylesheet" href="static/adminResources/css/vendor.bundle.base.css" type="text/css">
  
  <link rel="stylesheet" href="adminResources/css/style.css" type="text/css">
  
  <link rel="shortcut icon" href="adminResources/images/logo-mini.png"  />
  <script>
  	function fn(){
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
              <h6 class="font-weight-light">Sign in to continue.</h6>
              
              
              <form action="/j_spring_security_check" method="POST" onsubmit="return fn()">
              
                <div class="form-group">
                  <input type="email"  name="username" class="form-control form-control-lg" id="em" placeholder="Username" >
					<span style="color: red;display: none" id="sem1">Enter Email</span>
					<span style="color: red;display: none" id="sem2">Email Address Not Valid</span>
                </div>
                <div class="form-group">
                  <input type="password" name="password" class="form-control form-control-lg" id="pwd"  placeholder="Password">
                  <span style="color: red;display: none" id="spwd1">Enter Password</span>
				  <span style="color: red;display: none" id="spwd2">Using Minimum 8 charcter</span>
                </div>
                <div class="mt-3">
                  <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="Login" />
                </div>
                 </form>
            
                <div class="my-2 d-flex justify-content-between align-items-center">
                  <div class="form-check">
                    <label class="form-check-label text-muted">
                      <input type="checkbox" class="form-check-input">
                      Keep me signed in
                    </label>
                  </div>
                  <a href="forgetPassword" class="auth-link text-black">Forgot password?</a>
                </div>
               
                <div class="text-center mt-4 font-weight-light">
                  Don't have an account? <a href="register" class="text-primary">Create</a>
                </div>
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
  <script src="adminResources/js/vendor.bundle.base.js"  type="application/json"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="adminResources/js/off-canvas.js"  type="application/json"></script>
  <script src="adminResources/js/hoverable-collapse.js"  type="application/json"></script>
  <script src="adminResources/js/template.js"  type="application/json"></script>
  <script src="adminResources/js/settings.js"  type="application/json"></script>
  <script src="adminResources/js/todolist.js"  type="application/json"></script>
  <!-- endinject -->
</body>

</html>
