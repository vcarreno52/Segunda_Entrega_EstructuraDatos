import java.util.Scanner;

public class ControladorJuego {
    private Scanner scanner = new Scanner(System.in);

    public void iniciarHistoria(Paciente p) {
        System.out.println("Hospital: Caso Pedro");
        System.out.println("1. Entrevista\n2. Inspeccionar marca mano");

        int d1 = scanner.nextInt();
        if (d1 == 1) {
            System.out.println(new Entrevista().realizar(p));
            System.out.println("1. Examen Sangre\n2. Tomar Temperatura");

            int d2 = scanner.nextInt();
            if (d2 == 2) {
                // RAMA TEMPERATURA
                System.out.println(new TomarTemperatura().realizar(p));
                System.out.println("1. Tomografía\n2. Bajar fiebre");

                int d3 = scanner.nextInt();
                if (d3 == 2) {
                    System.out.println(new BajarFiebre().realizar(p));
                    if (!p.isEnHospital()) {
                        System.out.println(p.getMensajeFinal());
                        return; 
                    }
                }
            } else {
                // RAMA EXAMEN SANGRE
                System.out.println(new PruebaSangre().realizar(p));
                System.out.println("1. Diagnosticar diabetes\n2. Revisar sodio");

                int d4 = scanner.nextInt();
                if (d4 == 1) { // <-- LLAVE ABIERTA PARA DIABETES
                    System.out.println(new DiagnosticarDiabetes().realizar(p));
                    
                    if (!p.isEnHospital()) {
                        System.out.println(p.getMensajeFinal());
                        // Aquí, si el diagnóstico de diabetes "saca" al paciente del hospital (pierde), terminamos.
                        // Pero si quieres que el juego siga para elegir Amputar/Dieta, NO pongas setEnHospital(false) en DiagnosticarDiabetes.
                        return;
                    }

                    // Si el juego sigue después del diagnóstico (pista falsa)
                    System.out.println("1. Amputar\n2. Dieta Especial");
                    int d5 = scanner.nextInt();
                    if (d5 == 1) {
                        System.out.println(new Amputar().realizar(p));
                    } else {
                        System.out.println(new DietaEspecial().realizar(p));
                    }
                    
                    // Mostramos el mensaje final de la decisión d5
                    System.out.println(p.getMensajeFinal());
                    return; // Fin de esta rama
                } else {
                    // RAMA REVISAR SODIO (El camino correcto)
                    System.out.println(new PruebaSodio().realizar(p));
                    // Aquí podrías añadir el diagnóstico final ganador
                }
            }
        } else {
            // Aquí iría la opción 2: Inspeccionar marca mano (Traumatología)
            System.out.println("Vas a Traumatología...");
        }
    }
}