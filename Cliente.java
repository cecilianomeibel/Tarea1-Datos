

import javax.swing.*;  //importar interfaz grafica 

public class Cliente {   
    public static void main (String [] args) {
        
        ventanacliente ventana1 =new ventanacliente(); // crear un objeto

        ventana1.setVisible(true); // metodo para poder mostrar la ventana
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que al cerrar la ventana no siga ejecutandose el programa


    }
}

class ventanacliente extends JFrame {  //La clase usa JFrame para poder crear ventanas, botones..
    public ventanacliente() { //Constructor

        setSize(350,350); //define tamaño de la ventana 

    }

}