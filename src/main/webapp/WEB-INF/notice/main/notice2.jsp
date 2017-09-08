<%@page pageEncoding="utf-8" %><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<c:import url="../notice.jsp"></c:import>
		<div>
		
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
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
				<h3>公司简介</h3>
				
					<p>&nbsp&nbsp葬爱科技有限公司,由美国国际数据集团IDG投资,由来组SUN，IBM,亚信,华为,东软,用友等国际知名IT公司的技术骨干、海外留学生和加拿大专业技术人员创办,直接引进北美IT技术，结合中国IT企业的现状,定制化培养高端IT人才。</p>
					
					<p>&nbsp&nbsp致力于为中高端IT企业培训并输送基于Unix/Linux平台、Oracle大型关系数据库、IP网络协议、web和企业级应用的中高级软件人才。</p>
					
					<p>&nbsp&nbsp9年运营，葬爱在多伦多、北京、上海、广州等17个城市，建立27个分中心，拥有近20000平米培训场地，几千名学员同时在校学习。</p>
					<p>&nbsp&nbsp自2002年进入中国以来，已经为IBM、微软、摩托罗拉、华为、Yahoo、NEC、用友、神州数码、联想、新浪、搜狐、亚信、中国电信、中国银行、花旗银行等中外知名IT公司培养输送数万名中高软件人才。</p>
					<p>&nbsp&nbsp基于成熟、规范的IT人才培训体系和储备过万的专业开发工程师人才库，葬爱面向国际、国内中高端IT公司提供人才推荐、人才外包、校园招聘、定单培训等多项IT人才服务。</p>
					
			
	
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


