package pl.milionerzy.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KlasaUzytkowaTest {
    KlasaUzytkowa klasaUzytkowa = new KlasaUzytkowa();

    @Test
    public void testIndexOdpowiedziUzytkownika() {
        //given
        String inputUserChoice = "C";
        int expected = 2;
        //when
        int result = klasaUzytkowa.indexOdpowiedziUzytkownika(inputUserChoice);
        //then

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIndexOdpowiedziUzytkownika2() {
        //given
        String inputUserChoice = "A";
        int expected = 0;
        //when
        int result = klasaUzytkowa.indexOdpowiedziUzytkownika(inputUserChoice);
        //then

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIndexOdpowiedziUzytkownika3() {
        //given
        String inputUserChoice = null;
        int expected = 404;
        //when
        int result = klasaUzytkowa.indexOdpowiedziUzytkownika(inputUserChoice);
        //then

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIndexOdpowiedziUzytkownika4() {
        //given
        String inputUserChoice = "test";
        int expected = -1;
        //when
        int result = klasaUzytkowa.indexOdpowiedziUzytkownika(inputUserChoice);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPobierzLiterePrawidlowejOdp() {
        //given
        List<String> testowaLista = new ArrayList<>();

        String expected = "A";
        testowaLista.add("Java");
        testowaLista.add("jhkjhkhlk");
        testowaLista.add("asda");
        testowaLista.add("sadsada");

        //when
        String result = klasaUzytkowa.pobierzLiterePrawidlowejOdp(testowaLista, "Java");
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testZmienIndexNaLitere() {
        //given
        int cyfra = -1;
        String expected = "A";
        //when
        String result = klasaUzytkowa.zamienIndexNaLitere(cyfra);
        //then
        Assertions.assertEquals(expected, result);

    }
    @Test
    public void testZmienIndexNaLitere2() {
        //given
        int cyfra = -1;
        String expected = "Blad";
        //when
        String result = klasaUzytkowa.zamienIndexNaLitere(cyfra);
        //then
        Assertions.assertEquals(expected, result);

    }

}