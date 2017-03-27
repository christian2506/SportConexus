<%--
  Created by IntelliJ IDEA.
  User: INTEL
  Date: 25/11/2016
  Time: 11:46 AM
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
<title>
    Iniciar Sesión
</title>
<body>
<form action="users" method="post">
    <div class="container-fluid">
        <section class="container">
            <div class="container-page">
                <div class="col-md-6">
                    <h3 class="dark-grey">Ingresa</h3>

                    <div class="form-group col-lg-12">
                        <label>Correo electrónico</label>
                        <input type="email" name="email" class="form-control" value="${user.email}" id="email" required>
                    </div>

                    <div class="form-group col-lg-12">
                        <label>Contraseña</label>
                        <input type="password" name="password" class="form-control"  value="${user.password}" required>
                    </div>

                    <div class="form-group col-lg-6">
                        <input type="checkbox" />Recordar
                    </div>
                    <div class="form-group col-lg-6">
                        <label>¿No tienes cuenta?</label>
                        <a href="users?action=new">Regístrate aqui</a>
                    </div>
                    <div>
                        <input type="hidden" name="action" value="validation"/>
                        <button type="submit" class="btn btn-primary">Iniciar Session</button>
                    </div>
                </div>

                <div class="col-md-6">
                    <h3 class="dark-grey">Aprende lo que te gusta con los mejores</h3>
                    <ul>
                        <li>Vive la experiencia  de Jugar de tus Amigos</li>.
                        <li>Elije entre la variedad de Chanchas disponibles de la que contamos.</li>
                    </ul>
                </div>
            </div>
        </section>
    </div>
</form>
</body>
</html>
