<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
<style type="text/css">


.login p{
	font-size:20px;
	margin:10px;
}

#user{
font-size: 24px;
color:#ff0000;
text-shadow:0 1px 0 gray;

}

#quit {
text-align:right;
font-size:20px;
font-weight:bord;
color:gold;
}
</style>
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
		<div class="login">
		<c:import url="../type/adminlogin.jsp"></c:import>
        </div>
		<!-- 公告栏区域 -->
		<div class="notice" style="padding:80px">
		<c:import url="../notice/notice_admin.jsp"></c:import>
		</div>
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../headline/headline_admin.jsp"></c:import>	
			</div>
	<!-- 图片区 -->
	<div class="pic">
	<img alt="" src="images/pic.jpg">
	</div>
	<!-- 内容区 -->
	<div class="content">
	<div>
		<h1>葬爱家族简介:</h1>
		
			 
			<h2>(1)释义</h2>
				<p>&nbsp&nbsp葬爱有伤感，颓废之意。葬爱还有是不想再爱了，是害怕再受伤害，把自己的真情和挚爱埋葬心里，不会轻易地接纳另一个她（他）。</p>
			
			
				<h2>(2)寓意</h2>
				
					
					<p>&nbsp&nbsp 1.失去爱后，要让自己忘记那段刻骨铭心的爱，埋葬掉自己的爱，不再去爱，埋葬掉自己的回忆以及自己的心痛，葬掉爱情，埋掉一切，是心的祭奠！</p>
					
					
					<p>&nbsp&nbsp 2.当得不到她(他)的爱了，就只能让自己伤心，看着她(他)幸福，把爱埋葬起来，用最隆重的仪式来埋葬自己最深的爱..即把已有的却不想或不能的情感掩埋！</p>
					
					
					<p>&nbsp&nbsp 3.被爱情深深伤害了，心差不多死了一样，将自己的爱埋葬起来，不再付出真感情，不再去深爱！只怕受伤，只有在夜深人静的时候才会想起那段被埋葬的爱情！</p>
					
					
				
			
	
	</div>
	</div>
	</div>
	<!-- part3：版权区 -->
		<div class="part3">
			<div>
				&nbsp<a href="toIndexAdmin.do">首&nbsp页</a>&nbsp|&nbsp<a href="findCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="adminFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findAll.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_admin.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactAdmin.do">联系方式</a>
			</div>
			<p>本网页属于葬爱家族,版权所有，违者必究</p>
			<p>
				<a href="#">http://tieba.baidu.com/p/4800084227</a>
			</p>
		</div>
	</div>
	<embed src="bbb.mp3" width="0" height="0"></embed>
</body>
</html>