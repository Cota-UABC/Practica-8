import java.util.Scanner;

public class calculoNomina{
	public static void main(String[] args) {
	int num,c=0;
	boolean f=true;

	Empleado [] empleadoArray = new Empleado [100];//array de objetos de emplpeados

	System.out.println("\nDatos actuales del salario en la empresa:"+
						"\n-El salario fijo semanal es de 1200$"+
						"\n-El salirio por hora es de 20$, y un 10% mas despues de las 40 hrs"+
						"\n-La comision por venta es de 100$"+
						"\n-Empleados asalariados por comision reciben 10% extra en el salario base");
	
	Scanner sc= new Scanner(System.in);
	
	do{
			System.out.print("\n----------------------------------"+//menu
							"\nQue que tipo de salario recibe:"+ 
							"\n1.Salario fijo"+
							"\n2.Salario por hora"+
							"\n3.Salario por comision"+
							"\n4.Salario fijo con comision"+
							"\n5.Salir"+
							"\n\nIngresa numero: ");
			num = sc.nextInt();
							
			
							switch(num){  //switch case para el menu
							case 1: empleadoArray[c] = new salarioFijo(datos.getString(),1200);//envia un salario fijo
									System.out.println("\n" + empleadoArray[c].getName() + " recibe un salario de " + empleadoArray[c].getSalario() + "$ semanales");
									break;
							case 2: empleadoArray[c] = new salarioHora(datos.getString(),0,datos.getInt("Ingresa el numero de horas"));//envia la cantidad de horas trabajadas
									System.out.println("\n" + empleadoArray[c].getName() + " recibe un salario de " + empleadoArray[c].getSalario() + "$");
									break;
							case 3: empleadoArray[c] = new salarioComision(datos.getString(),0,datos.getInt("Ingresa las ventas realizadas"));//envia las ventas realizadas
									System.out.println("\n" + empleadoArray[c].getName() + " recibe un salario de " + empleadoArray[c].getSalario() + "$");
									break;
							case 4: empleadoArray[c] = new salarioComisionYBase(datos.getString(),1200,datos.getInt("Ingresa las ventas realizadas"));//envia las ventas realizadas y el salario fijo
									System.out.println("\n" + empleadoArray[c].getName() + " recibe un salario de " + empleadoArray[c].getSalario() + "$");
									break;
							case 5: f=false; break;//convierte la bandera de salida a falsa
							default: System.out.println("\n--Ingresa una de las opciones--");
							}
		c++;
	}while(f==true);//mientras que la bandera de salida sea verdadera
	
	}
}

abstract class Empleado{//clase padre abstracta Empleado
	String name;
	double salario;
	
	public Empleado(String name,double salario){
		this.name = name;
		this.salario = salario;
	}

	public abstract String getName();

	public abstract double getSalario();
}	

class salarioFijo extends Empleado{//clase de salario fijo de 1200
	
	public salarioFijo(String name,double salario){
		super(name,salario);		
	}

	public String getName(){
		return name;
	}

	public double getSalario(){
		return salario;
	}

}

class salarioHora extends Empleado{//clase que calcula el salario con respecto a las horas
	int horas;
	
	public salarioHora(String name,double salario,int horas){
		super(name,salario);
		this.horas= horas;
	}
	
	public String getName(){
		return name;
	}

	public double getSalario(){//20 pesos por hora, 20 mas 10% despues de 40 horas
		if(horas>40){
		salario = 20 * 40;
		salario = salario + (22 * (horas-40));
		}
		else salario = 20 * horas;
		return salario;
	}
}

class salarioComision extends Empleado{//clase que calcula el salario con comicion
	int ventas;
	
	public salarioComision(String name,double salario,int ventas){
		super(name,salario);
		this.ventas= ventas;
	}
	
	public String getName(){
		return name;
	}

	public double getSalario(){//100 pesos por venta
		salario = ventas * 100;
		return salario;
	}
}

class salarioComisionYBase extends Empleado{//clase de salario fijo mas comisiones
	int ventas;
	
	public salarioComisionYBase(String name,double salario,int ventas){
		super(name,salario);
		this.ventas= ventas;
	}
	
	public String getName(){
		return name;
	}

	public double getSalario(){//10% mas del salario fijo, mas 100 por venta
		salario =(salario * 1.1) + (ventas * 100);
		return salario;
	}
}
class datos{//clase de recivir datos por parte del usuario
	
	public static String getString(){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese el nombre: ");
		return( scan.nextLine() );
	}
	
	public static int getInt(String mens){
		Scanner scan= new Scanner(System.in);
		System.out.print("\n" + mens +": ");
		return( scan.nextInt() );
	}
}