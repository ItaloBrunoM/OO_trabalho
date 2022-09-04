package app;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import exceptions.DescricaoEmBrancoException;

public class Estacionamento {
    private String nome;

    private LocalTime horarioAbertura,
            horarioFechamento,
            inicioNoturno,
            inicioDiurno;
    private float valorFracao,
            valorHora,
            valorDiurna,
            valorNoturna,
            valorMensal,
            valorEvento,
            retornoContratante;
    private int capacidade;

    private List<Acesso> acessos;

    private List<Evento> eventos;

    private Estacionamento(String nome, LocalTime horarioAbertura, LocalTime horarioFechamento, LocalTime inicioNoturno,
            LocalTime inicioDiurno, float valorFracao, float valorHora, float valorDiurna, float valorNoturna,
            float valorMensal, float valorEvento, float retornoContratante, int capacidade) {
        this.nome = nome;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.inicioNoturno = inicioNoturno;
        this.inicioDiurno = inicioDiurno;
        this.valorFracao = valorFracao;
        this.valorHora = valorHora;
        this.valorDiurna = valorDiurna;
        this.valorNoturna = valorNoturna;
        this.valorMensal = valorMensal;
        this.valorEvento = valorEvento;
        this.retornoContratante = retornoContratante;
        this.capacidade = capacidade;
        eventos = new LinkedList<Evento>();
        acessos = new LinkedList<Acesso>();
    }

    public static Estacionamento criarEstacionamento(String nome, LocalTime horarioAbertura,
            LocalTime horarioFechamento,
            LocalTime inicioNoturno, LocalTime inicioDiurno, float valorFracao, float valorHora, float valorDiurna,
            float valorNoturna, float valorMensal, float valorEvento, float retornoContratante, int capacidade)
            throws DescricaoEmBrancoException {
        Estacionamento e = new Estacionamento(nome, horarioAbertura, horarioFechamento, inicioNoturno, inicioDiurno,
                valorFracao, valorHora, valorDiurna, valorNoturna, valorMensal, valorEvento, retornoContratante,
                capacidade);
        return e;

    }

    public void cadastrarEvento() {
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento:");
        LocalDate dataInicio = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data de início do evento no formato dd/mm/aaaa::"));
        LocalDate dataFim = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data do final do evento no formato dd/mm/aaaa::"));
        LocalTime horaInicio = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de início do evento no formato hh:mm:"));
        LocalTime horaFim = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de fim do evento no formato hh:mm:"));
        Evento e = null;
        e = Evento.criarEvento(nome, dataInicio, dataFim, horaInicio, horaFim);
        relatorioEvento(e);
        eventos.add(e);
    }

    public void relatorioEvento(Evento e) {
        String[] op = { "Ok", "Editar", "Apagar" };
        int escolha = JOptionPane.showOptionDialog(null,
                "Nome: " + e.getNome() +
                        "\nData de Início: " + e.getDataInicio().toString() +
                        "\nData de Fim: " + e.getDataFim().toString() +
                        "\nHorário de Início: " + e.getHoraInicio().toString() +
                        "\nHorário de Fim: " + e.getHoraFim().toString(),
                "Relatório Evento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                op,
                op[0]);
        switch (escolha) {
            case 0:
                break;
            case 1:
                editarEvento(e);
                relatorioEvento(e);
                break;
            case 2:
                apagarEvento(e);
        }
    }

    private void apagarEvento(Evento e) {
        eventos.remove(e);
        JOptionPane.showMessageDialog(null, "Evento apagado com sucesso!");
    }

    private void editarEvento(Evento e) {
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento:");
        LocalDate dataInicio = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data de início do evento no formato dd/mm/aaaa::"));
        LocalDate dataFim = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data do final do evento no formato dd/mm/aaaa::"));
        LocalTime horaInicio = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de início do evento no formato hh:mm:"));
        LocalTime horaFim = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de fim do evento no formato hh:mm:"));
        e.setNome(nome);
        e.setDataInicio(dataInicio);
        e.setDataInicio(dataFim);
        e.setHoraInicio(horaInicio);
        e.setHoraFim(horaFim);
    }

