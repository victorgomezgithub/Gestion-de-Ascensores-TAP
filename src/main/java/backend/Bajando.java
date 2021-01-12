package backend;

import java.util.logging.Level;

public class Bajando implements PanelDeControlEstado {


	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {
		Utils.gestionaLLamadaAscensor( ascensor,  plantaObjetivo);	
	}

	@Override
	public void abrirPuertas(Ascensor ascensor) {
		logger.log(Level.INFO, "No se pueden abrir puertas durante un trayecto de bajada");
	}

	@Override
	public void cerrarPuertas(Ascensor ascensor) {
		logger.log(Level.INFO, "No se pueden cerrar puertas durante un trayecto de bajada");
	}

	@Override
	public void updateState(Ascensor ascensor) {
		logger.log(Level.INFO, "Bajando");
		
		Utils.movimientoAscensor(ascensor, -1);
		ascensor.notifyObservers();

	}


}