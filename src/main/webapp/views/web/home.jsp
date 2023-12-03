<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<header class="masthead">
	<div class="container">
		<div class="masthead-subheading">Welcome To Our Store!</div>
		<div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
		<a class="btn btn-primary btn-xl text-uppercase" href="#services">Tell Me More</a>
	</div>
	<script>
		if ("${note}" != "") {
			alert("${note}");
		}
	</script>
</header>
<!-- Services-->