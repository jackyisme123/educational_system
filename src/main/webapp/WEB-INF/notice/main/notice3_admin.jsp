<%@page pageEncoding="utf-8" %><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>葬爱家族教务系统</title>
<link rel="stylesheet" href="main.css" />
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
	<!-- 全部页面 -->
	<div class="total">
	<!-- part1包括：logo，login及公共系统 -->
	<div class="part1">
		<!-- logo区 -->
		<div class="logo_top">
		<img alt="" src="images/logo2.jpg">
		</div>
		<div class="login">
		<c:import url="../../type/adminlogin.jsp"></c:import>
        </div>
		<!-- 公告栏区域 -->
	<div class="notice" style="padding:80px">
		<c:import url="../notice_admin.jsp"></c:import>
		<div>
		
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<!-- 标题栏 -->
	<div class="headline">
			<c:import url="../../headline/headline_admin.jsp"></c:import>	
			</div>
	<!-- 图片区 -->
	<div class="pic">
	<img alt="" src="images/pic.jpg">
	</div>
	<!-- 内容区 -->
	<div class="content">
	<div class="con1_3">
		<h2>公司发展历程:</h2>
					<p>&nbsp&nbsp2009年12月，葬爱获得“中国最尊贵家族称号”</p>

					<p>&nbsp&nbsp2010年1月，葬爱获得中纪委“建国60年百强品牌中国最尊贵家族”   </p>

					<p>&nbsp&nbsp2010年8月，葬爱成为2010年舞林大会指定官方培训机构  </p>
					
					<p>&nbsp&nbsp2011年11月，葬爱CEO受邀出席搜狐“2011职业斗舞高峰论坛”</p>
					
					<p>&nbsp&nbsp2011年4月，葬爱荣膺工信部2010年度“优秀舞蹈培训基地”称号  </p>

					<p>&nbsp&nbsp2011年9月，获得美国杀马特集团2000万美元投资</p>

					<p>&nbsp&nbsp2011年9月，葬爱获得“中国最具影响力舞蹈培训品牌”   </p>

					<p>&nbsp&nbsp2016年12月，葬爱荣膺2016“火星最具影响力杀马特造型设计品牌”</p>

					<p>&nbsp&nbsp2016年12月，葬爱荣获“2016年最佳火星文外包培训机构”   </p>
				
	</div>
	</div>
	</div>
	<!-- part3：版权区 -->
	<div class="part3">
	<<div>
				&nbsp<a href="toIndexAdmin.do">首&nbsp页</a>&nbsp|&nbsp<a href="findCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="adminFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findAll.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_admin.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactAdmin.do">联系方式</a>
			</div>
	<p>本网页属于葬爱家族,版权所有，违者必究</p>
	<p><a href="#">http://tieba.baidu.com/p/4800084227</a></p>
	</div>
	</div>
	
</body>
</html>


