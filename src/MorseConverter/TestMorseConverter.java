package MorseConverter;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMorseConverter {
    @Test
    public void convertAToMorse() {
        String expected = ".-";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("A");

        assertEquals(expected, actual);
    }

    @Test
    public void convertZToMorse() {
        String expected = "--..";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("Z");


        assertEquals(expected, actual);
    }

    @Test
    public void convertLettersToMorse() {
        String expected = ".- --.. ..- .-. .";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("AZURE");


        assertEquals(expected, actual);
    }

    @Test
    public void convertLettersToMorseLowerCase() {
        String expected = ".- --.. ..- .-. .";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("azure");

        assertEquals(expected, actual);
    }

    @Test
    public void convertLettersToMorseMixedCases() {
        String expected = ".... . .---";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("hEj");

        assertEquals(expected, actual);
    }

    @Test
    public void convertLettersToMorseSpecialSymbols() {
        String expected = "Endast bokstäver (A-Z) eller morsekod (kommatecken och punkt) accepteras\nBokstäver och morsekod kan inte kombineras.";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("!*?");

        assertEquals(expected, actual);
    }

    @Test
    public void convertMorseToLetter() {
        String expected = "HEJ";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter(".... . .---");

        assertEquals(expected, actual);
    }


    @Test
    public void convertMorseToWords() {
        String expected = "HELLOWORLD";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter(".... . .-.. .-.. --- .-- --- .-. .-.. -..");

        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessageConvertMorseWithIncorrectSymbols() {
        String expected = "Felaktig inmatning: Mata in bokstäver (A-Z) eller morsekord (Exempel: .-)";
        MorseConverter converter = new MorseConverter();

        Exception e = assertThrows(NullPointerException.class, () -> converter.universalConverter("...? !? : @ %"));
        String actual = e.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getErrorMessageConvertWordsWithIncorrectSymbols() {
        String expected = "Felaktig inmatning: Mata in bokstäver (A-Z) eller morsekord (Exempel: .-)";
        MorseConverter converter = new MorseConverter();

        Exception e = assertThrows(NullPointerException.class, () -> converter.universalConverter("Så Kan. det GÅ?"));
        String actual = e.getMessage();

        assertEquals(expected, actual);
    }


    @Test
    public void getExceptionConvertMorseWithIncorrectSymbols() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("...? !? : @ %"));
    }


    @Test
    public void convertWordsToMorseWithSpacesBetweenWords() {
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("HELLO WORLD");

        assertEquals(expected, actual);
    }

    @Test
    public void convertTwoWordsToMorseMixedCases() {
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("HellO WoRlD");

        assertEquals(expected, actual);
    }



    @Test
    public void convertWordsToMorseWithLargeSpacesBetweenWords() {
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("HELLO           WORLD");

        assertEquals(expected, actual);
    }

    @Test
    public void convertGeneralWordsToMorseWithIncorrectSymbolsMixed() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("HELLO_ W&ORLD   !H!"));

    }

    @Test
    public void convertGeneralMorseToWordsWithIncorrectSymbolsMixed() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("..! .-? ,"));

    }

    @Test
    public void convertMorseToWordsWithLettersMixedIn() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("..k .P -o -k"));

    }

    @Test
    public void convertWordsToMorseWithMorseMixedIn() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("ta-.ka b..len"));

    }

    @Test
    public void convertWithEmptySpaces() {
        String expected = "Endast bokstäver (A-Z) eller morsekod (kommatecken och punkt) accepteras\nBokstäver och morsekod kan inte kombineras.";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("             ");

        assertEquals(expected, actual);
    }

    @Test
    public void convertWordsToMorseWithIncorrectLetters() {
        String expected = "Endast bokstäver (A-Z) eller morsekod (kommatecken och punkt) accepteras\nBokstäver och morsekod kan inte kombineras.";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("ÅÄÖ");


        assertEquals(expected, actual);
    }

    @Test
    public void convertWordsToMorseWithIncorrectLettersMixedIn() {
        MorseConverter converter = new MorseConverter();
        assertThrows(NullPointerException.class, () -> converter.universalConverter("Så skär man lök"));

    }


    @Test
    public void convertConvertEmptyString() {
        String expected = "Endast bokstäver (A-Z) eller morsekod (kommatecken och punkt) accepteras\nBokstäver och morsekod kan inte kombineras.";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter("");


        assertEquals(expected, actual);
    }

    @Test
    public void convertMorseToWordsWithLargeSpacesBetweenInputs() {
        String expected = "APA";
        MorseConverter converter = new MorseConverter();

        String actual = converter.universalConverter(".-        .--.            .-");

        assertEquals(expected, actual);
    }

    @Test
    public void convertMorseToWordsIncorrectDots() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("..............."));

    }

    @Test
    public void convertMorseToWordsIncorrectHyphen() {
        MorseConverter converter = new MorseConverter();

        assertThrows(NullPointerException.class, () -> converter.universalConverter("------------------"));
    }

    @Test
    public void convertWhenEnteringEsc() {
        MorseConverter converter = new MorseConverter();

        assertNull(converter.universalConverter("esc"));

    }





}