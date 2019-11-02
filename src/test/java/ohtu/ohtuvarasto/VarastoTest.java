package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenVarasto() {

        Varasto v = new Varasto(-12);

        assertEquals(0.0, v.paljonkoMahtuu(), vertailuTarkkuus);

    }

    @Test
    public void liikaaTavaraa() {

        varasto.lisaaVarastoon(100);

        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void yritetaanOttaaLiikaa() {

        varasto.lisaaVarastoon(3);

        varasto.otaVarastosta(5);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenSaldoLisays() {

        varasto.lisaaVarastoon(-12);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenSaldonOtto() {
        varasto.otaVarastosta(-12);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void oikeaMerkkijono() {
        varasto.lisaaVarastoon(5);

        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto.toString());
    }

    @Test
    public void tilavuusOikein() {

        Varasto v = new Varasto(10, 5);

        assertEquals(10, v.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkusaldoOikein() {

        Varasto v = new Varasto(10, 5);

        assertEquals(5.0, v.getSaldo(), vertailuTarkkuus);
        // korjattu testi

    }
    
    @Test
    public void negatiivinenVarasto2() {
        
        Varasto v = new Varasto(-10, 5);
        
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenSaldo2() {
        
        Varasto v = new Varasto(10, -5);
        
        assertEquals(0.0, v.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void liikaaSaldoa() {
        
        Varasto v = new Varasto(10, 5);
        
        v.lisaaVarastoon(12);
        
        assertEquals(10.0, v.getSaldo(), vertailuTarkkuus);
        
    }
}
