<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!doctype html>
    <html lang="es">

    <head>
        <title>Subir Publicacion</title>
        <link rel="stylesheet" href="../../assets/css/procesos/actualizar.css">

    </head>

    <body>
        <center>
            <div class="container">
                <h1 class="title">FORMULARIO actualizar Publicacion</h1>
                <form action="estados" method="post">

                    <label for="nameRol">Ingrese el ID: </label>
                    <input type="number" class="idw" id="idw" name="idw" required><br>

                    <label for="nameRol">Ingrese Descripcion: </label>
                    <input type="text" class="biografiaw" id="biografiaw" name="biografiaw" required><br>

                    <label for="nameRol">Ingrese su Link: </label>
                    <input type="text" class="linkw" id="linkw" name="linkw" required><br>

                    <label for="nameRol">Ingrese una cancion: </label>
                    <input type="text" class="songw" id="songw" name="songw" required><br>


                    <button type="submit" class="registro" name="accionForm" value="Actualizar">Actualizar</button>
                </form>
                <a href="proyecto?action=whatsapp">volver</a>
            </div>
        </center>

    </body>

    </html>