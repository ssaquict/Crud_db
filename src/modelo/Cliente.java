/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SistemasU
 */
public class Cliente extends Personas{
    private int id;
    private String nit;
  
   
    Conexion cn;
    public Cliente(){}
    public Cliente(int id,String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacmiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacmiento);
        this.nit = nit;
        this.id = id;
    }

    //public Cliente(){
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query;
            query = "SELECT id_cliente AS id,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento FROM clientes; ";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezado[] = {"ID","Nit","Nombres","Apellidos","Direccion","Telefono","Fecha Nac"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos[] = new String[7];
            
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nit");
                datos[2] = consulta.getString("nombres");
                datos[3] = consulta.getString("apellidos");
                datos[4] = consulta.getString("direccion");
                datos[5] = consulta.getString("telefono");
                datos[6] = consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            
            cn.cerrar_conexion(); 
            
            
        }catch(SQLException ex){
             cn.cerrar_conexion();
            System.out.println("Error: " + ex.getMessage());
        }
        
        return tabla;
    
    }
    
    @Override
    public void agregar(){
        /*System.out.println("Nit:" + getNit());
        System.out.println("Nombres:" + getNombres());
        System.out.println("Apellidos:" + getApellidos());
        System.out.println("Direccion:" + getDireccion());
        System.out.println("Telefono:" + getTelefonos());
        System.out.println("Fecha_Nacimiento:" + this.getFecha_nacmiento());
        System.out.println("_________________________________________");*/
        
        try{
            PreparedStatement parametro;
            String query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento)VALUES(?,?,?,?,?,?);";
            
            cn = new Conexion();
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFecha_nacmiento());
            
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            System.out.println("Error......"+ ex.getMessage());
            
        }  
    }    

    @Override
    public void actualizar(){
        try{
            PreparedStatement parametro;
            String query = "UPDATE clientes SET nit= ?,nombres= ?,apellidos= ?,direccion= ?,telefono= ?,fecha_nacimiento= ? WHERE id_cliente = ?;";
            
            cn = new Conexion();
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFecha_nacmiento());
            parametro.setInt(7, getId());
            
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Actualizado","Agregar",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            System.out.println("Error......"+ ex.getMessage());
            
        }
    }
    
    @Override 
    public void eliminar(){
    try{
            PreparedStatement parametro;
            String query = "DELETE FROM clientes WHERE id_cliente = ?;";
            
            cn = new Conexion();
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
              
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro eliminado","Agregar",JOptionPane.INFORMATION_MESSAGE);
                        
        }catch(SQLException ex){
            System.out.println("Error......"+ ex.getMessage());
            
        }
    }
    
}
