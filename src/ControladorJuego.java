import java.util.Scanner;

public class ControladorJuego {
    private Scanner scanner = new Scanner(System.in);

    // MÉTODO AUXILIAR PARA AFECTAR STATS Y MOSTRAR MONITOR
    private void ejecutar(Procedimiento proc, Paciente p) {
        // 1. Mostrar el resultado médico
        System.out.println("\n" + proc.realizar(p));

        // 2. Aplicar costos (Restamos los valores definidos en los constructores)
        p.modificarVida(-proc.costoVida);
        p.modificarOro(-proc.costoOro);

        // 3. Monitor de estado
        System.out.println(">>> MONITOR [ ❤️ Vida: " + p.getVida() + " | 💰 Oro: " + p.getOro() + " ] <<<");

        // 4. Verificar si Pedro murió o el hospital quebró
        if (p.getVida() <= 0) {
            p.setEnHospital(false);
            p.setMensajeFinal("Pedro ha fallecido. El tiempo y los procedimientos fueron demasiados.");
        } else if (p.getOro() <= 0) {
            p.setEnHospital(false);
            p.setMensajeFinal("El hospital se ha quedado sin fondos. No pueden continuar el tratamiento.");
        }
    }

    public void iniciarHistoria(Paciente p, ArbolAVL arbol) {
        boolean enMenuInicio = true;
        while (enMenuInicio) {
            System.out.println("\nHospital: Caso Pedro");
            System.out.println("1. Entrevista\n2. Inspeccionar marca mano\n3. Revisar historia clinica");

            int d1 = scanner.nextInt();
        

        if (d1 == 1) {
            ejecutar(new Entrevista(), p);
            if (!p.isEnHospital()) { System.out.println(p.getMensajeFinal()); return; }

            System.out.println("1. Examen Sangre\n2. Tomar Temperatura");
            int d2 = scanner.nextInt();
            
            if (d2 == 2) {
                // RAMA TEMPERATURA
                ejecutar(new TomarTemperatura(), p);
                if (!p.isEnHospital()) { System.out.println(p.getMensajeFinal()); return; }

                System.out.println("1. Tomografía\n2. Bajar fiebre");
                int d3 = scanner.nextInt();
                if (d3 == 2) {
                    ejecutar(new BajarFiebre(), p);
                    if (!p.isEnHospital()) { System.out.println(p.getMensajeFinal()); return; }
                } else {
                    ejecutar(new Tomografia(), p);
                    if (!p.isEnHospital()) { System.out.println(p.getMensajeFinal()); return; }
                }
            } else {
                // RAMA EXAMEN SANGRE
                ejecutar(new PruebaSangre(), p);
                if (!p.isEnHospital()) { System.out.println(p.getMensajeFinal()); return; }

                System.out.println("1. Diagnosticar diabetes\n2. Revisar sodio");
                int d4 = scanner.nextInt();
                if (d4 == 1) {
                    ejecutar(new DiagnosticarDiabetes(), p);
                    
                    if (!p.isEnHospital()) {
                        System.out.println(p.getMensajeFinal());
                        return;
                    }

                    System.out.println("1. Amputar\n2. Dieta Especial");
                    int d5 = scanner.nextInt();
                    if (d5 == 1) {
                        ejecutar(new Amputar(), p);
                    } else {
                        ejecutar(new DietaEspecial(), p);
                    }
                    
                    System.out.println(p.getMensajeFinal());
                    return; 
                } else {
                    // RAMA REVISAR SODIO
                    ejecutar(new PruebaSodio(), p);
                    System.out.println("Bien hecho, salvaste a Pedro");
                }
            }
        } else if (d1 == 2){
            // RAMA TRAUMATOLOGÍA
            System.out.println("Pedro no siente la punta de sus dedos");
            System.out.println("Si el nervio de Pedro está muerto solo podemos amputar su mano");
            System.out.println("1. Poner ungüento y remitir el paciente\n2. Amputar inmediatamente");

            int d8 = scanner.nextInt();
            if (d8 == 1) {
                ejecutar(new poner_unguneto(), p);
                if (!p.isEnHospital()) {
                    System.out.println(p.getMensajeFinal());
                    return; 
                }                                              
            } else {
                ejecutar(new Amputar(), p);
                if (!p.isEnHospital()) {
                    System.out.println(p.getMensajeFinal());
                    return; 
                } 
            }
        }else if (d1 == 3) {
            arbol.buscar(12345678);
            System.out.println("\n Presione Enter para volver al caso");
            scanner.nextLine(); 
            scanner.nextLine(); 
        } else {
            System.out.println("Opción inválida.");
        }
    }
}
}    