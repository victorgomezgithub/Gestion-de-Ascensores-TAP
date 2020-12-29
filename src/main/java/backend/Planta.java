package backend;

import java.util.ArrayList;

public class Planta {

	private int numPiso;
	public Planta(int numPiso) {
		this.numPiso = numPiso;
	}
	public void llamarAscensor(Ascensor a) {
		a.irAPiso(numPiso);
	}
	
	
}
