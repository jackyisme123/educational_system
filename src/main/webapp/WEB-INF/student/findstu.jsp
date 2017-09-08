<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
<style type="text/css">
td {align ="center";
	
}
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
	<div class="total">
		<div class="part1">
			
			<!-- logo区 -->
		<div class="logo_top">
		<img alt="" src="images/logo2.jpg">
		</div>
		<!-- login区域 -->
		<%
							response.setContentType("text/html;charset=utf-8");
							Cookie[] cookies = request.getCookies();
							String adminCode = "";
							String stuName = "";
							String gender = "";
							String age = "";
							String mobile = "";
							String address = "";
							for (Cookie c : cookies) {
								if ("coname".equals(c.getName())) {
									stuName = java.net.URLDecoder.decode(c.getValue(), "UTF-8");
								} else if ("adminCode".equals(c.getName())) {
									adminCode = c.getValue();
								} else if ("gender".equals(c.getName())) {
									gender = java.net.URLDecoder.decode(c.getValue(), "UTF-8");
								} else if ("age".equals(c.getName())) {
									age = c.getValue();
								} else if ("mobile".equals(c.getName())) {
									mobile = c.getValue();
								} else if ("address".equals(c.getName())) {
									address = java.net.URLDecoder.decode(c.getValue(), "UTF-8");
								}
							}
							request.setAttribute("adminCode", adminCode);
							request.setAttribute("stuName", stuName);
							request.setAttribute("gender", gender);
							request.setAttribute("age", age);
							request.setAttribute("mobile", mobile);
							request.setAttribute("address", address);
						%>
		<div class="login">
		<c:import url="../type/stulogin.jsp"></c:import>
        </div>
		<!-- 公告栏区域 -->
		<div class="notice">
		<div class="notice" style="padding:80px">
		<c:import url="../notice/notice_stu.jsp"></c:import>
		<div>
		</div></div>
				<div class="part2">
					<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../headline/headline_stu.jsp"></c:import>	
			</div>
					<div class="pic">
						<img alt="" src="images/pic.jpg">
					</div>
					<div class="content">
						<!-- 主区域 -->
						
						<div>
							<form action="" method="post">
								<table width="100%" border="1">
									<tr>
										<td width="25%">姓名：</td>
										<td width="25%"><span>${stuName }</span></td>
										<td width="25%">学号：</td>
										<td width="25%"><span>${adminCode }</span></td>
									</tr>
									<tr>
										<td>年龄：</td>
										<td><span>${age }</span> </td>
										<td>性别：</td>
										<td><span>${gender }</span></td>
									</tr>
									<tr>
										<td>电话：</td>
										<td><span>${mobile }</span></td>
										<td>地址：</td>
										<td><span>${address }</span></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>

				<div class="part3">
				<div>
				&nbsp<a href="toIndexStu.do">首&nbsp页</a>&nbsp|&nbsp<a href="findStuCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="stuFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findStu.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_stu.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactStu.do">联系方式</a>
			</div>
					<p>本网页属于葬爱家族,版权所有，违者必究</p>
					<p>http://tieba.baidu.com/p/4800084227</p>
				</div>
			</div>
			
</body>
</html>