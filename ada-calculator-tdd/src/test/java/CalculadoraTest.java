import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveSomarCorretamente() {
        Calculadora calculadora = new Calculadora();
        
        int a = 5;
        int b = 100;
        int resultado = calculadora.somar(a, b);

        Assertions.assertEquals(105, resultado);
    }

    @Test
    public void deveDividirCorretamente() {
        Calculadora calculadora = new Calculadora();

        int a = 100;
        int b = 20;
        int resultado = calculadora.dividir(a, b);

        Assertions.assertEquals(5, resultado);
    }
}
