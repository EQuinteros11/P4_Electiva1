package utec.edu.sv.parcial4_2508722019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import utec.edu.sv.parcial4_2508722019.clases.clientevehiculos;
import utec.edu.sv.parcial4_2508722019.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.parcial4_2508722019.utilidades.utilidades;

public class MainActivity extends AppCompatActivity {

    ListView ver;
    ArrayList<String> listaInformacion;
    ArrayList<clientevehiculos> listacatalogo;
    AdminSQLiteOpenHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ver = findViewById(R.id.lstVer);
        conn =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial4",null,1);
        ConsultarListaPersonas();

        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listaInformacion);
        ver.setAdapter(adaptador);
        ver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String id = listacatalogo.get(pos).getID_Cliente(),
                        idv =  listacatalogo.get(pos).getID_Vehiculo(),
                          ma = listacatalogo.get(pos).getsMatricula(),
                            ki = listacatalogo.get(pos).getiKilometros();
                SQLiteDatabase db =conn.getWritableDatabase();
                Intent p = new Intent(getApplicationContext(),EditarYEliminar.class);
                p.putExtra("ID_CLIENTE", id);
                p.putExtra("ID_VEHICULO", idv);
                p.putExtra("MATRICULA", ma );
                p.putExtra("KILOMETRO", ki);
                startActivity(p);
            }
        });


    }


    private void ConsultarListaPersonas(){
        SQLiteDatabase db =conn.getWritableDatabase();
        clientevehiculos cv = null;
        listacatalogo = new ArrayList<clientevehiculos>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_CLIENTEVEHICULO,null);
        while (cursor.moveToNext()){
            cv = new clientevehiculos();
            cv.setID_Cliente(cursor.getString(0));
            cv.setID_Vehiculo(cursor.getString(1));
            cv.setsMatricula(cursor.getString(2));
            cv.setiKilometros(cursor.getString(3));
            listacatalogo.add(cv);
        }
        obtenerLista();
    }
    private void obtenerLista() {
        listaInformacion= new ArrayList<String>();
        for(int i=0;i<listacatalogo.size();i++){
            listaInformacion.add("ID cliente: "+listacatalogo.get(i).getID_Cliente()+"\nID Vehiculo "+listacatalogo.get(i).getID_Vehiculo()+"\n        Matricula: "
                    +listacatalogo.get(i).getsMatricula()+"\n        Kilometros: "+listacatalogo.get(i).getiKilometros());
        }
    }


    public boolean onCreateOptionsMenu( Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.opcionescrud, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem items) {
        switch (items.getItemId()){
            case R.id.Add:
                Intent o = new Intent(getApplicationContext(),Agregar.class);
                startActivity(o);
                break;

        }
        return super.onOptionsItemSelected(items);
    }
}