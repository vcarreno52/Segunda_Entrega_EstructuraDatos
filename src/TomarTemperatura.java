public class TomarTemperatura extends Procedimiento{
    public TomarTemperatura(){
        super("TomarTemperatura", 1, 2);}
    @Override
    public String realizar(Paciente p) {
        return "El paciente tiene un poco de fiebre";

    }
}
