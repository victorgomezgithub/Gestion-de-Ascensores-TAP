package backend;

public class Main {

	public static void main(String[] args) {
		Edificio edificio;
		edificio = Edificio.getSingletonEdificio();
		
		
		
		edificio.getPlantaPorIndex(3).llamarAscensor(edificio.getAscensorPorIndex(1));
		
	}

}
