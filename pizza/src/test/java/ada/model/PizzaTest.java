package ada.model;

import ada.enums.Size;
import ada.enums.Status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Assert;
import org.junit.Test;

public class PizzaTest {

    @Test
    public void testaCriaPizza() {
        Pizza pizza = new Pizza("4 queijos");

        Assert.assertEquals("4 queijos", pizza.getNome());
        Assert.assertEquals(10.0, pizza.getPreco(), 0.1);
        Assert.assertFalse(pizza.getPago());
        Assert.assertNull(pizza.getStatus());
        Assert.assertNull(pizza.getTamanho());
    }

    @Test
    public void testaEscolheTamanho() {
        Pizza pizza = new Pizza("4 queijos");

        Assert.assertEquals(30.5, pizza.escolheTamanho(Size.GRANDE), 0.1);
        Assert.assertThat(pizza.getTamanho(), is(equalTo(Size.GRANDE)));
    }

    @Test
    public void testaAssaPizza() {
        Pizza pizza = new Pizza("portuguesa");
        pizza.escolheTamanho(Size.PEQUENO);
        Assert.assertEquals(Status.FAZENDO, pizza.assaPizza());
    }

    @Test
    public void testaPagaPizza() {
        Pizza pizza = new Pizza("portuguesa");
        pizza.escolheTamanho(Size.PEQUENO);
        pizza.assaPizza();

        Assert.assertEquals(Status.PRONTO, pizza.pagaPizza());
        Assert.assertTrue(pizza.getPago());
    }

    @Test
    public void testaEntregaPizza() {
        Pizza pizza = new Pizza("portuguesa");
        pizza.escolheTamanho(Size.PEQUENO);
        pizza.assaPizza();
        pizza.pagaPizza();

        Assert.assertEquals(Status.ENTREGUE, pizza.entregaPizza());
    }

    @Test
    public void testaExcecaoTentarEntregarPizzaNaoPago() {
        Pizza pizza = new Pizza("portuguesa");
        pizza.escolheTamanho(Size.PEQUENO);
        pizza.assaPizza();

        Throwable throwable =
                Assert.assertThrows(RuntimeException.class, () -> pizza.entregaPizza());

        Assert.assertEquals("A pizza ainda não foi paga!", throwable.getMessage());
    }

}
