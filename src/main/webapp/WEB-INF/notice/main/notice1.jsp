<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
<style type="text/css">
.yzm {
	width: 50px;
	height: 25px;
}

.content {
background-image: url("images/ls.jpg") ;
background-repeat: no-repeat;
background-position: bottom;
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
				<div>
					<form action="login.do" method="post">
						<table>
							<tr>
								<td class="login_info">账号：</td>
								<td colspan="2"><input name="adminCode"
									value="${param.adminCode }" type="text" class="width110" /></td>
								<td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
							</tr>
							<tr>
								<td class="login_info">密码：</td>
								<td colspan="2"><input name="password"
									value="${param.password }" type="password" class="width110" /></td>
								<td><span class="required">30长度的字母、数字和下划线</span></td>
							</tr>
							<tr>
								<td class="login_info">验证码：</td>
								<td><input name="code" type="text" class="width70" /></td>

								<td><img class="yzm" src="createImg.do" alt="验证码"
									title="点击更换"
									onclick="this.setAttribute('src','createImg.do?x='+Math.random())" /></td>

							</tr>
							<tr>
								<td class="login_info"><select name="level">
										<option value="1">家族网管</option>
										<option value="2" selected>家族成员</option>

								</select></td>
								<td class="login_button" colspan="2"><a
									href="javascript:document.forms[0].submit()"><img
										src="images/login_btn1.jpg " /></a></td>
								<td><span class="required">${error }</span></td>


							</tr>
						</table>
					</form>
				</div>
			</div>
		<!-- 公告栏区域 -->
	<div class="notice" style="padding:80px">
		<c:import url="../notice.jsp"></c:import>
		<div>
		
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
			<div class="headline">
			<c:import url="../../headline/headline.jsp"></c:import>	
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
				&nbsp<a href="toLogin.do">首&nbsp页</a>&nbsp|&nbsp<a href="" onclick="alert('权限不足，请先登录！')">选课系统</a>&nbsp|&nbsp<a
					href="" onclick="alert('权限不足，请先登录！')">成绩查询</a>&nbsp|&nbsp<a href="" onclick="alert('权限不足，请先登录！')">学生信息</a>&nbsp|&nbsp<a href="tojxfc.b">教学风采</a>&nbsp|&nbsp<a
					href="toContact.do">联系方式</a>
			</div>
	<p>本网页属于葬爱家族,版权所有，违者必究</p>
	<p><a href="#">http://tieba.baidu.com/p/4800084227</a></p>
	</div>
	</div>
	
</body>
</html>


