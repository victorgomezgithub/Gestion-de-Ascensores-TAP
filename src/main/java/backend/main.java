package backend;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Planta> plantas = new ArrayList<>();
		ArrayList<Ascensor> ascensores = new ArrayList<>();
		ascensores.add(new Ascensor());
		ascensores.add(new Ascensor());
		ascensores.add(new Ascensor());
		plantas.add(new Planta(0));
		plantas.add(new Planta(1));
		plantas.add(new Planta(2));
		plantas.add(new Planta(3));
		plantas.add(new Planta(4));
		plantas.add(new Planta(5));
		ascensores.get(0).mostrarPiso();
		plantas.get(4).llamarAscensor(ascensores.get(0));
	}

}
