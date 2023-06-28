<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="es">
  <head>
    <title>Subir Publicacion</title>
    <link rel="stylesheet" href="../../assets/css/procesos/registrar.css">

  </head>
  <body>
    <center>
      <div class="container">
          <h1 class="title">FORMULARIO CREAR Publicacion</h1>
          <form action="publicacion" method="post">
              <label for="nameRol">Ingrese Biografia: </label>
              <input type="text" class="biografiaf" id="biografiaf" name="biografiaf" required><br>
              
              <label for="nameRol">Ingrese su estado de animo: </label>
              <input type="text" class="estado_animo" id="estado_animo" name="estado_animo" required><br>

              <label for="nameRol">Ingrese un link: </label>
              <input type="text" class="link" id="linkf" name="linkf" required><br>


              <button type="submit" class="registro" name="accionFormface" value="agregarf" >Registrar ESTADO</button>
          </form>
          <a href="proyecto?action=facebook">volver</a>
      </div>
    </center>

  </body>
</html>