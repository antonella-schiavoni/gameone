package guessme.ppc2017.unnoba.edu.ar.gameone;

/**
 * Singleton de la configuracion el juego. Singleton porque solo debe haber una configuracion
 * en el juego, sin posibilidad de mas instanciaciones.
 */
public class Configuration {

    // Constantes del los valores topes al momento de configurar los limites
    private static final int MAXIMUM_UPPER_LIMIT = 100;

    // Creacion de la unica configuracion
    private static Configuration config = new Configuration( );

    private int upperLimit = 20;

    // Constructor privado que es llamado arriba.
    private Configuration(){ }

    // Getter de la unica instancia de esta clase (estatico para no tener que instanciarlo, claramente)
    public static Configuration getConfig() {
        return config;
    }

    /**
     * Getters y Setters de la configuracion pertinente al juego
     */

    public int getUpperLimit() {
        return upperLimit;
    }

    /**
     * El setter evalua que no se supere el maximo valor permitido.
     * Si se viola esta restriccion, el valor quedara como estaba antes
     */
    public void setUpperLimit(int upperLimit) {

        // El límite superior, debe ser inferior del máximo permitido
        if ( upperLimit > MAXIMUM_UPPER_LIMIT ) {
            upperLimit = MAXIMUM_UPPER_LIMIT;
        }

        this.upperLimit = upperLimit;
    }
}