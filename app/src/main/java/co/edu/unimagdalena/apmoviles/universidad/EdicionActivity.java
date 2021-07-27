package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EdicionActivity extends AppCompatActivity {

    EditText txtid, nombre, pais, ciudad, direccion, latitud, longitud;//3 nuevos
    TextView mensajeError;
    Button actualizar, eliminar, regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        Intent i = getIntent();
        //se traen los datos del aeropuerto seleccionado, es en el listado donde se trae de la base de datos
        String id = i.getStringExtra("id");
        String nom = i.getStringExtra("nombre");
        String dep = i.getStringExtra("pais");
        final String ciud = i.getStringExtra("ciudad");
        String direc = i.getStringExtra("direccion");//nuevo
        String lati = i.getStringExtra("latitud");//nuevo
        String longi = i.getStringExtra("longitud");//nuevo

        //se asignan variables a los editText para trabajar con ellos
        txtid = findViewById(R.id.edtid);
        nombre = findViewById(R.id.edtnombre);
        pais = findViewById(R.id.edtpais);
        ciudad = findViewById(R.id.edtciudad);
        direccion = findViewById(R.id.edtdireccion2);//nuevo
        latitud = findViewById(R.id.edtlatitud2);//nuevo
        longitud = findViewById(R.id.edtlongitud2);//nuevo

        actualizar = findViewById(R.id.btnactualizar);
        eliminar = findViewById(R.id.btneliminar);
        regresar = findViewById(R.id.btnregresar);

        //Se le asignan a los editText los datos extraidos del intent que a su vez es de la base de datos
        txtid.setText(id);
        //la sgt linea es para que no se pueda editar el codigo, sino entonces quitar esa linea pero al poner editar codigo entonces habria que comprobar si esta repetido
        txtid.setEnabled(false);
        nombre.setText(nom);
        pais.setText((CharSequence) pais);
        ciudad.setText(ciud);
        direccion.setText(direc);//nuevo
        latitud.setText(lati);//nuevo
        longitud.setText(longi);//nuevo

        //Añado varibale para mostrar error cuando los datos esten vacios
        mensajeError = findViewById(R.id.textViewMensajeError);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AeropuertoController ec = new AeropuertoController(getApplication());
                ec.eliminarAeropuerto(Integer.parseInt(txtid.getText().toString()));
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
                finish();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensajeError.setText("");//por si acaso pero no dberia darse el caso
                if(TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(pais.getText().toString()) ||
                        TextUtils.isEmpty(direccion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString()) ){
                    //Si ninguno de los campos estaban vacios
                    //Toast.makeText(this,"No pueden haber casillas vacias", Toast.LENGTH_LONG).show();
                    mensajeError.setText("No pueden haber casillas vacias");
                    //Metodo de ocultar teclado cuando hay una view
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    //Fin ocultar teclado cuando hay una view
                }else {
                    Aeropuerto aeropuerto = new Aeropuerto(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), pais.getText().toString(),
                            ciudad.getText().toString(),
                            direccion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());
                    //la sgt linea solo va si en el creador de hotel no lleva el parametro ID
                    //e.setId(Integer.parseInt(txtid.getText().toString()));
                    AeropuertoController aeropuertoControllerController = new AeropuertoController(getApplication());
                    aeropuertoControllerController.actualizarAeropuerto(aeropuerto);
                    Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}