package backend;

public class Utils {

	private Utils() {
		
	}
	
	public static void movimientoAscensor(Ascensor ascensor,int direccion) {
		
		ascensor.setPiso(ascensor.getPiso() + direccion);
		if(ascensor.getPrimerPisoLlamada() == ascensor.getPiso()) {
			ascensor.setEstado(new AbriendoPuertas());
			ascensor.borrarLlamada();
		}
		
		ascensor.panel.updateState(ascensor);
	}
	
	public static void gestionaLLamadaAscensor(Ascensor ascensor, int plantaObjetivo) {
		if(plantaObjetivo == ascensor.getPrimerPisoLlamada()) {
			return;
		}		
		
		if(plantaObjetivo > ascensor.getPrimerPisoLlamada() && plantaObjetivo < ascensor.getPiso()) {
			ascensor.addPisoLlamadaPrincipio(plantaObjetivo);
		} else {
			ascensor.addPisoLlamadaFinal(plantaObjetivo);
		}
	}
	
}
