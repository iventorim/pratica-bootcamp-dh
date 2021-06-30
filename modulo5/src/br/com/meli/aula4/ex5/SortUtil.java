package br.com.meli.aula4.ex5;

import java.util.Arrays;

public class SortUtil {

    public static <T> Precedente<T>[] sort(Precedente<T>[] arr){
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j].precedeA(arr[j+1].getTipo()) > 0)
                    {
                        Precedente<T> temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }

            return arr;
    }

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];
        pessoas[0] = new Pessoa("João","111.111.111-31");
        pessoas[1] = new Pessoa("André","111.111.111-31");
        pessoas[2] = new Pessoa("Igor","111.111.111-31");

        sort(pessoas);
        Arrays.asList(pessoas).forEach( p -> System.out.println(p.getNome()));

        Celular[] celular = new Celular[3];
        celular[0] = new Celular("Igor", "997222028");
        celular[1] = new Celular("José Roela", "999202612");
        celular[2] = new Celular("José Mané", "30644756");

        sort(celular);
        Arrays.asList(celular).forEach( c -> System.out.println(c.getNumber()));
    }

}
