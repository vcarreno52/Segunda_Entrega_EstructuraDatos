public class InspeccionarMarca extends Procedimiento{
    public InspeccionarMarca() {
         super("InspeccionarMarca", 1, 1);}
    @Override
    public String realizar(Paciente p) {
        return "La marca se ve rugosa, y superficial, pero es necesario probar la sensibilidad en los dedos del paaciente";
    }
}

    
