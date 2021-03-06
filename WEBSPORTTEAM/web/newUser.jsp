<%--
  Created by IntelliJ IDEA.
  User: INTEL
  Date: 25/11/2016
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrarse</title>
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
    <link href="cssregister-login/register-login.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="users" method="post">
    <div class="container-fluid">
        <section class="container">
            <div class="container-page">
                <div class="col-md-6">
                    <h3 class="dark-grey">Registro</h3>

                    <div class="form-group col-lg-6">
                        <label>Nombre</label>
                        <input title="Necesitas un Nombre" type="text" name="first_name" class="form-control" value="${user.first_name}" required>
                    </div>

                    <div class="form-group col-lg-6">
                        <label>Apellido</label>
                        <input type="text" name="last_name" class="form-control" value="${user.last_name}" required>
                    </div>

                    <div class="form-group col-lg-6">
                        <label>NombreUsuario</label>
                        <input type="text" name="nomUser" class="form-control"  value="${user.nomUser}" required>
                    </div>

                    <div class="form-group col-lg-6 required">
                        <label>Confirmar NombreUsuario</label>
                        <input type="text" name="" class="form-control" required>
                    </div>

                    <div class="form-group col-lg-6">
                        <label>Contraseña</label>
                        <input type="password" name="password" class="form-control" value="${user.password}" required>
                    </div>

                    <div class="form-group col-lg-6">
                        <label>Repetir contraseña</label>
                        <input type="password" name="" class="form-control" id="" required>
                    </div>

                    <div class="form-group col-lg-12">
                        <input type="checkbox" />Acepto los terminos y condiciones
                    </div>
                    <div>
                        <input type="hidden" name="action" value="create"/>
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </div>
                </div>

                <div class="col-md-6">
                    <h3 class="dark-grey">Terms and Conditions</h3>
                    <p>
                        Al hacer clic en "Registrar", usted acepta los Términos y Condiciones de la Empresa
                    </p>
                    <p>
                        Los precios están sujetos a cambios basados en las fluctuaciones de los tipos de cambio,
                                                 Si tal fluctuacion ocurre, podemos solicitar un pago adicional. Usted tiene la opción de solicitar un reembolso completo o pagar el nuevo precio. (Parrafo 12.3.4)
                    </p>
                    <p>
                        En caso de error en la descripcion o precio del alquiler del espacio deportivo, le proporcionaremos un reembolso completo (Párrafo 17.5.6)
                    </p>
                    <p>

                        108/5000
                        La aceptación de la reservacion de un espacio deportivo depende de la capacidad de nuestros proveedores (Dueños de espacios deportivos) para proporcionar el producto. (Párrafo 14.5.6)
                    </p>


                </div>
            </div>
        </section>
    </div>
</form>
</body>
</html>