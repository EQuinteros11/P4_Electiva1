package utec.edu.sv.parcial4_2508722019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utec.edu.sv.parcial4_2508722019.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.parcial4_2508722019.utilidades.utilidades;

public class Agregar extends AppCompatActivity {

    EditText edtIDCLIENTE, edtIDVEHICULO, MATRICULA, KILO;
    Button btnagregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        edtIDCLIENTE= findViewById(R.id.edt_IDcliente);
        edtIDVEHICULO = findViewById(R.id.edtIDVehiculo);
        MATRICULA = findViewById(R.id.edtMatricula);
        KILO = findViewById(R.id.edtKilometro);
        btnagregar = findViewById(R.id.btnAgregar);
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial4",null,1);
                    SQLiteDatabase db =admin.getWritableDatabase();
                    String  ID_Cliente = edtIDCLIENTE.getText().toString() ,
                            ID_Vehiculo =edtIDVEHICULO.getText().toString(),
                            sMatricula = MATRICULA.getText().toString(),
                            iKilometros = KILO.getText().toString();

                    ContentValues detalle = new ContentValues();
                    detalle.put("ID_Cliente",ID_Cliente);
                    detalle.put("ID_Vehiculo",ID_Vehiculo);
                    detalle.put("sMatricula",sMatricula);
                    detalle.put("iKilometros",iKilometros);

                    db.insert(utilidades.TABLA_CLIENTEVEHICULO,null,detalle);
                    Toast.makeText(Agregar.this, "Se agrego registro", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Agregar.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}