import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HemogramaAnalyzerTest {
    private HemogramaAnalyzer analyzer;

    @Before
    public void setUp() {
        analyzer = new HemogramaAnalyzer();
    }

    @After
    public void tearDown() {
        analyzer = null;
    }

    @Test
    public void testCalcularHb() {
        assertEquals(1.5, analyzer.calcularHb(15, 10), 0.001);
        assertEquals(2.0, analyzer.calcularHb(20, 10), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularHbComHematocritoZero() {
        analyzer.calcularHb(15, 0);
    }

    @Test
    public void testCalcularVCM() {
        assertEquals(90.0, analyzer.calcularVCM(45, 5), 0.001);
        assertEquals(80.0, analyzer.calcularVCM(40, 5), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularVCMComNumeroEritrocitosZero() {
        analyzer.calcularVCM(45, 0);
    }

    @Test
    public void testAnalisarHemograma() {
        String resultado = analyzer.analisarHemograma(15, 45, 5);
        assertEquals("Hemoglobina Média: 0.33, VCM: 90.00", resultado);
    }
}
