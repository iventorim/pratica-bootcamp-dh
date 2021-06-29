package br.com.meli.aula4.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {

    private Map<Integer, List<Vestuario>> items = new HashMap<>();

    private Integer contador = 0;

    public Integer guardarVestuarios(List<Vestuario> listaDeVestuario) {
        contador++;
        items.put(contador,listaDeVestuario);
        return contador;
    }

    public void mostrarVestuarios() {
        items.forEach((k,v) -> printVestuario(k,v));
    }

    private void printVestuario(Integer k, List<Vestuario> v) {
        System.out.println("Indentificador: "+k.toString());
        v.forEach(System.out::println);
    }

    public List<Vestuario> devolverVestuarios(Integer id) {
        return items.get(id);
    }


}
