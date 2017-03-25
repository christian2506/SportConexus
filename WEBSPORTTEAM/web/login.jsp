<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 10/03/2017
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresar</title>
</head>
<body>
    <h1>Login</h1>
    <s:form action="validate">
        <s:textfield name="userName" label="User name"/>
        <s:password name="password" label="Password"/>
        <s:submit value="login"/>
    </s:form>
</body>
</html>
