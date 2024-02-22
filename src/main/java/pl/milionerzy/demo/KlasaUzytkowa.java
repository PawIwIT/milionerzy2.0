package pl.milionerzy.demo;

import java.util.List;

public class KlasaUzytkowa {
    public String pobierzLiterePrawidlowejOdp(List<String> listaOdpowiedzi, String prawidlowaOdpowiedz) {
        //przeszukanie listy w poszukiwaniu odpowiedzi pasujacej do prawidlowej odpowiedzi i zapisuje
        //index prawidlowej odpowiedzi do zmiennej
        String literaPrawidlowejOdpowiedzi = "";
        for (int i = 0; i < listaOdpowiedzi.size(); i++) {
            String s = listaOdpowiedzi.get(i);
            if (s.equals(prawidlowaOdpowiedz)) {
                literaPrawidlowejOdpowiedzi = zamienIndexNaLitere(i);
                break;
            }
        }
        return literaPrawidlowejOdpowiedzi;
    }

    public int indexOdpowiedziUzytkownika(String userChoice) {
        if (userChoice == null) {
            return 404;
        }
        return switch (userChoice) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            default -> -1;
        };
    }

    public String zamienIndexNaLitere(int index) {
        switch (index) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            default : return "Blad";
        }

    }
}
