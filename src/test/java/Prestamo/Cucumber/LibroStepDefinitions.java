package Prestamo.Cucumber;

import Prestamo.Libro;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LibroStepDefinitions {

    private Libro libro;

    @Given("Se crea un libro con ISBN {string}, título {string}, autor {string} y editorial {string}")
    public void seCreaUnLibroConISBNTituloAutorYEditorial(String isbn, String titulo, String autor, String editorial) {
        libro = new Libro(isbn, titulo, autor, editorial, 0);
    }

    @Given("Se crea un libro con título {string}")
    public void seCreaUnLibroConTitulo(String titulo) {
        libro = new Libro();
        libro.setTitulo(titulo);
    }

    @Given("Se crea un libro con ISBN {string}, título {string}, autor {string} y editorial {string} con {int} copias disponibles")
    public void seCreaUnLibroConISBNTituloAutorYEditorialConCopiasDisponibles(String isbn, String titulo, String autor, String editorial, int copiasDisponibles) {
        libro = new Libro(isbn, titulo, autor, editorial, copiasDisponibles);
    }

    @Then("El ISBN del libro debe ser {string}")
    public void elISBNDelLibroDebeSer(String isbnEsperado) {
        Assertions.assertEquals(isbnEsperado, libro.getIsbn());
    }

    @Then("El título del libro debe ser {string}")
    public void elTituloDelLibroDebeSer(String tituloEsperado) {
        Assertions.assertEquals(tituloEsperado, libro.getTitulo());
    }

    @Then("El autor del libro debe ser {string}")
    public void elAutorDelLibroDebeSer(String autorEsperado) {
        Assertions.assertEquals(autorEsperado, libro.getAutor());
    }

    @Then("La editorial del libro debe ser {string}")
    public void laEditorialDelLibroDebeSer(String editorialEsperada) {
        Assertions.assertEquals(editorialEsperada, libro.getEditorial());
    }

    @Then("Las copias disponibles del libro deben ser {int}")
    public void lasCopiasDisponiblesDelLibroDebenSer(int copiasEsperadas) {
        Assertions.assertEquals(copiasEsperadas, libro.getCopiasDisponibles());
    }

    @When("Se establecen las copias disponibles a {int}")
    public void seEstablecenLasCopiasDisponiblesA(int nuevasCopias) {
        libro.setCopiasDisponibles(nuevasCopias);
    }

    @Then("Los detalles del libro deben ser {string}")
    public void losDetallesDelLibroDebenSer(String detallesEsperados) {
        Assertions.assertEquals(detallesEsperados, libro.obtenerDetalles());
    }
}