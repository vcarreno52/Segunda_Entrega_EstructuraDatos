public class Enyesar_y_descanso extends Procedimiento {
    public Enyesar_y_descanso() { super("Enyesar_y_descanso", 1, 2); } // Cuesta vida porque pierde tiempo
    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false);
        p.setMensajeFinal("ERROR: Tratar la heridar No tratará los demás sintomas de Pedro");
        return "Le pides a Pedro que evite movimiento bruscos o usar su mano enyesada.";
    }
}