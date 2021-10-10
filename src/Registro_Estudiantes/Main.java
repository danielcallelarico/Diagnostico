
package Registro_Estudiantes;

import java.util.Scanner;
public class Main{
    static cRegistro objRegistro=new cRegistro(10);
    public static void ingreso_alumno(){
        Scanner br=new Scanner (System.in);
        int codigo;
        String nombres;
        double practica,exparcial,exfinal;
        System.out.print("INGRESE UN CODIGO:");
        codigo=br.nextInt();
        System.out.print("INGRESE UN NOMBRE:");
        nombres=br.next();
        System.out.print("INGRESE PRACTICA:");
        practica=br.nextFloat();
        System.out.print("INGRESE PARCIAL:");
        exparcial=br.nextDouble();
        System.out.print("INGRESE FINAL:");
        exfinal=br.nextDouble();

        objRegistro.agregar_alumno(codigo, nombres, practica, exparcial, exfinal);
    }
    public static void mostrar_alumnos(){
        System.out.println(objRegistro.listar_alumnos());
    }
     public static void busca_alumno_codigo(){
         Scanner br=new Scanner (System.in);
         int cod;
         System.out.print("INGRESE CODIGO DEL ALUMNO A BUSCAR: ");
         cod=br.nextInt();
         objRegistro.buscar_alumno(cod);
     }
     public static void busca_alumno_nombre(){
         Scanner br=new Scanner (System.in);
         String nomb;
         System.out.print("INGRESE NOMBRE DEL ALUMNO A BUSCAR: ");
         nomb=br.next();
         objRegistro.buscar_alumno(nomb);
     }
     public static void ordenar_alumno_codigo() {
        objRegistro.ordenar_codigo();
    }
    public static void ordenar_alumno_nombre() {
        objRegistro.ordenar_nombres();
    }
    public static void modificar_parcial() {
        int cod;
        Double parc;
        Scanner br=new Scanner (System.in);
        System.out.print("INGRESE CODIGO DEL ALUMNO: ");
        cod=br.nextInt();
        System.out.print("INGRESE PARCIAL DEL ALUMNO: ");
        parc=br.nextDouble();
        objRegistro.modificar_parcial(cod, parc);
    }
    public static void eliminar_alumno() {
        int cod;
        Scanner br=new Scanner (System.in);
        System.out.print("INGRESE CODIGO DEL ALUMNO: ");
        cod=br.nextInt();
        objRegistro.eliminar_alumno(cod);
    }
    public static void mostrar_aprobados(){
        System.out.println(objRegistro.listar_aprobados());
    }
    public static void main(String[] args){
Scanner br=new Scanner (System.in);
        int opcion;
        do{
            System.out.println("MENU DE OPCIONES:");
            System.out.println("1. INGRESO DE ALUMNO");
            System.out.println("2. MOSTRAR ALUMNO");
            System.out.println("3. BUSCAR ALUMNO POR CODIGO ");
            System.out.println("4. BUSCAR ALUMNO POR NOMBRE ");
            System.out.println("5. ORDENAR ALUMNO POR CODIGO ");
            System.out.println("6. ORDENAR ALUMNO POR NOMBRES");
            System.out.println("7. MODIFICAR EXAMEN PARCIAL");
            System.out.println("8. ELIMINAR ALUMNO");
            System.out.println("9. MOSTRAR ALUMNOS APROBADOS");
            System.out.println("10. SALIR");

            do{
                System.out.print("INGRESE UNA OPCION [1-10]:");
                opcion=br.nextInt();
            }while(opcion<1||opcion>10);
            switch(opcion){
                case 1:
                    ingreso_alumno();
                    break;
                case 2:
                    mostrar_alumnos();
                    break;
                case 3:
                    busca_alumno_codigo();
                    break;
                case 4:
                    busca_alumno_nombre();
                    break;
                case 5:
                    ordenar_alumno_codigo();
                    break;
                case 6:
                    ordenar_alumno_nombre();
                    break;
                case 7:
                    modificar_parcial();
                    break;
                case 8:
                    eliminar_alumno();
                    break;
                case 9:
                    mostrar_aprobados();
                    break;
                case 10:
                    System.exit(0);
            }
        }while(opcion!=10);
    }
}
