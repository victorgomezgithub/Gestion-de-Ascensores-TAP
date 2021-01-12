package backend;

public interface PanelDeControlEstado {
	
	public void llamadaDePlanta(Ascensor ascensor, int plantaObjetivo);
	public void abrirPuertas(Ascensor ascensor);
	public void cerrarPuertas(Ascensor ascensor);
	
	public void updateState(Ascensor ascensor);

}
