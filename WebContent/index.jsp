<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<title>首页</title>


</head>

<body>
<div align="center">
<br/>
<br/>
	<a href="<%=basePath%>user/getAllUser">进入用户管理页</a>
	</div>
	</h5>
	  	<div align="center">
   	<br/>
   	<a style="color:#55555; font-size:50px;" href="<%=basePath%>user/tohtml">html5测试</a> <Br/><Br/>
   	<a style="color:#55555; font-size:50px;" href="http://xiaocaimi/rechargeStatus">充值</a> <Br/><Br/>
   	<a style="color:#55555; font-size:50px;" href="xiaocaimi://home">首页</a> <Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://productList">产品列表</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://productDetail?product_id=123&type=1">产品详情</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://productRecord?product_id=123&type=1">购买记录</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://checkMoney?product_id=123&type=1&money=234&coupon_id=985">确认购买</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://accountProperty">账户中心</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://accountBalance?money=12346">账户-账户余额</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://recharge">余额-充值</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://withdraw">余额-提现</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://capitalFlow">余额-资金记</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://coupon">账户-优惠券</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://transactionFlowList">账户-交易记录</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://plan">账户-回款日历</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://myProductDetail?record_id=2345678">账户-已购产品详情</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://acountBase">个人信息</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://bankcardManagement">个人信息-银行卡管理	</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://securityCenter">个人信息-安全中心</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://realNameIdentity">个人信息-实名认证</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://message">消息-消息</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://activity">消息-活动</a><Br/><Br/>
<a style="color:#55555; font-size:50px;" href="xiaocaimi://more">更多</a><Br/><Br/>
   	
 
</div>


</body>
</html>
