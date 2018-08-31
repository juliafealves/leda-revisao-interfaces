package produto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Os testes sao iguais para ProdutoNaoPerecivelArray
 * Os codigo sao bastante similares.
 */
public class TestRepositorioProdutoArray {

    private RepositorioProdutoArray repositorioPerecivel;

    @Before
    public void inicializa() {
        this.repositorioPerecivel = new RepositorioProdutoPerecivelArray(3);
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(1, "Arroz", 3.00, null, null));
    }

    @Test
    public void testProcura(){
        Assert.assertEquals(1, this.repositorioPerecivel.procurar(1).getCodigo());
    }

    @Test (expected = RuntimeException.class)
    public void testProcuraInexistente(){
        this.repositorioPerecivel.procurar(10);
    }

    @Test
    public void testExiste(){
        Assert.assertTrue(this.repositorioPerecivel.existe(1));
    }

    @Test
    public void testNaoExiste(){
        Assert.assertFalse(this.repositorioPerecivel.existe(2));
    }

    @Test
    public void testInsere(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        Assert.assertTrue(this.repositorioPerecivel.existe(2));
    }

    @Test
    public void testInsereArrayCheio(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(3, "Carne", 10.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(4, "Macarrão", 3.00, null, null));
        Assert.assertTrue(this.repositorioPerecivel.existe(4));
    }

    @Test
    public void testAtualiza(){
        Produto produtoPerecivel = this.repositorioPerecivel.procurar(1);
        Assert.assertEquals("Arroz", produtoPerecivel.getNome());

        produtoPerecivel.setNome("Arroz Branco");
        this.repositorioPerecivel.atualizar(produtoPerecivel);
        Assert.assertEquals("Arroz Branco", this.repositorioPerecivel.procurar(1).getNome());
    }

    @Test (expected = RuntimeException.class)
    public void testAtualizaInexistente(){
        Produto produtoPerecivel = new ProdutoPerecivel(2, "Feijão", 5.00, null, null);
        produtoPerecivel.setNome("Arroz Branco");
        this.repositorioPerecivel.atualizar(produtoPerecivel);
    }

    @Test
    public void testRemove(){
        this.repositorioPerecivel.remover(1);
        Assert.assertFalse(this.repositorioPerecivel.existe(1));
    }

    @Test
    public void testRemoveDuplicados(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.remover(2);
        Assert.assertFalse(this.repositorioPerecivel.existe(2));
    }

    @Test (expected = RuntimeException.class)
    public void testRemoveInexistente(){
        this.repositorioPerecivel.remover(10);
    }

    @Test
    public void testRemoveNoInicio(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(3, "Carne", 10.00, null, null));
        this.repositorioPerecivel.remover(1);
        Assert.assertTrue(this.repositorioPerecivel.existe(2));
        Assert.assertTrue(this.repositorioPerecivel.existe(3));
        Assert.assertFalse(this.repositorioPerecivel.existe(1));
    }

    @Test
    public void testRemoveNoMeio(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(3, "Carne", 10.00, null, null));
        this.repositorioPerecivel.remover(2);
        Assert.assertTrue(this.repositorioPerecivel.existe(1));
        Assert.assertTrue(this.repositorioPerecivel.existe(3));
        Assert.assertFalse(this.repositorioPerecivel.existe(2));
    }

    @Test
    public void testRemoveNoFinal(){
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(2, "Feijão", 5.00, null, null));
        this.repositorioPerecivel.inserir(new ProdutoPerecivel(3, "Carne", 10.00, null, null));
        this.repositorioPerecivel.remover(3);
        Assert.assertTrue(this.repositorioPerecivel.existe(1));
        Assert.assertTrue(this.repositorioPerecivel.existe(2));
        Assert.assertFalse(this.repositorioPerecivel.existe(3));
    }
}
