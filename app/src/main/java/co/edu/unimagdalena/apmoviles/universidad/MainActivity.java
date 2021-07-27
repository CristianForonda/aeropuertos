package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Aeropuerto aeropuerto;
    AeropuertoController aeropuertoController;
    EditText ciudad, nombre, pais, txtid, direccion, latitud, longitud;//4 nuevos
    Button agregar, mostrar, mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.btnguardar);
        mostrar = findViewById(R.id.btnlistado);
        mapa = findViewById(R.id.btnvermapa);

        txtid = findViewById(R.id.edtcodigo);//nuevo
        ciudad = findViewById(R.id.edtciudad);
        nombre = findViewById(R.id.edtnombre);
        pais = findViewById(R.id.edtpais);
        direccion = findViewById(R.id.edtdireccion);//nuevo
        latitud = findViewById(R.id.edtlatitud);//nuevo
        longitud = findViewById(R.id.edtlongitud);//nuevo

        agregar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
        mapa.setOnClickListener(this);

        aeropuertoController = new AeropuertoController(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnguardar: //agregaraeropueto(e);
               if(TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                  TextUtils.isEmpty(pais.getText().toString()) ||
                  TextUtils.isEmpty(direccion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString()) ){
                    //Si ninguno de los campos estaban vacios
                    Toast.makeText(this,"No pueden haber casillas vacias", Toast.LENGTH_LONG).show();

               }else{
                    aeropuerto = new Aeropuerto(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), pais.getText().toString(), ciudad.getText().toString(),

                            direccion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());//3 nuevos + el id
                    //Crea un nuevo aeropuerto e, pero sin ingresarlo aun a la base de datos
                    if (aeropuertoController.buscarAeropuerto(aeropuerto)){//si no encontro el aeropuerto, es decir sino estaba repetido, como busca por id
                        Toast.makeText(this,"Código ya existe", Toast.LENGTH_LONG).show();
                    }
                    else{            //si quedo listo para crear
                        aeropuertoController.agregarAeropuerto(aeropuerto);//Se agrega el nuevo hotel
                        //y luego se reinician los editText para que se muestren limpios de nuevo
                        txtid.setText("");//nuevo
                        nombre.setText("");
                        pais.setText("");
                        ciudad.setText("");
                        direccion.setText("");//nuevo
                        latitud.setText("");//nuevo
                        longitud.setText("");//nuevo
                    }
               }
                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, ListadoActivity.class);
                startActivity(i);
                break;
            case R.id.btnvermapa:
                Intent j = new Intent(this, MapsActivity.class);
                startActivity(j);
                break;
        }
    }


}
