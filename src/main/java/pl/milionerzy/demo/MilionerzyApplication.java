package pl.milionerzy.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class MilionerzyApplication {
    KlasaUzytkowa klasaUzytkowa = new KlasaUzytkowa();


    public static void main(String[] args) throws IOException {

            SpringApplication.run(MilionerzyApplication.class, args);


    }

    @Bean
    public CommandLineRunner runApp(JdbcTemplate jdbcTemplate) throws IllegalStateException {

        KlasaUzytkowa klasaUzytkowa = new KlasaUzytkowa();

        String nazwaUzytkownika = "";
        boolean poprawneLogowanie = false;
//        Map<String, String> stringStringMap = odczytajDaneZPliku("src\\main\\resources\\plik.txt");

        String hasloUzytkownika = null;
        while (!poprawneLogowanie) {
            LoginService loginService = new LoginService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Witaj w grze Milionerzy");
            System.out.println("Podaj nazwe uzytkownika: ");
            nazwaUzytkownika = scanner.nextLine();
            System.out.println("Podaj haslo");
            hasloUzytkownika = scanner.nextLine();


            if (loginService.zalogujUzytkownika(nazwaUzytkownika, hasloUzytkownika)) {
                System.out.println("zalogowano jako uzytkownik");
                poprawneLogowanie = true;
            } else {
                System.out.println("Zla nazwa uzytkownika lub haslo");
            }
            User user1 = new User(nazwaUzytkownika, hasloUzytkownika);

        }
        User user1 = new User(nazwaUzytkownika, hasloUzytkownika);
        int liczbaPoprawnychOdpowiedzi = 0;

        String sql = "SELECT question, answer1, answer2, answer3, answer4, correctLetter FROM questionandanswer";

        List<Map<String, Object>> listaPytaniOdpowiedzi = jdbcTemplate.queryForList(sql);
        List<Question> lista = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : listaPytaniOdpowiedzi) {
            String question = (String) stringObjectMap.get("question");
            String answer1 = (String) stringObjectMap.get("answer1");
            String answer2 = (String) stringObjectMap.get("answer2");
            String answer3 = (String) stringObjectMap.get("answer3");
            String answer4 = (String) stringObjectMap.get("answer4");
            String correctLetter = (String) stringObjectMap.get("correctLetter");

            Question question1 = new Question(question, answer1, answer2, answer3, answer4, correctLetter);
            lista.add(question1);

        }
        for (Question question : lista) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int randomIndex = random.nextInt(lista.size());
            Question selectedQuestion = lista.get(randomIndex);

            char litera = 'A';

            //wyswietlamy pytanie
            System.out.println("Pytanie: " + selectedQuestion.getQuestion());

            //tworzymy liste odpowiedzi
            List<String> listaOdpowiedzi = new ArrayList<>();

            String prawidlowaLiteraOdpowiedzi = selectedQuestion.getCorrectLetter();
            int indexPoprawnejOdpowiedzi = klasaUzytkowa.indexOdpowiedziUzytkownika(prawidlowaLiteraOdpowiedzi);

            listaOdpowiedzi.add(selectedQuestion.getAnswer1());
            listaOdpowiedzi.add(selectedQuestion.getAnswer2());
            listaOdpowiedzi.add(selectedQuestion.getAnswer3());
            listaOdpowiedzi.add(selectedQuestion.getAnswer4());

            String prawidlowaOdpowiedz = listaOdpowiedzi.get(indexPoprawnejOdpowiedzi);

            Collections.shuffle(listaOdpowiedzi);

            String literaPrawidlowejOdpowiedzi = klasaUzytkowa.pobierzLiterePrawidlowejOdp(listaOdpowiedzi, prawidlowaOdpowiedz);

            for (String answer : listaOdpowiedzi) {
                System.out.println(litera + "." + answer + ", ");
                litera++;
            }

            String userChoice = scanner.nextLine();

            if (userChoice.equals(literaPrawidlowejOdpowiedzi)) {
                System.out.println("Brawo! to jest prawidlowa odpowiedz");
                liczbaPoprawnychOdpowiedzi++;
                Tabela_Kwota kwotaGwarantowana = Tabela_Kwota.values()[liczbaPoprawnychOdpowiedzi - 1];
                System.out.println("Brawo to poprawna odpwoiedz " + "Twoja liczba poprawnych odpowiedzi to: " + liczbaPoprawnychOdpowiedzi);
                System.out.println("Kwota gwarantowana to: " + kwotaGwarantowana.getKwota());

                if (liczbaPoprawnychOdpowiedzi == 12) {
                    user1.aktualizujWynik(Integer.parseInt(kwotaGwarantowana.getKwota()));
                    user1.zapiszWynikDoPliku(user1.getUserName());
                    break;
                }
            } else {
                System.out.println("To jest bledna odpowiedz. Przegrywasz");
                break;
            }

        }

        return null;
    }
}


 /*   private static Map<String, String> odczytajDaneZPliku(String sciezka) throws IOException {
        Map<String, String> credentials = new HashMap<>();

        Path path = Paths.get(sciezka);
        List<String> dane = Files.readAllLines(path);
        for (String s : dane) {
            String[] split = s.split(";");
            if (split.length == 2) {
                String userName = split[0];
                String password = split[1];

                credentials.put(userName, password);
            }
        }
        return credentials;
    }*/


