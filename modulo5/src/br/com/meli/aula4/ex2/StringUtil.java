package br.com.meli.aula4.ex2;

public class StringUtil {

    public static String rpad(String s, char c, int n) {
        String part = "";
        for(int i = 0; i < n; i++) {
            part += Character.toString(c);
        }

        return s+part;
    }

    public static String ltrim(String s) {
        int contador = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                contador++;
            }else {
                break;
            }
        }
        return s.substring(contador);
    }

    public static String rtrim(String s) {
        int contador = s.length();
        for(int i = s.length() - 1; i > 0; i--) {
            if(s.charAt(i) == ' ') {
                contador--;
            }else {
                break;
            }
        }
        return s.substring(0,contador);
    }

    public static String trim(String s) {
        String result = rtrim(s);
        return ltrim(result);
    }

    public static int indexOfN(String s, char c, int n) {
        int contador = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                contador++;
            }

            if(contador == n) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ltrim("     oioioioi      "));
        System.out.println(rtrim("     oioioioi      "));
        System.out.println(trim("     oioioioi      "));
        System.out.println(rpad("oiiii",'e',5));
        System.out.println(indexOfN("John|Paul|George|Ringo",'|',2));
    }

}
