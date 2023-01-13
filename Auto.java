package gestiondeautos;

public class Auto {
    private String Marca;
    private String Modelo;
    private String Anio;

    public Auto(String Marca, String Modelo, String Anio) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Anio = Anio;
    }

    public Auto() {
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    @Override
    public String toString() {
        return "Auto{" + "Marca=" + Marca + ", Modelo=" + Modelo + ", Anio=" + Anio +'}';
    }
    
    
    
}
