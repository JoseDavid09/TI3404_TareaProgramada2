
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;



public class Principal extends JFrame {

	private JPanel contentPane;
	
	private ImageIcon img;
String hechos="";
String reglas="";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);				} catch (Exception e) {
				e.printStackTrace();
			}			}
		});
	}
	public static ListaSimple Almacenamiento=new ListaSimple();
	
	public Principal() {
		//lecturaNueva.leerarchivos();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCuenta = new JLabel("Menú Principal Prolog");
		lblCrearCuenta.setBounds(125, 75, 375, 29);
		lblCrearCuenta.setFont(new Font("Monospaced", Font.BOLD+Font.ITALIC, 27));
		contentPane.add(lblCrearCuenta);
		
		
		
		//metodo que permite ingresar reglas valida que haya un punto al final de las reflas
		 // se esta trabajando en  hacer validacion de los parentesis 
		JButton btnGuardar = new JButton("Reglas");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String Regla= JOptionPane.showInputDialog("Escriba la Regla");
							String[] hech = Regla.split("[\\(\\)\\.]+");
							reglas=reglas+hech[0]+",";
							//convierte de string a un areglo de strings
							char[] ArrayRegla = Regla.toCharArray();
							//longitud del arreglo
							int longitud=ArrayRegla.length;
							//si se cumple la validacion del punto , procede a validar los parentesis 
							if(( Almacenamiento.validarPunto(ArrayRegla [longitud-1]))==true){
								int count=0;
								//if(( Almacenamiento.ValidarParentesis(Regla, count))==true){
								 if ((Almacenamiento.validarClausula(Regla))==true){
									 if ((Almacenamiento.validarVariasMayuscalas(Regla))==true){
									 Almacenamiento.InsertaFinal(Regla);}
									 else{
										 JOptionPane.showMessageDialog(null, "Sintaxis Invalida, Revisar Mayusculas ","Warning",JOptionPane.WARNING_MESSAGE);
									 }
									 
								 }else{
										JOptionPane.showMessageDialog(null, "Sintaxis Invalida, Revisar :- ","Warning",JOptionPane.WARNING_MESSAGE);
									}
								
									
							//	}
								/*else{
									JOptionPane.showMessageDialog(null, "Sintaxis Invalida, Revisar Parentesis","Warning",JOptionPane.WARNING_MESSAGE);
								}*/
								
							      }
							else{							
							
							JOptionPane.showMessageDialog(null, "La Regla es invalida, debe colocar un punto al final","Warning",JOptionPane.WARNING_MESSAGE);
							}	
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						}});}});
		btnGuardar.setBounds(150, 290, 110, 23);
		contentPane.add(btnGuardar);
		
		//boton que permite mostrar la informacion de un determinado cliente 
		JButton btnMostrarInformacion = new JButton("Consultas");
		btnMostrarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String Consulta= JOptionPane.showInputDialog("Escriba la Consulta");
							//convierte de string a un areglo de strings
							char[] ArrayRegla = Consulta.toCharArray();
							int longitud=ArrayRegla.length;
							String[] ari = Consulta.split("[\\(\\)\\.]+");
							String[] aridad = Consulta.split("[\\,\\.]+");
							String[] aridad1 = Consulta.split("[\\(\\,\\)\\.]+");
							
							String[] hechoBC = Consulta.split("[\\(\\)\\,\\.]+");
							  String b=hechoBC[0];	
							  
							  
							 if (!(hechos.equals(""))&&(!(reglas.equals("")))){
							//si se cumple la validacion del punto
							if(( Almacenamiento.validarPunto(ArrayRegla [longitud-1]))==true){
									
								if ((hechoBC[0].equals("write"))){
									if ((aridad1.length)==2){
										JOptionPane.showMessageDialog(null, Almacenamiento.Write(Consulta),"Warning",JOptionPane.WARNING_MESSAGE);
										
									}		
										else {
											if ((hechoBC[2].equals("ln"))){
												JOptionPane.showMessageDialog(null, Almacenamiento.Writeln(Consulta),"Warning",JOptionPane.WARNING_MESSAGE);
												}
											
										}}
								
								else if ((Almacenamiento.validarVariasMayuscalas(Consulta))==true){
									 String[] he = ari[1].split("[\\,]+");
									 int cont1=he.length;
									JOptionPane.showMessageDialog(null,Almacenamiento.BuscarHechosBC(ari[0],cont1),"Warning",JOptionPane.WARNING_MESSAGE);
									
									
								}
								else {
									 if ((Almacenamiento.BuscarHechosBC1(Consulta,ari[0],ari[1],hechos)==true)){
											
											JOptionPane.showMessageDialog(null, "YES","Warning",JOptionPane.WARNING_MESSAGE);
										}else {
											JOptionPane.showMessageDialog(null, "NO","Warning",JOptionPane.WARNING_MESSAGE);
										}
									
								
									}
									
									
									
									
									
									//empezar consultas con mas ariadad
								
								
								
							}/*else {
									JOptionPane.showMessageDialog(null, "La Consulta es invalida, el argumento debe ser mayuscula","Warning",JOptionPane.WARNING_MESSAGE);
									
								}*/
								
							      
							
							else{							
							
							JOptionPane.showMessageDialog(null, "La Consulta es invalida, debe colocar un punto al final","Warning",JOptionPane.WARNING_MESSAGE);
							}	
							 }else{
								 
								 JOptionPane.showMessageDialog(null, "La Consulta es invalida, primero debe registrar la informacion en la base de conocimientos para realizar consultas","Warning",JOptionPane.WARNING_MESSAGE);
									 
							 }
								
							}	
						 catch (Exception e) {
							e.printStackTrace();
						}}});}});
		
		
		
		
		
		btnMostrarInformacion.setBounds(325, 290, 110, 23);
		contentPane.add(btnMostrarInformacion);
		
		//boton q permite abrir una nueva ventana para abrir reportes
	JButton btnReportes1 = new JButton("Hechos ");
		btnReportes1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() {
					

					private Component frame;

					public void run() {
						try {
							
							String Hecho= JOptionPane.showInputDialog("Escriba el Hecho");
							char[] ArrayRegla = Hecho.toCharArray();
							String[] hech = Hecho.split("[\\(\\)\\.]+");
							hechos=hechos+hech[0]+",";
							int longitud=ArrayRegla.length;
							if(( Almacenamiento.validarPunto(ArrayRegla [longitud-1]))==true){
								if ((Almacenamiento.recibirLN(Hecho))==true){
								Almacenamiento.InsertaFinal(Hecho);
								}else{
									JOptionPane.showMessageDialog(null, "Sintaxis Invalida, Revisar Parentesis","Warning",JOptionPane.WARNING_MESSAGE);
								}
							      }
							else{							
							
							JOptionPane.showMessageDialog(null, "El Hecho es invalido, debe colocar un punto al final","Warning",JOptionPane.WARNING_MESSAGE);
							}	
							
							
					       
						} catch (Exception e) {
							e.printStackTrace();
						}}});}});
		btnReportes1.setBounds(22, 290, 110, 23);
		contentPane.add(btnReportes1);
		//boton permite salir del menu principal
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}}});}});
		btnCancelar.setBounds(450, 290, 110, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBaseConocimientos = new JButton("Base de Conocimientos");
		btnBaseConocimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//muestra la informacion de la base de conocimientos 
							JOptionPane.showMessageDialog(null, Almacenamiento.Imprimir(),"Warning",JOptionPane.WARNING_MESSAGE);
							
						} catch (Exception e) {
							e.printStackTrace();
						}}});}});
		btnBaseConocimientos.setBounds(45, 252, 210, 23);
		contentPane.add(btnBaseConocimientos);
		
	}
	
	//metodo para determinar si es un numero o un String
	private boolean esNumero(String string) {
		boolean booleanResultado = true;
		try{
			Integer.parseInt(string);
		}catch(NumberFormatException nfe){
			booleanResultado = false;
		}
		return booleanResultado;
	}

	

}






