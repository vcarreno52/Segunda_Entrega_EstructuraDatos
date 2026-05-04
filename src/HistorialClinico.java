import java.util.HashMap;
import java.util.Map;

class HistorialClinico {
    private Map<String, String> campos;

    public HistorialClinico(String cedula, String nombre, String edad, String sangre, String enfermedad) {
        campos = new HashMap<>();
        campos.put("cedula", cedula);
        campos.put("nombre", nombre);
        campos.put("edad", edad);
        campos.put("sangre", sangre);
        campos.put("enfermedad", enfermedad);
    }

    @Override
    public String toString() {
        return String.format("Paciente: %-10s | Edad: %s | Sangre: %-3s | Historial: %s",
                campos.get("nombre"), campos.get("edad"), campos.get("sangre"), campos.get("enfermedad"));
    }
}