package br.com.meli.aula4.dakar;

public class Main {

    public static void main(String[] args) {
        Corrida corrida = new Corrida(50000, 100000, "GP de Mônaco", 32);

        corrida.registrarCarro(300,100,30,"MLL0123");
        corrida.registrarCarro(160,30,180,"FUS1215");
        corrida.registrarCarro(260,50,60,"OIA1320");
        corrida.registrarCarro(300,80,30,"SEI2020");
        corrida.registrarMoto(120,60,180,"NAO8784");
        corrida.registrarMoto(100, 45,180, "IAE1045");

        corrida.removerVeiculoPorPlaca("MLL0123");

        Veiculo vencedor = corrida.obterVencendor();
        System.out.println("VENCEDOR: "+vencedor.placa);

        SocorristaCarro socorristaCarro = new SocorristaCarro();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        corrida.adicionarSocorrista(socorristaCarro);
        corrida.adicionarSocorrista(socorristaMoto);

        corrida.socorrerCarro("OIA1320");
    }

}
