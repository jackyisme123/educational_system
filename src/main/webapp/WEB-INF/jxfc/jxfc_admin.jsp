<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
		<c:import url="../type/adminlogin.jsp"></c:import>
        </div>
		<!-- 公告栏区域 -->
		<div class="notice" style="padding:80px">
		<c:import url="../notice/notice_admin.jsp"></c:import>
		</div>
	
	</div>
	<!-- part2：包括标题栏，图片及内容区域 -->
	<div class="part2">
	<!-- 标题栏 -->
	<div class="headline">
		<div><a href="" class="shouye"><img alt="" src="images/shouye.jpg"></a></div>
		<div><a href="" class="xkxt"><img alt="" src="images/xkxt.jpg"></a></div>
		<div><a href="" class="cjcx"><img alt="" src="images/cjcx.jpg"></a></div>
		<div><a href="findAll.a" class="xsxx"><img alt="" src="images/xsxx.jpg"></a></div>
		<div><a href="" class="jxfc"><img alt="" src="images/jxfc.jpg"></a></div>
		<div><a href="" class="lxfs"><img alt="" src="images/lxfs.jpg"></a></div>
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
				&nbsp<a href="toIndexAdmin.do">首&nbsp页</a>&nbsp|&nbsp<a href="findCourse.do">选课系统</a>&nbsp|&nbsp<a
					href="adminFindScore.do">成绩查询</a>&nbsp|&nbsp<a href="findAll.a">学生信息</a>&nbsp|&nbsp<a href="tojxfc_admin.b">教学风采</a>&nbsp|&nbsp<a
					href="toContactAdmin">联系方式</a>
			</div>
			<p>本网页属于葬爱家族,版权所有，违者必究</p>
			<p>
				<a href="#">http://tieba.baidu.com/p/4800084227</a>
			</p>
		</div>
	</div>
	
</body>
</html>