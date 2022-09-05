package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoHora extends Acesso {

    private LocalTime horaEnt,
            horaSai;

    public AcessoHora(String placa, LocalTime horaEnt, LocalTime horaSai, LocalDate dataEnt, LocalDate dataSai,
            float valor) {
        super(placa, horaEnt, horaSai, dataEnt, dataSai, valor);
    }

}
