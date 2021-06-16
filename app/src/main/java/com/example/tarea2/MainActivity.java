package com.example.tarea2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import controlador.RevistaAdapter;
import modelo.Revista;

public class MainActivity extends AppCompatActivity {

    EditText txt;

    List<Revista> listaRevistas;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txtIDRevista);

        requestQueue = Volley.newRequestQueue(this);
    }

    private void setAdapter() {
        RevistaAdapter adapter = new RevistaAdapter(listaRevistas, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerRevista);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void eventoButtonVolley(View v) {
        buscarVolley(txt.getText().toString(), "https://revistas.uteq.edu.ec/ws/issues.php");
    }

    private void buscarVolley(String id, String url) {
        url += "?j_id=" + id;
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listaRevistas = new ArrayList<Revista>();

                        int tamanio = response.length();
                        if (tamanio > 0) {
                            for (int i = 0; i < tamanio; i++) {
                                try {
                                    JSONObject json = new JSONObject(response.get(i).toString());
                                    Revista revista = new Revista(json.getInt("issue_id"),
                                            json.getInt("volume"), json.getInt("number"),
                                            json.getInt("year"), json.getString("date_published"),
                                            json.getString("title"), json.getString("doi"),
                                            json.getString("cover"));
                                    listaRevistas.add(revista);
                                } catch (JSONException ex) {
                                    Revista revista = new Revista(0, 0, 0, 0,
                                            "No hay resultados", "No hay resultados",
                                            "No hay resultados", "https://cdn3.josefacchin.com/wp-content/uploads/2018/09/http-not-found-error-404.png");
                                    listaRevistas.add(revista);
                                    System.out.println(ex.toString());
                                }
                            }
                        } else {
                            Revista revista = new Revista(0, 0, 0, 0,
                                    "No hay resultados", "No hay resultados",
                                    "No hay resultados", "https://cdn3.josefacchin.com/wp-content/uploads/2018/09/http-not-found-error-404.png");
                            listaRevistas.add(revista);
                        }
                        setAdapter();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError ex) {
                Revista revista = new Revista(0, 0, 0, 0,
                        "No hay resultados", "No hay resultados",
                        "No hay resultados", "https://cdn3.josefacchin.com/wp-content/uploads/2018/09/http-not-found-error-404.png");
                listaRevistas.add(revista);
                System.out.println(ex.toString());
            }
        });
        requestQueue.add(jsonRequest);

        /* .baseUrl("https://revistas.uteq.edu.ec/ws/")*/
    }
}