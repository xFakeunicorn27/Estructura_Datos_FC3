# Trabajo Final – Parte 3 – Estructuras de Datos

Fundamentos de Computacion III (ISI - 2026-2)

## Integrantes

- _Nevarez Figueroa Iaac Fernando_
- _Ramirez Bautista Hiram Mohamed_
- _Robles Robles Miguel Angel_
- _Sanchez Cordova Jose Daniel_

## Programas (Java)

1. **Evaluador de expresiones**: convierte una expresion infija a postfija y la evalua con pilas.
2. **Simulador bancario**: registra, procesa y deshace depositos y retiros.

## Como ejecutar

Actividad 1:

```
javac EvaluadorExpresiones.java
java EvaluadorExpresiones
```

Actividad 2:

```
javac Operacion.java SimuladorBancario.java
java SimuladorBancario
```

## Estructuras usadas

**Actividad 1**
- Pila de operadores: para convertir a postfija.
- Pila de operandos: para evaluar la postfija.

**Actividad 2**
- Cola: operaciones pendientes (se procesan en el orden en que se registran).
- Lista: historial de todas las operaciones.
- Pila: operaciones procesadas correctamente (para deshacer la ultima).

## Ejemplos

- `(8 + 4) / 2 * 3` -> `8 4 + 2 / 3 *` -> resultado 18
- Simulador: con saldo de $1,000, tras procesar las 4 operaciones del caso de prueba el saldo es $1,200, y al deshacer la ultima queda en $1,100.

## Control de versiones

- Plataforma: GitHub
- Repositorio: https://github.com/xFakeunicorn27/Estructura_Datos_FC3
- Estrategia: cada integrante trabaja en su propia rama y, al terminar su parte, se hace merge a `main`.
