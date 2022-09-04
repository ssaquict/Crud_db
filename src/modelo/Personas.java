/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SistemasU
 */
abstract class Personas {
    private String nombres,apellidos,direccion,telefono,fecha_nacmiento;

    public Personas(){}
    public Personas(String nombres, String apellidos, String direccion, String telefono, String fecha_nacmiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacmiento = fecha_nacmiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacmiento() {
        return fecha_nacmiento;
    }

    public void setFecha_nacmiento(String fecha_nacmiento) {
        this.fecha_nacmiento = fecha_nacmiento;
    }
    
    protected void agregar(){
    }
    protected void actualizar(){
    }
    protected void eliminar(){
    }

}
