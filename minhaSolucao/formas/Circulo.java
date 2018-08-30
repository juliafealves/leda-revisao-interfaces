package formas;

public class Circulo implements Forma {

	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}

	/**
	 * Calcula a área do círculo.
	 */
	@Override
	public double calcula() {
		return this.raio * Math.PI;
	}
}
