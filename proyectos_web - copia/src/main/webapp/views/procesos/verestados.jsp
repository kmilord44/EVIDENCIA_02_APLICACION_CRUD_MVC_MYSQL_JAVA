<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/1067cb33f8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../assets/css/procesos/visualizar.css">
    <title>Ver estados</title>

    <style>
      .btnDelete {
        color: brown;
      }

      .btnDelete:hover {
        cursor: pointer;
        color: red;
        transition: 0.3s ease;
      }

      i {
        font-size: 16px;
      }

      button[type="submit"] {
        border: none;
      }
    </style>
</head>
<body>
    <main>
        <div class="formulario">
            <center>

                <h1>Lista de Estados</h1>
                <a type="button" class="btn btn-primary" href="proyecto?action=subirestados"> 
                Agregar Estado
                </a>
                <a type="button" class="btn btn-primary" href="proyecto?action=actualizarestado">
                  modificar Estado
                </a>
              
               <table class="table table-hover table-bordered">
               
                      <tr>
                          <th>Id</th>
                          <th>Descripcion</th>
                          <th>Link</th>            
                          <th>Cancion</th>
                      </tr>
                      
              <c:forEach var="estados" items="${estados}">         
                      
                    <tr>
                    <div class="contenido">
                      <td>${estados.getId()}</td>
                      <td>${estados.getDescripcion()}</td>
                      <td>${estados.getLinkw()}</td>
                      <td>${estados.getCancion()}</td>
                    </div>
                     
                    
                    <form action="estados" method="post" id="formularioEliminar${estados.getId()}">
                      <input type="hidden" name="id" id="IdFormulario" value="${estados.getId()}">
                      <input type="hidden" name="accionForm" value="eliminar">
                      <i class="fa-solid fa-trash btnDelete" onclick="EnviarEliminacion('${estados.getId()}')"></i>
                    </form>  
                  </tr> 

                        
              </c:forEach>    
              
              
              </table>
            </center>
          
          
          </div> 
          <a href="proyecto?action=whatsapp">volver</a>

          
        </main>

        <script>
          function EnviarEliminacion(id) {
  
            var formEliminado = document.getElementById('formularioEliminar' + id);
  
            Swal.fire({
              title: "¿Seguro que deesea eliminar este registro?",
              text: "Los registros eliminados no se podran recuperar.",
              icon: "warning",
              showCancelButton: true,
              confirmButtonColor: "#3085d6",
              cancelButtonColor: "#d33",
              confirmButtonText: "Sí, eliminarlo"
            }).then((result) => {
              if (result.isConfirmed) {
                formEliminado.submit();
              }
  
            });
          }
  
        </script>
  
  
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
          integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
          crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
          integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
          crossorigin="anonymous"></script>
</body>
</html>