

import javax.swing.*;  //importar interfaz grafica 
import java.awt.*;

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
        JTextField cuadrodetexto = new JTextField("Escriba aquí"); //Nos abre un campo para agregar texto
        add(cuadrodetexto);
    }
        
}

