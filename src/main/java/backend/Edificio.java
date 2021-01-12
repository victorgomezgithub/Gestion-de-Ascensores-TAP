package backend;

import java.util.ArrayList;
import java.util.List;

public class Edificio {

	
	private static Edificio edificio;
	
	List<Planta> plantas;
	List<Ascensor> ascensores;
	
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
	
	private List<Ascensor> inicializarAscensores() {
		ascensores = new ArrayList<>();
		for(int i = 0; i<3; i++) 
		{
			ascensores.add(new Ascensor());
		}
		return ascensores;	
	}

	private List<Planta> inicializarPlantas() {
		plantas = new ArrayList<>();
		for(int i = 0; i<8; i++)
		{
			plantas.add(new Planta(i));
		}
		return plantas;	
	}
	
	public void addAscensor() {
		ascensores.add(new Ascensor());
	}
	
	public void removeAscensor() {
		if(!ascensores.isEmpty()) {
			ascensores.remove(ascensores.size() - 1);
			Ascensor.restarUnoTotalAscensores();
		}
	}
	
	
	public Ascensor getAscensorPorIndex(int index) {
		return ascensores.get(index);
	}
	
	public Planta getPlantaPorIndex(int index) {
		return plantas.get(index);
	}

	public List<Ascensor> getAscensores() {
		return ascensores;
	}
	public void attachObserver(Observer o,int ascensor) {
		getAscensorPorIndex(ascensor).attachObserver(o);
	}
	
	public static void reiniciarSistema() {
		Ascensor.idAscensoresTotales = 0;
		edificio = new Edificio();
	}
	
	public int getAscensoresLength() {
		return ascensores.size();
	}

}
