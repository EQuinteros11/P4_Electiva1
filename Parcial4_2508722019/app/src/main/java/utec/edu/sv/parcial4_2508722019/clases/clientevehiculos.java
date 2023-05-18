package utec.edu.sv.parcial4_2508722019.clases;

public class clientevehiculos {
    private String ID_Cliente;
    private String ID_Vehiculo;
    private String sMatricula;
    private String iKilometros;
    public clientevehiculos(){

    }

    public clientevehiculos(String ID_Cliente, String ID_Vehiculo, String sMatricula, String iKilometros) {
        this.ID_Cliente = ID_Cliente;
        this.ID_Vehiculo = ID_Vehiculo;
        this.sMatricula = sMatricula;
        this.iKilometros = iKilometros;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getID_Vehiculo() {
        return ID_Vehiculo;
    }

    public void setID_Vehiculo(String ID_Vehiculo) {
        this.ID_Vehiculo = ID_Vehiculo;
    }

    public String getsMatricula() {
        return sMatricula;
    }

    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }

    public String getiKilometros() {
        return iKilometros;
    }

    public void setiKilometros(String iKilometros) {
        this.iKilometros = iKilometros;
    }



}
