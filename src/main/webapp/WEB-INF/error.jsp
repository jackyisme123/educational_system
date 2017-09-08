<%@page pageEncoding="utf-8" %>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>出错了</title>
        <style type="text/css">
        	body{
        	background-image: url("images/error.jpg");
        	
        	}
        	div {
        	float:right;
        
        	width:250px;
        	height:500px;
        	}
        	
        	span{
        	color:red;
        	font-size: 5em;
        	font-weight: bold;
        	text-shadow:5px 5px 5px gray;
        	}
        </style>
     <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    location.href = "toLogin.do";
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "toLogin.do";
                }
            }
      </script> 
     
    </head>
    <body class="error_page" onload="startTimes();">
        <div><h1 id="error" >
	        
	      &nbsp;&nbsp;<a  href="javascript:resetTimer();"><span id="secondes">5</span></a>&nbsp;&nbsp;
	      
            
            <img alt="" src="images/404.jpg">
            
        </h1>
        </div>
    </body>
</html>









