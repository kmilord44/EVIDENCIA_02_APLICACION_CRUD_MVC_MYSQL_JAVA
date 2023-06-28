package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estado.EstadoDao;
import model.Estado.EstadoVo;

public class Estados extends HttpServlet {

    EstadoVo estadoVo = new EstadoVo();
    EstadoDao estadoDao = new EstadoDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String pagina = req.getParameter("accion");

        System.out.println(pagina);
        
        switch (pagina) {
            
                case "Listar":
                    System.out.println("para ver accion");  
                    listar(req, resp);
                    
                    break;
                

        
        }

    }

    // DO POST
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al Dopost");
        String accion = req.getParameter("accionForm");
        switch (accion) {
            case "agregar":
                agregar(req, resp);
                break;
                case "Actualizar":
                    actualizar(req, resp);
                    break;
            case "eliminar":
                eliminar(req, resp);
                break;
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idw") != null) {
            estadoVo.setId(Integer.parseInt(req.getParameter("idw")));
        }
        if (req.getParameter("biografiaw") != null) {
            estadoVo.setDescripcion(req.getParameter("biografiaw"));
        }
        if (req.getParameter("linkw") != null) {
            estadoVo.setLinkw(req.getParameter("linkw"));
        }
        if (req.getParameter("songw") != null) {
            estadoVo.setCancion(req.getParameter("songw"));
        }
        try {
            estadoDao.actualizar(estadoVo.getId(), estadoVo.getDescripcion(), estadoVo.getCancion(), estadoVo.getLinkw());

            
            req.setAttribute("proceso", true);
            resp.sendRedirect("estados?accion=Listar");
            System.out.println("Información actualizada");
        } catch (Exception e) {
            req.setAttribute("msg", "No se puede actualizar el registro " + e.getMessage());
            System.out.println("No se puede actualizar el registro" + e.getMessage());
        }
    }

    private void agregar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("descripw") != null) {
            estadoVo.setDescripcion((req.getParameter("descripw")));
            ;
        }

        if (req.getParameter("linkw") != null) {
            estadoVo.setLinkw((req.getParameter("linkw")));
            ;
        }

        if (req.getParameter("songw") != null) {
            estadoVo.setCancion((req.getParameter("songw")));
            ;
        }
        try {
            estadoDao.Registrar(estadoVo);
            System.out.println("El registro fue exitoso");
            resp.sendRedirect("estados?accion=Listar");
        } catch (Exception e) {
            System.out.println("error en el registro");
        }

    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("id") != null) {
            estadoVo.setId(Integer.parseInt(req.getParameter("id")));
        }
        try {
            estadoDao.Eliminar(estadoVo.getId());
            req.setAttribute("proceso", true);
            resp.sendRedirect("estados?accion=Listar");
            System.out.println("Estado eliminado");
        } catch (Exception e) {
            req.setAttribute("msg", "No se puede eliminar el registro " + e.getMessage());
            System.out.println("No se puede eliminar el registro" + e.getMessage());
        }
    }


    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println(estadoVo.getDescripcion());
            List estados=estadoDao.Listar(); //llamar al metodo de la clase dao 
            req.setAttribute("estados", estados);
            req.getRequestDispatcher("views/procesos/verestados.jsp").forward(req, resp);
            System.out.println("DATOS LISTADOS CORRECTAMENTE");
        } catch (Exception e) {
            System.out.println("problemas al listar los datos"+e.getMessage().toString());
        }
    }


public static void main(String[] args) {
    Estados objeto = new Estados();
    objeto.listar(null, null);
}
}