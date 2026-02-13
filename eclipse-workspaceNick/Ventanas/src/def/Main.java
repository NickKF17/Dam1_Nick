package def;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
public static void main(String[] args) {
	

	JFrame ventana =new JFrame("Ventana de Bienvenida");
	ventana.setSize(350,200);
	
	ventana.setLayout(new FlowLayout());
	JButton boton=new JButton("Acpetar");
	
	JLabel mensaje=new JLabel("Hola mundo");
	JTextField edicion=new javax.swing.JTextField(50);
	
	
	ventana.add(boton);
	ventana.add(mensaje);
	ventana.add(edicion);
	ventana.setLocationRelativeTo(null);
	ventana.setVisible(true);
	
}
}
