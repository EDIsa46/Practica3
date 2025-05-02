package Prestamo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PrestamoTest {

    @Test
    void crearPrestamo() {
        Prestamo prestamo = new Prestamo();
        assertNotNull(prestamo);
    }

    @Test
    void verificarEstadoInicial() {
        Prestamo prestamo = new Prestamo();
        // Un préstamo recién creado no debería estar vencido si la fecha de fin se inicializa
        assertFalse(prestamo.estaVencido());
        assertFalse(prestamo.isRenovado());
        assertEquals(0, prestamo.getRenovacionesRealizadas());
        assertEquals(1, prestamo.getNumeroRenovacionesPermitidas()); // Valor por defecto
    }

    @Test
    void renovarPrestamoExitosamente() {
        Prestamo prestamo = new Prestamo();
        Date fechaInicio = new Date();
        prestamo.setFechaInicio(fechaInicio);
        // Establecer fecha de fin en el futuro cercano
        long dosDiasEnMilisegundos = 2 * 24 * 60 * 60 * 1000L;
        prestamo.setFechaFin(new Date(System.currentTimeMillis() + dosDiasEnMilisegundos));

        assertTrue(prestamo.renovar());
        assertTrue(prestamo.isRenovado());
        assertEquals(1, prestamo.getRenovacionesRealizadas());
        assertTrue(prestamo.getFechaFin().after(new Date(fechaInicio.getTime() + dosDiasEnMilisegundos)));
    }

    @Test
    void noRenovarPrestamoVencido() throws InterruptedException {
        Prestamo prestamo = new Prestamo();
        Date fechaInicio = new Date();
        prestamo.setFechaInicio(fechaInicio);
        // Establecer fecha de fin en el pasado
        long unDiaEnMilisegundos = -1 * 24 * 60 * 60 * 1000L;
        prestamo.setFechaFin(new Date(System.currentTimeMillis() + unDiaEnMilisegundos));

        Thread.sleep(2000); // Asegurar que la fecha actual sea posterior a fechaFin

        assertFalse(prestamo.renovar());
        assertFalse(prestamo.isRenovado());
        assertEquals(0, prestamo.getRenovacionesRealizadas());
    }

    @Test
    void noRenovarPrestamoSiAlcanzoLimiteRenovaciones() {
        Prestamo prestamo = new Prestamo();
        Date fechaInicio = new Date();
        prestamo.setFechaInicio(fechaInicio);
        long cincoDiasEnMilisegundos = 5 * 24 * 60 * 60 * 1000L;
        prestamo.setFechaFin(new Date(System.currentTimeMillis() + cincoDiasEnMilisegundos));
        prestamo.setNumeroRenovacionesPermitidas(1);
        prestamo.renovar(); // Primera renovación exitosa

        assertFalse(prestamo.renovar()); // Intento de segunda renovación
        assertTrue(prestamo.isRenovado()); // Sigue marcado como renovado
        assertEquals(1, prestamo.getRenovacionesRealizadas());
    }

    @Test
    void verificarEstaVencido() throws InterruptedException {
        Prestamo prestamoPasado = new Prestamo();
        // Fecha de fin en el pasado
        long unDiaEnMilisegundos = -1 * 24 * 60 * 60 * 1000L;
        prestamoPasado.setFechaFin(new Date(System.currentTimeMillis() + unDiaEnMilisegundos));
        Thread.sleep(2000); // Asegurar que la fecha actual sea posterior
        assertTrue(prestamoPasado.estaVencido());

        Prestamo prestamoFuturo = new Prestamo();
        long dosDiasEnMilisegundos = 2 * 24 * 60 * 60 * 1000L;
        prestamoFuturo.setFechaFin(new Date(System.currentTimeMillis() + dosDiasEnMilisegundos));
        assertFalse(prestamoFuturo.estaVencido());

        Prestamo prestamoHoy = new Prestamo();
        prestamoHoy.setFechaFin(new Date());
        // Puede variar ligeramente, así que verificamos que no sea en el futuro lejano
        assertFalse(prestamoHoy.estaVencido());
    }

    @Test
    void obtenerDiasRestantes() {
        Prestamo prestamoFuturo = new Prestamo();
        long tresDiasEnMilisegundos = 3 * 24 * 60 * 60 * 1000L;
        prestamoFuturo.setFechaFin(new Date(System.currentTimeMillis() + tresDiasEnMilisegundos));
        assertTrue(prestamoFuturo.obtenerDiasRestantes() > 0);

        Prestamo prestamoPasado = new Prestamo();
        long unDiaEnMilisegundos = -1 * 24 * 60 * 60 * 1000L;
        prestamoPasado.setFechaFin(new Date(System.currentTimeMillis() + unDiaEnMilisegundos));
        assertTrue(prestamoPasado.obtenerDiasRestantes() < 0);

        Prestamo prestamoHoy = new Prestamo();
        prestamoHoy.setFechaFin(new Date());
        // Puede ser 0 o muy cercano a 0 debido a la diferencia de milisegundos
        assertTrue(Math.abs(prestamoHoy.obtenerDiasRestantes()) < 1);
    }
}