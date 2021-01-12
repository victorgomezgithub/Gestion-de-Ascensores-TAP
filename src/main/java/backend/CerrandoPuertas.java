package backend;

import java.util.logging.Level;

public class CerrandoPuertas implements PanelDeControlEstado {



	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {	
		Utils.gestionaLLamadaAscensor( ascensor,  plantaObjetivo);		
	}



	@Override
	public void abrirPuertas(Ascensor ascensor) {	
		ascensor.setEstado(new AbriendoPuertas());
	}

	@Override
	public void cerrarPuertas(Ascensor ascensor) {
		logger.log(Level.INFO, "Cerrando Puertas");	
	}

	@Override
	public void updateState(Ascensor ascensor) {
		logger.log(Level.INFO, "Cerrando Pueras");

		if(ascensor.llamadasEsVacio()) {
			ascensor.setEstado(new Parado());
		} else 
		if(ascensor.getPrimerPisoLlamada() < ascensor.getPiso()) {
			ascensor.setEstado(new Bajando());
		} else {
			ascensor.setEstado(new Subiendo());
		}
		ascensor.notifyObservers();
		ascensor.panel.updateState(ascensor);
	}
	
}
