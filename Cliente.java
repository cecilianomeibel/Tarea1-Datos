

import javax.swing.*;  //importar interfaz grafica 
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*; 

public class Cliente {   
    public static void main (String [] args) {
        
        ventanacliente ventana1 =new ventanacliente(); // crear un objeto
        
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que al cerrar la ventana no siga ejecutandose el programa

    }
}

class ventanacliente extends JFrame {  //La clase hereda de JFrame para poder crear cuadros(ventanas)
    public ventanacliente() { //Constructor
        setBounds(500,200,300,300); //define ubicacion en x, y , ancho, alto del cuadro
        setResizable(false); //Evita que se puede redimencionar la ventana 
        setTitle("Cliente"); //Colocar un titulo en la ventana 
        Lamina lamina1 = new Lamina(); //Se crea un objeto
        add(lamina1); 
        setVisible(true); //metodo para poder mostrar la ventana
    }
}

class Lamina extends JPanel{
    public Lamina(){ //Constructor
        JLabel texto= new JLabel("CLIENTE 1"); // instancia para agregar una etiqueta de text
        
        add(texto); // se añade el texto a la lamina
        cuadrodetexto = new JTextField(" ", 8); //Nos abre un campo para agregar texto
        add(cuadrodetexto);
        
        boton1 = new JButton("Enviar"); // instancia para crear un boton 

        ObtenerTexto click = new ObtenerTexto(); //instancia que servira para obtener el texto al presionar el boton
        boton1.addActionListener(click);
        add(boton1); //se añade el boton a la lamina 
    }

    private class ObtenerTexto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           // System.out.println(cuadrodetexto.getText());
           try {
            Socket socket1 = new Socket ("192.168.0.15" , 8888); //coloca como parametros direccion ip y puerto
        } catch (UnknownHostException e1) {
            
            e1.printStackTrace();
        } catch (IOException e1) {  
    
            e1.printStackTrace();  // seguimiento de errores
            System.out.println(e1.getMessage());
        } 

        }

    }
    private JTextField cuadrodetexto;
    private JButton boton1;
} 

    

 

