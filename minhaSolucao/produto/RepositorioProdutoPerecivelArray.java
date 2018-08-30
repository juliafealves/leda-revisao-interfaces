package produto;

import com.sun.tools.javac.util.ArrayUtils;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoPerecivelArray {

    private static final int INDICE_INEXISTENTE = -1;

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = INDICE_INEXISTENTE;

	public RepositorioProdutoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoPerecivel[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int indice = INDICE_INEXISTENTE;

		for(int i = 0; i < produtos.length; i++){
		    if(produtos[i].getCodigo() == codigo){
		        indice = i;
            }
        }

        return indice;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		boolean existeProduto = false;

		if(this.procurarIndice(codigo) != INDICE_INEXISTENTE){
            existeProduto = true;
        }

        return existeProduto;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoPerecivel produto) {
	    index += index;

	    if((this.produtos.length - 1) >= index) {
            this.produtos[index] = produto;
        } else {
	        ProdutoPerecivel[] produtos = new ProdutoPerecivel[this.produtos.length + 10];
            System.arraycopy(this.produtos, 0, produtos, 0, this.produtos.length);
            this.produtos = produtos;
	        this.produtos[index] = produto;
        }
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(ProdutoPerecivel produto) {
	    int indice = this.procurarIndice(produto.getCodigo());

	    if(indice == INDICE_INEXISTENTE)
	        throw new RuntimeException("O produto nao existente.");

	    this.produtos[indice] = produto;
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
        int indice = this.procurarIndice(codigo);

        if(indice == INDICE_INEXISTENTE)
            throw new RuntimeException("O produto nao existente.");

        ProdutoPerecivel[] produtos = new ProdutoPerecivel[this.produtos.length];

        indice += indice;

        System.arraycopy(this.produtos, indice, produtos, 0, this.produtos.length);
        this.produtos[indice] = produto;
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public ProdutoPerecivel procurar(int codigo) {
        int indice = this.procurarIndice(codigo);

        if(indice == INDICE_INEXISTENTE)
            throw new RuntimeException("O produto nao existente.");

        return this.produtos[indice];
	}
}
