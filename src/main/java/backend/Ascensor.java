package backend;

import java.util.ArrayList;

public class Ascensor {
	
	static int idAscensoresTotales = 0;
	
	public static void restarUnoTotalAscensores() {
		Ascensor.idAscensoresTotales--;
	}
	private ArrayList<Observer> observers;
	
	private enum estados{
		SUBIENDO,
		BAJANDO,
		CERRANDO,
		ABRIENDO,
		PARADO
	}
	
	private estados estado;
	private int piso;
	private boolean alarma;
	private boolean puerta;
	private int idAscensor;
	
	public Ascensor() {
		this.idAscensor = idAscensoresTotales;
		idAscensoresTotales++;
		this.piso = 0;
		this.setEstado(estados.PARADO);
		this.setAlarma(false);
		this.puerta = true;
		observers =  new ArrayList<>();
	}
	
	public void irAPiso(int plantaObjetivo) {
		this.puerta = true;
		while (this.piso != plantaObjetivo) {
			if (plantaObjetivo < this.piso) {
				this.piso = this.piso - 1;
			}
			else {	
				this.piso = this.piso + 1;
			}
			this.notifyObservers();
		}
		this.notifyObservers();
	}

	public int getIdAscensor()
	{
		return idAscensor;
	}
	
	public void abrirPuertas() {
		this.setEstado(estados.ABRIENDO);
		this.setPuerta(true);
	}
	
	public void subiendo() {
		this.setEstado(estados.SUBIENDO) ;
	}
	
	public void bajando() {
		this.setEstado(estados.BAJANDO) ;
	}
	
	public void pulsarAlarma() {
		this.alarma = true;
	}

	public estados getEstado() {
		return estado;
	}
	public String getEstadoPcontrol() {
		return estado.toString();
	}

	public void setEstado(estados estado) {
		this.estado = estado;
	}
	
	public int getPiso() {
		return piso;
	}
	public int getPisoPcontrol() {
		return piso+1;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public boolean getAlarma() {
		return alarma;
	}
	public String getAlarmaPcontrol() {
		if (alarma)
			return "Pulsada";
		else
			return "No pulsada";
	}

	public void setAlarma(boolean alarma) {
		this.alarma = alarma;
	}
	
	public void attachObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void detachObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObservers() {
		
		for(Observer o : this.observers) {
			o.update(this.piso, this.idAscensor);
		}
	}

	public boolean getPuerta() {
		
		return this.puerta;
	}

	public void setPuerta(boolean puerta) {
		this.puerta = puerta;
		this.notifyObservers();
	}
	public String getPuertaPcontrol() {
		if (puerta)
			return "Abierta";
		else
			return "Cerrada";
	}
	

}
