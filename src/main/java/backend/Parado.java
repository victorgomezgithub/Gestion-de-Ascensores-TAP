package backend;

import java.util.logging.Level;

public class Parado implements PanelDeControlEstado {



	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {
		
		if(plantaObjetivo == ascensor.getPiso()) {
			ascensor.setEstado(new AbriendoPuertas());
			return;
		}
		
		
		if(!ascensor.llamadasEsVacio() && ((plantaObjetivo > ascensor.getPiso() && plantaObjetivo < ascensor.getPrimerPisoLlamada()) ||  (plantaObjetivo < ascensor.getPiso() && plantaObjetivo > ascensor.getPrimerPisoLlamada()))) {
			ascensor.addPisoLlamadaPrincipio(plantaObjetivo);
		} else {
			ascensor.addPisoLlamadaFinal(plantaObjetivo);
		}
	}



	@Override
	public void abrirPuertas(Ascensor ascensor) {		
		ascensor.setEstado(new AbriendoPuertas());		
	}

	@Override
	public void cerrarPuertas(Ascensor ascensor) {		
		ascensor.setEstado(new CerrandoPuertas());
	}

	@Override
	public void updateState(Ascensor ascensor) {
		
		logger.log(Level.INFO, "Ascensor Parado");
		if(ascensor.llamadasEsVacio()) {
			ascensor.notifyObservers();
			return;
		}
		ascensor.setEstado(new CerrandoPuertas());
		ascensor.notifyObservers();
		ascensor.panel.updateState(ascensor);
		
	}

}