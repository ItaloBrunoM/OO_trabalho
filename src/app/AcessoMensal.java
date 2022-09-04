package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoMensal extends Acesso{

    public AcessoMensal(String placa, LocalDate dataEnt, LocalDate dataSai, float valor) {
        super(placa, dataEnt, dataSai, valor);

    }

}
