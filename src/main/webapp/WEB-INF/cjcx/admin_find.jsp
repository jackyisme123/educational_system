<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="pic">
	
	</div>
	<div class="content">
	    <form action="">	  
		<table border="1px solid red"  cellsspaceing="50" width="80%">
		   <thead>
		       <tr>
		          <th>学号</th>
		        
		          <th>课程编号</th>
		          <th>学科</th>
		          <th>任课老师</th>
		          <th>成绩</th>
		          <th><input type="button" value="增加" class="btn_add" onclick="location.href='toAddScore.do'" /></th>
		       </tr>
		   </thead>
		   <tbody >
		   <c:forEach items="${score }" var='c'>
		       <tr>
		          <th>${c.stuId }</th>
		          <td name="id">${c.courseId }</td>
		          <td>${c.courseName }</td>
		          <td>${c.teacherName }</td>
		          <td>${c.scoreNum }</td>
		       <td>                                
                   <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateScore.do?id=${c.courseId}'" />
                   <input type="button" value="删除" class="btn_delete" onclick="location.href='deleteScore.do?id=${c.courseId}'" />
               </td>
		       </tr>
		     </c:forEach>
		   </tbody>	
		  
		</table>
		<!--分页-->
                <div id="pages" >
                <!-- 当前是第一页，则不能点上一页 -->
        	       <c:if test="${page==1 }">
        	           <a href="">上一页</a>
        	       </c:if>  
        	       <c:if test="${page!=1 }">
        	           <a href="adminFindScore.do?page=${page-1 }">上一页</a>
        	       </c:if> 
        	       <!-- 
        	           begin:循环起始位置；
        	           end:循环终止位置；
        	        -->
        	       <c:forEach begin="1" end="${total }" var="i">
        	         <!-- 若循环到了当前页，则将页码高亮显示 -->
        	         <c:if test="${i==page }">
        	            <a href="adminFindScore.do?page=${i }" class="current_page">${i }</a>
        	         </c:if>
        	         <!-- 若不是当前页，则去掉将高亮样式 -->
        	         <c:if test="${i!=page }">
        	            <a href="adminFindScore.do?page=${i }">${i }</a>
        	         </c:if>
        	       </c:forEach>
        	      
        	       <!-- 当前页面是最后一夜，则不能点下一页 -->
        	       <c:if test="${page==total }">
        	           <a href="">下一页</a>
        	       </c:if>
        	       <c:if test="${page!=total }">
        	           <a href="adminFindScore.do?page=${page+1 }">下一页</a>
        	       </c:if>
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