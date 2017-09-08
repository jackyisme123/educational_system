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

height:250px;
width:200px;
margin:60px 2px;
float:left;
position:relative;
}

.content div img{
position:absolute;
margin:5px;

}

.content div p{
font:italic bold 16px 黑体;
text-align:center;
margin:5px;
}

.img0{
z-index:5;
}
.img1{
z-index:4;
}
.img2{
z-index:3;
}
.img3{
z-index:2;
}
.img4{
z-index:1;
}

.p1, .p2{
position:absolute;
bottom:15px;
}

.p3{
position:absolute;
bottom:0px;
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
				<img src="images/jxfc0_small.jpg"
				onmouseover="this.src='images/jxfc0.jpg'"
				onmouseout="this.src='images/jxfc0_small.jpg'"
				class="img0">
				<p class="p1">杀马特是什么?</p>
				</div>
				<div>
				<p>他们是落入凡间的精灵!</p>
				<img alt="" src="images/jxfc1_small.jpg"
				onmouseover="this.src='images/jxfc1.png' "
				onmouseout="this.src='images/jxfc1_small.jpg' "
				class="img1">
				
				</div>
				<div>
				<img alt="" src="images/jxfc2_small.jpg"
				onmouseover="this.src='images/jxfc2.jpg'"
				onmouseout="this.src='images/jxfc2_small.jpg'"
				class="img2">
				<p class="p2">他们是缺了翅膀的天使!</p>
				</div>
				<div>
				 <p>他们是敢于表现的勇士!</p>
				<img alt="" src="images/jxfc3_small.jpg"
				onmouseover="this.src='images/jxfc3.jpg'"
				onmouseout="this.src='images/jxfc3_small.jpg'"
				class="img3">
				</div>
				<div>
				<img alt="" src="images/jxfc4_small.jpg"
				onmouseover="this.src='images/jxfc4.jpg'"
				onmouseout="this.src='images/jxfc4_small.jpg'"
				class="img4">
				<p class="p3">他们绝不同于45°角仰望的文艺青年!</p>
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