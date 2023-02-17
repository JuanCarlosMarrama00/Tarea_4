package com.company;
import java.util.Scanner;
public class Original {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector =new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            extracted(i);
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            extracted(vector, i);
        }
    }

    private static void extracted(int i) {
        extracted1(i);
    }

    private static void extracted1(int i) {
        if (i %10==0) System.out.println();
        System.out.print(i +1+"\t");
    }

    private static void extracted(int[] vector, int i) {
        extracted1(vector, i);
    }

    private static void extracted1(int[] vector, int i) {
        if (i %10==0) System.out.println();
        System.out.print(vector[i]+"\t");
    }

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = esPrimo(dim);
// Criba
            for (i=2; i<Math.sqrt(dim)+1; i++) {
                if (esPrimo[i]) {
// Eliminar los múltiplos de i
                    extracted(i, dim, esPrimo);
                }
            }
// ¿Cuántos primos hay?
            int cuenta = 0;
            for (i=0; i<dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i=0, j=0; i<dim; i++) {
                j = getJ(i, j, esPrimo, primos);
            }
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    private static int getJ(int i, int j, boolean[] esPrimo, int[] primos) {
        j = getAnInt(i, j, esPrimo, primos);
        return j;
    }

    private static int getAnInt(int i, int j, boolean[] esPrimo, int[] primos) {
        if (esPrimo[i])
            primos[j++] = i;
        return j;
    }

    private static boolean[] esPrimo(int dim) {
        int i;
        boolean[] esPrimo = new boolean[dim];
// Inicializar el array
        for (i=0; i< dim; i++)
            esPrimo[i] = true;
// Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }

    private static void extracted(int i, int dim, boolean[] esPrimo) {
        int j;
        for (j=2* i; j< dim; j+= i)
            esPrimo[j] = false;
    }
}

