public class Tomografia extends Procedimiento {
    public Tomografia() {super ("Tomografia", 4, 0 );}
    @Override
    public String realizar(Paciente p) {
        return "HALLAZGO: El cerebro de Pedro está muy inflamado ";
    }
}
