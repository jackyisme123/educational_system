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
<script type="text/javascript">
	function deleteStuCourse(id) {
		location.href = "deleteStuCourse.do?id="+id;
	}
</script>
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
		<form action="">
		<div class="data">  
			<h1>${stuName }之贵族专属课程</h1>
			<input type="button" class="add" value="选课" onclick="location.href='toShowCourse.do';"/>          
      		<table border="1" width=80% >
          		<tr>
					<th>学号</th>          		
              		<th>课程代码</th>
		              <th class="width100">课程名</th>
		              <th>教师</th>
		              <th>上课地点</th>
		              <th>上课时间</th>
		              <th>考试时间</th>
		              <th>状态</th>
			     </tr> 
			 	<c:forEach items="${stucourses }" var="s">
				 	<tr>
				 		<td>${s.studentId }</td>
				 		<td>${s.courseId }</td>
				 		<td>${s.courseName }</td>
				 		<td>${s.teacherName }</td>
				 		<td>${s.classroomName }</td>
				 		<td>${s.classDate }</td>
				 		<td>${s.examDate }</td>
				 		<td>
				 			<input type="button" value="删除"  onclick="deleteStuCourse(${s.courseId});" />
				 		</td>
				 	</tr>
			 	</c:forEach>
			</table>
			<!-- 分页 -->
			<div class="pages">
                 <!-- 当前是第1页，则不能点上一页 -->
                 <c:if test="${page==1 }">
                 	 <a href="">上一页</a>
                 </c:if>
                 <c:if test="${page!=1 }">
	     	        	  <a href="findStuCourse.do?page=${page-1 }">上一页</a>
                 </c:if>
                 
                 <!-- 
                 	begin：循环起始位置；
                 	end：循环终止位置；
                 -->
                 <c:forEach begin="1" end="${total }" var="i">
                 	 <!-- 若循环到了当前页，则将页码高亮显示 -->
                 	 <c:if test="${i==page }">
                 	 	<a href="findStuCourse.do?page=${i }">${i }</a>
                 	 </c:if>
                 	 
                   <!-- 若不是当前页，则去掉高亮的样式 -->
                   <c:if test="${i!=page }">
                   	<a href="findStuCourse.do?page=${i }">${i }</a>
                   </c:if>
                   
                 </c:forEach>
                 
                 <!-- 当前页是最后一页，则不能点下一页 -->
                 <c:if test="${page==total }">
                 	 <a href="">下一页</a>
                 </c:if>
                 <c:if test="${page!=total }">
	                 <a href="findStuCourse.do?page=${page+1 }">下一页</a>
                 </c:if>
                </div>
		</div>  
	</form>         
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