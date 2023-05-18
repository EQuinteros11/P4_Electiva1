package utec.edu.sv.parcial4_2508722019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import utec.edu.sv.parcial4_2508722019.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.parcial4_2508722019.utilidades.utilidades;

public class EditarYEliminar extends AppCompatActivity {
    EditText edtIDCLIENTE, edtIDVEHICULO, MATRICULA, KILO;
    Button btnupdate, btndelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_yeliminar);
        edtIDCLIENTE= findViewById(R.id.edt_IDcliente);
        edtIDVEHICULO = findViewById(R.id.edtIDVehiculo);
        MATRICULA = findViewById(R.id.edtMatricula);
        KILO = findViewById(R.id.edtKilometro);
        btndelete = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);
        Bundle bundle=getIntent().getExtras();
        edtIDCLIENTE.setText(bundle.getString("ID_CLIENTE"));
        edtIDVEHICULO.setText(bundle.getString("ID_VEHICULO"));
        MATRICULA.setText(bundle.getString("MATRICULA"));
        KILO.setText(bundle.getString("KILOMETRO"));

      btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper conn =new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial4",null,1);
                SQLiteDatabase db =conn.getWritableDatabase();
                db.execSQL("delete from "+utilidades.TABLA_CLIENTEVEHICULO+" where ID_Cliente = "+bundle.getString("ID_CLIENTE"));
                 Intent dl = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(dl);
            }
        });

    }
}