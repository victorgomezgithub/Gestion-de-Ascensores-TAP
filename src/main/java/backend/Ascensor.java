package backend;

public class Ascensor {
	
	private enum estados{
		Subiendo,
		Bajando,
		Cerrando,
		Abriendo,
		Parado
		
	}
	private estados estado;
	private int piso;
	private Boolean alarma;
	
	public Ascensor() {
		this.piso = 0;
		this.setEstado(estados.Parado);
		this.setAlarma(false);
	}
	
	public int mostrarPiso (){
		System.out.println("planta: " + this.piso);
		return this.piso;
		
	}
	
	public void irAPiso(int plantaObjetivo) {
		System.out.println(this.piso + " " + plantaObjetivo);
		while (this.piso != plantaObjetivo) {
			if (plantaObjetivo < this.piso) {
				this.piso = this.piso - 1;
				System.out.println("planta: " + this.piso);
			}
			else {	
				this.piso = this.piso + 1;
				System.out.println("planta: " + this.piso);
				
			}
		}	
		
		ascensorLlegado();
	}

	public void abrirPuertas() {
		this.setEstado(estados.Abriendo);
	}
	public void cerrarPuertas() {
		this.setEstado(estados.Cerrando) ;
	}
	public void subiendo() {
		this.setEstado(estados.Subiendo) ;
	}
	
	public void bajando() {
		this.setEstado(estados.Bajando) ;
	}
	
	public void ascensorLlegado() {
		System.out.println("El ascensor ha llegado");
	}

	public estados getEstado() {
		return estado;
	}

	public void setEstado(estados estado) {
		this.estado = estado;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Boolean getAlarma() {
		return alarma;
	}

	public void setAlarma(Boolean alarma) {
		this.alarma = alarma;
	}

}
