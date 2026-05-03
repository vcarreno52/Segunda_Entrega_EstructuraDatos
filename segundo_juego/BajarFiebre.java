public class BajarFiebre extends Procedimiento{
    public BajarFiebre() {
        super ("BajarFiebre", 1,0);}
    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false); // Sin la palabra 'estado:'
        p.setMensajeFinal("Pedro se fue a casa creyendo que era solo fiebre...Pedro murio");
    return "Has bajado la fiebre de Pedro."; // ¡Falta el return!
}
}

