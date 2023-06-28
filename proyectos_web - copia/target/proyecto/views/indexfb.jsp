<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>indexFACEBOOK </title>
        <link rel="stylesheet" href="assets/css/indexfb.css">
    </head>

    <body>
        <header>
            <nav>
                <button class="regresar"><a href="proyecto?action=index">Regresar</a></button>
            </nav>
        </header>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="proyecto" method="post">
                        <h2>Login</h2>
                        <div class="inputbox">
                            <input type="text" placeholder="usuario" name="usuario" required>
                            <label for="">Correo</label>
                        </div>
                        <div class="inputbox">
                            <input type="password" placeholder="Contrasena" name="contrasena" required>
                            <label for="">Contraseña</label>
                        </div>
                        <div class="forget">
                            <label for=""><input type="checkbox">Recuerdame</label>
                        </div>
                        <button type="submit" name="enviar" value="iniciofb">inicio</button>
                        <div class="register">
                            <p>¿No tienes una cuenta? <a href="proyecto?action=registrofb">Registrate</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>

    </html>