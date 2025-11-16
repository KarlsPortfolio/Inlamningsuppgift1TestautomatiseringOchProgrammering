package MorseConverter;

import java.util.Scanner;

public class ConverterMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Välkommen! I detta program kan du fritt konvertera mellan engelska till morsekod, morsekod till engelska \n" +
                "Bokstäver och morsekod kan inte kombineras");
        MorseConverter converter = new MorseConverter();


        while (true) {
            System.out.println("\nSkriv in ett ord/bokstav på engelska eller morsekod för att konvertera. " +
                    "Skriv esc för att avsluta programmet");
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
