package pe.edu.pucp.iweb.lab8.beans;

/**
 * Ejercicio 2: bean Cancion.
 */
public class Cancion {

    private int idCancion;
    private String titulo;
    private String artista;
    private int duracion_seg;
    private int anio;
    private int idGenero;

    public Cancion() {
    }

    public Cancion(int idCancion, String titulo, String artista, int duracion_seg, int anio, int idGenero) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion_seg = duracion_seg;
        this.anio = anio;
        this.idGenero = idGenero;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion_seg() {
        return duracion_seg;
    }

    public void setDuracion_seg(int duracion_seg) {
        this.duracion_seg = duracion_seg;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    /**
     * TODO: retornar la duración en formato m:ss
     *          (354 segundos -> "5:54", 200 segundos -> "3:20").
     */
    public String getDuracionFormateada(int duracion_seg) {

        return null;
    }
}
