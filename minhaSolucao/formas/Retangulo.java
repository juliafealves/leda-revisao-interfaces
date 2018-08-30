package formas;

public class Retangulo implements Forma {

	private double altura;
	private double base;
	
	public Retangulo(double altura, double base) {
		this.altura = altura;
		this.base = base;
	}

	/**
	 * Calcula a área do retângulo.
	 */
	@Override
	public double calcula() {
		return this.base * this.altura;
	}
}
