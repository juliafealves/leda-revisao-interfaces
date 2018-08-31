package produto;

public interface RepositorioProduto {

    /**
     * Recebe o codigo e diz se tem produto com esse codigo armazenado
     *
     * @param codigo - Codigo do produto
     * @return boolean - Retorna true caso o produto exista na colecao.
     */
    public abstract boolean existe(int codigo);

    /**
     * Insere um novo produto (sem se preocupar com duplicatas).
     *
     * @param produto - Produto a ser adicionado na colecao.
     */
    public abstract void inserir(Produto produto);

    /**
     * Atualiza um produto armazenado ou retorna um erro caso o produto nao
     * esteja no array. Note que, para localizacao, o código do produto será
     * utilizado.
     *
     * @param produto - Produto a ser atualizado na colecao.
     */
    public abstract void atualizar(Produto produto);

    /**
     * Remove produto com determinado codigo, se existir, ou entao retorna um
     * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
     * array.
     *
     * @param codigo - Codigo do produto
     */
    public abstract void remover(int codigo);

    /**
     * Retorna um produto com determinado codigo ou entao um erro, caso o
     * produto nao esteja armazenado
     *
     * @param codigo - Codigo do produto
     * @return Produto - Retorna o produto que consciende com codigo do produto.
     */
    public abstract Produto procurar(int codigo);
}
