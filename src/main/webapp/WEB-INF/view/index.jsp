<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Banners</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="startertemplate"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${startertemplate}" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right"></ul>
        </div>
    </div>
</nav>

<header id="banners" class="carousel slide">
    <div class="carousel-inner">
        <div class="item active">
            <div class="fill" style="background-image:url('http://placehold.it/1900x1080&amp;text=Banners');"></div>
        </div>
    </div>
</header>

<div class="row">
    <div class="col-md-6">
        <form action="/banners" method="get">
            <br><label>Please, enter the desired number of banners (random result):</label>
            <input type="text" class="form-control" name="count"
                   required data-validation-required-message="Please count banners!"><br>
            <button type="submit" class="btn btn-primary">Get Banners</button>
        </form>
    </div>

    <div class="col-md-6">
        <form action="/bannersByWeight" method="get">
            <br><label>Please, enter the desired number of banners (weight result):</label>
            <input type="text" class="form-control" name="count"
                   required data-validation-required-message="Please weight banners!"><br>
            <button type="submit" class="btn btn-primary">Get Banners</button>
        </form>
    </div>

    <footer>
        <div class="navbar-fixed-bottom row-fluid">
            <div class="container">
                <p>By Rigzz © Banners 2016</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>