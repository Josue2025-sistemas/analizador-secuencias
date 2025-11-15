import java.util.Scanner;

public class Parcial2 {

    
    public static int[] leerArreglo(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = new int[n];
        System.out.println("Introduce " + n + " números:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }
        return arreglo;
    }

    
    public static boolean esPrimo(int x) {
        if (x <= 1) {
            return false;  
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {  
            if (x % i == 0) {
                return false;  
            }
        }
        return true;
    }

    
    public static int contarPrimos(int[] a) {
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            if (esPrimo(a[i])) {
                contador++;
            }
        }
        return contador;
    }

    
    public static int maximo(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    
    public static int[] indicesDeMaximo(int[] a) {
        int max = maximo(a);
        int contador = 0;
        
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                contador++;
            }
        }

        
        int[] indices = new int[contador];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                indices[index++] = i;
            }
        }
        return indices;
    }

    
    public static boolean esCapicua(int[] a) {
        int inicio = 0;
        int fin = a.length - 1;
        
        
        while (inicio < fin) {
            if (a[inicio] != a[fin]) {
                return false;  
            }
            inicio++;
            fin--;
        }
        return true;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Introduce el tamaño del arreglo (5 ≤ N ≤ 50):");
        int N = scanner.nextInt();
        
        
        if (N < 5 || N > 50) {
            System.out.println("El tamaño del arreglo debe estar entre 5 y 50.");
            return;
        }

        
        int[] arreglo = leerArreglo(N);

        
        System.out.println("Cantidad de números primos: " + contarPrimos(arreglo));
        System.out.println("Valor máximo: " + maximo(arreglo));
        
        int[] indicesMax = indicesDeMaximo(arreglo);
        System.out.print("Índices del valor máximo: ");
        for (int i = 0; i < indicesMax.length; i++) {
            System.out.print(indicesMax[i] + " ");
        }
        System.out.println();
        
        System.out.println("¿Es capicúa? " + (esCapicua(arreglo) ? "Sí" : "No"));
    }
