package joel.com.aplicacion.validaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText  NombreEditText;

    EditText EmailEditText;

    Button btnAceptar;

    ListView usuariosListView;


    List<String> usuarios = new ArrayList<>();


    ArrayAdapter<String> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NombreEditText = (EditText) findViewById(R.id.editTextNombre);
        EmailEditText = (EditText) findViewById(R.id.editTextEmail);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        usuariosListView = (ListView)findViewById((R.id.listView));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,usuarios);


        usuariosListView.setAdapter(adapter);






        btnAceptar.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                String nombre = NombreEditText.getText().toString();

                String email = EmailEditText.getText().toString();





                if (!validarNombre(nombre)) {


                   NombreEditText.setError(getString(R.string.nombre_error));



                }else if (!validarEmail(email)) {

                    EmailEditText.setError(getString(R.string.email_error));





                }else {
                    String mensaje = getString(R.string.bienvenido) + nombre + " " + email;

                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
                    String datos = nombre + " " + email;

                    usuarios.add(datos);

                    adapter.notifyDataSetChanged();






                    NombreEditText.setText(null);

                    EmailEditText.setText(null);




                }



            }

        });

    }


    private boolean validarNombre(String nombre) {


        return !nombre.equals("");



    }

    private  boolean validarEmail(String email){


        return Patterns.EMAIL_ADDRESS.matcher(email).matches();





    }

}






