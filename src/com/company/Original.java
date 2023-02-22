package com.company;

import java.util.Scanner;

public class Original {
    public static void main(String[] args) {
        /**
         * En esta parte lo que hacemos es pedir el numero limite del cual vamos a obtener numeros primos.
         */
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        /**
         * Aqui realizamos un cuadro con todos los numeros desde el 1 hasta el numero limite
         */
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            extracted(i);
        }
        /**
         * Aqui llamamos al metodo donde genera los numeros primos y despues realizamos otro cuadro con todos los numeros primos desde el 2 hasta el numero limite
         */
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            extracted(vector, i);
        }
    }

    public static void extracted(int i) {
        generadorCuadro(i);
    }

    /**
     * Este metodo genera el cuadro de los numeros, lo que hace el metodo es que cuando el numero de i es multiplo de 10, se imprime el numero y despues se hace un salto de linea.
     *
     * @param i
     */
    public static void generadorCuadro(int i) {
        if (i % 10 == 0) System.out.println();
        System.out.print(i + 1 + "\t");
    }

    public static void extracted(int[] vector, int i) {
        extracted1(vector, i);
    }

    public static void extracted1(int[] vector, int i) {
        if (i % 10 == 0) System.out.println();
        System.out.print(vector[i] + "\t");
    }

// Generar números primos de 1 a max

    /**
     * En este metodo se genera los numeros primos del 2 hasta el numero limite.
     *
     * @param max
     * @return
     */
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = esPrimo(dim);
// Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
// Eliminar los múltiplos de i
                    extracted(i, dim, esPrimo);
                }
            }
// ¿Cuántos primos hay?
            int cuenta = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i = 0, j = 0; i < dim; i++) {
                j = getJ(i, j, esPrimo, primos);
            }
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    public static int getJ(int i, int j, boolean[] esPrimo, int[] primos) {
        j = getAnInt(i, j, esPrimo, primos);
        return j;
    }

    public static int getAnInt(int i, int j, boolean[] esPrimo, int[] primos) {
        if (esPrimo[i])
            primos[j++] = i;
        return j;
    }

    /**
     * En este metodo se comprueba si los numeros son primos o no
     *
     * @param dim
     * @return
     */
    public static boolean[] esPrimo(int dim) {
        int i;
        boolean[] esPrimo = new boolean[dim];
// Inicializar el array
        for (i = 0; i < dim; i++)
            esPrimo[i] = true;
// Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }

    public static void extracted(int i, int dim, boolean[] esPrimo) {
        int j;
        for (j = 2 * i; j < dim; j += i)
            esPrimo[j] = false;
    }
}