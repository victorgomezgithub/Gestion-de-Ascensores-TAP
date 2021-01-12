package backend;

public class Bajando implements PanelDeControlEstado {



	@Override
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo) {
		
		if(plantaObjetivo == ascensor.getPrimerPisoLlamada()) {
			return;
		}
		
		
		if(plantaObjetivo > ascensor.getPrimerPisoLlamada() && plantaObjetivo < ascensor.getPiso()) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateState(Ascensor ascensor) {
		System.out.println("bajando");
		ascensor.setPiso(ascensor.getPiso() - 1);
		if(ascensor.getPrimerPisoLlamada() == ascensor.getPiso()) {
			ascensor.setEstado(new AbriendoPuertas());
			ascensor.borrarLlamada();
		}
		
		ascensor.panel.updateState(ascensor);
		ascensor.notifyObservers();
	}


}