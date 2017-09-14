package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.content.SharedPreferences;

/**
 * Singleton de la configuracion el juego. Singleton porque solo debe haber una configuracion
 * en el juego, sin posibilidad de mas instanciaciones.
 */
public class Configuration {

    private SharedPreferences sharedPreferences;

    private static final int MAXIMUM_UPPER_LIMIT = 100;
    private static final int MINIMUM_UPPER_LIMIT = 20;
    private static final String CONFIG_MAX_KEY = "CONFIG_MAX";
    private static final int DEFAULT_UPPER_LIMIT = 20;

    // Creacion de la unica configuracion
    private static Configuration config = new Configuration( );

    private int upperLimit = DEFAULT_UPPER_LIMIT;

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

        if ( upperLimit < MINIMUM_UPPER_LIMIT ) {
            upperLimit = MINIMUM_UPPER_LIMIT;
        }

        this.upperLimit = upperLimit;
    }

    void setSharedPreferences(SharedPreferences sharedPreferences) {
        int newUpperLimit = sharedPreferences.getInt(CONFIG_MAX_KEY, DEFAULT_UPPER_LIMIT);
        setUpperLimit(newUpperLimit);
        this.sharedPreferences = sharedPreferences;
    }

    void persistConfig() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.putInt(CONFIG_MAX_KEY, upperLimit);
        edit.apply();
    }
}