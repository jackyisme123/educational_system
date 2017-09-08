<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link type="text/css" rel="stylesheet" href="main.css" />
<link type="text/css" rel="stylesheet" href="style/course.css" />
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
			<h1 class="title">为了家族！</h1>
		</div>
		<form action="updateCourse.do" method="post" class="course">
			<div>
			<table class="table" >
				<tr>
					<td>课程代码：<input class="input" type="text" name="courseId" value="${course.courseId }"/></td>
					<td>课程名：<input class="input" type="text" name="courseName" value="${course.courseName }"/></td>
				</tr>
				<tr>
					<td>教师：<input class="input" type="text" name="teacherName" value="${course.teacherName }"/></td>
					<td>上课地点：<input class="input" type="text" name="classroomName" value="${course.classroomName }"/></td>
				</tr>
				<tr>	
					<td>上课时间：<input class="input" type="text" name="classDate" value="${course.classDate }"/></td>
					<td>考试时间：<input class="input" type="text" name="examDate" value="${course.examDate }"/></td>
				</tr>
			</table>
			</div>
				<div class="but_div">
				<input class="btn" type="submit" value="保存" />
				<input class="btn" type="button" value="取消" onclick="history.back()"/>
				</div>
			</form>

		</form>
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
	<p><a href="#">http://tieba.baidu.com/p/4800084227</a></p>
	</div>
	
	
</body>
</html>