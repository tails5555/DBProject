<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
<h1>음악목록</h1>
  <div class="pull-right mb5">
  <a href="create.do" class="btn btn-info">
    <span class="glyphicon glyphicon-music"></span> 음악등록</a>
  </div>    
  <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th>id</th>
        <th>가수</th>
        <th>제목</th>
        <th>장르</th>
        <th>발매년도</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="music" items="${ musics }">
        <tr data-url="edit.do?id=${ music.id }">
          <td>${ music.id }</td>
          <td>${ music.singer }</td>
          <td>${ music.title }</td>
          <td>${ music.genreName }</td>
          <td>${ music.year }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="http://localhost:8080/myBatis01_1/genre/list" class="btn btn-info">
    <span class="glyphicon glyphicon-film"></span> 장르 목록으로</a>
  <a href="#top" class="btn btn-info">
  	<span class="glyphicon glyphicon-circle-arrow-up"></span> 맨 위로</a>
</div>
</body>
</html>
