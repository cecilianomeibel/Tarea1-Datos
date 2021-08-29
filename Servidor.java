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

                String valor_producto , peso_producto , porcentaje_impuesto;
                Envio paquete_recibido;

                while(true){ //la conexion se abre y cierra constantemente
            
                Socket socket1 = servidor.accept(); // abra el puerto y acepte las conexiones del exterior
                
                //Flujo de datos de entrada
                ObjectInputStream paquete_datos = new ObjectInputStream(socket1.getInputStream());
                paquete_recibido= (Envio) paquete_datos.readObject(); //lea el flujo de datos y lo que ahi se encuentre lo almacene en paquete recibido
                
                valor_producto= paquete_recibido.getvalor_producto();
                peso_producto= paquete_recibido.getpeso_producto();
                porcentaje_impuesto= paquete_recibido.getporcetaje_impuestos();

                areatexto.append("\n" + "Valor producto: " + valor_producto + "\n" + "Peso producto: " + peso_producto+ "\n" +"Porcentaje impuesto: " + porcentaje_impuesto);
                
                
                Socket Cliente2 = new Socket("192.168.0.14",9090); //Para conectar con cliente 2
                ObjectOutputStream paqueteReenvio = new ObjectOutputStream(Cliente2.getOutputStream());
                paqueteReenvio.writeObject(paquete_recibido); 
                
                Cliente2.close();

                socket1.close();

            }
                

                }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();

                }
                    
            

        }
        private	JTextArea areatexto;  

}
    


    
    


