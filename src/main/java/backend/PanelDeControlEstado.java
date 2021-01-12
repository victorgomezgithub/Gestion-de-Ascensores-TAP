package backend;

import java.util.logging.Logger;

public interface PanelDeControlEstado {
	
	Logger logger = Logger.getLogger(PanelDeControlEstado.class.getSimpleName()); 

	
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo);
	public void abrirPuertas(Ascensor ascensor);
	public void cerrarPuertas(Ascensor ascensor);
	
	public void updateState(Ascensor ascensor);

}