    public Evento findEvento(String nome) {
        Evento resposta = null;
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                resposta = e;
            }
        }
        relatorioEvento(resposta);
        return resposta;
    }

    public void cadastrarAcesso() {
        String[] op = { "Padrão", "Mensal", "Por Evento" };
        int menu = JOptionPane.showOptionDialog(null,
                "Escolha o tipo de acesso:",
                "Escolha uma opção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                op,
                op[0]);
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        switch (menu) {
            case 0:
                String placa = JOptionPane.showInputDialog(null, "Insira a placa do veículo:");
                LocalDate dataEnt = LocalDate.parse(
                        JOptionPane.showInputDialog(null, "Insira a data de entrada no formato dd/mm/aaaa:"),
                        formatoData);
                LocalDate dataSai = LocalDate
                        .parse(JOptionPane.showInputDialog(null, "Insira a data de saída no formato dd/mm/aaaa:"),
                                formatoData);
                LocalTime horaEnt = LocalTime
                        .parse(JOptionPane.showInputDialog(null, "Insira o horário de entrada no formato hh:mm:"));
                LocalTime horaSai = LocalTime
                        .parse(JOptionPane.showInputDialog(null, "Insira o horário de saída  no formato hh:mm:"));
                Duration deltaHorario = Duration.between(horaEnt, horaSai);
                if (horaEnt.isAfter(inicioNoturno) & horaSai.isBefore(inicioDiurno)) {
                    float valorN = calcularValorAcesso("AcessoNoturno");
                    Acesso aN = new AcessoNoturno(placa, horaEnt, horaSai, dataEnt, dataSai, valorN);
                    acessos.add(aN);
                } else if (deltaHorario.compareTo(Duration.ofHours(9)) >= 0) {
                    float valorD = calcularValorAcesso("AcessoDiurno");
                    Acesso aD = new AcessoDiurna(placa, horaEnt, horaSai, dataEnt, dataSai, valorD);
                    acessos.add(aD);
                } else if (deltaHorario.compareTo(Duration.ofHours(9)) < 0) {
                    double minutos = deltaHorario.toMinutes();
                    int fracoesDe15 = (int) Math.ceil(minutos / 15);
                    int fracoesDeHora = 0;
                    if (fracoesDe15 >= 4) {
                        fracoesDeHora = fracoesDe15 / 4;
                    }
                    for (int i = 0; i < fracoesDe15; i++) {
                        float valorF = calcularValorAcesso("AcessoFracao");;
                        AcessoFracao aF = new AcessoFracao(placa, horaEnt, horaSai, dataEnt, dataSai, valorF);
                        acessos.add(aF);
                    }
                    for (int i = 0; i < fracoesDeHora; i++) {
                        float valorH = calcularValorAcesso("AcessoHora");
                        AcessoHora aH = new AcessoHora(placa, horaEnt, horaSai, dataEnt, dataSai, valorH);
                        acessos.add(aH);
                    }
                }
                break;
            case 1:
                String placaMes = JOptionPane.showInputDialog(null, "Insira a placa do veículo:");
                LocalDate inicioMes = LocalDate.parse(
                        JOptionPane.showInputDialog(null, "Insira a data de inicio do acesso mensal no formato dd/mm/aaaa:"),
                        formatoData);
                LocalDate fimMes = LocalDate
                        .parse(JOptionPane.showInputDialog(null, "Insira a data de fim do acesso mensal no formato dd/mm/aaaa:"),
                                formatoData);
                float valorM = calcularValorAcesso("AcessoMensal");
                AcessoMensal aM = new AcessoMensal(placaMes, inicioMes, fimMes, valorM);
                acessos.add(aM);
                break;
            case 2:
                String placaEvento = JOptionPane.showInputDialog(null, "Insira a placa do veículo:");  
                String nomeEvento = JOptionPane.showInputDialog(null, "Insira o nome do evento");
                Evento evento = findEvento(nomeEvento);
                LocalDate dataEntEvento = LocalDate.parse(
                        JOptionPane.showInputDialog(null, "Insira a data de entrada no formato dd/mm/aaaa:"),
                        formatoData);
                LocalDate dataSaiEvento = LocalDate
                        .parse(JOptionPane.showInputDialog(null, "Insira a data de saída no formato dd/mm/aaaa:"),
                                formatoData);
                LocalTime horaEntEvento = LocalTime
                .parse(JOptionPane.showInputDialog(null, "Insira o horário de entrada no formato hh:mm:"));
                LocalTime horaSaiEvento = LocalTime
                .parse(JOptionPane.showInputDialog(null, "Insira o horário de saída  no formato hh:mm:"));
                float valorE = calcularValorAcesso("AcessoEvento");;
                AcessoEvento aE = new AcessoEvento(placaEvento, horaEntEvento, horaSaiEvento, dataEntEvento, dataSaiEvento, valorE, evento);
                acessos.add(aE);
                break;
        }
    }

    private float calcularValorAcesso (String tipoAcesso) {
        float valor = 0;
        switch (tipoAcesso) {
            case "AcessoDiurna":
                valor = valorDiurna;
                break;
            case "AcessoEvento":
                valor = valorEvento;
                break;
            case "AcessoFracao":
                valor = valorFracao;
                break;
            case "AcessoHora":
                valor = valorHora;
                break;
            case "AcessoMensal":
                valor = valorMensal;
                break;
            case "AcessoNoturno":
                valor = valorDiurna * valorNoturna;
                break;
        }
        return valor;
        }
        

    public Acesso findAcesso(String placa) {
        Acesso resposta = null;
        for (Acesso a : acessos) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                resposta = a;
            }
        }
        relatorioAcesso(resposta);
        return resposta;
    }

    public void relatorioAcesso(Acesso a) {
        String[] op = { "Ok", "Editar", "Apagar" };
        int escolha = JOptionPane.showOptionDialog(null,
                "Placa: " + a.getPlaca() +
                "\nTipo do Acesso: " + a.getClass().getSimpleName() +
                        "\nData de Entrada: " + a.getDataEnt().toString() +
                        "\nData de Saída: " + a.getDataSai().toString() +
                        "\nHorário de Entrada: " + a.getHoraEnt().toString() +
                        "\nHorário de Saída: " + a.getHoraSai().toString() +
                        "\nValor Cobrado: R$ " + a.getValor(),
                "Relatório Evento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                op,
                op[0]);
        switch (escolha) {
            case 0:
                break;
            case 1:
                editarAcesso(a);
                relatorioAcesso(a);
                break;
            case 2:
                apagarAcesso(a);
    }
}

    private void apagarAcesso(Acesso a) {
        acessos.remove(a);
        JOptionPane.showMessageDialog(null, "Acesso apagado com sucesso!");
    }

    private void editarAcesso(Acesso a) {
        String placa = JOptionPane.showInputDialog(null, "Insira a placa do acesso:");
        LocalDate dataEnt = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data de início do evento no formato dd/mm/aaaa::"));
        LocalDate dataSai = LocalDate.parse(JOptionPane.showInputDialog(null, "Insira a data do final do evento no formato dd/mm/aaaa::"));
        LocalTime horaEnt = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de início do evento no formato hh:mm:"));
        LocalTime horaSai = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de fim do evento no formato hh:mm:"));
        float valorAtualizado = calcularValorAcesso(a.getClass().getSimpleName());
        a.setPlaca(placa);
        a.setDataEnt(dataEnt);
        a.setDataSai(dataSai);
        a.setHoraEnt(horaEnt);
        a.setHoraSai(horaSai);
        a.setValor(valorAtualizado);
    }

    public String getNome() {
        return nome;
    }

    public LocalTime getHorarioAbertura() {
        return horarioAbertura;
    }

    public LocalTime getHorarioFechamento() {
        return horarioFechamento;
    }

    public LocalTime getInicioNoturno() {
        return inicioNoturno;
    }

    public LocalTime getInicioDiurno() {
        return inicioDiurno;
    }

    public float getValorFracao() {
        return valorFracao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public float getValorDiurna() {
        return valorDiurna;
    }

    public float getValorNoturna() {
        return valorNoturna;
    }

    public float getValorMensal() {
        return valorMensal;
    }

    public float getValorEvento() {
        return valorEvento;
    }

    public float getRetornoContratante() {
        return retornoContratante;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorarioAbertura(LocalTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public void setInicioNoturno(LocalTime inicioNoturno) {
        this.inicioNoturno = inicioNoturno;
    }

    public void setInicioDiurno(LocalTime inicioDiurno) {
        this.inicioDiurno = inicioDiurno;
    }

    public void setValorFracao(float valorFracao) {
        this.valorFracao = valorFracao;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public void setValorDiurna(float valorDiurna) {
        this.valorDiurna = valorDiurna;
    }

    public void setValorNoturna(float valorNoturna) {
        this.valorNoturna = valorNoturna;
    }

    public void setValorMensal(float valorMensal) {
        this.valorMensal = valorMensal;
    }

    public void setValorEvento(float valorEvento) {
        this.valorEvento = valorEvento;
    }

    public void setRetornoContratante(float retornoContratante) {
        this.retornoContratante = retornoContratante;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
