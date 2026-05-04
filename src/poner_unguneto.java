public class poner_unguneto extends Procedimiento {
    public poner_unguneto() { super("poner_unguneto", 15, 20); } // Cuesta vida porque pierde tiempo
    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false);
        p.setMensajeFinal("ERROR: Tratar la mano de Pedro No tratará los demás sintomas de Pedro");
        return "Le pides a Pedro que consiga una cita con un especalista lo más pronto posible";
    }
}