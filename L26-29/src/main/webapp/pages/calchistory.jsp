
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.04.2023
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>CalculatorHistory</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
  <div class="row justify-text-center">
    <ul>
      <c:forEach items="${operationList}" var="operation">
        <li>
          <c:out value="${operation.num1} ${operation.type} ${operation.num2} result ${operation.result} "/>
        </li>
      </c:forEach>
    </ul>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</body>
</html>
