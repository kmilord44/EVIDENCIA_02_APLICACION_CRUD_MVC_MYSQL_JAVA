package model.Estado;

public class EstadoVo {
    private int id;
    private String descripcion;
    private String linkw;
    private String cancion;

    public EstadoVo(){
        
    }

    public EstadoVo(int id, String descripcion, String linkw, String cancion) {
        this.id = id;
        this.descripcion = descripcion;
        this.linkw = linkw;
        this.cancion = cancion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkw() {
        return linkw;
    }

    public void setLinkw(String linkw) {
        this.linkw = linkw;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

 
}


