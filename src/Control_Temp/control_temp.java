
package Control_Temp;


import java.util.*;

public class control_temp extends Thread {

public double temperatura = 25; //Se fija una temperatura ambiental inicial de 25º C
public int temp,velocidad;
public boolean estadoVentilador;
public String state;
public Random genRand = new Random();

	 public void run() {

		try {

            HiloTemperatura hiloTemp = new HiloTemperatura();
			hiloTemp.setTemperatura(temperatura);
			hiloTemp.start(); //Iniciamos el hilo de Temperatura.
		
		long start = System.currentTimeMillis(); //Se obtiene la hora del sistema en milisegundos (inicial) 

			while(true) {

				long end = System.currentTimeMillis(); //Se obtiene la hora del sistema en milisegundos (final)
	   			long dif = end - start; //Se calcula el tiempo transcurrido entre la hora del sistema final e inicial

		if(dif >= 20000) { //Genera una temperatura aleatoria cada 20 segundos

				temp = ((genRand.nextInt(10000) % 30) + 17); //Se genera un numero aleatorio entre 17 y 30
				temperatura = (double)temp; // Se hace la conversion de tipo de dato entero a double
		
				hiloTemp.setTemperatura(temperatura); //Ajusta la temperatura en la clase HiloTemperatura
				hiloTemp.setVelocidad(velocidad);

				start = System.currentTimeMillis();

			if (temperatura > 24) {
				estadoVentilador = true;
				setEstado(estadoVentilador);
				
			} else {
				estadoVentilador = false;
				setEstado(estadoVentilador);
			}	

		velocidad = hiloTemp.getVelocidad();
		temperatura = hiloTemp.getTemperatura(); 

		}
		else {
			if (temperatura > 24) {
				estadoVentilador = true;
				setEstado(estadoVentilador);
				
			} else {
				estadoVentilador = false;
				setEstado(estadoVentilador);
			}	
			
		velocidad = hiloTemp.getVelocidad();
		//temperatura = hiloTemp.getTemperatura(); 

		}	
	

			for(int r=0;r<20;r++){System.out.println("\n");}
				System.out.println("\t----------------------------------");
				System.out.println("\t~Sistema Control de Temperatura~");	
				System.out.println("\t\t----------------------------------");

				System.out.println("\n\t\t\t~Estado del termostato~");
				System.out.println("\n\tTemperatura del agua -> "+temperatura+" ºC");
				System.out.println("\n\tPotencia -> "+velocidad);
				System.out.println("\n\tEstado -> "+state);	

			temperatura = hiloTemp.getTemperatura();
			hiloTemp.setTemperatura(temperatura); 
			
			Thread.sleep(5000);
			} //Fin del while

		} catch(InterruptedException e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	} //Fin del metodo run


	public String setEstado(boolean estado) {
		if (estado == true) {
			this.state = "Encendido";
		}	
		else {
			this.state = "Apagado";
		}
	return state;
	}

	public void setTemperatura(double temp) {
		temperatura = temp;
    }

	public void setVelocidad(int vel) {
		velocidad = vel;
    }

	public static void main(String[] args) {
		control_temp termostato = new control_temp();
		termostato.start();
    }
}
