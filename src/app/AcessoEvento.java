package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoEvento extends Acesso{

    Evento evento;

    public AcessoEvento(String placa, LocalTime horaEnt, LocalTime horaSai, LocalDate dataEnt, LocalDate dataSai,
            float valor, Evento evento) {
        super(placa, horaEnt, horaSai, dataEnt, dataSai, valor);
        this.evento = evento;
    }


    
}
