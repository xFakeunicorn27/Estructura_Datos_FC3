package Banco;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Banco {
    private double saldo = 1000;
    private int siguienteId = 1;

    private final Queue<Operacion> pendientes = new ArrayDeque<>();
    private final List<Operacion> historial = new ArrayList<>();
    private final Deque<Operacion> procesadas = new ArrayDeque<>();

    // (Daniel)
    public void registrar(Operacion.Tipo tipo, double monto) {
    }

    // (Daniel)
    public void procesarSiguiente() {
    }

    // (Daniel)
    public void mostrarPendientes() {
    }

    // (Miguel)
    public void mostrarHistorial() {
    }

    // (Miguel)
    public void deshacerUltima() {
    }

    // (Miguel)
    public void consultarSaldo() {
    }

    // (Miguel)
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
    }
}
