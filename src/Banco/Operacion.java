package Banco;

public class Operacion {
    public enum Tipo { DEPOSITO, RETIRO }
    public enum Estado { PENDIENTE, PROCESADA, RECHAZADA, DESHECHA }

    // (Daniel): atributos
    private final int id;
    private final Tipo tipo;
    private final double monto;
    private Estado estado;

    // (Daniel): constructor
    public Operacion(int id, Tipo tipo, double monto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.estado = Estado.PENDIENTE;
    }
    // (Daniel): getters
    public int getId() {
        return id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public Estado getEstado() {
        return estado;
    }

    // (Daniel): setEstado
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    // (Daniel): toString
    @Override
    public String toString() {
        return String.format("ID: %d | %s | $%.2f | %s", id, tipo, monto, estado);
    }
}
