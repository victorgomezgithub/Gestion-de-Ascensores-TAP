package backend;

public class AbriendoPuertas implements PanelDeControlEstado {



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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarPuertas(Ascensor ascensor) {
		
		ascensor.setEstado(new CerrandoPuertas());
		
	}

	@Override
	public void updateState(Ascensor ascensor) {

		System.out.println("Abriendo Puertas");
		ascensor.setEstado(new Parado());
		ascensor.panel.updateState(ascensor);
		ascensor.notifyObservers();
	}

}
