package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publicacion.PublicacionDao;
import model.Publicacion.PublicacionVo;

public class Publicacion extends HttpServlet {

    PublicacionVo publicacionVo = new PublicacionVo();
    PublicacionDao publicacionDao = new PublicacionDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String paginaf = req.getParameter("accionf");

        System.out.println(paginaf);
        
        switch (paginaf) {
            
                case "listarf":
                    System.out.println("para ver accion");  
                    listarf(req, resp);
                    
                    break;
                

        
        }

    }


    // DO POST
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al Dopost");
        String accionf = req.getParameter("accionFormface");
        switch (accionf) {
            case "agregarf":
                agregarf(req, resp);
                break;
                case "actualizarf":
                    actualizarf(req, resp);
                    break;
            case "eliminarf":
                eliminarf(req, resp);
                break;

        }
    }

    private void actualizarf(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idf") != null) {
            publicacionVo.setId(Integer.parseInt(req.getParameter("idf")));
        }
        if (req.getParameter("biografiaf") != null) {
            publicacionVo.setBiografia(req.getParameter("biografiaf"));
        }
        if (req.getParameter("estado_animo") != null) {
            publicacionVo.setEstado_animo(req.getParameter("estado_animo"));
        }
        if (req.getParameter("linkf") != null) {
            publicacionVo.setLinkf(req.getParameter("linkf"));
        }
        try {
            publicacionDao.Actualizarf(publicacionVo.getId(), publicacionVo.getBiografia(), publicacionVo.getEstado_animo(), publicacionVo.getLinkf());
          

            req.setAttribute("proceso", true);
            resp.sendRedirect("publicacion?accionf=listarf");
            System.out.println("Información actualizada");
        } catch (Exception e) {
            req.setAttribute("msg", "No se puede actualizar el registro " + e.getMessage());
            System.out.println("No se puede actualizar el registro" + e.getMessage());
        }
    }

    private void agregarf(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("biografiaf") != null) {
            publicacionVo.setBiografia((req.getParameter("biografiaf")));
            ;
        }

        if (req.getParameter("estado_animo") != null) {
            publicacionVo.setEstado_animo((req.getParameter("estado_animo")));
            ;
        }

        if (req.getParameter("linkf") != null) {
            publicacionVo.setLinkf((req.getParameter("linkf")));
            ;
        }
        try {
            publicacionDao.Registrarf(publicacionVo
            );
            System.out.println("El registro fue exitoso");
            resp.sendRedirect("publicacion?accionf=listarf");
        } catch (Exception e) {
            System.out.println("error en el registro");
        }

    }

    private void eliminarf(HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("id") != null) {
            publicacionVo.setId(Integer.parseInt(req.getParameter("id")));
        }
        try {
            publicacionDao.Eliminarf(publicacionVo.getId());
            req.setAttribute("proceso", true);
            resp.sendRedirect("publicacion?accionf=listarf");
            System.out.println("Publicacion eliminada");
        } catch (Exception e) {
            req.setAttribute("msg", "No se puede eliminar el registro " + e.getMessage());
            System.out.println("No se puede eliminar el registro" + e.getMessage());
        }
    }


    private void listarf(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println(publicacionVo.getBiografia());
            List publicacion=publicacionDao.Listarf(); //llamar al metodo de la clase dao 
            req.setAttribute("publicacion", publicacion);
            req.getRequestDispatcher("views/procesos/verpubli.jsp").forward(req, resp);
            System.out.println("DATOS LISTADOS CORRECTAMENTE");
        } catch (Exception e) {
            System.out.println("problemas al listar los datos"+e.getMessage().toString());
        }
    }


public static void main(String[] args) {
    Publicacion objeto = new Publicacion();
    objeto.listarf(null, null);
}
}