<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style type="text/css">

#stuName{
font-size: 24px;
color:#ff0000;
text-shadow:0 1px 0 gray;
}
.login p{
	font-size:20px;
	margin:10px;
}

#quit {
text-align:right;
font-size:20px;
font-weight:bord;
}
.content {
background-image: url("images/ls.jpg") ;
background-repeat: no-repeat;
background-position: bottom;
}
</style>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
</head>
<body>
	<!-- 全部页面 -->
	<div class="total">
	<!-- part1包括：logo，login及公共系统 -->
	<div class="part1">
		<!-- logo区 -->
		<div class="logo_top">
		<img alt="" src="images/logo2.jpg">
		</div>
	<!-- login区域 -->
		<% 
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		String stuName="";
		for(Cookie c: cookies){
			if("coname".equals(c.getName()))
			stuName=	java.net.URLDecoder.decode(c.getValue(), "UTF-8");}
		request.setAttribute("stuName", stuName);
		%>
		<div class="login">
		<c:import url="../../type/stulogin.jsp"></c:import>
        </div>	
        <!-- 公告栏区域 -->
	<div class="notice" style="padding:80px">
		<c:import url="../notice_stu.jsp"></c:import>
		<div>
		
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../../headline/headline_stu.jsp"></c:import>	
			</div>
	<!-- 图片区 -->
	<div class="pic">
	<img alt="" src="images/pic.jpg">
	</div>
	<!-- 内容区 -->
	<div class="content">
	<div class="con1_2">
		<h1>葬爱:</h1>	
					<p >&nbsp&nbsp把我们的爱都葬了吧,从此一刀两断 .一刀两断,你和我走到今天,实在情非所愿 
						原本深深的爱着彼此,如今却要天各一方 .是什么让我们这样把心灵狠狠戳伤, 
						爱到了这个份上 也没什么可讲 ,把属于我们的爱情都葬了吧 !
						不管它以后会怎样 ,把它葬在同一个地方,把我们的名字也刻上. 
						如果那天爱能重生,你是否还记得我的模样 ,
						想想这个葬爱的地方, 会不会变得十分凄凉 .
						把所有的快乐 ,悲伤随爱葬了吧 !
						从此不再去想!不再去想!</p>
					<p>&nbsp&nbsp</p>
					<p>&nbsp&nbsp </p>
					<p>&nbsp&nbsp </p>
					<p>&nbsp&nbsp </p>
					<p class="con1_1">&nbsp&nbsp  葬爱冷少-</p>
					
	
	</div>
	</div>
	</div>
	<!-- part3：版权区 -->
	<div class="part3">
	<div>
				&nbsp<a href="toIndexStu.do">首&nbsp页</a>&nbsp|&nbsp<a href="findStuCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="stuFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findStu.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_stu.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactStu.do">联系方式</a>
			</div>
	<p>本网页属于葬爱家族,版权所有，违者必究</p>
	<p><a href="#">http://tieba.baidu.com/p/4800084227</a></p>
	</div>
	</div>
	
</body>
</html>


