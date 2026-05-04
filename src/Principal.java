import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolAVL arbol = new ArbolAVL(); 
        String rutaArchivo = "cedulas.txt";

        // Procesamiento de archivo
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("Error fatal: El archivo 'cedulas.txt' no se encuentra en " + archivo.getAbsolutePath());
            return;
        }
        //try catch para el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("Cargando registros...");
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    int id = Integer.parseInt(datos[0].trim());
                    HistorialClinico hc = new HistorialClinico(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    arbol.insertar(id, hc);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
        //Menu
        int op = 0;
        while (op != 4) {
            System.out.println("\n   Menu");
            System.out.println("1. Listar todos los pacientes (ordenado por cedula)");
            System.out.println("2. Buscar paciente por numero de cedula");
            System.out.println("3. Iniciar juego con Jorge");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            try {
                op = sc.nextInt();
                switch (op) {
                  
                    case 1: 
                        arbol.listarEnOrden(arbol.getRaiz());
                        break;
                    case 2:
                        System.out.print("Ingrese la cedula a buscar: ");
                        arbol.buscar(sc.nextInt());
                        break;
                    case 3:
                        Paciente pedro = new Paciente("Pedro", 100, 1600);
                        ControladorJuego juego = new ControladorJuego();
                        juego.iniciarHistoria(pedro, arbol);
                        break;
                    case 4:
                        System.out.println("Cerrando sistema...");
                        break;
                    default:
                        System.out.println("Opción invalida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo numeros.");
                sc.next();
            }
        }
    }
}