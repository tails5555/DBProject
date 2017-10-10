<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <h1>장르 ${ genre.id > 0 ? "수정" : "등록" }</h1>
  <hr />
  <form:form method="post" modelAttribute="genre">  
    <div class="form-group">
      <label>장르이름:</label>
      <form:input path="genreName" class="form-control w200" />
    </div>
    <div>
      <button type="submit" class="btn btn-primary">
        <span class="glyphicon glyphicon-ok"></span> 저장</button>
      <a href="list.do" class="btn btn-info">목록으로</a>
    </div>
    <hr />
    <c:if test="${ genre.id > 0 }">
    <h3>${ genre.genreName } <small>${ genre.musics.size() }곡</small></h3>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>id</th>
            <th>가수</th>
            <th>제목</th>
            <th>발간년도</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="music" items="${ genre.musics }">
            <tr>
              <td>${ music.id }</td>
              <td>${ music.singer }</td>
              <td>${ music.title }</td>
              <td>${ music.year }</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </form:form>
</div>
</body>
</html>
