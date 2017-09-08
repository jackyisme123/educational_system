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
.content div{
float:left;
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
			<div class="content" style="margin:10px 50px">
		<div>	<p>
		<strong>葬爱国际集团</strong> 
	</p>
	<p>
		葬爱学员服务邮箱：ts@tarena.com.cn
	</p>
	<p>
		·电话：+86 10&nbsp;62135687;62136211
	</p>
	<p>
		·传真：+86 10 62110873
	</p>
	<p>
		·邮编：100098
	</p>
	<br>
	<p>
		<strong>葬爱北京中关村中心</strong> 
	</p>
	<p>
		·电话：010-62130963
	</p>
	<p>
		·传真：+86 10 62110873
	</p>
	<p>
		·邮编：100098
	</p>
	<p>
		·地址：北京市海淀区北三环西路甲18号中鼎大厦B座7层
	</p>
	</div>
	<div><p>
		<strong>葬爱上海人民广场中心</strong> 
	</p>
	<p>
		·电话：021-61202663
	</p>
	<p>
		·传真：021-61202663
	</p>
	<p>
		·邮编：200001
	</p>
	<p>
		·地址：上海市北京东路688号上海科技京城东楼6层EFG座
	</p>
	<br>

				<strong>葬爱无锡中心</strong> 
	</p>
	<p>
		·电话：（0510）85380882
	</p>
	<p>
		·传真： 0510-85380882-8014
	</p>
	<p>
		·邮编：214235
	</p>
	<p>
		·地址：无锡市新区湘江路2-3 金源国际大厦A座1506
	</p>
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
	
</body>
</html>