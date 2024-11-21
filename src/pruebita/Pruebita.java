/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebita;

import java.util.Scanner;

/**
 *
 * @author Mayra Bardales
 */
public class Pruebita {

   static int clientesAtendidos = 0;
    static int cafesPequenosVendidos = 0;
    static int cafesMedianosVendidos = 0;
    static int cafesGrandesVendidos = 0;
    static double totalCaja = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            procesarCliente(scanner);

            System.out.print("Desea atender a otro cliente? (S/N): ");
            char respuesta = scanner.next().toUpperCase().charAt(0);
            continuar = respuesta == 'S';
        }

        
    }

    
    public static void procesarCliente(Scanner scanner) {
        System.out.println("Bienvenido a Cafe Express UNI!");

        
        System.out.println("Seleccione el tamaño del cafe:");
        System.out.println("1. Pequeño (Lps. 45)");
        System.out.println("2. Mediano (Lps. 56)");
        System.out.println("3. Grande (Lps. 65)");
        int opcionCafe = scanner.nextInt();
        double precioCafe = obtenerPrecioCafe(opcionCafe);

        
        System.out.println("Seleccione el agregado:");
        System.out.println("1. Leche (Lps. 5)");
        System.out.println("2. Cremora (Lps. 8)");
        System.out.println("3. Sencillo (Lps. 0)");
        int opcionAgregado = scanner.nextInt();
        double precioAgregado = obtenerPrecioAgregado(opcionAgregado);

       
        System.out.print("¿Es mayor de edad? (S/N): ");
        char mayorEdad = scanner.next().toUpperCase().charAt(0);
        boolean aplicaDescuento = mayorEdad == 'S';

        
        double total = calcularTotal(precioCafe, precioAgregado, aplicaDescuento);
        System.out.printf("El total a pagar es: Lps. %.2f%n", total);

       
        actualizarResumen(opcionCafe, total);
        clientesAtendidos++;
    }

    
    public static double obtenerPrecioCafe(int opcion) {
        switch (opcion) {
            case 1:
                cafesPequenosVendidos++;
                return 45;
            case 2:
                cafesMedianosVendidos++;
                return 56;
            case 3:
                cafesGrandesVendidos++;
                return 65;
            default:
                System.out.println("Opción no valida, seleccionando tamaño pequeño por defecto.");
                cafesPequenosVendidos++;
                return 45;
        }
    }

    
    public static double obtenerPrecioAgregado(int opcion) {
        switch (opcion) {
            case 1:
                return 5;
            case 2:
                return 8;
            case 3:
                return 0;
            default:
                System.out.println("Opción no válida, seleccionando sencillo por defecto.");
                return 0;
        }
    }

    
    public static double calcularTotal(double precioCafe, double precioAgregado, boolean aplicaDescuento) {
        double subtotal = precioCafe + precioAgregado;
        if (aplicaDescuento) {
            subtotal *= 0.90; 
        }
        return subtotal;
    }

    
    public static void actualizarResumen(int opcionCafe, double total) {
        totalCaja += total;
    }

    
    public static void mostrarResumenDelDia() {
        System.out.println("\nResumen del dia:");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Cafés pequeños vendidos: " + cafesPequenosVendidos);
        System.out.println("Cafés medianos vendidos: " + cafesMedianosVendidos);
        System.out.println("Cafés grandes vendidos: " + cafesGrandesVendidos);
        System.out.printf("Total en caja: Lps. %.2f%n", totalCaja);
    }
    
}
