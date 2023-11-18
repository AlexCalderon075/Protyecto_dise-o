/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dis;

import java.util.ArrayList;
import java.util.Scanner;

 class clase_producto {
        public double precio, cantidad;
        public String descripcion;
    
        public clase_producto(double precio, String descripcion) {
            this.cantidad = 1;
            this.precio = precio;
            this.descripcion = descripcion;
        }
    
        public double getSubtotal() {
            return cantidad * precio;
        }
    
        public double getPrecio() {
            return precio;
        }
    
    
        public double getCantidad() {
            return cantidad;
        }
    
        public void setCantidad(double cantidad) {
            this.cantidad = cantidad;
        }
    
        public String getDescripcion() {
            return descripcion;
        }
         public static clase_producto solicitarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa producto");
        String descripcion = sc.nextLine();
        System.out.println("Ingresa precio:");
        double precio = sc.nextDouble();
        return new clase_producto (precio, descripcion);
    }

    public static void agregarProducto(ArrayList<clase_producto > productos) {
        productos.add(solicitarProducto());
    }

    public static int solicitarIndice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el numero de producto: ");
        return sc.nextInt();
    }


    public static void mostrarTicket(ArrayList<clase_producto > productos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el pago al  producto: ");
        double pago = sc.nextDouble();

        System.out.println("-".repeat(85));
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|\n", "Producto", "Precio", "Cantidad", "Subtotal");
        System.out.println("-".repeat(85));
        double total = 0;
        double resultado=0;
      

        for (clase_producto  p : productos) {
            System.out.printf("|%-20s|%-20f|%-20f|%-20f|\n", p.getDescripcion(), p.getPrecio(), p.getCantidad(), p.getSubtotal());
            total += p.getSubtotal();
            resultado=pago-total;
        }
        System.out.println("-".repeat(85));
        System.out.printf("|%83s|\n", "pago: " + String.valueOf(pago));
        System.out.printf("|%83s|\n", "Total: " + String.valueOf(total));
         System.out.printf("|%83s|\n", "Cambio: "+ String.valueOf(resultado));

        System.out.println("                            **Gracias por su compra**");
    }
    public static void Menu () {
        ArrayList<clase_producto> productos = new ArrayList<clase_producto >();
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (productos.size() > 0) {
                System.out.println("-".repeat(106));
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Numero", "Producto", "Precio", "Cantidad", "Subtotal");
                System.out.println("-".repeat(106));
            }
            int contador = 0;
            for (clase_producto  p : productos) {
                System.out.printf("|%-20d|%-20s|%-20f|%-20f|%-20f|\n", contador, p.getDescripcion(), p.getPrecio(), p.getCantidad(), p.getSubtotal());
                contador++;
            }
            if (productos.size() > 0) {
                System.out.println("-".repeat(106));
            }
            System.out.println("1. Agregar producto\n" +
                    "2. Mostrar ticket y terminar venta\n" +
                    "3. Salir\n" +
                    "Seleccione: ");
            String eleccion = sc.nextLine();
            if (eleccion.equals("1")) {
                agregarProducto(productos);
            } else if (eleccion.equals("2")) {
                mostrarTicket(productos);
                break;
            } else if (eleccion.equals("3")) {
                break;
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }
}