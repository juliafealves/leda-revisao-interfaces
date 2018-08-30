package formas;

public class Triangulo implements Forma {

	private double base;
	private double altura;
	
	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	/**
	 * Calcula a área do triângulo.
	 */
	@Override
	public double calcula() {
		return (this.base * this.altura) / 2;
	}
}
