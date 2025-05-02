package Prestamo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrestamoMockitoTest {

    @Test
    void renovarPrestamoExitosamenteConMockito() {
        // Crear un objeto Prestamo real
        Prestamo prestamo = new Prestamo();
        Date fechaInicio = new Date();
        prestamo.setFechaInicio(fechaInicio);
        // Establecer una fecha de fin en el futuro
        long dosDiasEnMilisegundos = 2 * 24 * 60 * 60 * 1000L;
        prestamo.setFechaFin(new Date(System.currentTimeMillis() + dosDiasEnMilisegundos));

        // En este caso, no hay dependencias externas complejas para simular.
        // La lógica de renovación depende principalmente del estado interno del objeto Prestamo.

        assertTrue(prestamo.renovar());
        assertTrue(prestamo.isRenovado());
        assertEquals(1, prestamo.getRenovacionesRealizadas());
        assertTrue(prestamo.getFechaFin().after(new Date(fechaInicio.getTime() + dosDiasEnMilisegundos)));
    }

    @Test
    void noRenovarPrestamoVencidoConMockito() throws InterruptedException {
        // Crear un objeto Prestamo real
        Prestamo prestamo = new Prestamo();
        Date fechaInicio = new Date();
        prestamo.setFechaInicio(fechaInicio);
        // Establecer una fecha de fin en el pasado
        long unDiaEnMilisegundos = -1 * 24 * 60 * 60 * 1000L;
        prestamo.setFechaFin(new Date(System.currentTimeMillis() + unDiaEnMilisegundos));

        Thread.sleep(2000); // Asegurar que la fecha actual sea posterior a fechaFin

        assertFalse(prestamo.renovar());
        assertFalse(prestamo.isRenovado());
        assertEquals(0, prestamo.getRenovacionesRealizadas());
    }

    @Test
    void verificarEstaVencidoConMockito() throws InterruptedException {
        // Crear un objeto Prestamo real
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
    }

    // Ejemplo de prueba con una dependencia simulada (aunque Prestamo no tiene dependencias complejas ahora)
    @Test
    void ejemploConDependenciaSimulada() {
        // Supongamos que Prestamo tiene una dependencia llamada ServicioDeReglas
        // y queremos simular su comportamiento.

        // ServicioDeReglas servicioDeReglasMock = mock(ServicioDeReglas.class);
        // Prestamo prestamo = new Prestamo(servicioDeReglasMock); // Si el constructor aceptara la dependencia

        // when(servicioDeReglasMock.esRenovable(any(Prestamo.class))).thenReturn(true);

        // assertTrue(prestamo.renovar());
        // verify(servicioDeReglasMock).esRenovable(prestamo);
    }
}

// Interfaz ficticia para el ejemplo de dependencia simulada
// interface ServicioDeReglas {
//     boolean esRenovable(Prestamo prestamo);
// }
