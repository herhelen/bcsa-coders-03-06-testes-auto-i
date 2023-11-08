import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class PraticandoAssertivas {

    @Test
    public void praticandoAssertTrue() {
        boolean ehMaiorDeIdade = true;

        Assert.assertTrue(ehMaiorDeIdade);
    }

    @Test
    public void praticandoAssertFalse() {
        boolean foiReprovado = false;

        Assert.assertFalse(foiReprovado);
    }

    @Test
    public void praticandoAssertNull() {
        Carro carro = null;

        Assert.assertNull(carro);
    }

    @Test
    public void praticandoAssertNotNull() {
        Carro carro = new Carro();

        Assert.assertNotNull(carro);
    }

    @Test
    public void praticandoAssertArraysEquals() {
        int[] numA = new int[]{1, 2, 3}; // a ordem dos elementos do array é importante
        int[] numB = new int[]{1, 2, 3};

        Assert.assertArrayEquals(numA, numB);
    }

    @Test
    public void praticandoAssertEqualsPrimitivos() {
        int a = 1;
        int b = 1;

        Assert.assertEquals(a, b);

        char c = 'a';
        char d = 'a';

        Assert.assertEquals(c, d);

        Integer e = 1;
        Integer f = 1;

        Assert.assertEquals(e, f);

        Assert.assertEquals(0.515, 0.519, 0.01);
    }

    @Test
    public void praticandoAssertEqualsObjetos() {
        Carro carroA = new Carro("azul", "fiat", "uno");
        Carro carroB = new Carro("azul", "fiat", "uno");

        Assert.assertEquals(carroA, carroB);
    }

    @Test
    public void praticandoAssertEqualsStrings() {
        String nomeA = "ada";
        String nomeB = "ada";
        String nomeC = new String("ada");

        Assert.assertEquals(nomeA, nomeB);
        Assert.assertEquals(nomeA, nomeC);

        Assert.assertTrue(nomeA == nomeB); // == compara endereço de memória
        Assert.assertTrue(nomeA == nomeC);
    }


    @Test
    public void praticandoAssertNotEqualsPrimitivos() {
        int a = 1;
        int b = 2;

        Assert.assertNotEquals(a, b);
    }

    @Test
    public void praticandoAssertSame() {
        Carro carroA = new Carro();
        Carro carroB = carroA;

        Assert.assertSame(carroA, carroB);
    }

    @Test
    public void praticandoAssertNotSame() {
        Carro carroA = new Carro();
        Carro carroB = new Carro();

        Assert.assertNotSame(carroA, carroB);
    }

}
