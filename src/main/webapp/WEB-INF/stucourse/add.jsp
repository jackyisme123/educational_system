<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link type="text/css" rel="stylesheet" href="main.css" />
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
		<c:import url="../type/stulogin.jsp"></c:import>
        </div>
		<!-- 公告栏区域 -->
		<div class="notice">
		<div class="notice" style="padding:80px">
		<c:import url="../notice/notice_stu.jsp"></c:import>
		<div>
		</div>
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../headline/headline_stu.jsp"></c:import>	
			</div>
	<!-- 图片区 -->
	<div class="pic">
	<img alt="" src="images/pic.jpg">
	</div>
	<!-- 内容区 -->
	<div class="content">
	<h1>选啊选</h1>
		<form action="addStuCourse.do" method="post">
			  	<!--  
			<table>
				<thead>
					<tr>
						<td>学号</td>
						<td>课程代码</td>
						<td>课程名</td>
						<td>教师</td>
						<td>上课地点</td>
						<td>上课时间</td>
						<td>考试时间</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><span name="studentId">${stucourse.studentId }</span></td>
						<td><span name="courseId">${stucourse.courseId }</span></td>
						<td><span name="courseName">${stucourse.courseName }</span></td>
						<td><span name="teacherName">${stucourse.teacherName }</span></td>
						<td><span name="classroomName">${stucourse.classroomName }</span></td>
						<td><span name="classDate">${stucourse.classDate }</span></td>
						<td><span name="examDate">${stucourse.examDate }</span></td>
					</tr>
				</tbody>
			</table>
				-->
			<div>
				学号：<input type="text" name="studentId" value="${stucourse.studentId }" readOnly/>
			</div>
			<div>
			课程代码：<input type="text" name="courseId" value="${stucourse.courseId }" readOnly/>
			课程名：<input type="text" name="courseName" value="${stucourse.courseName }" readOnly/>
			
			</div>
			<div>
			教师：<input type="text" name="teacherName" value="${stucourse.teacherName }" readOnly/>
			上课地点：<input type="text" name="classroomName" value="${stucourse.classroomName }" readOnly/>
			</div>
			<div>
			上课时间：<input type="text" name="classDate" value="${stucourse.classDate }" readOnly/>
			考试时间：<input type="text" name="examDate" value="${stucourse.examDate }" readOnly/>
			</div>
			<input type="submit" value="确定">
			<input type="button" value="取消" onclick="location.href='toShowCourse.do'">
		</form>
		
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