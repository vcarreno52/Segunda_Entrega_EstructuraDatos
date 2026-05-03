public class Principal {
    public static void main(String[] args) {
        Paciente pedro = new Paciente("Pedro", 10, 20);
        ControladorJuego juego = new ControladorJuego();
        juego.iniciarHistoria(pedro);
    }
}