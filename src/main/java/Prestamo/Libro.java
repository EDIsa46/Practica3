package Prestamo;
/**
 * Representa un libro en el catálogo de la biblioteca digital.
 * Contiene información bibliográfica y de disponibilidad.
 *
 * @author Tu Nombre
 * @version 1.0
 * @since 1.0
 */
public class Libro {
    /**
     * ISBN único del libro.
     */
    private String isbn;
    /**
     * Título del libro.
     */
    private String titulo;
    /**
     * Autor del libro.
     */
    private String autor;
    /**
     * Editorial del libro.
     */
    private String editorial;
    /**
     * Número de copias disponibles del libro para préstamo.
     */
    private int copiasDisponibles;

    /**
     * Constructor por defecto de la clase Libro.
     */
    public Libro() {
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos del libro.
     *
     * @param isbn              El ISBN del libro.
     * @param titulo            El título del libro.
     * @param autor             El autor del libro.
     * @param editorial         La editorial del libro.
     * @param copiasDisponibles El número de copias disponibles del libro.
     */
    public Libro(String isbn, String titulo, String autor, String editorial, int copiasDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.copiasDisponibles = copiasDisponibles;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El nuevo ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return La editorial del libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial La nueva editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el número de copias disponibles del libro.
     *
     * @return El número de copias disponibles.
     */
    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    /**
     * Establece el número de copias disponibles del libro.
     *
     * @param copiasDisponibles El nuevo número de copias disponibles.
     */
    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    /**
     * Obtiene los detalles completos del libro en formato de cadena.
     *
     * @return Una cadena con los detalles del libro.
     * @since 1.0
     */
    public String obtenerDetalles() {
        return "ISBN: " + isbn + ", Título: " + titulo + ", Autor: " + autor + ", Editorial: " + editorial + ", Copias disponibles: " + copiasDisponibles;
    }

    /**
     * Devuelve una representación en cadena del objeto Libro.
     *
     * @return Una cadena que representa el libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

}
