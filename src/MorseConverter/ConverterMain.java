package MorseConverter;

import java.util.Scanner;

public class ConverterMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Välkommen! I detta program kan du fritt konvertera mellan ord och morsekod, morsekod till ord \nGår inte att kombinera bokstäver och morsekod");
        MorseConverter converter = new MorseConverter();


        while (true) {
            System.out.println("\nSkriv in ett ord eller morsekod för att konvertera. Skriv esc för att avsluta programmet");
            try {
                String convertedMessage = converter.universalConverter(scan.nextLine());

                if (convertedMessage == null) {
                    System.out.println("Avslutar programmet...");
                    break;
                }
                System.out.println("Resultat: " + convertedMessage);


            } catch (NullPointerException e) {
                System.out.println(e.getMessage());

            }
        }
    }

}
