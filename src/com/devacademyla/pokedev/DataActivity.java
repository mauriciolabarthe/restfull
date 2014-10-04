package com.devacademyla.pokedev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.devacademyla.pokedev.lista.PokemonAdapter;
import com.devacademyla.pokedev.models.Pokemon;
import com.devacademyla.pokedev.utils.PokedexUtil;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DataActivity extends Activity {
	
	TextView text, text2, text3;
	int pokemon;
	private Gson gson;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        
        text = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        
        //ACA INGRESAR EL NUMERO DE POKEMON, ESTE NUMERO SE OBTIENE DEL LISTVIEW QUE HAN HECHO
        //SORRY POR LA POBRE INTERFAZ Y EL APURO QUE SE NOTA EN EL CODIGO PERO 
        //NO LE PUDE DEDICAR MUCHO TIEMPO POR RAZONES UNIVERSITARIAS
        //UTILIZO VOLLEY Y GSON
        
        pokemon = 1;
        
        
        RequestQueue queue = Volley.newRequestQueue(this);
        String URL = "http://pokeapi.co/api/v1/pokemon/";
        
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL + pokemon,
                new Response.Listener<String>(){
        @Override
        public void onResponse(String response) {
        	gson = new Gson();
        	var nom = gson.fromJson(response, var.class);
        	String nombre = nom.getName();
        	Responses vars = gson.fromJson(response, Responses.class);
        	String evolucion = vars.getEvolutions().get(0).getTo();
            text.setText("Nombre: "+ nombre);
            text2.setText("Evolucion: "+ evolucion);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            text.setText("That didn't work!");
        }
    });
    queue.add(stringRequest);
    }
     
}
