

import javax.swing.*;  //importar interfaz grafica 
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*; 

public class Cliente {   
    public static void main (String [] args) {
        
        ventanacliente ventana1 =new ventanacliente(); // crear un objeto
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que al cerrar la ventana no siga ejecutandose el programa

    }
}

class ventanacliente extends JFrame {  //La clase hereda de JFrame para poder crear cuadros(ventanas)
    public ventanacliente() { //Constructor
        setBounds(500,200,600,300); //define ubicacion en x, y , ancho, alto del cuadro
        setResizable(false); //Evita que se puede redimencionar la ventana 
        setTitle("Cliente"); //Colocar un titulo en la ventana 
        Lamina lamina1 = new Lamina(); //Se crea un objeto
        
        add(lamina1); 
        setVisible(true); //metodo para poder mostrar la ventana
    }
}

class Lamina extends JPanel{
    public Lamina(){ //Constructor
        

        JLabel datos = new JLabel("Datos a ingresar del producto: "); // instancia para agregar una etiqueta de texto
        add(datos); // se añade el texto a la lamina
        JLabel valor = new JLabel(" Valor"); // instancia para agregar una etiqueta de texto
        add(valor); // se añade el texto a la lamina
        valor_producto = new JTextField(5); //Nos abre un campo para agregar texto
        add(valor_producto);
        JLabel peso = new JLabel(" Peso"); // instancia para agregar una etiqueta de texto
        add(peso); // se añade el texto a la lamina
        peso_producto = new JTextField(5); //Nos abre un campo para agregar texto
        add(peso_producto);
        JLabel impuestos = new JLabel(" (%) Impuestos"); // instancia para agregar una etiqueta de texto
        add(impuestos); // se añade el texto a la lamina
        porcentaje_impuestos = new JTextField(5); //Nos abre un campo para agregar texto
        add(porcentaje_impuestos);
        chat = new JTextArea(13,25); //anota las coordenadas donde lo va a colocar
        add(chat);

        boton1 = new JButton("Enviar"); // instancia para crear un boton 
        ObtenerTexto click = new ObtenerTexto(); //instancia que servira para obtener el texto al presionar el boton
        boton1.addActionListener(click);
        add(boton1); //se añade el boton a la lamina 
    }

    private class ObtenerTexto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           
           try {
            Socket socket1 = new Socket ("192.168.0.15" , 8888); //coloca como parametros direccion ip y puerto
            Envio datos = new Envio(); //encapsular los datos
            datos.SetValor_producto(valor_producto.getText()); //obtener con lo que agrega en el cuadro de texto
            datos.SetPeso_producto(peso_producto.getText());
            datos.SetPorcentaje_impuestos(porcentaje_impuestos.getText());

           
            //Crear flujo de datos de salida
            ObjectOutputStream paquete_datos = new ObjectOutputStream(socket1.getOutputStream());
            paquete_datos.writeObject(datos);
            socket1.close();



        } catch (UnknownHostException e1) {
            
            e1.printStackTrace();
        } catch (IOException e1) {  
    
            e1.printStackTrace();  // seguimiento de errores
            System.out.println(e1.getMessage());
        } 

        }

    }
    private JTextField valor_producto,peso_producto , porcentaje_impuestos;
    private JTextArea chat;
    private JButton boton1;
} 

    class Envio implements Serializable{ 

        private String valor_producto, peso_producto , porcentaje_impuestos;

        public String getvalor_producto() {
            return valor_producto;
        }
        public void SetValor_producto(String valor_producto) {
            this.valor_producto= valor_producto;
        }

        public String getpeso_producto() {
            return peso_producto;
        }
        public void SetPeso_producto(String peso_producto) {
            this.peso_producto = peso_producto;
        }

        public String getporcetaje_impuestos() {
            return porcentaje_impuestos;
        }
        public void SetPorcentaje_impuestos(String porcentaje_impuestos) {
            this.porcentaje_impuestos= porcentaje_impuestos;
        }

    
    }

 

