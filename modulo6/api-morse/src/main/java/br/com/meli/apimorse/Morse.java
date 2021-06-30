package br.com.meli.apimorse;

public class Morse {

    private static final class Simbolo {

        public final char normal;
        public final String morse;

        Simbolo(char normal, String morse) {
            this.normal = normal;
            this.morse = morse;
        }
    }

    private static final Simbolo[] SIMBOLOS = new Simbolo[] {
            new Simbolo('A', ".-"),
            new Simbolo('B', "-..."),
            new Simbolo('C', "-.-."),
            new Simbolo('D', "-.."),
            new Simbolo('E', "."),
            new Simbolo('F', "..-."),
            new Simbolo('G', "--."),
            new Simbolo('H', "...."),
            new Simbolo('I', ".."),
            new Simbolo('J', ".---"),
            new Simbolo('K', "-.-"),
            new Simbolo('L', ".-.."),
            new Simbolo('M', "--"),
            new Simbolo('N', "-."),
            new Simbolo('O', "---"),
            new Simbolo('P', ".--."),
            new Simbolo('Q', "--.-"),
            new Simbolo('R', ".-."),
            new Simbolo('S', "..."),
            new Simbolo('T', "-"),
            new Simbolo('U', "..-"),
            new Simbolo('V', "...-"),
            new Simbolo('W', ".--"),
            new Simbolo('X', "-..-"),
            new Simbolo('Y', "-.--"),
            new Simbolo('Z', "--.."),
            new Simbolo('0', "-----"),
            new Simbolo('1', ".---"),
            new Simbolo('2', "..---"),
            new Simbolo('3', "...--"),
            new Simbolo('4', "....-"),
            new Simbolo('5', "....."),
            new Simbolo('6', "-...."),
            new Simbolo('7', "--..."),
            new Simbolo('8', "---.."),
            new Simbolo('9', "----."),
            new Simbolo(' ', "   ")
    };

    public static String morse(String normal) {
        StringBuilder textMorse = new StringBuilder();
        for (char letraNormal : normal.toUpperCase().toCharArray()) {
            if (textMorse.length() > 0) {
                textMorse.append(" ");
            }
            textMorse.append(letraMorse(letraNormal));
        }
        return textMorse.toString();
    }

    public static String normal(String morse) {
        StringBuilder textNormal = new StringBuilder();
        String[] palavrasMorse = morse.split("\\Q   \\E");
        for (String palavraMorse : palavrasMorse) {
            if (textNormal.length() > 0) {
                textNormal.append(" ");
            }
            String[] letrasMorse = palavraMorse.trim().split(" ");
            for (String letraMorse : letrasMorse) {
                textNormal.append(letraNormal(letraMorse));
            }
        }
        return textNormal.toString();
    }

    private static String letraMorse(char normal) {
        for (Simbolo simbolo : SIMBOLOS) {
            if (simbolo.normal == normal) {
                return simbolo.morse;
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + normal + "\"");
    }

    private static char letraNormal(String morse) {
        for (Simbolo simbolo : SIMBOLOS) {
            if (simbolo.morse.equals(morse)) {
                return simbolo.normal;
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + morse + "\"");
    }

    private Morse() {}
}
