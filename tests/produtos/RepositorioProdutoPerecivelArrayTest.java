package produtos;

import org.junit.Before;
import org.junit.Test;

public class RepositorioProdutoPerecivelArrayTest {
    RepositorioProdutoPerecivelArray repositorioProdutoPerecivelArray;

    @Before
    public void inicializa(){
        this.repositorioProdutoPerecivelArray = new RepositorioProdutoPerecivelArray(3);
        this.repositorioProdutoPerecivelArray.inserir(new ProdutoPerecivel(1, "Produto 1", 10.00, null, null));
        this.repositorioProdutoPerecivelArray.inserir(new ProdutoPerecivel(2, "Produto 2", 20.00, null, null));
        this.repositorioProdutoPerecivelArray.inserir(new ProdutoPerecivel(3, "Produto 3", 30.00, null, null));
    }

    @Test (expected = RuntimeException.class)
    public void testRemoverDoMeio(){
        this.repositorioProdutoPerecivelArray.remover(2);
        this.repositorioProdutoPerecivelArray.procurar(2);
    }

    @Test (expected = RuntimeException.class)
    public void testRemoverPrimeiro(){
        this.repositorioProdutoPerecivelArray.remover(1);
        this.repositorioProdutoPerecivelArray.procurar(1);
    }

    @Test (expected = RuntimeException.class)
    public void testRemoverUltimo(){
        this.repositorioProdutoPerecivelArray.remover(3);
        this.repositorioProdutoPerecivelArray.procurar(3);
    }
}
