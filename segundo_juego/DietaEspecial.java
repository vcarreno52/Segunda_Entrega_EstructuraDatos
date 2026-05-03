public class DietaEspecial extends Procedimiento {
    public DietaEspecial() { super("Dieta Especial", 1, 2); } // Cuesta vida porque pierde tiempo
    @Override
    public String realizar(Paciente p) {
        p.setEnHospital(false);
        p.setMensajeFinal("ERROR: La dieta no sirve para la intoxicación por agua. Pedro colapsa esa misma noche.");
        return "Le pides a Pedro que deje los carbohidratos y vuelva en una semana.";
    }
}