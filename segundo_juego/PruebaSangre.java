public class PruebaSangre extends Procedimiento{
    public PruebaSangre(){
        super("Prueba de sangre", 1,0);}
    
    @Override
    public String realizar(Paciente p) {
        return "Conteo de globulo rojos bajo";
    }
}
    
