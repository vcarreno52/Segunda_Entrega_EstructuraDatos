public abstract class Procedimiento {
    public String  nombre;
    public int costoVida;
    public int costoOro;

    public Procedimiento(String nombre, int vida, int oro){
        this.nombre =nombre;
        this.costoVida= vida;
        this.costoOro= oro;
    }

    public abstract String realizar(Paciente p);
}

