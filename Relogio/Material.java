public class Material {

    private String tipoMat;
    private String orig;
    private int codOrig;
    private Pais pais;

    public Material() {
        tipoMat = " ";
        orig = " ";
        codOrig = 0;
        pais = new Pais();
    }

    public void setTipoMat(String tipoMat) {
        this.tipoMat = tipoMat;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public void setCodOrig(int codOrig) {
        this.codOrig = codOrig;
    }

    public String getTipoMat() {
        return tipoMat;
    }

    public String getOrig() {
        return orig;
    }

    public int getCodOrig() {
        return codOrig;
    }

    public Pais getPais() {
        return pais;
    }

}