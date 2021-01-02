package backend;

import java.util.ArrayList;

public class Edificio {

	
	private static Edificio edificio;
	
	ArrayList<Planta> plantas;
	ArrayList<Ascensor> ascensores;
	
	private Edificio() {
		plantas = inicializarPlantas();
		ascensores = inicializarAscensores();
	}
	
	public static Edificio getSingletonEdificio()
	{
		if(edificio == null)
			edificio = new Edificio();
		
		return edificio;
	}
	
	private ArrayList<Ascensor> inicializarAscensores() {
		ascensores = new ArrayList<Ascensor>();
		for(int i = 0; i<3; i++) 
		{
			ascensores.add(new Ascensor());
		}
		return ascensores;	
	}

	private ArrayList<Planta> inicializarPlantas() {
		plantas = new ArrayList<Planta>();
		for(int i = 0; i<8; i++)
		{
			plantas.add(new Planta(i));
		}
		return plantas;	
	}
	
	public Ascensor getAscensorPorIndex(int index) {
		return ascensores.get(index);
	}
	
	public Planta getPlantaPorIndex(int index) {
		return plantas.get(index);
	}

	
	//TODO metodo que asocie un observer a ascensor, y ya estar
	public void attachObserver(Observer o,int ascensor) {
		getAscensorPorIndex(ascensor).attachObserver(o);
	}

}
