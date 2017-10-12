package remmcal_apps.persistenciadedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoResultado;
    private int resultado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado=(TextView) findViewById(R.id.resultado);

    }


    public void sumar(View v){

        resultado++;
        textoResultado.setText(""+resultado);
    }


    public void restar(View v){

        resultado--;
        textoResultado.setText(""+resultado);
    }
}
