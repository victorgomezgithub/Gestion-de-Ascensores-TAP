package backend;

public class CerrandoPuertas implements PanelDeControlEstado {



	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {
		
		if(plantaObjetivo == ascensor.getPrimerPisoLlamada() || plantaObjetivo == ascensor.getPiso()) {
			return;
		}
		
		
		if((plantaObjetivo > ascensor.getPiso() && plantaObjetivo < ascensor.getPrimerPisoLlamada()) ||  (plantaObjetivo < ascensor.getPiso() && plantaObjetivo > ascensor.getPrimerPisoLlamada())) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateState(Ascensor ascensor) {
		System.out.println("Cerrando Puertas");
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
