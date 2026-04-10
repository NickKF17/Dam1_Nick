package Ventanas;
import java.awt.FlowLayout;

import javax.swing.*;
public class swing01 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ventana de bienvenida");
		ventana.setSize(800,600);
		ventana.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel("Hola Mundo");
		JButton boton = new JButton("Aceptar");
		JTextField edicion = new JTextField(50);
		
		ventana.add(mensaje);
		ventana.add(edicion);
		ventana.add(boton);
		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		

	}

}
