package base;

/**
 *
 * @author Pedro, Chistopher y Katia
 */
public class Carretera {
    private final Localidad origen;
    private final Localidad destino;
    private final double peso;

    public Carretera(Localidad origen, Localidad destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Localidad getOrigen() {
        return origen;
    }

    public Localidad getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Arista{" + "origen=" + origen + ", destino=" + destino + ", peso=" + peso + '}';
    }
    
    
}
