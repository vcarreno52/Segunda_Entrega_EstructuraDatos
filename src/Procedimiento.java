public abstract class Procedimiento {
    protected String  nombre;
    protected int costoVida;
    protected int costoOro;

    public Procedimiento(String nombre, int vida, int oro){
        this.nombre =nombre;
        this.costoVida= vida;
        this.costoOro= oro;
    }

    public abstract String realizar(Paciente p);
}

