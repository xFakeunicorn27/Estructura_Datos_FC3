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
            switch (op){
                case '+': return a + b;
                case '-': return a - b;
                case '*': return a * b;
                case '/':
                    if (b == 0){
                        throw new ArithmeticException("Division entre cero");
                    }
                    return a / b;
                default:
                    throw new IllegalArgumentException("Operador invalido: "+ op);
            }
    }

    // (Isaac)
    static int evaluarPostfija(String postfija) {
        Deque<Integer> pila = new ArrayDeque<>();

        for(char c : postfija.toCharArray()){
            if (c ==' '){
                continue;
            }
            if (Character.isDigit(c)){
                pila.push(c - '0');
            } else if ("+-*/".indexOf(c) >= 0) {
                if (pila.size() < 2){
                    throw new IllegalArgumentException("Expresion invalida");
                }
                int b = pila.pop();
                int a = pila.pop();
                pila.push(aplicarOperacion(a,b,c));
            }else {
                throw new IllegalArgumentException("Caracter invalido: "+ c);
            }
        }
        if (pila.size() != 1){
            throw new IllegalArgumentException("Expresion invalida");
        }
        return pila.pop();
    }

    // (Isaac)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa la expresion: ");
        String expresion = sc.nextLine();

        try{
            String postfija = infijaAPostfija(expresion);
            int resultado = evaluarPostfija(postfija);

            System.out.println("Expresion postfija: "+ postfija);
            System.out.println("Resultado: "+ resultado);
        }catch (ArithmeticException e){
            System.out.println("Error: "+ e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
