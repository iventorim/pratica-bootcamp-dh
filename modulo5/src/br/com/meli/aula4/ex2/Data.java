package br.com.meli.aula4.ex2;

import java.time.LocalDate;
import java.time.temporal.TemporalField;

public class Data {

    int dia;
    int mes;
    int ano;

    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean isDataAtual() {
        LocalDate localDate = LocalDate.now();
        if(dia == localDate.getDayOfMonth() &&
        mes == localDate.getMonth().getValue() &&
        ano == localDate.getYear()) {
            return true;
        }else {
            return false;
        }
    }

    public void incrementaData() {
        LocalDate localDate = LocalDate.of(this.ano,this.mes,this.dia).plusDays(1);
        ano = localDate.getYear();
        mes = localDate.getMonth().getValue();
        dia = localDate.getDayOfMonth();
    }

    public static void main(String[] args) {
        Data data = new Data(28,6,2021);

        System.out.println(data.isDataAtual());
        data.incrementaData();
        System.out.println(data);
    }
}
