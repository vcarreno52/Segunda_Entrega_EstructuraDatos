public class Enyesar_y_seguir extends Procedimiento {
    public Enyesar_y_seguir() { super("Enyesar_y_seguir", 1, 2); } // Cuesta vida porque pierde tiempo
    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false);
        p.setMensajeFinal("Perfecto, el dolor de la mano de Perdro mejora, pero sus demás sintomas significan algo");
        return "Le dices a Pedro que su mano mejorará, y mientras tanto seguirás sanando el resto de su cuerpo.";
    }
}
