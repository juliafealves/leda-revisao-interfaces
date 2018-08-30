package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 *
 * @author Adalberto
 */
public class RepositorioProdutoArrayList {

	/**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	private ArrayList produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produtos foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoArrayList(int size) {
		super();
		this.produtos = new ArrayList();
	}

	/**
	 * Recebe o codigo do produtos e devolve o indice desse produtos no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Recebe o codigo e diz se tem produtos com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Insere um novo produtos (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Atualiza um produtos armazenado ou retorna um erro caso o produtos nao
	 * esteja no array. Note que, para localizacao, o código do produtos será
	 * utilizado.
	 */
	public void atualizar(Produto produto) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Remove produtos com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Retorna um produtos com determinado codigo ou entao um erro, caso o
	 * produtos nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
