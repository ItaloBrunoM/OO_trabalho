package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class Acesso {
    String placa;
    LocalDate dataEnt,
            dataSai;
    private LocalTime horaEnt,
            horaSai;
    float valor;

    Acesso(String placa, LocalTime horaEnt, LocalTime horaSai, LocalDate dataEnt, LocalDate dataSai, float valor) {
        this.placa = placa;
        this.horaEnt = horaEnt;
        this.horaSai = horaSai;
        this.dataEnt = dataEnt;
        this.dataSai = dataSai;
        this.valor = valor;
    }

    Acesso(String placa, LocalDate dataEnt, LocalDate dataSai, float valor) {
        this.placa = placa;
        this.dataEnt = dataEnt;
        this.dataSai = dataSai;
        this.valor = valor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setDataEnt(LocalDate dataEnt) {
        this.dataEnt = dataEnt;
    }

    public void setDataSai(LocalDate dataSai) {
        this.dataSai = dataSai;
    }

    public void setHoraEnt(LocalTime horaEnt) {
        this.horaEnt = horaEnt;
    }

    public void setHoraSai(LocalTime horaSai) {
        this.horaSai = horaSai;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDate getDataEnt() {
        return dataEnt;
    }

    public LocalDate getDataSai() {
        return dataSai;
    }

    public LocalTime getHoraEnt() {
        return horaEnt;
    }

    public LocalTime getHoraSai() {
        return horaSai;
    }

    public float getValor() {
        return valor;
    }

}
