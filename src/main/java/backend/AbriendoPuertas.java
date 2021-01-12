package backend;

import java.util.logging.Level;

public class AbriendoPuertas implements PanelDeControlEstado {



	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {		
		Utils.gestionaLLamadaAscensor( ascensor,  plantaObjetivo);
	}


	@Override
	public void abrirPuertas(Ascensor ascensor) {
		logger.log(Level.INFO, "Ya se estan abriendo puertas");
	}

	@Override
	public void cerrarPuertas(Ascensor ascensor) {		
		ascensor.setEstado(new CerrandoPuertas());	
	}

	@Override
	public void updateState(Ascensor ascensor) {
		logger.log(Level.INFO, "Abriendo puertas");
		
		ascensor.setEstado(new Parado());
		ascensor.panel.updateState(ascensor);
		ascensor.notifyObservers();
	}

}
