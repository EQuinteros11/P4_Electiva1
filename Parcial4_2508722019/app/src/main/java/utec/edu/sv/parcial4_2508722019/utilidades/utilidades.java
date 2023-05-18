package utec.edu.sv.parcial4_2508722019.utilidades;

public class utilidades {


    //Para Crear Tabla MD_CLIENTE
    public static String TABLA_CLIENTE ="MD_CLIENTE";
    public static String CAMPO_ID_CLIENTE ="ID_Cliente";
    public static String CAMPO_sNombreCliente ="sNombreCliente";
    public static String CAMPO_sApellidoCliente ="sApellidoCliente";
    public static String CAMPO_sDireccionCliente ="sDireccionCliente";
    public static String CAMPO_sCiudadCliente ="sCiudadCliente";


    ///Para Crear Tabla MD_Vehiculos
    public static String TABLA_VEHICULOS ="MD_VEHICULOS";
    public static String CAMPO_ID_Vehiculo ="ID_Vehiculo";
    public static String CAMPO_sMarca ="sMarca";
    public static String CAMPO_sModelo ="sModelo";


    //Para Crear Tabla MD_CLIENTEVEHICULO

    public static String TABLA_CLIENTEVEHICULO ="MD_CLIENTEVEHICULO";
    public static String CAMPO_ID_CLIENTEV ="ID_Cliente";
    public static String CAMPO_ID_VEHICULOV ="ID_Vehiculo";
    public static String CAMPO_sMatricula ="sMatricula";
    public static String CAMPO_iKilometros ="iKilometros";



    public static final String CREAR_TABLA_CLIENTEVEHICULO="CREATE TABLE "+TABLA_CLIENTEVEHICULO+" ("+CAMPO_ID_CLIENTEV+" integer, "+CAMPO_ID_VEHICULOV+" integer, "+CAMPO_sMatricula+" text, "+CAMPO_iKilometros+" text,foreign key (ID_Cliente) references MD_CLIENTE(ID_Cliente),foreign key (ID_Vehiculo) references MD_VEHICULOS(ID_Vehiculo))";


    public static final String CREAR_TABLA_CLIENTE="CREATE TABLE "+TABLA_CLIENTE+" ("+CAMPO_ID_CLIENTE+" integer primary key autoincrement, "+CAMPO_sNombreCliente+" text, "+CAMPO_sApellidoCliente+" text, "+CAMPO_sDireccionCliente+" text,"+CAMPO_sCiudadCliente+" text)";

    public static final String CREAR_TABLA_VEHICULO="CREATE TABLE "+TABLA_VEHICULOS+" ("+CAMPO_ID_Vehiculo+" integer primary key autoincrement, "+CAMPO_sMarca+" text, "+CAMPO_sModelo+" text)";


}
