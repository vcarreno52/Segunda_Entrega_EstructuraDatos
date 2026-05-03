public class Entrevista extends Procedimiento{
    public Entrevista() {
         super("Entrevista", 1, 1);}
    @Override
    public String realizar(Paciente p) {
        return "Pedro dice que toma 4 lts de agua al día y constantemente siente un sabor metálico en la boca, a demás dice que siente mucha calor";
    }
}
