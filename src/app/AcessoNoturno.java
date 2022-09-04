package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoNoturno extends Acesso {
 
    private LocalTime horaEnt,
                      horaSai;

    public AcessoNoturno(String placa, LocalTime horaEnt, LocalTime horaSai, LocalDate dataEnt, LocalDate dataSai,
            float valor) {
        super(placa, horaEnt, horaSai, dataEnt, dataSai, valor);
    }

    }

