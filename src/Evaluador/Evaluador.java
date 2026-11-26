package Evaluador;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Evaluador {
    // Persona 1 (Hiram)
    static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // (Hiram)
    static int prioridad(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    // (Hiram)
    static String infijaAPostfija(String infija) {
        Deque<Character> pila = new ArrayDeque<>();
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                salida.append(c).append(' ');
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop()).append(' ');
                }
                if (pila.isEmpty()) {
                    throw new IllegalArgumentException("Falta paréntesis de apertura");
                }
                pila.pop();
            } else if (esOperador(c)) {
                while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(c)) {
                    salida.append(pila.pop()).append(' ');
                }
                pila.push(c);
            } else {
                throw new IllegalArgumentException("El carácter: " + c + " no es válido, solo se aceptan dígitos del 0 al 9, paréntesis y operadores.");
            }
        }

        while (!pila.isEmpty()) {
            char tope = pila.pop();
            if (tope == '(') {
                throw new IllegalArgumentException("Falta paréntesis de cierre");
            }
            salida.append(tope).append(' ');
        }

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
