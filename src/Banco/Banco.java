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
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }

        Operacion op = new Operacion(siguienteId++, tipo, monto);
        pendientes.offer(op);
        historial.add(op);

        System.out.println("Operacion registrada (pendiente): " + op);
}

    // (Daniel)
    public void procesarSiguiente() {
        Operacion op = pendientes.poll();
        if (op == null) {
            System.out.println("No hay operaciones pendientes.");
            return;
        }

        if (op.getTipo() == Operacion.Tipo.DEPOSITO) {
            saldo += op.getMonto();
            op.setEstado(Operacion.Estado.PROCESADA);
            procesadas.push(op);
            System.out.println("Deposito realizado: " + op);
        } else {
            if (saldo >= op.getMonto()) {
                saldo -= op.getMonto();
                op.setEstado(Operacion.Estado.PROCESADA);
                procesadas.push(op);
                System.out.println("Retiro realizado: " + op);
            } else {
                op.setEstado(Operacion.Estado.RECHAZADA);
                System.out.println("Retiro rechazado por fondos insuficientes: " + op);
            }
        }
        consultarSaldo();
    }

    // (Daniel)
    public void mostrarPendientes() {
        if (pendientes.isEmpty()) {
            System.out.println("No hay operaciones pendientes.");
            return;
        }

        System.out.println("Operaciones pendientes:");
        for (Operacion op : pendientes) {
            System.out.println(op);
        }
    }

    // (Miguel)
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones en el historial.");
            return;
        }
    
        System.out.println("Historial de operaciones:");
    
        for (Operacion op : historial) {
            System.out.println(op);
        }
    }


    // (Miguel)
    public void deshacerUltima() {
        if (procesadas.isEmpty()) {
            System.out.println("No hay operaciones para deshacer");
            return;
        }

        Operacion op = procesadas.pop();
    
        if (op.getTipo() == Operacion.Tipo.DEPOSITO) {
            saldo -= op.getMonto();
        } else if (op.getTipo() == Operacion.Tipo.RETIRO) {
            saldo += op.getMonto();
        }
    
        historial.remove(op);
    
        System.out.println("Operacion deshecha correctamente");
        consultarSaldo();
    }

    // (Miguel)
    public void consultarSaldo() {
        System.out.printf("Saldo actual: $%.2f%n", saldo);
    }

    // (Miguel)
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
    
        int opcion;
        double monto;
    
        do {
            System.out.println("\n--- MENU DEL BANCO ---");
            System.out.println("1. Registrar deposito");
            System.out.println("2. Registrar retiro");
            System.out.println("3. Procesar siguiente operacion");
            System.out.println("4. Mostrar operaciones pendientes");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Deshacer ultima operacion");
            System.out.println("7. Consultar saldo");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
    
            opcion = sc.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.print("Monto a depositar: ");
                    monto = sc.nextDouble();
                    banco.registrar(Operacion.Tipo.DEPOSITO, monto);
                    break;
    
                case 2:
                    System.out.print("Monto a retirar: ");
                    monto = sc.nextDouble();
                    banco.registrar(Operacion.Tipo.RETIRO, monto);
                    break;
    
                case 3:
                    banco.procesarSiguiente();
                    break;
    
                case 4:
                    banco.mostrarPendientes();
                    break;
    
                case 5:
                    banco.mostrarHistorial();
                    break;
    
                case 6:
                    banco.deshacerUltima();
                    break;
    
                case 7:
                    banco.consultarSaldo();
                    break;
    
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
    
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
