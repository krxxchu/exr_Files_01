import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //blok odpowiedzialny za wczytywanie oraz wyświetlenie pliku, do 24 linijki
        try {
            File file = new File("F:\\Pobrane Google Chrome\\fragment.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linia;
            while ((linia = bufferedReader.readLine()) != null) {
                System.out.println(linia);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie udało się wczytać danych");
        }System.out.println();


        System.out.println("Podaj słowo do sprawdzenia występowania w pliku");
        Scanner scanner1 = new Scanner(System.in);
        String mojeSlowo = scanner1.nextLine();
        try {

            File file = new File("F:\\Pobrane Google Chrome\\fragment.txt");
            Scanner scanner = new Scanner(file);

            int iloscWyrazow = 0;
            int liczbaZnakow = 0;
            boolean czyZawiera = false;
            List<String> listaWersow = new ArrayList<>();
            while (scanner.hasNext()) {
//                String slowo = scanner.next();
                String wers = scanner.nextLine();
                listaWersow.add(wers);
                liczbaZnakow += wers.length();
//                System.out.println(slowo);
                if (wers.toLowerCase().contains(mojeSlowo)) {
                    czyZawiera = true;
                    System.out.println("numer wersu zawierającego Twoje słowo: " + listaWersow.indexOf(wers) + ", brzmienie wersu to:  " + wers);
                }

//               iloscWyrazow++;
            }
            System.out.println();
            System.out.println("Ilosc wyrazów w pliku wynosi: " + iloscWyrazow);
            if(czyZawiera) {
                System.out.println("Plik zawiera wskazane przez Ciebie słowo");
            } else {
                System.out.println("Plik nie zawiera wskazanego słowa");
            }
        } catch (FileNotFoundException e) {
            System.out.println("nie znaleziono pliku");;
        }
        System.out.println();

    }
}