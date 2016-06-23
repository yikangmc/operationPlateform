<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" 		prefix="c"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt" %>

<%@ page isELIgnored ="false"%>

	<link rel="shortcut icon" href="<%=basePath%>img/common/YK.png"  type="image/x-icon"/>
	<link rel="Bookmark" 	  href="<%=basePath%>img/common/YK.png"  type="image/x-icon"/>
	<link rel="icon" 		  href="<%=basePath%>img/common/YK.png"  type="image/x-icon"/>
	
	<!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>js/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<%=basePath%>js/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="<%=basePath%>js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    
    <script src="<%=basePath%>js/plugins/iCheck/icheck.min.js"></script>
    
    
      <!-- FastClick -->
    <script src="<%=basePath%>js/plugins/fastclick/fastclick.min.js"></script>
    <!-- CK Editor -->
<!--     <script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script> -->
	<script src="<%=basePath%>js/plugins/ckeditor/ckeditor.js"></script>
	<script src="<%=basePath%>js/plugins/ckeditor/config.js"></script>
	<script src="<%=basePath%>js/plugins/ckeditor/plugins/image/dialogs/image.js"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<%=basePath%>js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script>
      $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('editor1');
        //bootstrap WYSIHTML5 - text editor
        $(".textarea").wysihtml5();
      });
    </script>
	
    <script type="text/javascript">
    	var basePath='<%=basePath %>';
    </script>