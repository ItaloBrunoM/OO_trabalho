package app;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import exceptions.DescricaoEmBrancoException;
import exceptions.ObjetoNaoEncontradoException;

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
            float valorNoturna, float valorMensal, float valorEvento, float retornoContratante, int capacidade) {
        Estacionamento e = new Estacionamento(nome, horarioAbertura, horarioFechamento, inicioNoturno, inicioDiurno,
                valorFracao, valorHora, valorDiurna, valorNoturna, valorMensal, valorEvento, retornoContratante,
                capacidade);
        return e;

    }

    public void cadastrarEvento() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento :");
        String dataInicio_ = JOptionPane.showInputDialog(null,
                "Insira a data de início do evento no formato dd/mm/aaaa :");
        String dataFim_ = JOptionPane.showInputDialog(null, "Insira a data do final do evento no formato dd/mm/aaaa :");
        String horaInicio_ = JOptionPane.showInputDialog(null,
                "Insira o horário de início do evento no formato hh:mm:");
        String horaFim_ = JOptionPane.showInputDialog(null, "Insira o horário de fim do evento no formato hh:mm :");
        if (nome.equalsIgnoreCase("") || dataInicio_.equalsIgnoreCase("") || dataFim_.equalsIgnoreCase("")
                || horaInicio_.equalsIgnoreCase("") | horaFim_.equalsIgnoreCase("")) {
            try {
                throw new DescricaoEmBrancoException();
            } catch (DescricaoEmBrancoException exc) {
                exc.printStackTrace();
            }
        }
        LocalDate dataInicio = LocalDate.parse(dataInicio_, formatoData);
        LocalDate dataFim = LocalDate.parse(dataFim_, formatoData);
        LocalTime horaInicio = LocalTime.parse(horaInicio_);
        LocalTime horaFim = LocalTime.parse(horaFim_);

        Evento e = null;
        e = Evento.criarEvento(nome, dataInicio, dataFim, horaInicio, horaFim);
        relatorioEvento(e);
        eventos.add(e);
    }

    public void relatorioEvento(Evento e) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String[] op = { "Ok", "Editar", "Apagar" };
        int escolha = JOptionPane.showOptionDialog(null,
                "Nome: " + e.getNome() +
                        "\nData de Início: " + e.getDataInicio().format(formatoData) +
                        "\nData de Fim: " + e.getDataFim().format(formatoData) +
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
                break;
        }
    }

    private void apagarEvento(Evento e) {
        eventos.remove(e);
        JOptionPane.showMessageDialog(null, "Evento apagado com sucesso!");
    }

    private void editarEvento(Evento e) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento :");
        String dataInicio_ = JOptionPane.showInputDialog(null,
                "Insira a data de início do evento no formato dd/mm/aaaa :");
        String dataFim_ = JOptionPane.showInputDialog(null, "Insira a data do final do evento no formato dd/mm/aaaa :");
        String horaInicio_ = JOptionPane.showInputDialog(null,
                "Insira o horário de início do evento no formato hh:mm:");
        String horaFim_ = JOptionPane.showInputDialog(null, "Insira o horário de fim do evento no formato hh:mm :");
        if (nome.equalsIgnoreCase("") || dataInicio_.equalsIgnoreCase("") || dataFim_.equalsIgnoreCase("")
                || horaInicio_.equalsIgnoreCase("") | horaFim_.equalsIgnoreCase("")) {
            try {
                throw new DescricaoEmBrancoException();
            } catch (DescricaoEmBrancoException exc) {
                exc.printStackTrace();
            }
        }
        LocalDate dataInicio = LocalDate.parse(dataInicio_, formatoData);
        LocalDate dataFim = LocalDate.parse(dataFim_, formatoData);
        LocalTime horaInicio = LocalTime.parse(horaInicio_, formatoData);
        LocalTime horaFim = LocalTime.parse(horaFim_, formatoData);

        e.setNome(nome);
        e.setDataInicio(dataInicio);
        e.setDataInicio(dataFim);
        e.setHoraInicio(horaInicio);
        e.setHoraFim(horaFim);
    }

    public Evento findEvento(String nome) throws ObjetoNaoEncontradoException {
        Evento resposta = null;
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                resposta = e;
            }
        }
        if (resposta == null) {
            throw new ObjetoNaoEncontradoException();
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
                String placa = JOptionPane.showInputDialog(null, "Insira a placa do acesso:");
                String dataEnt_ = JOptionPane.showInputDialog(null, "Insira a data de entrada no formato dd/mm/aaaa :");
                String dataSai_ = JOptionPane.showInputDialog(null, "Insira a data de saída no formato dd/mm/aaaa :");
                String horaEnt_ = JOptionPane.showInputDialog(null, "Insira o horário de entrada no formato hh:mm :");
                String horaSai_ = JOptionPane.showInputDialog(null, "Insira o horário de saída  no formato hh:mm :");
                if (placa.equalsIgnoreCase("") || dataEnt_.equalsIgnoreCase("") || dataSai_.equalsIgnoreCase("")
                        || horaEnt_.equalsIgnoreCase("") || horaSai_.equalsIgnoreCase("")) {
                    try {
                        throw new DescricaoEmBrancoException();
                    } catch (DescricaoEmBrancoException exc) {

                        exc.printStackTrace();
                    }
                }
                LocalDate dataEnt = LocalDate.parse(dataEnt_, formatoData);
                LocalDate dataSai = LocalDate.parse(dataSai_, formatoData);
                LocalTime horaEnt = LocalTime.parse(horaEnt_);
                LocalTime horaSai = LocalTime.parse(horaSai_);
                Duration deltaHorario = Duration.between(horaEnt, horaSai);
                if (horaEnt.isAfter(inicioNoturno) & horaSai.isBefore(inicioDiurno)) { 
                    float valorN = calcularValorAcesso("AcessoNoturno");
                    Acesso aN = new AcessoNoturno(placa, horaEnt, horaSai, dataEnt, dataSai, valorN);
                    relatorioAcesso(aN);
                    acessos.add(aN);
                } else if (deltaHorario.compareTo(Duration.ofHours(9)) >= 0) {
                    float valorD = calcularValorAcesso("AcessoDiurna");
                    Acesso aD = new AcessoDiurna(placa, horaEnt, horaSai, dataEnt, dataSai, valorD);
                    relatorioAcesso(aD);
                    acessos.add(aD);
                } else if (deltaHorario.compareTo(Duration.ofHours(9)) < 0) {
                    double minutos = deltaHorario.toMinutes();
                    int fracoesDe15 = (int) Math.ceil(minutos / 15.0);
                    int fracoesDeHora = 0;
                    if (fracoesDe15 >= 4) {
                        fracoesDeHora = fracoesDe15 / 4;
                        fracoesDe15 = fracoesDe15 - (fracoesDeHora * 4);
                    }
                    Duration erroHoraSaiFracao = Duration.between(horaEnt.plusMinutes(15 * fracoesDe15),horaSai).abs();
                    Duration erroHoraSaiHora = Duration.between(horaEnt.plusMinutes(60 * fracoesDeHora),horaSai).abs();
                    for (int i = 1; i <= fracoesDe15; i++) {
                        LocalTime horaSaiAtt = horaSai;
                        if (i - fracoesDe15 != 0) {
                            horaSaiAtt = (horaSai.plusMinutes(15 * (i - fracoesDe15))).plus(erroHoraSaiFracao);
                        }
                        LocalTime horaEntAtt = horaEnt.plusMinutes(15 * (i - 1));
                        float valorF = calcularValorAcesso("AcessoFracao");
                        AcessoFracao aF = new AcessoFracao(placa, horaEntAtt, horaSaiAtt, dataEnt, dataSai, valorF);
                        relatorioAcesso(aF);
                        acessos.add(aF);
                    }
                    for (int i = 1; i <= fracoesDeHora; i++) {
                        LocalTime horaSaiAtt = horaSai;
                        if (i - fracoesDeHora != 0) {
                            horaSaiAtt = (horaSai.plusMinutes(60 * (i - fracoesDeHora))).plus(erroHoraSaiHora);
                        }
                        LocalTime horaEntAtt = horaEnt.plusMinutes(60 * (i - 1));
                        float valorH = calcularValorAcesso("AcessoHora");
                        AcessoHora aH = new AcessoHora(placa, horaEntAtt, horaSaiAtt, dataEnt, dataSai, valorH);
                        relatorioAcesso(aH);
                        acessos.add(aH);
                    }
                }
                break;
            case 1:
                String placaMes = JOptionPane.showInputDialog(null, "Insira a placa do acesso :");
                String inicioMes_ = JOptionPane.showInputDialog(null,
                        "Insira a data de inicio do acesso mensal no formato dd/mm/aaaa :");
                String fimMes_ = JOptionPane.showInputDialog(null,
                        "Insira a data fim do acesso mensal no formato dd/mm/aaaa :");
                if (placaMes.equalsIgnoreCase("") || inicioMes_.equalsIgnoreCase("") || fimMes_.equalsIgnoreCase("")) {
                    try {
                        throw new DescricaoEmBrancoException();
                    } catch (DescricaoEmBrancoException exc) {
                        exc.printStackTrace();
                    }
                }
                LocalDate inicioMes = LocalDate.parse(inicioMes_, formatoData);
                LocalDate fimMes = LocalDate.parse(fimMes_, formatoData);
                float valorM = calcularValorAcesso("AcessoMensal");
                AcessoMensal aM = new AcessoMensal(placaMes, inicioMes, fimMes, valorM);
                relatorioAcesso(aM);
                acessos.add(aM);
                break;
            case 2:
                String placaEvento = JOptionPane.showInputDialog(null, "Insira a placa do acesso:");
                String[] menuEv = menuListaEventos();
                if (menuEv.length == 0) {
                    JOptionPane.showMessageDialog(null, "Não há nenhum evento cadastrado ainda, abrindo tela de cadastro de evento");
                    cadastrarEvento();
                }
                int numEvento = JOptionPane.showOptionDialog(null,
                        "Escolha um evento da lista",
                        "Escolha:",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        menuEv,
                        menuEv[0]);
                Evento evento = null;
                try {
                    evento = findEvento(menuEv[numEvento]);
                } catch (ObjetoNaoEncontradoException e1) {
                    e1.printStackTrace();
                }
                String dataEntEvento_ = JOptionPane.showInputDialog(null,
                        "Insira a data de entrada no formato dd/mm/aaaa :");
                String dataSaiEvento_ = JOptionPane.showInputDialog(null,
                        "Insira a data de saída no formato dd/mm/aaaa :");
                String horaEntEvento_ = JOptionPane.showInputDialog(null,
                        "Insira o horário de entrada no formato hh:mm :");
                String horaSaiEvento_ = JOptionPane.showInputDialog(null,
                        "Insira o horário de saída  no formato hh:mm :");

                if (placaEvento.equalsIgnoreCase("") || dataEntEvento_.equalsIgnoreCase("")
                        || dataSaiEvento_.equalsIgnoreCase("") || horaEntEvento_.equalsIgnoreCase("")
                        || horaSaiEvento_.equalsIgnoreCase("")) {
                    try {
                        throw new DescricaoEmBrancoException();
                    } catch (DescricaoEmBrancoException e) {
                        e.printStackTrace();
                    }
                }
                LocalDate dataEntEvento = LocalDate.parse(dataEntEvento_, formatoData);
                LocalDate dataSaiEvento = LocalDate.parse(dataSaiEvento_, formatoData);
                LocalTime horaEntEvento = LocalTime.parse(horaEntEvento_);
                LocalTime horaSaiEvento = LocalTime.parse(horaSaiEvento_);

                float valorE = calcularValorAcesso("AcessoEvento");
                ;
                AcessoEvento aE = new AcessoEvento(placaEvento, horaEntEvento, horaSaiEvento, dataEntEvento,
                        dataSaiEvento, valorE, evento);
                relatorioAcesso(aE);
                acessos.add(aE);
                break;
        }
    }

    private String[] menuListaEventos() {
        String[] listaEventos = new String[0];
        for (Evento e : eventos) {
            String[] temporario = new String[listaEventos.length + 1];
            for (int i = 0; i < listaEventos.length; i++) {
                temporario[i] = listaEventos[i];
            }
            temporario[listaEventos.length] = e.getNome();
            listaEventos = temporario;
        }
        return listaEventos;
    }

    private float calcularValorAcesso(String tipoAcesso) {
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

    public void findAcesso(String placa) throws ObjetoNaoEncontradoException {
        List<Acesso> respostas = new LinkedList<Acesso>();
        for (Acesso a : acessos) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                respostas.add(a);
            }
        }
        if (respostas.isEmpty()) {
            throw new ObjetoNaoEncontradoException();
        }
        JOptionPane.showMessageDialog(null, respostas.size() + " acessos encontrados para essa placa");
        for (Acesso a: respostas) {
            relatorioAcesso(a);
        }
        // return respostas;
    }

    public void relatorioAcesso(Acesso a) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String[] op = { "Ok", "Editar", "Apagar" };
        if (a.getClass().getSimpleName().equalsIgnoreCase("AcessoMensal")) {
            int escolha = JOptionPane.showOptionDialog(null,
                    "Placa: " + a.getPlaca() +
                            "\nTipo do Acesso: " + a.getClass().getSimpleName() +
                            "\nData de Entrada: " + a.getDataEnt().format(formatoData) +
                            "\nData de Saída: " + a.getDataSai().format(formatoData) +
                            "\nValor Cobrado: R$ " + a.getValor() +
                            "\nRendimento pro contratante: R$ " + a.getValor() * retornoContratante +
                            "\nRendimento pro contratado: R$ " + a.getValor() * (1 - retornoContratante),
                    "Relatório Acesso",
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
        } else if (a.getClass().getSimpleName().equalsIgnoreCase("AcessoEvento")) {
            int escolha = JOptionPane.showOptionDialog(null,
                    "Placa: " + a.getPlaca() +
                            "\nTipo do Acesso: " + a.getClass().getSimpleName() +
                            "\nEvento: " + ((AcessoEvento) a).getEvento().getNome() +
                            "\nData de Entrada: " + a.getDataEnt().format(formatoData) +
                            "\nData de Saída: " + a.getDataSai().format(formatoData) +
                            "\nHorário de Entrada: " + a.getHoraEnt().toString() +
                            "\nHorário de Saída: " + a.getHoraSai().toString() +
                            "\nValor Cobrado: R$ " + a.getValor() +
                            "\nRendimento pro contratante: R$ " + a.getValor() * retornoContratante +
                            "\nRendimento pro contratado: R$ " + a.getValor() * (1 - retornoContratante),
                    "Relatório Acesso",
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
        } else {
            int escolha = JOptionPane.showOptionDialog(null,
                    "Placa: " + a.getPlaca() +
                            "\nTipo do Acesso: " + a.getClass().getSimpleName() +
                            "\nData de Entrada: " + a.getDataEnt().format(formatoData) +
                            "\nData de Saída: " + a.getDataSai().format(formatoData) +
                            "\nHorário de Entrada: " + a.getHoraEnt().toString() +
                            "\nHorário de Saída: " + a.getHoraSai().toString() +
                            "\nValor Cobrado: R$ " + a.getValor() +
                            "\nRendimento pro contratante: R$ " + a.getValor() * retornoContratante +
                            "\nRendimento pro contratado: R$ " + a.getValor() * (1 - retornoContratante),
                    "Relatório Acesso",
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

    }

    private void apagarAcesso(Acesso a) {
        acessos.remove(a);
        JOptionPane.showMessageDialog(null, "Acesso apagado com sucesso!");
    }

    private void editarAcesso(Acesso a) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        if (a.getClass().getSimpleName().equalsIgnoreCase("AcessoMensal")) {
            String placaMes = JOptionPane.showInputDialog(null, "Insira a placa do acesso:");
            String inicioMes_ = JOptionPane.showInputDialog(null,
                    "Insira a data de inicio do acesso mensal no formato dd/mm/aaaa :");
            String fimMes_ = JOptionPane.showInputDialog(null,
                    "Insira a data fim do acesso mensal no formato dd/mm/aaaa :");
            if (placaMes.equalsIgnoreCase("") || inicioMes_.equalsIgnoreCase("") || fimMes_.equalsIgnoreCase("")) {
                try {
                    throw new DescricaoEmBrancoException();
                } catch (DescricaoEmBrancoException exc) {
                    exc.printStackTrace();
                }
            }
            LocalDate inicioMes = LocalDate.parse(inicioMes_, formatoData);
            LocalDate fimMes = LocalDate.parse(fimMes_, formatoData);
            float valorAtualizado = calcularValorAcesso("AcessoMensal");
            a.setPlaca(placaMes);
            a.setDataEnt(inicioMes);
            a.setDataSai(fimMes);
            a.setValor(valorAtualizado);
        } else {
            String placa = JOptionPane.showInputDialog(null, "Insira a placa do acesso:");
            String dataEnt_ = JOptionPane.showInputDialog(null, "Insira a data de entrada no formato dd/mm/aaaa :");
            String dataSai_ = JOptionPane.showInputDialog(null, "Insira a data de saída no formato dd/mm/aaaa :");
            String horaEnt_ = JOptionPane.showInputDialog(null, "Insira o horário de entrada no formato hh:mm :");
            String horaSai_ = JOptionPane.showInputDialog(null, "Insira o horário de saída  no formato hh:mm :");
            if (placa.equalsIgnoreCase("") || dataEnt_.equalsIgnoreCase("") || dataSai_.equalsIgnoreCase("")
                    || horaEnt_.equalsIgnoreCase("") || horaSai_.equalsIgnoreCase("")) {
                try {
                    throw new DescricaoEmBrancoException();
                } catch (DescricaoEmBrancoException e) {
                    e.printStackTrace();
                }
            }
            LocalDate dataEnt = LocalDate.parse(dataEnt_, formatoData);
            LocalDate dataSai = LocalDate.parse(dataSai_, formatoData);
            LocalTime horaEnt = LocalTime.parse(horaEnt_);
            LocalTime horaSai = LocalTime.parse(horaSai_);

            float valorAtualizado = calcularValorAcesso(a.getClass().getSimpleName());
            a.setPlaca(placa);
            a.setDataEnt(dataEnt);
            a.setDataSai(dataSai);
            a.setHoraEnt(horaEnt);
            a.setHoraSai(horaSai);
            a.setValor(valorAtualizado);
        }
    }

    public float calcularRetornoTotal () {
        float total = 0;
        for (Acesso a : acessos) {
            total += a.getValor();
        }
        return total;
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
