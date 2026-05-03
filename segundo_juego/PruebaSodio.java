public class PruebaSodio extends Procedimiento {
    public PruebaSodio() {super ("Prueba de  Sodio", 2, 1);}
    @Override
    public String realizar(Paciente p) {
        return "REsultado : Sodio bajo, el paciente tiene diluido los electrolitos"; 
    }
}
