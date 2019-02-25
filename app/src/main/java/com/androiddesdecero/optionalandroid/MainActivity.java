package com.androiddesdecero.optionalandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    /*
    La principal función de los optional es que desaparezcan de nuestro código las excepciones de NullPointerException.
    Es decir con JAVA 8 queremos reducir los null pointer exception de nuestra app de manera considerable.
    Optional es un emboltorio del tipo de dato
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //probarOptional(null);
        //orElseOptional("Alberto");
        //orElseThrow();
        isPresent(null);
    }

    public void probarOptional(String nombre){
        //Error Null Pointer Exception
        Log.d("TAG1", nombre);
        //Creamos Objeto Optional Vacio
        Optional<String> optional = Optional.empty();
        //Optional es un emboltorio del tipo de dato -> esto significa que si queremos el tipo de dato, tendremos que llamar al método get
        optional.get();
    }

    public void orElseOptional(String nombre){
        //Inicializamos el Optional con la variable nombre de tipo String.
        //Optional<String> optional = Optional.of(nombre);
        //String nombre1 = optional.get();
        //Tddavía nos devuelve null, puesto que no hemos puesto la sentencia orElse
        //Log.d("TAG1", nombre1);
        //Con orElse -> Si el valor es nulo, damos un valor por defecto, y sino toma el valor que le pasamos como parametros.
        //Si acepta nulos se hace de esta manera
        Optional<String> optional1 = Optional.ofNullable(nombre);
        String nombre1 = optional1.orElse("Defecto");
        Log.d("TAG1", nombre1);
    }

    public void orElseThrow(String nombre){
        //Igual que la anterior pero con la opción de enviar Excepción
        Optional<String> optional = Optional.ofNullable(nombre);
        //optional.orElseThrow(NullPointerException::new);
    }

    public void isPresent(String nombre){
        Optional<String> optional = Optional.ofNullable(nombre);
        Log.d("TAG1", optional.isPresent() + "");

    }

}
