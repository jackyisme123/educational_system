<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="cjcx.css" />
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
	<div class="total">
		<div class="part1">
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
				<div class="part2">
					<div class="headline">
			<c:import url="../headline/headline_admin.jsp"></c:import>	
			</div>
					<div class="pic"></div>
					<div class="content">

						<form action="updateScore.do" method="post">
							<div>
								学&nbsp&nbsp&nbsp&nbsp号:<input type="text" readonly name="stuId" value="${score.stuId }" /> <span>*必须填写</span>
								<p>
									</>课程编号:<input type="text" readonly name="courseId"
									value="${score.courseId }" /> <span>*必须填写</span>
								<p>
									</>学&nbsp&nbsp&nbsp&nbsp科:<input type="text" name="courseName"
										value="${score.courseName }" /> <span>*必须填写</span>
								</p>
								<p>
									</>任课老师:<input type="text" name="teacherName"
										value="${score.teacherName }" /> <span>*必须填写</span>
								</p>
								<p>
									</>成&nbsp&nbsp&nbsp&nbsp绩:<input type="text" name="scoreNum"
										value="${score.scoreNum }" /> <span>*必须填写</span>
								</p>
								<input type="submit" value="修改" class="btn_save" /> <input
									type="button" value="取消" class="btn_save"
									onclick='history.back()' />
							</div>


						</form>


					</div>
				</div>

				<div class="part3">
					<div>
				&nbsp<a href="toIndexAdmin.do">首&nbsp页</a>&nbsp|&nbsp<a href="findCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="adminFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findAll.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_admin.b">教学风采</a>&nbsp|&nbsp<a
					href="">联系方式</a>
			</div>
					<p>本网页属于葬爱家族,版权所有，违者必究</p>
					<p>http://tieba.baidu.com/p/4800084227</p>
				</div>
			</div>
			
</body>
</html>