import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class listaVagones {
    private Nodo locomotora = null;
    private int longitud = 0;
    private int descargas = 0;
    private int kilos = 0;
    private int kilosDescargados = 0;

    public class Nodo {
        public fruta fruta;
        public Nodo siguiente = null;

        public Nodo(fruta fruta) {
            this.fruta = fruta;
        }
    }

    public void insertarPrimero(fruta fruta) {
        Nodo nodo = new Nodo(fruta);
        nodo.siguiente = locomotora;
        locomotora = nodo;
        longitud++;
        kilos = fruta.getKilos() + kilos;
    }

    public void insertarFinal(fruta fruta) {
        Nodo nodo = new Nodo(fruta);

        if (locomotora == null) {
            locomotora = nodo;
        } else {
            Nodo puntero = locomotora;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
        }
        longitud++;
        kilos = fruta.getKilos() + kilos;

    }

    public int contadorVagones(){
        return longitud;
    }

    public int vagonesDescargados() {
        return descargas;
    }

    public void descargarVagon(int numCiudad, fruta fruta, int kilosDescarga) {
        Nodo nodo = new Nodo(fruta);

        if(locomotora != null) {
            if (numCiudad == 0) {
                Nodo primer = locomotora;
                locomotora = locomotora.siguiente;
                primer.siguiente = null;
                longitud--;
                descargas++;
                kilosDescargados = kilosDescarga;
                kilos = kilos-kilosDescarga;
            } else if(numCiudad < longitud) {
                Nodo puntero = locomotora;
                int contador = 0;

                while (contador < (numCiudad-1)) {
                    puntero = puntero.siguiente;
                    contador++;
                }
                Nodo temp = puntero.siguiente;
                puntero.siguiente = temp.siguiente;
                temp.siguiente = null;
                longitud--;
                descargas++;
                kilosDescargados = kilosDescarga;
                kilos = kilos-kilosDescarga;
            }
        }
    }

    public void mostrarData(fruta fruta) {
        System.out.println("=========================================================");
        System.out.println("INFORMACION GENERAL:");
        System.out.println("Vagones:" + longitud);
        System.out.println("Ultima ciudad: Ciudad #" + fruta.getCiudad());
        System.out.println("Kilos Totales: " + kilos + "Kg");
        System.out.println("Kilos descargados: " + kilosDescargados + "Kg");
        System.out.println("=========================================================");
        imprimirCantidadNodos();
        System.out.println("=========================================================");
    }

    public void imprimirCantidadNodos() {
        int cantidad = 0;
        Nodo actual = locomotora;
        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }
        System.out.println("INFO: Numero de nodos de la lista: " + cantidad);
    }
}
