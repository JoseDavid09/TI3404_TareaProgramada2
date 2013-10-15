

// Clase NodosLista
class NodosLista {
 // datos amigables para que la Clase Lista Tenga un acceso directo

	String Linea;
     int contador=1;
     NodosLista siguiente;

//Construtor  Crea un nodo del tipo Object
 NodosLista (String superm)
  {  
  Linea =superm;
  
     siguiente = null;  //siguiente con valor de nulo
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosLista (int CS,String superm,NodosLista signodo)
{ 
	
Linea =superm;

    siguiente = signodo; //siguiente se refiere al siguiente nodo
}



//Retorna el siguiente nodo
NodosLista getnext() {return siguiente; }

}//Final de la Clase NodosLista


//Definición de la Clase Lista
 public class ListaSimple
{
  public NodosLista PrimerNodo;
  public NodosLista UltimoNodo;
  String Nombre;

//Constructor construye una lista vacia con un nombre s

//Retorna True si Lista Vacía
 public boolean VaciaLista () {return PrimerNodo == null;}


 
 
 public ListaSimple (String s)
{ Nombre = s;
  PrimerNodo = UltimoNodo =null;
}

//Constructor construye una lista vacia con un nombre de List
public ListaSimple(){ this ("Lista");}

//Inserta al Final de la Lista
//Si la lista se encuentra vacía, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(String superm)
{ if ( VaciaLista())

     PrimerNodo = UltimoNodo = new NodosLista (superm);
  else
     UltimoNodo=UltimoNodo.siguiente =new NodosLista(superm);
}

public boolean CompararHechos(String hecho)
{
	
	  NodosLista aux= PrimerNodo;
	  String respuesta="";
	  String[] consulta= hecho.split("[\\(\\)]+");
	 
	 
	  if(aux==null){
		  return  false;
	  } 

	  while((aux!=null)){
		  String[] hechoBC = aux.Linea.split("[\\(\\)]+");
		  String b=hechoBC[0];
		  String b1=hechoBC[1];	
		
		  if ((b.equals(consulta[0]))){
			  if ((b1.equals(consulta[1]))){
				  System.out.println ("si hay");
			  return true; 
		  }}
		  
		  aux=aux.siguiente;
		
	  }
	  System.out.println ("no hay");
	  	  return false;
	 
	
}
public boolean BuscarBc2(String funtor,String datos)
{
	  NodosLista aux= PrimerNodo;
	  String respuesta="";
	  String[] consulta= datos.split("[\\,]+");
	  int largo=consulta.length;
	  int cont=0;	 
	  int res=0;
	  
	  if(aux==null){
		  return  false;
	  } 
	  while((aux!=null)){
		  String[] hechoBC = aux.Linea.split("[\\(\\)]+");
		  String b=hechoBC[0];
		  int cantidad=	hechoBC[1].length();	
		  if ((b.equals(funtor))){
			  while (largo!=cont){//revisar xq puede ser cantidda
				  String[] hecho = hechoBC[1].split("[\\,]+");
			  if ((hecho[cont].equals(consulta[cont]))){
				  cont=cont+1;
				  res=res+1;
				  }
				  else {
					 cont=largo; 				  
				  }}}
		  if (res==largo){
			  return true;
			  //aux==null;
		  }
		  else {
			  aux=aux.siguiente;
			  cont=0; 
			  res=0;} }
	  System.out.println ("no hay");
	  	  return false;	
}
public boolean BuscarBc(String funtor,String datos)
{
	  NodosLista aux= PrimerNodo;
	  String respuesta="";
	  String[] consulta= datos.split("[\\,]+");
	  int largo=consulta.length;
	  int cont=0;	 
	  int res=0;
	  
	  if(aux==null){
		  return  false;
	  } 
	  while((aux!=null)){
		  String[] hechoBC = aux.Linea.split("[\\(\\)]+");
		  String b=hechoBC[0];
		  int cantidad=	hechoBC[1].length();	
		  if ((b.equals(funtor))){
			  while (largo!=cont){//revisar xq puede ser cantidda
				  String[] hecho = hechoBC[1].split("[\\,]+");
			  if ((hecho[cont].equals(consulta[cont]))){
				  cont=+1;
				  res=+1;
				  }
				  else {
					 cont=largo; 				  
				  }}}
		  if (res==largo){
			  return true;
		  }
		  else {
			  aux=aux.siguiente;
			  cont=0; } }
	  System.out.println ("no hay");
	  	  return false;	
}

public boolean BuscarHechosBC1(String consulta,String funtor, String hecho,String lishec)
{
	  boolean resul=false;
	  NodosLista aux= PrimerNodo;
	 
	  String[] consult= consulta.split("[\\(\\)\\.]+");
	  String[] consult1= consult[1].split("[\\,]+");
	  int longitud=consult1.length;
	  String[] larhe= lishec.split("[\\,]+");
	  int can=larhe.length;
	  int cont=0;
	  int cont1=0;
	  int cont2=0;
	  int cont3=0;
	  
	  if(aux==null){
		  return  false;  
		  } 
	  
	 while (can-1!=cont3){
		 if (larhe[0].equals(funtor)){
			 if ((BuscarBc2(funtor,hecho))==true){
				 return true;
			}
			else{
				return false;
			}
			 
		 }cont3=cont3+1;
	 }
	  
	  
	  
	
	  

	  while((aux!=null)){
		  String datos=""; 
		  String[] hechoBC = aux.Linea.split("[\\:-]+");
		  String[] compara =hechoBC[0].split("[\\(\\)]+");
		  String[] comp =compara[1].split("[\\,]+");
		  
		  
		  
		 int longit=comp.length;		
		 
		  if ((compara[0].equals(consult[0]))&&(longit ==longitud)){
			  
			  String[] hechoBC1 = hechoBC[1].split("[\\),\\.]+");
			  int largo =hechoBC1.length;
				
			  while (largo!=cont1){
			  
				  String[] argumentos = hechoBC1[cont1].split("[\\(\\)]+");
				  if (argumentos[cont].equals("fail")){
					  System.out.println ("funciono");
					  return false;
				  }
				 while (longit!=cont){
				 
					 
					 
					 String[] argum= argumentos[1].split("[\\,]+");
					 int larg=argum.length;
					 while (larg!=cont2){
						 if (comp[cont].equals(argum[cont2])){
							 datos=datos+consult1[cont]+",";
							 cont2=cont2+1;
						 }else {
							 //cont2=+1;
							 cont2=cont2+1;
						 } 
					 }cont=+1;
					 cont2=0;						
					}
				
				 if ((BuscarBc(argumentos[0],datos))==true){
						resul=true;}
						else{
							resul=false;
						}
				 datos="";
				 cont=0;
				 cont1=cont1+1;
				 
				 } }
		  aux=aux.siguiente;
	 } 
	  System.out.println ("funciono"+resul);
		 
	  	  return resul;
	 
	
}
//metodo booleano que busca un elemento retorna true si lo encuentra y le suma uno a contador 
public String BuscarHechosBC(String hecho,int largo1)
{
	NodosLista aux= PrimerNodo;
	  String datos="";
	
	 int cont1=0;
	 
	 
	  if(aux==null){
		  return  ("No hay ninguna Coinsidencia");
	  } 

	  while((aux!=null)){
		  String[] hechoBC = aux.Linea.split("[\\(\\)]+");
		  String b=hechoBC[0];
		  String[] hec = hechoBC[1].split("[\\,]+");
		  
		  
		  int largo=hec.length;
		
		  if ((b.equals(hecho))&&(largo==largo1)){
			  while (largo!=cont1){
			 
			  
			  datos=datos+" "+hec[cont1]+"\n";
			  cont1=cont1+1;
			  }
		  }
		 
		  cont1=0;
		  aux=aux.siguiente;
		
	  }
	  System.out.println (datos+"");
	  	  return datos;
	 
	
}
public boolean CompararHechosBC(String hecho)
{
	
	  NodosLista aux= PrimerNodo;
	  String respuesta="";
	  String[] consulta= hecho.split("[\\(\\)]+");
	 
	 
	  if(aux==null){
		  return  false;
	  } 

	  while((aux!=null)){
		  String[] hechoBC = aux.Linea.split("[\\(\\)]+");
		  String b=hechoBC[0];
		  String b1=hechoBC[1];	
		
		  if ((b.equals(consulta[0]))){
			  if ((b1.equals(consulta[1]))){
				  System.out.println ("si hay");
			  return true; 
		  }}
		  
		  aux=aux.siguiente;
		
	  }
	  System.out.println ("no hay");
	  	  return false;
	 
	
}
public boolean validarComilla(String a){
	int len=a.length();
	int count=0;
	int cont=0;
	String comilla="'";
	while(count!=len)
	{
		char c=a.charAt(count);
		String i=Character.toString(c);
		if (i.equals(comilla)){
			cont+=1;
		}
		count++;
	}
	if (cont==2){
		return true;
	
	}else {
		return false;
	}
}

public String 	Write(String hecho)
{  
	  String palabra="write";
	  String[] hechoBC = hecho.split("[\\(\\)]+");
	  String b=hechoBC[0];
	  String datos="";
	 
	  if(palabra.equals(b)){
		  if ((validarComilla(hechoBC[1]))==true){
			  String[] imprime = hecho.split("[\\(\\'\\)\\.]+");
			  datos=datos+" "+imprime[1]+""+"yes";
			  System.out.println (datos+"");
		  	  return datos;
		  }
		  	  
	  } 	 
	  return "";
	 
	
}
public String contar_aridad(String aridad){
	
	 String[] ari = aridad.split("[\\(\\)]+");
	 int largo =ari.length;
	 int count=0;
	
	
	
	return aridad;
	
}
public String 	Writeln(String hecho)
{  
	  String palabra="write";
	  String saltolinea="ln";
	  String[] hechoBC = hecho.split("[\\(\\)]+");
	  String b=hechoBC[0];
	  String datos="";
	 
	  if(palabra.equals(b)){
		  if ((validarComilla(hechoBC[1]))==true){
			  String[] salto = hecho.split("[\\(\\)\\'\\,\\.]+");
			  if (saltolinea.equals(salto[2])){
				  String[] imprime = hecho.split("[\\(\\'\\)\\.]+");
				  datos=datos+" "+imprime[1]+""+"\n"+"yes";
				  System.out.println (datos+"");
		  	  return datos;
		  }}
		  	  
	  } 	 
	  return "";
	 
	
}
//imprime una lista
public String Imprimir()
{ String i="";
	if (VaciaLista())
  {
    System.out.println( "vacia " +Nombre);
  }
  //fin del primer if
 else
 {
	 System.out.print( "La  " +  Nombre  +"  es:  ");
     NodosLista Actual = PrimerNodo;
	
    while (Actual != null)
	 {
	 	i=i+"  "+" "+Actual.Linea+ "\n ";     
       Actual=Actual.siguiente;
    }
	 System.out.println (i+"");
    System.out.println();
    System.out.println();
  }
	
return i;
}
//metodo booleano para validar si una letra es mayuscula
public boolean validarMayus(String a){
	if (Character.isUpperCase(a.charAt(0))==true|a=="_"){
		System.out.println("mayuscu");
		return true;
	}
	System.out.println("minuscula");
	return false;
}

//metodo booleano para validar si al final de la linea hay un punto 
public boolean validarPunto(char a){
	String b=Character.toString(a);
	String punto=".";
	if (b.equals(punto)){
		
		return true;
		
	}
	
	return false;
}
//metodo boolean que permite validar un parentesis 
public boolean valPD(String a){
	String b=")";
	if (a.equals(b)){
		return true;
	}
	return false;
}
//metodo boolean que permite validar un parentesis 
public boolean valPI(String a){
	String b="(";
	if (a.equals(b)){
		return true;
	}
	return false;
}
// metodo booleano que permite validar :-
public boolean validarClausula(String a){
	int len=a.length();
	int count=0;
 	String punto=":";
 	String guion="-";
	while(count!=len)
	{
		char c=a.charAt(count);
		String i=Character.toString(c);
		if (i.equals(punto)){
			String j=Character.toString(a.charAt(count+1));
			if (j.equals(guion)){
				System.out.println("Correcto");
				return true;}
			else{System.out.println("incorrecto");
				return false;}
		}
		count++;
	}
	System.out.println("no sirve");
	return false;
}
//metodo booleano que permite validar varias mayusculas
public boolean validarVariasMayuscalas(String a){
	int len=a.length();
	int count=0;
	String PA="(";
	String PC=")";
	String coma=",";
	boolean t = true ;
	
	while(count!=len)
	{
		char c=a.charAt(count);
		String i=Character.toString(c);
		if (i.equals(PA)){
		String k=Character.toString(a.charAt(count));
		while (!(PC.equals(Character.toString(a.charAt(count))))){
		
			String j=Character.toString(a.charAt(count));
			if ((j.equals(coma))||(j.equals(PA))){
				count+=1;
			}else{
				if ((validarMayus(j))==true){
					System.out.println("Correcto");
					t = true;
					count+=1;
					}
				else{System.out.println("incorrecto");
					return false;}
			}
			i=j;
		}}
		count++;
	}
	System.out.println("sirve");
	return t;
}

// metodo boolean que permite validar si hay un parentesis que abre y uno que cierra
public boolean recibirLN(String x){
	int len=x.length();
	int count=0;
	int parent=0;
	int parent1=0;
	while(count!=len)
	{
		char c=x.charAt(count);
		String i=Character.toString(c);
		if ((valPI(i))==true){
			parent+=1;
		}
		if ((valPD(i))==true){
			parent1+=1;
		}
		
		count++;
		}
	if (((parent>1) || (parent1>1) )||((parent<1) || (parent1<1) )){
		System.out.println("rica");
		return false;
	}
		
	else{
	System.out.println("fea");
	return true;
	
}}//metodo boolean que valida varios parentesis es decir si hay un ( sigue recorriendo la linea hasta encontrar ) y asi sucesivamente con los demas parentesis 

//este metodo aun esta en etapa de analisis
public boolean ValidarParentesis(String x,int count){
		int len=x.length();
		//int count = 0;
		
		
		while(count!=len-1)
		{
			char c=x.charAt(count);
			String i=Character.toString(c);
			
			if ((valPI(i))==true){
				
				while ((count<len-1)){
					count++;
					char s=x.charAt(count);
					String n=Character.toString(s);
					if ((valPD(n))==true){
						ValidarParentesis(x,count+1);
							}}
				
					
					return false;					
			}
			
			count++;
			}
		
		
		
		return true;
		
	
		

	}
/*
public boolean ValidarParentesis(String x,int count){
	int len=x.length();
	//int count = 0;
	while(count!=len)
	{
		char c=x.charAt(count);
		String i=Character.toString(c);
		if ((valPI(i))==true){
			String a="";
			System.out.println("COUNT=LEN");
			count++;
			char s=x.charAt(count);
			String n=Character.toString(s);
			while ((valPD(n))==false){
				count++;
				char s1=x.charAt(count);
				n=Character.toString(s);
				a+=n;
				if( count==len){return false;}
			}
			System.out.println("COUNT=LEN");
			tomarObj(a);
			count++;					
		}
	}
	System.out.println("COUNT=LEN");
	return true;
}*/


public boolean tomarObj(String a){
String obj=a;
return false;
}
	public boolean CompararHechos(String x,int count){
		int len=x.length();
		//int count = 0;
		
		
		while(count!=len-1)
		{
			char c=x.charAt(count);
			String i=Character.toString(c);
			
			if ((valPI(i))==true){
				
				while ((count<len)){
					count++;
					char s=x.charAt(count);
					String n=Character.toString(s);
					if ((valPD(n))==true){
						//ValidarParentesis(x,count+1);
							}}
				
					System.out.println("rica");
					return false;					
			}
			
			count++;
			}
		
		System.out.println("fea");
		
		return true;
		
	
		

	}




//Ejemplo de un main
};
class Prueba
{
 public static void main (String [] args){ 
	//para hacer pruebas 
	ListaSimple NuevaLista = new ListaSimple();
	String str="animal(l).";
	String str1="write('hola que haces'),ln.";
	//NuevaLista.validarClausula(str);
	//System.out.println("COUNT=LEN");
	//NuevaLista.Writeln(str1);
	NuevaLista.InsertaFinal("perro(ruffo).");	NuevaLista.InsertaFinal("gato(mimi,yui).");

	NuevaLista.InsertaFinal("perro(r).");
	NuevaLista.InsertaFinal("perro(ruf).");
	NuevaLista.InsertaFinal("gato(r).");
	NuevaLista.InsertaFinal("perro(mim).");
	NuevaLista.InsertaFinal("animal(Y):-perro(Y),gato(Y).");
	//NuevaLista.InsertaFinal("perro().");
	//NuevaLista.BuscarBc2("gato","mumu,mimi");
	NuevaLista.BuscarHechosBC1(str,"","","");
    //NuevaLista.validarVariasMayuscalas(str);
	//NuevaLista.InsertaF@@inal("perro(ronron).");+
	//NuevaLista.InsertaFinal("perro(fofi).");
	//System.out.println("rica");
	//NuevaLista.BuscarHechosBC("perro");
	
	
//	char[] ArrayRegla = str.toCharArray();
//	int longitud=ArrayRegla.length;
	NuevaLista.ValidarParentesis(str,0);
	//NuevaLista.validarPunto(ArrayRegla [longitud-1]);
	
//	NuevaLista.InsertaFinal(01, "hola");
//	NuevaLista.InsertaFinal(05, "hol");
//	NuevaLista.InsertaFinal(07, "ho");
//	NuevaLista.InsertaFinal(01, "hola");
//	NuevaLista.InsertaFinal(01, "hola");
	//NuevaLista.Imprimir();
	
	


	
	}



}
