package MorseConverter;
import java.util.HashMap;


public class MorseConverter {
    private HashMap<String, String> hashMap = new HashMap<>();


    public String convertInput(String input) {
        initializeHashMap();
        String output = this.hashMap.get(input);
        return output;
    }


    public void initializeHashMap() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        //Initiera en enda lång HashMap med nycklar och värden från båda hållen (alfabet -> morse, morse -> alfabet)
        for (int i = 0; i < alphabet.length(); i++) {
            this.hashMap.put(morse[i], Character.toString(alphabet.charAt(i)));
            this.hashMap.put(Character.toString(alphabet.charAt(i)), morse[i]);
        }

    }


    public String universalConverter(String input) {
        String output = "Endast bokstäver (A-Z) eller morsekod (kommatecken och punkt) accepteras\n" +
                "Bokstäver och morsekod kan inte kombineras";

        if (!input.trim().isBlank() && !input.trim().isEmpty()) {
            //Vid esc skickas null tillbaka och då avslutas programmet i main
            if (input.equalsIgnoreCase("esc")) {
                output = null;

                //Vid bokstav som första tecken initieras ett konverteringsläge från bokstav till morse
            } else if (Character.getNumericValue(input.charAt(0)) >= 10 && Character.getNumericValue(input.charAt(0)) <= 35) {
                String[] letters = input.split("");
                output = convertEachElement(letters, "letter");

                //Vid punkt eller bindestreck som första tecken initieras ett konverteringsläge från morse till bokstav
            } else if (input.contains(".") || input.contains("-")) {
                String[] morse = input.split(" ");
                output = convertEachElement(morse, "morse");
            }
        }

        return output;

    }


    public String convertEachElement(String[] arr, String convertType) {
        StringBuilder output = new StringBuilder("");
        boolean correctInput = false;

        for (int i = 0; i < arr.length; i++) {
            //Fortsätt vidare även om det förekommer tomma element
            if (arr[i].trim().isBlank() || arr[i].trim().isEmpty()) {
                correctInput = true;
            }
            //När element innehåller punkt eller bindestreck samt konvertering är av typen morse
            else if (arr[i].matches("^[-.]+$") && convertType.equalsIgnoreCase("morse")) {

                //Konvertera morse till bokstav om nyckel existerar
                if (convertInput(arr[i]) != null) {
                    output.append(convertInput(arr[i]));
                    correctInput = true;
                }

                //När element innehåller stora och små bokstäver (A-Z) samt konvertering är av typen letter
            } else if (arr[i].matches("^[A-Za-z]+$") && convertType.equalsIgnoreCase("letter")) {
                output.append(convertInput(arr[i].toUpperCase()));
                correctInput = true;

                //Lägg till mellanrum mellan varje morsekod, men inte på sista raden
                if (i != arr.length - 1) {
                    output.append(" ");
                }

                //Om det förekommer felaktig input i element blir inmatningen inte godkänd
            } else {
                correctInput = false;
            }

            //Om inmatningen inte är godkänd kastas en NullpointerException med felmeddelande.
            if (!correctInput) {
                throw new NullPointerException("Felaktig inmatning: Mata in bokstäver (A-Z) eller morsekord (Exempel: .-)");
            }
        }

        return output.toString().trim();
    }
}


