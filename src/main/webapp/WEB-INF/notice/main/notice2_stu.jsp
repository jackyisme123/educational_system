<%@page pageEncoding="utf-8" %><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
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
		<c:import url="../../type/stulogin.jsp"></c:import>
        </div>	
		<!-- 公告栏区域 -->
	<div class="notice" style="padding:80px">
		<c:import url="../notice_stu.jsp"></c:import>
		<div>
		
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../../headline/headline_stu.jsp"></c:import>	
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


