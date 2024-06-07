package com.mycompany.instrumentoinventario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InstrumentoInventario {
    
    ArrayList<String>listaProductos;
    ArrayList<ArrayList<String>> listaGeneralProductos;
    
     public InstrumentoInventario(){
        listaProductos=new ArrayList<>();
        listaGeneralProductos=new ArrayList<>();
    }

  
    public void iniciar() { //Menú para escoger la opción que el usuario desea consultar
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Agregar Producto\n2. Buscar prodcuto por nombre\n3. Eliminar producto\n4. Mostrar inventario\n5. Terminar.\n"));
            switch (opcion) {
                case 1:
                    AgregarProducto();
                    break;
                case 2:
                    Buscarproductopornombre();
                    break;
                case 3:
                    Eliminarproducto();
                    break;
                case 4:
                    MostrarInventario();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, ingrese una opción válida ");
            }
        } while (opcion!=5);
    }
    public void inicia(){
        AgregarProducto();
        Buscarproductopornombre();
        Eliminarproducto();
        MostrarInventario();
    }
     private void AgregarProducto(){ //Bloque de codigo para ingresar el producto
        System.out.println("\n<<<< Agregar producto >>>>");
        int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de producto"));
        
        for (int i = 0; i <cant ; i++){
            
            String nombreProducto=JOptionPane.showInputDialog("nombre Producto "+(i+1));
            if (!listaProductos.contains(nombreProducto))
                listaProductos.add(nombreProducto);
            else
                JOptionPane.showMessageDialog(null, "El producto " +nombreProducto+ " ya se encuentra registrado en la lista");
        }
        System.out.println("Registro Exitoso!\n");
    }
     private void Buscarproductopornombre(){
         System.out.println("\n<<<< Consulta de Producto >>>> \n");
         String nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto");
         if (listaProductos.contains(nombreProducto)) {
            System.out.print("Profesor: "+nombreProducto+" = ");
            int posicion=listaProductos.indexOf(nombreProducto);
            if (posicion < listaGeneralProductos.size()) {
                System.out.print("[");

                ArrayList<String> listaProductosTemporal=listaGeneralProductos.get(posicion);

                for (int j = 0; j < listaProductosTemporal.size(); j++) {
                    System.out.print(listaProductosTemporal.get(j));
                    if (j<listaProductosTemporal.size()-1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("El producto no tiene cantidad registrada");
            }
        } else {
            System.out.println("No se encuentra el producto "+nombreProducto+"\n");
        }
     }
      private void consultaCantidadProductoPorNombre() {//Permite al usuario consultar la cantidad de cada producto
        System.out.println("\n<<<< Consulta cantidad de un producto por nombre >>>>  \n");
        String nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto para saber la cantidad de este producto");

        if (listaProductos.contains(nombreProducto)) {
            int posicion=listaProductos.indexOf(nombreProducto);
            if (posicion < listaGeneralProductos.size()) {

                ArrayList<String> listaProductosTemporal=listaGeneralProductos.get(posicion);
                System.out.println("La cantidad de estudiantes asociados al profesor "+nombreProducto+" es "+listaProductosTemporal.size());
            } else {
                System.out.println("El profesor "+nombreProducto+" no tiene estudiantes.");
            }
        } else {
            System.out.println("No se encuentra el profesor "+nombreProducto+"\n");
        }  
     }
     private void  MostrarInventario() {// Bloque de un codigo que mostrará los productos y la cantidad 
        System.out.println("\n<<<< Lista de Profesores y Estudiantes >>>>");
        ArrayList<String> listaTemporal;

        if (listaProductos.size() > 0) {
            if (listaGeneralProductos.size() > 0) {
                for (int i = 0; i < listaGeneralProductos.size(); i++) {
                    listaTemporal=listaGeneralProductos.get(i);

                    System.out.print("Producto: "+listaProductos.get(i)+" = ");
                    System.out.print("[");
                    for (int j = 0; j < listaTemporal.size(); j++) {
                        System.out.print(listaTemporal.get(j));
                        if (j<listaTemporal.size()-1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto "+listaProductos.get(0)+" no tiene cantidades registradas, registre una cantidad de producto antes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos registrados, registre un producto primero");
        }
     }
     private void Eliminarproducto(){
         System.out.println("\n<<<< Producto a Eliminar >>>>  \n");
         String nombreProducto=JOptionPane.showInputDialog("Ingrese el nombre del producto a eliminar");
         
         listaProductos.remove(nombreProducto);
         System.out.print(listaProductos);
     }
}
