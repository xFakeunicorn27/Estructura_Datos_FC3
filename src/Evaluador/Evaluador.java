package Evaluador;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Evaluador {
    // Persona 1 (Hiram)
    static boolean esOperador(char c) {
        return false;
    }

    // (Hiram)
    static int prioridad(char op) {
        return 0;
    }

    // (Hiram)
    static String infijaAPostfija(String infija) {
        Deque<Character> pila = new ArrayDeque<>();
        StringBuilder salida = new StringBuilder();
        return salida.toString().trim();
    }

    // (Isaac)
    static int aplicarOperacion(int a, int b, char op) {
        return 0;
    }

    // (Isaac)
    static int evaluarPostfija(String postfija) {
        Deque<Integer> pila = new ArrayDeque<>();
        return 0;
    }

    // (Isaac)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
