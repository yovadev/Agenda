package agenda;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.*;        

public class Agenda extends JFrame implements ActionListener{
    //variables de swing
    private JMenuBar barra;
    private JMenu menu1;
    private JMenuItem mi1, mi2, mi3;
    private JTextField camponuevonombre, camponuevotelefono, campobuscarnombre;
    private JLabel etiquetanuevonombre, etiquetanuevotelefono, imprimenombre, imprimetelefono,
            nombreprograma, nombreautor, numeroversion, dibusca;
    private JButton boton, botonnuevo, botonbuscar;
    
    //otras variables
    
    File archivo = new File("C://prueba//archivo.txt");
    Formatter nuevoarchivo;
    Scanner x;

    public Agenda(){
        setLayout(null);
     //textos de introduccion
    nombreprograma = new JLabel("Agenda Telefonica");
        nombreprograma.setBounds(0,0,180,30);
        add(nombreprograma);
     
    nombreautor = new JLabel("Yova M.");
        nombreautor.setBounds(0,30,180,30);
        add(nombreautor);
    
    numeroversion = new JLabel("Version 1.0");
        numeroversion.setBounds(0,50, 180, 30);
        add(numeroversion);
    
        
    //menu superior
    
    barra = new JMenuBar();
        setJMenuBar(barra);
    
    menu1 = new JMenu("Archivo");
    barra.add(menu1);
    
    mi1 = new JMenuItem("Nuevo");
    mi1.addActionListener(this);
    menu1.add(mi1);
    
        mi2 = new JMenuItem("Buscar");
    mi2.addActionListener(this);
    menu1.add(mi2);
    
        mi3 = new JMenuItem("Salir");
    mi3.addActionListener(this);
    menu1.add(mi3);
    
    }

    public void actionPerformed(ActionEvent e){
    Container f = this.getContentPane();
        if (e.getSource() == mi1) {
            /** ocultar elementos previos **/
            nombreprograma.setVisible(false);
            nombreautor.setVisible(false);
            numeroversion.setVisible(false);
            
            /*formulario */
            etiquetanuevonombre = new JLabel("Nuevo nombre");
            etiquetanuevonombre.setBounds(0,0,180,30);
            add(etiquetanuevonombre);
            etiquetanuevonombre.setVisible(true);
            
                        camponuevonombre = new JTextField();
            camponuevonombre.setBounds(100,0,180,30);
            add(camponuevonombre);
            camponuevonombre.setVisible(true);
            
                        etiquetanuevotelefono = new JLabel("Nuevo telefono");
            etiquetanuevotelefono.setBounds(0,50,180,30);
            add(etiquetanuevotelefono);
            etiquetanuevotelefono.setVisible(true);
            
                        camponuevotelefono = new JTextField();
            camponuevotelefono.setBounds(100,50,180,30);
            add(camponuevotelefono);
            camponuevotelefono.setVisible(true);
            
            botonnuevo = new JButton("Crear");
            botonnuevo.setBounds(100,100, 180, 30);
            add(botonnuevo);
            botonnuevo.addActionListener(this);
            botonnuevo.setVisible(true);
            
        }
        
         if (e.getSource() == mi2) {
                      /** ocultar elementos previos **/
            nombreprograma.setVisible(false);
            nombreautor.setVisible(false);
            numeroversion.setVisible(false);
            etiquetanuevonombre.setVisible(false);
            camponuevonombre.setVisible(false);
            etiquetanuevotelefono.setVisible(false);
            camponuevotelefono.setVisible(false);
            botonnuevo.setVisible(false);
            
            /*formulario */
            imprimenombre = new JLabel("Buscar por nombre");
            imprimenombre.setBounds(0,0,180,30);
            add(imprimenombre);
            imprimenombre.setVisible(true);
            
             campobuscarnombre = new JTextField();
            campobuscarnombre.setBounds(150,0,180,30);
            add(campobuscarnombre);
            campobuscarnombre.setVisible(true);
            
            botonbuscar = new JButton("Buscar");
            botonbuscar.setBounds(150,50, 180, 30);
            add(botonbuscar);
            botonbuscar.addActionListener(this);
            botonbuscar.setVisible(true);
            
        }
         
          if (e.getSource() == mi3) {
              System.exit(0); 
        }
          
         if (e.getSource()==botonnuevo) {
             try {
                System.out.println("Conectando a la Base de Datos");
                 Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendatelefonica?useTimezone=true&serverTimezone=UTC", "root", "");
                       System.out.println("Conexion realiza con exito!");
                    Statement estado = con.createStatement();
                    estado.executeUpdate("INSERT INTO agenda VALUES ('5', '"+camponuevonombre.getText()+"', '"+camponuevotelefono.getText()+"')");
                      System.out.println("Datos insertados");
             } catch (SQLException ex) {
            System.out.println("error mysql");
        }
        catch(ClassNotFoundException err){
            err.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("Se ha encontrado un error es: "+ex.getMessage());
        }

            }
         
            if (e.getSource()==botonbuscar) {
             try {
                System.out.println("Conectando a la Base de Datos");
                 Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendatelefonica?useTimezone=true&serverTimezone=UTC", "root", "");
                       System.out.println("Conexion realiza con exito!");
                    Statement estado = con.createStatement();
              ResultSet resultado = estado.executeQuery("Select * from agenda where nombre='"+campobuscarnombre.getText()+"'");
                      System.out.println("Datos obtenidos");
                      //exportando resultado
                      while (resultado.next()) {                     
                          if (archivo.exists()) {
                               if (archivo.canWrite()) {
                                  nuevoarchivo = new Formatter("C://prueba//archivo.txt");
                                  nuevoarchivo.format("%s %s %s",resultado.getString("nombre"),resultado.getString("telefono"),"telefono");
                                  nuevoarchivo.close();
                                    } else {
                                        System.out.println("archivo existe y no se puede escribir");
                                   }
                          }else{
                          
                          }
                 }
             } catch (SQLException ex) {
            System.out.println("error mysql");
        }
        catch(ClassNotFoundException err){
            err.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("Se ha encontrado un error es: "+ex.getMessage());
        }
            }
    }
    
    
    public static void main(String[] args) {
        Agenda ventana = new Agenda();
        ventana.setBounds(10, 20, 440, 250);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }

}
