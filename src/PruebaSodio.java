public class PruebaSodio extends Procedimiento {
    public PruebaSodio() {super ("Prueba de  Sodio", 25, 100);}
    @Override
    public String realizar(Paciente p) {
        return "REsultado : Sodio bajo, el paciente tiene diluido los electrolitos"; 
    }
}
