package Prestamo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prestamo {
    private int id;
    private String libroId;
    private int usuarioId;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean renovado;
    private int numeroRenovacionesPermitidas = 1;
    private int renovacionesRealizadas = 0;

    public Prestamo() {
        // Inicializar fechaFin con la fecha actual por defecto.
        // Esto evita el NullPointerException en verificarEstadoInicial.
        this.fechaFin = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isRenovado() {
        return renovado;
    }

    public void setRenovado(boolean renovado) {
        this.renovado = renovado;
    }

    public int getNumeroRenovacionesPermitidas() {
        return numeroRenovacionesPermitidas;
    }

    public void setNumeroRenovacionesPermitidas(int numeroRenovacionesPermitidas) {
        this.numeroRenovacionesPermitidas = numeroRenovacionesPermitidas;
    }

    public int getRenovacionesRealizadas() {
        return renovacionesRealizadas;
    }

    public void setRenovacionesRealizadas(int renovacionesRealizadas) {
        this.renovacionesRealizadas = renovacionesRealizadas;
    }

    public boolean renovar() {
        if (renovacionesRealizadas < numeroRenovacionesPermitidas && !estaVencido()) {
            long quinceDiasEnMilisegundos = 15 * 24 * 60 * 60 * 1000L;
            this.fechaFin = new Date(this.fechaFin.getTime() + quinceDiasEnMilisegundos);
            this.renovado = true;
            this.renovacionesRealizadas++;
            return true;
        }
        return false;
    }

    public boolean estaVencido() {
        Date ahora = new Date();
        return ahora.after(this.fechaFin);
    }

    public long obtenerDiasRestantes() {
        long diferenciaEnMilisegundos = this.fechaFin.getTime() - new Date().getTime();
        return TimeUnit.DAYS.convert(diferenciaEnMilisegundos, TimeUnit.MILLISECONDS);
    }
}