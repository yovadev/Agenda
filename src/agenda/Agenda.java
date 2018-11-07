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
    private JTextField camponuevonombre, camponuevotelefono, campocrearnombre;
    private JLabel etiquetanuevonombre, etiquetanuevotelefono, imprimenombre, imprimetelefono,
            nombreprograma, nombreautor, numeroversion, dibusca;
    private JButton boton, botonnuevo, botonbusca;
    
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
            
        }
        
         if (e.getSource() == mi2) {
            
        }
         
          if (e.getSource() == mi3) {
              System.exit(0);
            
        }
    
    }
    
    public static void main(String[] args) {
        Agenda ventana = new Agenda();
        ventana.setBounds(10, 20, 640, 250);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }

}
