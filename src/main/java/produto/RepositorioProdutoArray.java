package produto;

public class RepositorioProdutoArray implements RepositorioProduto {

    protected static final int INDICE_INEXISTENTE = -1;

    /**
     * A posicao do ultimo elemento inserido no array de produto. o valor
     * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
     */
    protected int index = INDICE_INEXISTENTE;

    /**
     * A estrutura (array) onde os produto sao mantidos.
     */
    protected Produto[] produtos;

    /**
     * Recebe o codigo do produto e devolve o indice desse produto no array ou
     * -1 caso ele nao se encontre no array. Esse método é util apenas na
     * implementacao com arrays por questoes de localizacao. Outras classes que
     * utilizam outras estruturas internas podem nao precisar desse método.
     *
     * @param codigo
     * @return
     */
    protected int procurarIndice(int codigo) {
        int indice = INDICE_INEXISTENTE;
        boolean existe = false;
        int i = 0;

        while ((i <= this.index) && this.produtos[i] != null && !existe){
            if(this.produtos[i].getCodigo() == codigo){
                indice = i;
                existe = true;
            }

            i++;
        }

        return indice;
    }

    /**
     * Recebe o codigo e diz se tem produto com esse codigo armazenado
     *
     * @param codigo - Codigo do produto
     * @return boolean - Retorna true caso o produto exista na colecao.
     */
    @Override
    public boolean existe(int codigo) {
        boolean existeProduto = false;

        if(this.procurarIndice(codigo) != INDICE_INEXISTENTE){
            existeProduto = true;
        }

        return existeProduto;
    }

    /**
     * Insere um novo produto (sem se preocupar com duplicatas).
     *
     * @param produto - Produto a ser adicionado na colecao.
     */
    @Override
    public void inserir(Produto produto) {
        this.index = this.index + 1;

        if((this.produtos.length - 1) >= index) {
            this.produtos[this.index] = produto;
        } else {
            Produto[] produtos = new Produto[this.produtos.length + 10];
            System.arraycopy(this.produtos, 0, produtos, 0, this.produtos.length);
            this.produtos = produtos;
            this.produtos[this.index] = produto;
        }
    }

    /**
     * Atualiza um produto armazenado ou retorna um erro caso o produto nao
     * esteja no array. Note que, para localizacao, o código do produto será
     * utilizado.
     *
     * @param produto - Produto a ser atualizado na colecao.
     */
    @Override
    public void atualizar(Produto produto) {
        if(!this.existe(produto.getCodigo())) {
            throw new RuntimeException("O produto nao existente.");
        }

        int indice = this.procurarIndice(produto.getCodigo());
        this.produtos[indice] = produto;
    }

    /**
     * Remove produto com determinado codigo, se existir, ou entao retorna um
     * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
     * array.
     *
     * @param codigo - Codigo do produto
     */
    @Override
    public void remover(int codigo) {
        if(!this.existe(codigo)) {
            throw new RuntimeException("O produto nao existente.");
        }

        /**
         * Remove produtos duplicados dentro da colecao.
         */
        do {
            int indice = this.procurarIndice(codigo);

            if (indice == this.index) {
                this.produtos[indice] = null;
            } else {
                for (int i = indice + 1; i <= this.index; i++) {
                    this.produtos[i - 1] = this.produtos[i];
                }
            }

            this.index--;
        } while (this.existe(codigo));
    }

    /**
     * Retorna um produto com determinado codigo ou entao um erro, caso o
     * produto nao esteja armazenado
     *
     * @param codigo - Codigo do produto
     * @return Produto - Retorna o produto que consciende com codigo do produto.
     */
    @Override
    public Produto procurar(int codigo) {
        if(!this.existe(codigo)) {
            throw new RuntimeException("O produto nao existente.");
        }

        int indice = this.procurarIndice(codigo);
        return this.produtos[indice];
    }
}
