import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.*;


public class Servidor {
    public static void main(String[] args) {
        ventanaServidor ventana2 = new ventanaServidor();
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que al cerrar la ventana no siga ejecutandose el programa
    }

}


class ventanaServidor extends JFrame implements Runnable{ //hereda de JFrame para crear la ventana
    public ventanaServidor () {  //Constructor
        setBounds(500,200,300,300); //define ubicacion en x, y , ancho, alto del cuadro
        JPanel lamina2 = new JPanel ();
        lamina2.setLayout(new BorderLayout());
        setTitle("Servidor");

        areatexto = new JTextArea();

        lamina2.add(areatexto,BorderLayout.CENTER); // se añade en la lamina el area de texto centrada
        add(lamina2);
        setVisible(true); //mostrar en pantalla

        //Crear el hilo
        Thread hilo1 = new Thread(this);
        hilo1.start();
        
        }
    
        

        @Override
        public void run() { //Se crea este hilo para que el servidor este a la escucha

            try{
                ServerSocket servidor = new ServerSocket(8888) ; //agrega el puerto que se definio en cliente

                while(true){ //la conexion se abre y cierra constantemente
            
                Socket socket1 = servidor.accept(); // abra el puerto y acepte las conexiones del exterior
                DataInputStream flujo_entrada = new DataInputStream(socket1.getInputStream()); //flujo de datos que va a usar como medio de transporte
                String mensaje_texto= flujo_entrada.readUTF(); // almacena lo que envie el cliente en una variable tipo string
                areatexto.append("\n" + mensaje_texto);
                socket1.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            


            
            
            
         

        }
    
        private	JTextArea areatexto;  

}
    


    
    


