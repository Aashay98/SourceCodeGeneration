<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>SourceCodeGeneration</title>
  <!-- base:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/jqvmap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/flag-icon.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/logo-mini.png" />
</head>
<body class="sidebar-fixed">
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    
    
    
   <!-- :::::::::::::::::::::HEADER::::::::::::::::::::::::: -->
    <jsp:include page="header.jsp"></jsp:include>
    
    
    
    
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_settings-panel.html -->
      <div class="theme-setting-wrapper">
        <div id="settings-trigger"><i class="mdi mdi-settings"></i></div>
        <div id="theme-settings" class="settings-panel">
          <i class="settings-close mdi mdi-close"></i>
          <p class="settings-heading">SIDEBAR SKINS</p>
          <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
          <p class="settings-heading mt-2">HEADER SKINS</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles primary"></div>
            <div class="tiles secondary"></div>
            <div class="tiles dark"></div>
            <div class="tiles default"></div>
          </div>
        </div>
      </div>
      <div id="right-sidebar" class="settings-panel">
        <i class="settings-close mdi mdi-close"></i>
        <ul class="nav nav-tabs" id="setting-panel" role="tablist">
          <li class="nav-item">
            <a class="nav-link active" id="todo-tab" data-toggle="tab" href="#todo-section" role="tab" aria-controls="todo-section" aria-expanded="true">TO DO LIST</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" id="chats-tab" data-toggle="tab" href="#chats-section" role="tab" aria-controls="chats-section">CHATS</a>
          </li>
        </ul>
        
      </div>
      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
      
      
      
      <!-- :::::::::::::::::MENU:::::::::::::::: -->
      <jsp:include page="menu.jsp"></jsp:include>
      
      
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="dashboard-header d-flex flex-column grid-margin">
            
            
          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                      
                      
                      
                        <img src="<%=request.getContextPath()%>/adminResources/images/alexa.jpeg" style="width:1028px;" alt="ALEXA"/>
            
                      
                      
                  </div>
                </div>
              </div>
            </div>
          </div>

          
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        
        
        <!-- ::::::::::::::footer:::::::::::-->
        <jsp:include page="footer.jsp"></jsp:include>
        
              <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- base:js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.pie.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.resize.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.vmap.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.vmap.world.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.vmap.usa.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.peity.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.flot.dashes.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
  <!-- endinject -->
  <!-- plugin js for this page -->
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="<%=request.getContextPath()%>/adminResources/js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>

</html>

