public class DiagnosticarDiabetes extends Procedimiento{
    public DiagnosticarDiabetes() {
        super("Diagnosticar Diabetes", 1, 4);}
    @Override
    public String realizar(Paciente p) {
    return "Los globulo rojos bajos, el cansancio, la desroientaci+on, todo apunta a una diabetes terminal";
    
    }
}