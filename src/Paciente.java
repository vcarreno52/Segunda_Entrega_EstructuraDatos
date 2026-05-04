public class Paciente {
    private String nombre;
    private int vida;
    private int oro;
    private boolean enHospital = true;
    private String mensajeFinal = "";

    public Paciente(String nombre, int vida, int oro){
        this.nombre= nombre;
        this.vida=vida;
        this.oro=oro;
    }

    public void setEnHospital(boolean estado){
        this.enHospital = estado;
    }


    public boolean isEnHospital(){
           return enHospital;}

    public void setMensajeFinal(String mensaje) {
    this.mensajeFinal = mensaje; }


    public String getMensajeFinal() {
        return mensajeFinal;

    }

    public void modificarVida(int cantidad) {this.vida += cantidad;}
    public void modificarOro(int cantidad) {this.oro += cantidad;}

    public String getNombre() {return nombre;}
    public int getVida() {return vida;}
    public int getOro() {return oro;} 
}