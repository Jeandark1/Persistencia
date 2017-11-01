package remmcal_apps.persistenciadedatos;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private TextView textoResultado;
    private EditText texto;

    private int resultado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado=(TextView) findViewById(R.id.resultado);
        texto = (EditText) findViewById(R.id.etInterna);

    }


    public void sumar(View v){

        resultado++;
        textoResultado.setText(""+resultado);
    }


    public void restar(View v){

        resultado--;
        textoResultado.setText(""+resultado);
    }




    public void onPause()
    {
        super.onPause();
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor miEditor= datos.edit();

        miEditor.putInt("dato1",resultado);

        miEditor.apply();
    }


    public  void onResume(){
        super.onResume();
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(this);

        resultado = datos.getInt("dato1", 0);

        textoResultado.setText(""+resultado);
    }


    public void guardar(View v)
    {
        if(!texto.getText().toString().equals(""))
        {

        try
        {

        OutputStreamWriter op= new OutputStreamWriter( openFileOutput("nombre del archivo", Context.MODE_APPEND));
        op.write(texto.getText().toString());
            op.close();

            Toast.makeText(this, "Guardado en: "+getFilesDir(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }

        }

        else
        {
            Toast.makeText(this, "Debe ingresar datos al edit text", Toast.LENGTH_SHORT).show();
        }
    }




    public  void leer(View v)
    {
        try{
            BufferedReader lector= new BufferedReader( new InputStreamReader( openFileInput("nombre del archivo")));
            String res=lector.readLine();
            lector.close();

            texto.setText(""+res);

        } catch (Exception e){
                System.out.println("Error: "+e.getMessage());
            }
    }






}
