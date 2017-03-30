<%--
  Created by IntelliJ IDEA.
  User: CHRISTIAN
  Date: 30/03/2017
  Time: 5:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link href="cssregister-login/register-login.css" rel="stylesheet" type="text/css">

</head>
<title>Iniciar Seccion</title>
<body> <br><br><br>
<center><h1>Iniciar Seccion</h1></center>
<br><br><br>

<form action="Controller" method="post">
    <table align="center">
<tr>

<th align="right"> Nombre Usuario:</th>
<td><input type="text" name="nom" placeholder="NombreUsuario"> </td>
</tr>

<tr>
    <th align="rigth"> Password:</th>
    <td> <input type="password" name="txtpassword" placeholder="Password"> </td>

</tr>
   <tr>
       <td colspan="2" align="right"><input type="SUBMIT" value="Log In" class="btn btn-primary" > </td>
   </tr>
    </table>
</form>

</body>
</html>
