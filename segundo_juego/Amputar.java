public class Amputar extends Procedimiento{
    public Amputar() {
        super("Amputar", 3, 2);}

    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false); // Sin la palabra 'estado:'
        p.setMensajeFinal("Amputaron la mano de Pedro, úede estar teniendo una necrosis");
        return "Quebraste, con una demanda al hospital, la necrosis era solamente una herada superficial";
    }
}