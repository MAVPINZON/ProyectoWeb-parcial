<%-- 
    Document   : Registrar
    Created on : 2/12/2020, 12:53:10 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Registrar</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        
         <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </head>

    <body class="bg-dark">
        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Registrar</div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="lblIdentificacion">Identificacion</label>
                                    <input class="form-control" name="txtIdentificacion" type="text" placeholder="Ingresar Identificación">
                                </div>
                            </div>
                        </div>
                         <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="lblPrimerNombre">Primer Nombre</label>
                                    <input class="form-control" name="txtPrimerNombre" type="text" placeholder="Ingresar primer nombre">
                                </div>
                                 <div class="col-md-6">
                                    <label for="lblSegundoNombre">Segundo Nombre</label>
                                    <input class="form-control" name="txtSegundoNombre" type="text" placeholder="Ingresar segundo nombre">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="lblPrimerApellido">Primer Apellido</label>
                                    <input class="form-control" name="txtPrimerApellidoo" type="text" placeholder="Ingresar primer Apellido">
                                </div>
                                 <div class="col-md-6">
                                    <label for="lblSegundoNombre">Segundo Apellido</label>
                                    <input class="form-control" name="txtSegundoApellido" type="text" placeholder="Ingresar segundo Apellido">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="lblDireción">Dirección</label>
                                    <input class="form-control" name="txtDireción" type="text" placeholder="Ingresar dirección">
                                </div>
                                 <div class="col-md-6">
                                    <label for="lblTelefono">Telefono</label>
                                    <input class="form-control" name="txtTelefono" type="text" placeholder="Ingresar telefono">
                                </div>
                            </div>
                        </div>
                         <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <label for="lblCorreo">Correo</label>
                                    <input class="form-control" name="txtCorreo" type="text" placeholder="Ingresar el correo">
                                </div>
                            </div>
                         </div>
                         <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="lblPassword">Password</label>
                                    <input class="form-control" name="txtPassword" type="password" placeholder="Ingresar contraseña">
                                </div>
                                 <div class="col-md-6">
                                    <label for="lblConfirmarPassword">Confirmar password</label>
                                    <input class="form-control" name="txtConfirmarPassword" type="password" placeholder="Confirmar contraseña">
                                </div>
                            </div>
                        </div>
                        <input type="submit" name="Aceptar" class="btn btn-primary btn-block" value="Aceptar"/>
                    </form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="Login.jsp">Login</a>
                        
                    </div>
                </div>
            </div>
        </div>
   
    </body>
</html>
