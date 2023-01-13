public class Libros {
    String titulo;
    String autor;
    String anio;

    public Libros(String titulo, String autor, String anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public Libros() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio='" + anio + '\'' +
                '}';
    }
}
