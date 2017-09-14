package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Activity de bienvenida
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Obtenemos la ultima configuracion utilizada (si es que existe)
        Configuration config = Configuration.getConfig();
        SharedPreferences sharedPreferences = getSharedPreferences("PYRAMID_CONFIG", MODE_PRIVATE);
        config.setSharedPreferences(sharedPreferences);

        // Mostramos el limite superior en la vista acorde a la configuracion
        TextView maximumText = (TextView) findViewById(R.id.maximum);
        maximumText.setText("" + config.getUpperLimit());
    }

    /**
     * Este metodo inicia el juego, creando un Intent del GameActivity.
     * Es llamado mediante el onClick del boton "iniciar" declarado en activity_welcome.xml
     *
     * @param view
     */
    public void initiateGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        Configuration.getConfig().persistConfig();

        startActivity(intent);
    }

   /**
     * Este metodo disminuye el numero maximo. Es llamado mediante el "onClick" de la imagen
     * "lessMaximum" del activity_welcome.xml
     *
     * @param view
     */
   public void lessMaximum(View view) {
        // Obtenemos la unica instancia de configuracion
        Configuration config = Configuration.getConfig();
        // Obtenemos tenemos de la vista, el textView que muestra esta configuracion
        TextView maximum = (TextView) findViewById(R.id.maximum);
        // Setteamos la nueva configuracion, actual - 1
        config.setUpperLimit(config.getUpperLimit() - 1);
        // Mostramos en la vista como quedo la configuracion
        maximum.setText(String.valueOf(config.getUpperLimit()));
    }

    /**
     * Este metodo aumenta el numero maximo. Es llamado mediante el "onClick" de la imagen
     * "moreMaximum" del activity_welcome.xml
     *
     * @param view
     */
    public void moreMaximum(View view) {
        // Obtenemos la unica instancia de configuracion
        Configuration config = Configuration.getConfig();
        // Obtenemos tenemos de la vista, el textView que muestra esta configuracion
        TextView maximum = (TextView) findViewById(R.id.maximum);
        // Setteamos la nueva configuracion, actual + 1
        config.setUpperLimit(config.getUpperLimit() + 1);
        // Mostramos en la vista como quedo la configuracion
        maximum.setText(String.valueOf(config.getUpperLimit()));
    }
}