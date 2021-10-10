
package Control_Temp;


public class HiloTemperatura extends Thread {

public double temperatura;
public int velocidad;
	
	public void run() {
	
	try {
	
	control_temp hiloVent = new control_temp();

		while(true) {
		/*Se ira reduciendo la temperatura ambiental dependiendo de la velocidad del ventilador cada 500 milisegundos*/		
		
			if ( (temperatura >= 25) && (temperatura <= 28) ) {
				velocidad = 1;
				hiloVent.setVelocidad(velocidad);
			
				temperatura = temperatura - 0.10;
				hiloVent.setTemperatura(temperatura);
				
			} 

			else if( (temperatura >= 29) && (temperatura <=34) ) {
			velocidad = 2;
			hiloVent.setVelocidad(velocidad);
	
				temperatura = temperatura - 0.05;
				hiloVent.setTemperatura(temperatura);
				
			} 

			else if( temperatura >= 35 ) {
			velocidad = 3;
			hiloVent.setVelocidad(velocidad);

				temperatura = temperatura - 0.02;
				hiloVent.setTemperatura(temperatura);
				
			} 

			else if (temperatura <= 24) {
			velocidad = 0;
			hiloVent.setVelocidad(velocidad);

				temperatura = temperatura + 0.12;
				hiloVent.setTemperatura(temperatura);
				
			}

		Thread.sleep(500);
		}

	} catch(InterruptedException e){ 
		System.out.println("Excepcion: " + e.getMessage());
	}

    } //fin del metodo run()

    public void setTemperatura(double temp) {
		temperatura = temp;
    }

	public void setVelocidad(int vel) {
		velocidad = vel;
    }

	public double getTemperatura() {
		return temperatura;
    }

	public int getVelocidad() {
		return velocidad;
    }

} //Fin de la clase HiloTemperatura
