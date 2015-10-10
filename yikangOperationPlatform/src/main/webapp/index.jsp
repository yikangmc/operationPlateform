<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="<%=path%>/img/common/YK.png" />
<link rel="Bookmark" href="<%=path%>/img/common/YK.png" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>易康美辰</title>

<link rel="stylesheet" type="text/css" href="css/protal/mainCss.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (max-device-width: 400px)"
	href="css/protal/smallScreen.css" />
<!-- Bootstrap -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script>
var _hmt = _hmt || [];
(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?bfa063bc01b8c0b11ee446bb9d4072a4";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
})();
</script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
    	<div id="toptiles1" style="width:100%; padding-top:20px; position:fixed; z-index:1;; height:70px; background:#FFF;">
          	<div id="titleone" class="fonts" style="margin-top:-4px; float:left; text-align:center; padding-left:76px;">
            	<img style="width:118px; height:38px;" src="img/protal/hlg.png" />
            </div>
            <div id="lefttitle" style="height:50px; width:200px; text-align:center; margin:auto; margin-top:-3px;">
        		<div id="tanks1"></div>
            	<img id="imgselectnowone" style=" display:none; width:173px; height:39px;" src="img/protal/fulc.png" />
            	<img id="imgselectnowtwo" style=" display:none; width:173px; height:39px;" src="img/protal/funl.png" />
            </div>
            <div id="titletwo" class="fonts" style="margin-top:-8px; float:right; margin-top:-48px; padding-right:70px;">
              	<a href="#01"><img class="imgs1" style="width:122px; height:29px;" src="img/protal/fw2.png" /></a>&nbsp;
                 &nbsp;
                <a href="#02"><img class="imgs1" style="width:122px; height:29px;" src="img/protal/fw1.png" /></a>
            </div>
            <div id="Boom" style=" width:100%; background:#E4E5E3; text-align:center; position:absolute; top:70px; margin-top:1px;">
            	<div class="bennerone" style="float:left; width:80%;">
            		<img class="benner" style="width:1200px;" src="img/protal/banner.png"  />
                </div>
            	<div style="float:left; width:32px; height:32px; position:relative; top:22px;">
                    <a name="Boom" style="cursor:pointer;" onclick="Boom()">
                        <img class="closes" styel="margin-top:12px;" src="img/protal/cancel.png"  />
                    </a>
                </div>
        	</div>
            <div style="margin-top:-17px;">
            	<div id="toptitlehr"></div>
               	<hr style="height:1px;border:none;border-top:1px solid  #0066CC;" />
            </div>
      	</div>
        <div class="div1_1" id="pa" >
           	<img id="images1" style="width:100%; height:100%;" src="img/protal/WEB.jpg" />
           	<img id="images2" style="width:100%; height:100%; display:none;" src="img/protal/phone/banner.jpg" />
        </div>
    	<div style="height:1000px;" class="dv1">
        	<a name="01"></a>
        	<div class="d1" style="width:80%; height:70%; margin:0 auto; position:relative; top:15%; background:url(img/protal/servicebackground.png); padding-top: 130px;">
            	<div class="ds" style="width:33%; height:400px; float:left; text-align:center;">
                    	<img style="width:310px; height:310px; margin-top:10px;" src="img/protal/yyfs.png" />
                 	<div style="text-align:center;">
                    	<img style="width:211px; height:36px; margin-top:10px;" src="img/protal/yyfs1.png" />
                    </div>
                 	<div style="text-align:center;">
                    	<img style="width:194px; height:51px; margin-top:10px;" src="img/protal/pg2.png" />
                    </div>
                </div>
                <div class="ds" style=" width:33%; height:400px; float:left; text-align:center;">
                    <img style="width:310px; height:310px; margin-top:10px;" src="img/protal/rupg.png" />
                    <div style="text-align:center;">
                    	<img style="width:211px; height:36px; margin-top:10px;" src="img/protal/rhpg1.png" />
                    </div>
                 	<div style="text-align:center;">
                    	<img style="width:194px; height:51px; margin-top:10px;" src="img/protal/pg1.png" />
                    </div>
                </div>
                <div class="ds" style="width:33%; height:400px; float:left; text-align:center;">
                    <img style="width:310px; height:310px; margin-top:10px;" src="img/protal/tgfs.png" />
                    <div style="text-align:center;">
                    	<img style="width:211px; height:36px; margin-top:10px;" src="img/protal/tgfw1.png" />
                    </div>
                 	<div style="text-align:center;">
                    	<img style="width:194px; height:51px; margin-top:10px;" src="img/protal/pg3.png" />
                    </div>
                </div>
                <div class="bottom1" style="width:100%; height:36px; float:left; margin-top:220px;">
                	<div style="width:70px; heigth:36px; margin:0 auto;">
                    	<a href="#001"><img style="width:70px; heigth:36px;" src="img/protal/bottomgo.png" /></a>
                    </div>
                </div>
            </div>
        </div>
    	<div class="d3" style="height:1100px;">
        	<a name="02"></a>
            <a name="001"></a>
        	<div id="dv2" style="width:80%; height:60%; position:relative; top:12%; text-align:center; margin:0 auto; background:url(img/protal/servicebackground.png); padding-top: 180px;">
            	<div class="d2" style="width:20%; height:400px; float:left; text-align:center;">
                	<div style="height:200px; margin:0 auto;">
                		<img style="width:130px; height:103px;" src="img/protal/01.png" />
                    </div>
                    <div>
                    	<img style="width:160px; height:38px;" src="img/protal/1.png" />
                    </div>
                </div>
                <div class="d2" style="width:20%; height:400px; float:left; text-align:center;">
                	<div style="height:200px;">
                		<img style="width:119px; height:120px;" src="img/protal/02.png" />
                    </div>
                    <div>
                    	<img style="width:160px; height:38px;" src="img/protal/2.png" />
                    </div>
                </div>
                <div class="d2" style="width:20%; height:400px; float:left; text-align:center;">
                	<div style="height:200px;">
                		<img style="width:138px; height:97px;" src="img/protal/03.png" />
                    </div>
                    <div>
                    	<img style="width:160px; height:38px;" src="img/protal/3.png" />
                    </div>
                </div>
                <div class="d2" style="width:20%; height:400px; float:left; text-align:center;"> 
                	<div style="height:200px;">
                		<img style="width:107px; height:143px;" src="img/protal/04.png" />
                    </div>
                    <div>
                    	<img style="width:160px; height:38px;" src="img/protal/4.png" />
                    </div>
                </div>
                <div class="d2" style="width:20%; height:400px; float:left; text-align:center;">
                	<div style="height:200px;">
                		<img style="width:102px; height:119px;" src="img/protal/05.png" />
                    </div>	
                    <div>
                    	<img style="width:80px; height:38px;" src="img/protal/5.png" />
                    </div>
                </div>
                <div class="bottom1" style="width:100%; height:36px; float:left; margin-top:208px;">
                	<div style="width:70px; heigth:36px; margin:0 auto;">
                    	<a href="#002"><img style="width:70px; heigth:36px;" src="img/protal/bottomgo.png" /></a>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <div style="height:400px; background:url(img/protal/phone/end.png);">
            	<a name="002"></a>
                <div id="bottomtitle" style="width:59%; height:240px; margin:0 auto; position:relative; top:25%; right:10%; ">
                	<div style=" margin:20px 20px 10px 20px;">
                    	<img class="bottomimg1" style="width:465px; height:25px;" src="img/protal/hr@stellarheal.com.png" />
                        <img class="bottomimg2" style="width:234px; height:14px; display:none;" src="img/protal/hr@stellarheal.com.png" />
                        <br />
                    </div>
                	<div style=" margin:20px 20px 10px 20px;">
                    	<img class="bottomimg1" style="width:533px; height:29px;" src="img/protal/yikang@stellarheal.com.png"/>
                        <img class="bottomimg2" style="width:183px; height:14px; display:none;" src="img/protal/yikang@stellarheal.com.png" />
                        <br />
                    </div>
                	<div style=" margin:20px 20px 10px 20px;">
                    	<img class="bottomimg1" style="width:766px; height:24px;" src="img/protal/yinsi.png" />
                        <img class="bottomimg2" style="width:366px; height:14px; display:none;" src="img/protal/phone/yinsi.png" />
                        <br />
                    </div>
                	<div style=" margin:20px 20px 10px 20px;">
                    	<img class="bottomimg1" style="width:917px; height:30px;" src="img/protal/phone/copyright-.png" />
                        <img class="bottomimg2" style="width:437px; height:14px; display:none;" src="img/protal/phone/copyright-.png" />
                        <br />
                    </div>
                </div>
            </div>
            <!-- 二维码 -->
            <div style="padding:10px; width:300px; height:50px;
            			background:#91A9BB;
                        border: 1px solid #5383CA;
                        border-top-left-radius: 15px; 
                        border-bottom-left-radius:  15px;  
                        width:220px; height:276px; position:fixed;right:0;top:220px;">
            	<img src="img/protal/202.png" />
            </div>
        </div>
		<script>
			window.onscroll = now;
			$(document).ready(function(){
				var width = $(window).width();
				var heigth = $(window).height();
				//alert("当前的宽"+parseInt(width)+"，当前的高"+parseInt(heigth));
				var infoanimateLeft = parseInt(screen.height); // 获得当前分辨率
				var bigimg = document.getElementById("#midtopimg");
				
				if(heigth >= width){
					//alert("执行手机方案");
					$("#tanks1").css({"height":"12"});
					$("#toptitlehr").css({"height":"88"});
					$("#toptiles1").css({"height":"110"});
					$(".imgs1").css({"display":"none"});
					$(".fonts img").css({"width":"230","height":"72"});
					$("#titleone").css({"padding-left":"14px;"});
					$("#lefts").css({"padding-left":"-160"});
					$("#rights").css({"padding-right":"-160"});
					$(".ds").css({"float":"none","margin":"0 auto","width":"100%","height":"440"});
					$("#images1").css({"display":"none"});
					$("#images2").css({"display":"block"});
					$(".d1").css({"width":"75%","height":"93%"});
					$(".d2").css({"float":"none","width":"auto"});
					$(".dv1").css({"height":"1600","padding-top":"-120"});
					$("#dv2").css({"height":"75%"});
					$(".d3").css({"height":"2700"});
					$("#bottomtitle").css({"width":"75%","height":"270"});
					$(".bottom1").css({"display":"none"});
					$("#lefttitle").css({"float":"right","width":"300"});
					$("#lefttitle img").css({"width":"230","height":"58","margin-top":"10"});
					$("#Boom").css({"margin-top":"30px"});
					$("#x").css({"margin-top":"8px"});
					$(".benner").css({"margin-left":"-100px"})
				}
			});
			
			function Boom(){
				$("#Boom").css({"display":"none"});
			}

			function now(){
				var top = document.body.scrollTop;
				var widthone = $(window).width();
				var heigthtwo = $(window).height();
				if(widthone >= heigthtwo){
					if(top < 840){
						$("#imgselectnowone").css({"display":"none"});
						$("#imgselectnowtwo").css({"display":"none"});
					}
					if(top >= 840 && top < 1700) {
						$("#imgselectnowone").css({"display":"block"});
						$("#imgselectnowtwo").css({"display":"none"});
					}
					if(top >= 1700) {
						$("#imgselectnowone").css({"display":"none"});
						$("#imgselectnowtwo").css({"display":"block"});
					}
				}
				if(widthone <= heigthtwo){
					if(top < 900){
						$("#imgselectnowone").css({"display":"none"});
						$("#imgselectnowtwo").css({"display":"none"});
					}
					if(top >= 900 && top < 2500) {
						$("#imgselectnowone").css({"display":"block"});
						$("#imgselectnowtwo").css({"display":"none"});
					}
					if(top >= 2500) {
						$("#imgselectnowone").css({"display":"none"});
						$("#imgselectnowtwo").css({"display":"block"});
					}
				}
			}
		</script>
  	</div>
</body>
</html>
