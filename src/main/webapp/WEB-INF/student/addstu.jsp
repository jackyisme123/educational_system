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
.ga{
	height:20px;
}
#tab{
	margin-top:50px;
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
		</div></div>
				<div class="part2">
					<div class="headline">
			<c:import url="../headline/headline_admin.jsp"></c:import>	
			</div>
					<div class="pic">
						<img alt="" src="images/pic.jpg">
					</div>
					<div class="content" align="center">
						<!-- 主区域 -->
						
						 <form action="addStu.a" method="post" >
						 <table id="tab">
						 <tr class="ga">
						 	<td>族员编号：</td>
						 	<td><input type="text" name="stuId"/></td>
						 	<td>* 编号是四位正整数</td>
						 </tr>
						<tr class="ga">
							<td>密&nbsp;&nbsp;码：</td>
							<td><input type="password" name="pwd"/></td>
							<td>* 随便输，别太长就行</td>
						</tr>
						<tr class="ga">
							<td>姓&nbsp;&nbsp;名：</td>
							<td><input type="text" name="name"/></td>
							<td>* 必须是葬爱某某</td>
						</tr>
						<tr class="ga">
							<td>性&nbsp;&nbsp;别：</td>
							<td><input type="text" name="gender"/></td>
							<td>* 看心情</td>
						</tr>
						<tr class="ga">
							<td>年&nbsp;&nbsp;龄：</td>
							<td><input type="text" name="age"/></td>
							<td>* 活太久我不相信的</td>
						</tr>
						<tr class="ga">
							<td>电&nbsp;&nbsp;话：</td>
							<td><input type="text" name="mobile"/></td>
							<td>* 11位手机号，国内的</td>
						</tr>
						<tr class="ga">
							<td>地&nbsp;&nbsp;址：</td>
							<td><input type="text" name="address"/></td>
							<td>* 外星的不允许</td>
						</tr>
						</table>

						<div>
							<input type="submit" value="保存" />
                    		<input type="button" value="取消" onclick="history.back();"/>
						</div>
						</form>
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