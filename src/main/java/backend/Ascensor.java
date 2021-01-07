package backend;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Ascensor {
	
	static int idAscensoresTotales = 0;
	
	private ArrayList<Observer> observers;
	
	private enum estados{
		Subiendo,
		Bajando,
		Cerrando,
		Abriendo,
		Parado
		
	}
	
	private estados estado;
	private int piso;
	private Boolean alarma;
	private Boolean puerta;
	private int idAcensor;
	public Ascensor() {
		this.idAcensor = idAscensoresTotales;
		idAscensoresTotales++;
		this.piso = 0;
		this.setEstado(estados.Parado);
		this.setAlarma(false);
		this.setPuerta(true);
		observers =  new ArrayList<Observer>();
	}
	
	public int mostrarPiso (){
		System.out.println("planta: " + this.piso);
		return this.piso;
		
	}
	
	public void irAPiso(int plantaObjetivo) {
		this.setPuerta(false);
		while (this.piso != plantaObjetivo) {
			if (plantaObjetivo < this.piso) {
				this.piso = this.piso - 1;
				
				//System.out.println("planta: " + this.piso);
			}
			else {	
				this.piso = this.piso + 1;
				//System.out.println("planta: " + this.piso);
			}
			this.notifyObservers(this.piso,this.idAcensor);

		}
		ascensorLlegado();
	}

	public int getIdAscensor()
	{
		return idAcensor;
	}
	public void abrirPuertas() {
		this.setEstado(estados.Abriendo);
		this.setPuerta(true);
	}
	
	public void cerrarPuertas() {
		this.setEstado(estados.Cerrando) ;
		this.setPuerta(false);
	}
	
	public void subiendo() {
		this.setEstado(estados.Subiendo) ;
	}
	
	public void bajando() {
		this.setEstado(estados.Bajando) ;
	}
	
	public void pulsarAlarma() {
		this.alarma = true;
		System.out.println("ALARMAAAA");
	}
	
		
	public void ascensorLlegado() {
		this.setPuerta(true);
		//System.out.println("El ascensor ha llegado");
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

	public Boolean getAlarma() {
		return alarma;
	}
	public String getAlarmaPcontrol() {
		if (alarma==false)
			return "No pulsada";
		else
			return "Pulsada";
	}

	public void setAlarma(Boolean alarma) {
		this.alarma = alarma;
	}
	
	public void attachObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void detachObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObservers(int piso,int idAscensor) {
		
		for(Observer o : this.observers) {
			o.update(piso,idAscensor);
		}
	}

	public Boolean getPuerta() {
		return puerta;
	}

	public void setPuerta(Boolean puerta) {
		this.puerta = puerta;
	}
	public String getPuertaPcontrol() {
		if (puerta==true)
			return "Abierta";
		else
			return "Cerrada";
	}

}
