public class Rayos_X extends Procedimiento{
    public Rayos_X() {
         super("Rayos_X", 1, 1);}
    @Override
    public String realizar(Paciente p) {
        return "El paciente presenta múltiples laceraciones, sin embargo ninguna muy profunda";
    }
}