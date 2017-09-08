<%@page pageEncoding="utf-8"%>
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
		<c:import url="../notice/notice.jsp"></c:import>
		<div>

		</div>
		<!-- part2：包括标题栏，图片及内容区域 -->
		<div class="part2">
			<!-- 标题栏 -->
			<div class="headline">
			<c:import url="../headline/headline.jsp"></c:import>	
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


					<p>&nbsp&nbsp
						1.失去爱后，要让自己忘记那段刻骨铭心的爱，埋葬掉自己的爱，不再去爱，埋葬掉自己的回忆以及自己的心痛，葬掉爱情，埋掉一切，是心的祭奠！</p>


					<p>&nbsp&nbsp
						2.当得不到她(他)的爱了，就只能让自己伤心，看着她(他)幸福，把爱埋葬起来，用最隆重的仪式来埋葬自己最深的爱..即把已有的却不想或不能的情感掩埋！</p>


					<p>&nbsp&nbsp
						3.被爱情深深伤害了，心差不多死了一样，将自己的爱埋葬起来，不再付出真感情，不再去深爱！只怕受伤，只有在夜深人静的时候才会想起那段被埋葬的爱情！</p>





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
			<p>
				<a href="#">http://tieba.baidu.com/p/4800084227</a>
			</p>
		</div>
	</div>
	<embed src="123.mp3" width="0" height="0"></embed>
</body>
</html>