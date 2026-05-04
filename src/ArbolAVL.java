import java.util.HashMap;
import java.util.Map;

class ArbolAVL {
    class Nodo {
        int cedula;
        HistorialClinico historial;
        Nodo izq, der;
        int altura;

        Nodo(int c, HistorialClinico h) {
            this.cedula = c;
            this.historial = h;
            this.altura = 1;
        }
    }

    private Nodo raiz;

    private int altura(Nodo n) { return (n == null) ? 0 : n.altura; }
    private int getBalance(Nodo n) { return (n == null) ? 0 : altura(n.izq) - altura(n.der); }

    // Rotacion simple derecha
    private Nodo rotarDer(Nodo y) {
        Nodo x = y.izq;
        Nodo T2 = x.der;
        x.der = y;
        y.izq = T2;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        return x;
    }

    // Rotación simple izquierda
    private Nodo rotarIzq(Nodo x) {
        Nodo y = x.der;
        Nodo T2 = y.izq;
        y.izq = x;
        x.der = T2;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        return y;
    }

    public void insertar(int cedula, HistorialClinico historial) {
        raiz = insertarRec(raiz, cedula, historial);
    }

    private Nodo insertarRec(Nodo nodo, int cedula, HistorialClinico historial) {
        if (nodo == null) return new Nodo(cedula, historial);

        if (cedula < nodo.cedula) nodo.izq = insertarRec(nodo.izq, cedula, historial);
        else if (cedula > nodo.cedula) nodo.der = insertarRec(nodo.der, cedula, historial);
        else return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        int balance = getBalance(nodo);

        // Casos de desbalanceo
        if (balance > 1 && cedula < nodo.izq.cedula) return rotarDer(nodo);
        if (balance < -1 && cedula > nodo.der.cedula) return rotarIzq(nodo);
        if (balance > 1 && cedula > nodo.izq.cedula) {
            nodo.izq = rotarIzq(nodo.izq);
            return rotarDer(nodo);
        }
        if (balance < -1 && cedula < nodo.der.cedula) {
            nodo.der = rotarDer(nodo.der);
            return rotarIzq(nodo);
        }
        return nodo;
    }

    public void buscar(int cedula) {
        Nodo aux = raiz;
        while (aux != null) {
            if (cedula == aux.cedula) {
                System.out.println("Encontrado: " + aux.historial);
                return;
            }
            aux = (cedula < aux.cedula) ? aux.izq : aux.der;
        }
        System.out.println("Error: La cedula " + cedula + " no existe en los registros.");
    }

    public void listarEnOrden(Nodo n) {
        if (n != null) {
            listarEnOrden(n.izq);
            System.out.println("[Cédula: " + n.cedula + "] " + n.historial);
            listarEnOrden(n.der);
        }
    }
    
    public Nodo getRaiz() { return raiz; }
}