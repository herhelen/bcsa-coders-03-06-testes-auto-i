package ada.model;

import ada.enums.Size;
import ada.enums.Status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Assert;
import org.junit.Test;

public class PizzaTest {

    @Test
    public void testaEscolheTamanho() {
        Pizza pizza = new Pizza("4 queijos");

        Assert.assertEquals(30, pizza.escolheTamanho(Size.GRANDE), 0.1);
        Assert.assertThat(pizza.getTamanho(), is(equalTo(Size.GRANDE)));
    }

    @Test
    public void testaAssaPizza() {
        Pizza pizza = new Pizza("portuguesa");

        Assert.assertEquals(Status.FAZENDO, pizza.assaPizza());
    }

    @Test
    public void testPagaPizza() {
        Pizza pizza = new Pizza("portuguesa");
        pizza.assaPizza();

        Assert.assertEquals(Status.PRONTO, pizza.pagaPizza());
        Assert.assertTrue(pizza.getPago());
    }




}
