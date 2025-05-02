package Prestamo;

import Prestamo.Libro;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Crear un libro
        Libro libro1 = new Libro("978-1234567890", "El Principito", "Antoine de Saint-Exupéry", "Salamandra", 3);
        System.out.println("--- Libro Creado ---");
        System.out.println("Título: " + libro1.getTitulo());
        System.out.println("ISBN: " + libro1.getIsbn());
        System.out.println("Copias Disponibles: " + libro1.getCopiasDisponibles());
        System.out.println("Detalles: " + libro1.obtenerDetalles());

        System.out.println("\n--- Gestión de Préstamo ---");

        // Crear un préstamo
        Prestamo prestamo1 = new Prestamo(); // Corregido el nombre de la clase a Prestamo
        prestamo1.setId(1);
        prestamo1.setLibroId(libro1.getIsbn()); // Asignar el ISBN del libro creado
        prestamo1.setUsuarioId(101);
        prestamo1.setFechaInicio(new Date());

        // Establecer una fecha de fin para dentro de 5 días
        long cincoDiasEnMilisegundos = 5 * 24 * 60 * 60 * 1000L;
        prestamo1.setFechaFin(new Date(System.currentTimeMillis() + cincoDiasEnMilisegundos));

        System.out.println("\n--- Préstamo Inicial ---");
        System.out.println("ID del Préstamo: " + prestamo1.getId());
        System.out.println("Libro ID (ISBN): " + prestamo1.getLibroId());
        System.out.println("Usuario ID: " + prestamo1.getUsuarioId());
        System.out.println("Fecha de Inicio: " + prestamo1.getFechaInicio());
        System.out.println("Fecha de Fin Esperada: " + prestamo1.getFechaFin());
        System.out.println("¿Está vencido? " + prestamo1.estaVencido());
        System.out.println("Días restantes: " + prestamo1.obtenerDiasRestantes());
        System.out.println("Renovado: " + prestamo1.isRenovado());
        System.out.println("Renovaciones realizadas: " + prestamo1.getRenovacionesRealizadas());

        // Intentar renovar el préstamo
        System.out.println("\n--- Intento de Renovación 1 ---");
        boolean renovacionExitosa1 = prestamo1.renovar();
        System.out.println("Renovación exitosa: " + renovacionExitosa1);
        System.out.println("Nueva Fecha de Fin Esperada: " + prestamo1.getFechaFin());
        System.out.println("Renovado: " + prestamo1.isRenovado());
        System.out.println("Renovaciones realizadas: " + prestamo1.getRenovacionesRealizadas());
        System.out.println("¿Está vencido? " + prestamo1.estaVencido());
        System.out.println("Días restantes: " + prestamo1.obtenerDiasRestantes());

        // Intentar renovar de nuevo
        System.out.println("\n--- Intento de Renovación 2 ---");
        boolean renovacionExitosa2 = prestamo1.renovar();
        System.out.println("Renovación exitosa: " + renovacionExitosa2);
        System.out.println("Fecha de Fin Esperada: " + prestamo1.getFechaFin());
        System.out.println("Renovado: " + prestamo1.isRenovado());
        System.out.println("Renovaciones realizadas: " + prestamo1.getRenovacionesRealizadas());

        // Simular que pasa el tiempo y el préstamo vence
        System.out.println("\n--- Simulando que el tiempo pasa (espera 6 días) ---");
        Thread.sleep(6 * 24 * 60 * 60 * 1000L); // Espera 6 días
    }
}