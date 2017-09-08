<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
<style type="text/css">
btn_add{
	text-align: left;
	margin: 0 right;
	
}

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
<script type="text/javascript">
	function deleteFee(id){
		var r = window.confirm("确定删除本族员吗？")
		if(r){
			location.href="deleteStu.a?id="+id;
		}
	}

</script>

</head>
<body>
	<div class="total">
		<div class="part1">
			<div class="logo_top">
				<img alt="" src="images/logo2.jpg">
			</div>
			<div class="login">
		<c:import url="../type/adminlogin.jsp"></c:import>
        </div>
			<div class="notice" style="padding:80px">
		<c:import url="../notice/notice_admin.jsp"></c:import>
		</div>
		</div>
				<div class="part2">
					<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../headline/headline_admin.jsp"></c:import>	
			</div>
					<div class="pic">
						<img alt="" src="images/pic.jpg">
					</div>
					<div class="content">
						<!-- 主区域 -->
						<div>
							<input type="button" value="增加" class="btn_add" onclick="location.href='toAddStu.a';" />	
						</div>
						<div>
							<table border="1" cell-padding="0" >
								<tr>
									<th width="10%">学生编号</th>
									<th width="10%">密码</th>
									<th width="10%">姓名</th>
									<th width="10%">性别</th>
									<th width="10%">年龄</th>
									<th width="20%">电话</th>
									<th width="20%">地址</th>
									<th width="10%">状态</th>
							
								</tr>
								<c:forEach items="${students }" var="s">
								<tr>
									<td>${s.stuId }</td>
									<td>${s.pwd }</td>
									<td>${s.name }</td>
									<td>${s.gender }</td>
									<td>${s.age }</td>
									<td>${s.mobile }</td>
									<td>${s.address }</td>
									<td>
										<input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateStu.a?id=${s.stuId}';" />
                                		<input type="button" value="删除" class="btn_delete" onclick="deleteFee(${s.stuId});" />
									</td>
								</tr>
								</c:forEach>
							</table>
						
						</div>
					</div>
				</div>

				<div class="part3">
					<div>
				&nbsp<a href="toIndexAdmin.do">首&nbsp页</a>&nbsp|&nbsp<a href="findCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="adminFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findAll.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_admin.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactAdmin.do">联系方式</a>
			</div>
					<p>本网页属于葬爱家族,版权所有，违者必究</p>
					<p>http://tieba.baidu.com/p/4800084227</p>
				</div>
			</div>
			
</body>
</html>