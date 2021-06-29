package br.com.meli.aula4.ex2;

import java.math.BigDecimal;

public class ContaCorrente {

    private String numero;

    private String titular;

    private BigDecimal saldo;

    public ContaCorrente() {
        this.saldo = new BigDecimal(0);
    }

    public ContaCorrente(String numero, String titular, BigDecimal saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public ContaCorrente(ContaCorrente contaCorrente) {
        this.numero = contaCorrente.numero;
        this.saldo = contaCorrente.saldo;
        this.titular = contaCorrente.titular;
    }

    public void deposito(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void saque(BigDecimal valor) {
        if (saldo.subtract(valor).signum() > 0) {
           saldo = saldo.subtract(valor);
        }else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void devolucao(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void transferencia(ContaCorrente conta, BigDecimal valor) {
        if (saldo.subtract(valor).signum() > 0) {
            saldo = this.saldo.subtract(valor);
            conta.deposito(valor);
        }else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente("875500-0","Igor Ventorim",new BigDecimal(50000));
        ContaCorrente cc2 = new ContaCorrente("000001-0","Meli",new BigDecimal(10000));

        cc1.deposito(new BigDecimal(10000));
        cc2.saque(new BigDecimal(5000));
        cc1.transferencia(cc2, new BigDecimal(1000));
        System.out.println("Saldo conta1 R$ "+cc1.getSaldo().doubleValue());
        System.out.println("Saldo conta2 R$ "+cc2.getSaldo().doubleValue());
    }
}
