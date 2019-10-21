package bbcar.persistence.bean;

public class Coche {

	private String matricula;
	private String modelo;
	private int anyo;
	private int confort;
	private Usuario propietario;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getConfort() {
		return confort;
	}
	public void setConfort(int confort) {
		this.confort = confort;
	}
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	
}
