package utec.edu.sv.parcial4_2508722019.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import utec.edu.sv.parcial4_2508722019.utilidades.utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(utilidades.CREAR_TABLA_CLIENTE);
            db.execSQL(utilidades.CREAR_TABLA_VEHICULO);
            db.execSQL(utilidades.CREAR_TABLA_CLIENTEVEHICULO);
          //  db.execSQL("insert into MD_CLIENTEVEHICULO values ('Elias','Quinteros','SS','SS')");
            //db.execSQL("insert into MD_VEHICULOS values ('Hyundai','Elantra')");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
