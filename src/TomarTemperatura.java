public class TomarTemperatura extends Procedimiento{
    public TomarTemperatura(){
        super("TomarTemperatura", 5, 5);}
    @Override
    public String realizar(Paciente p) {
        return "El paciente tiene un poco de fiebre";

    }
}
