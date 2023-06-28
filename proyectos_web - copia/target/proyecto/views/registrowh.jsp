<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="assets/css/registrowh.css">
</head>
<body>
    <header>
        <nav>
            <button class="regresar"><a href="proyecto?action=index">Regresar</a></button>
        </nav>
    </header>  
    <div class="container">
        <h2>Registro de usuario</h2>
        <form action="proyecto?action=indexwh" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre">
            
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido">
            
            <label for="correo">Correo electrónico:</label>
            <input type="email" id="correo" name="correo">
            
            <label for="contraseña">Contraseña:</label>
            <input type="password" id="contraseña" name="contraseña">
            
            <button class="registro"><a href="proyecto?action=indexwh">Registrarse</a></button>
        </form>
    </div>
</body>
</html>