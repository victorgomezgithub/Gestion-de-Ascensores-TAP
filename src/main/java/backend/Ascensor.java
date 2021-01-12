package backend;

import java.util.ArrayList;

public class Ascensor {
	
	static int idAscensoresTotales = 0;
	
	public static void restarUnoTotalAscensores() {
		Ascensor.idAscensoresTotales--;
	}
	private ArrayList<Observer> observers;
	

	private int piso;
	private boolean alarma;
	private boolean puerta;
	private int idAscensor;
	
	
	// Añado lista de pisos por visitar
	private ArrayList<Integer> llamadas;
	PanelDeControlEstado panel;
	//
	
	
	public Ascensor() {
		this.idAscensor = idAscensoresTotales;
		idAscensoresTotales++;
		this.piso = 0;
		this.setAlarma(false);
		this.puerta = true;
		observers =  new ArrayList<>();
		
		// Inicialización
		llamadas = new ArrayList<>();
		this.panel = new Parado();

	}
	
	

	public int getIdAscensor()
	{
		return idAscensor;
	}
		
	public void pulsarAlarma() {
		this.alarma = true;
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
	
	
	public void abrirPuertas() {
		this.setPuerta(true);
		panel.abrirPuertas(this);
		panel.updateState(this);
	}
	
	public void cerrarPuertas() {
		this.setPuerta(false);
		panel.cerrarPuertas(this);
		panel.updateState(this);
	}
	
	
	public int getPrimerPisoLlamada() {
		return this.llamadas.get(0);
	}
	
	public void borrarLlamada() {
		this.llamadas.remove(0);
	}
	
	
	public boolean checkColaLlamadas() {
		return this.llamadas.isEmpty();
	}
	
	public void addPisoLlamadaFinal(int piso) {
		
		if(llamadas.contains(piso)) {
			return;
		}
		
		llamadas.add(piso);
	}
	
	public void addPisoLlamadaPrincipio(int piso) {
		
		if(llamadas.contains(piso)) {
			return;
		}
		
		llamadas.add(0, piso);
	}
	
	public void setEstado(PanelDeControlEstado nuevoEstado) {
		this.panel = nuevoEstado;
	}
	
	public boolean llamadasEsVacio() {
		
		return this.llamadas.isEmpty();
		
	}
	
	public void llamadaDePlanta(int plantaObjetivo) {
		
		panel.llamadaDePlanta(this, plantaObjetivo);
		panel.updateState(this);

	}
	
	public String getEstadoPcontrol() {
		return this.panel.getClass().getSimpleName();
	}

}
