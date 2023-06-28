package model.Publicacion;

public class PublicacionVo {

    private int id;
    private String biografia;
    private String estado_animo;
    private String linkf;
    

    public PublicacionVo(int id, String biografia, String estado_animo, String linkf) {
        this.id = id;
        this.biografia = biografia;
        this.estado_animo = estado_animo;
        this.linkf = linkf;
    }

    public PublicacionVo(){

    }
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEstado_animo() {
        return estado_animo;
    }

    public void setEstado_animo(String estado_animo) {
        this.estado_animo = estado_animo;
    }

    public String getLinkf() {
        return linkf;
    }

    public void setLinkf(String linkf) {
        this.linkf = linkf;
    }




}