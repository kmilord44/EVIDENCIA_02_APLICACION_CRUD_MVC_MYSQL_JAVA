<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="es">
  <head>
    <title>Subir estado</title>
    <link rel="stylesheet" href="../../assets/css/procesos/registrar.css">
  </head>
  <body>
    <center>
      <div class="container">
          <h1 class="title">FORMULARIO CREAR ESTADO</h1>
          <form action="estados" method="post">
              <label for="nameRol">Ingrese descripcion: </label>
              <input type="text" class="descrip" id="descrip" name="descripw" required><br>
              
              <label for="nameRol">Ingrese un link: </label>
              <input type="text" class="linkw" id="linkw" name="linkw" required><br>

              <label for="nameRol">Ingrese el nombre de una cancion: </label>
              <input type="text" class="song" id="song" name="songw" required><br>


              <button type="submit" class="registro" name="accionForm" value="agregar" >Registrar ESTADO</button>
          </form>
          <a href="proyecto?action=whatsapp">volver</a>
      </div>
    </center>

  </body>
</html>