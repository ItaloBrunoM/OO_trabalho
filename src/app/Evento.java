package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    String nome;
    LocalDate dataInicio,
              dataFim;
    LocalTime horaInicio,
              horaFim;

    private Evento (String nome, LocalDate dataInicio, LocalDate dataFim, LocalTime horaInicio, LocalTime horaFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public static Evento criarEvento (String nome, LocalDate dataInicio, LocalDate dataFim, LocalTime horaInicio, LocalTime horaFim) {
        Evento e = new Evento(nome, dataInicio, dataFim, horaInicio, horaFim);
        return e;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
    
}
