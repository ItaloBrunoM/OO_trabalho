package app;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import exceptions.DescricaoEmBrancoException;
import exceptions.ObjetoNaoEncontradoException;

import java.time.LocalTime;

public class GerenciadorEstacionamentos {
    List<Estacionamento> estacionamentos;

    public GerenciadorEstacionamentos() {
        estacionamentos = new LinkedList<Estacionamento>();
    }

    public void cadastrarEstacionamento() throws DescricaoEmBrancoException {
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do estacionamento:");
        String capacidade_ = JOptionPane.showInputDialog(null, "Insira a capacidade do estacionamento:");
        String inicioNoturno_ = JOptionPane.showInputDialog(null,
                "Insira o horário de início do período noturno do estacionamento no formato hh:mm :");
        String inicioDiurno_ = JOptionPane.showInputDialog(null,
                "Insira o horário de início do período diurno do estacionamento no formato hh:mm :");
        String horarioAbertura_ = JOptionPane.showInputDialog(null, "Insira o horário de abertura do estacionamento no formato hh:mm :");
        String horarioFechamento_ = JOptionPane.showInputDialog(null,
                "Insira o horário de fechamento do estacionamento no formato hh:mm :");
        String valorFracao_ = JOptionPane.showInputDialog(null,
                "Insira o valor da fração de 15 min do estacionamento:");
        String valorHora_ = JOptionPane.showInputDialog(null, "Insira o valor da hora cheia do estacionamento:");
        String valorDiurna_ = JOptionPane.showInputDialog(null, "Insira o valor da diária diurna do estacionamento:");
        String valorNoturna_ = JOptionPane.showInputDialog(null,
                "Insira o valor da porcentagem da diária noturna do estacionamento em decimal:");
        float valorMensal = Float
                .parseFloat(JOptionPane.showInputDialog(null, "Insira o valor do acesso mensal do estacionamento:"));
        float valorEvento = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Insira o valor do acesso por evento do estacionamento:"));
        float retornoContratante = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Insira o valor do retorno do contratante do estacionamento:"));
        if (capacidade_.equalsIgnoreCase("") || valorFracao_.equalsIgnoreCase("") || valorHora_.equalsIgnoreCase("")
                || valorDiurna_.equalsIgnoreCase("") || valorNoturna_.equalsIgnoreCase("")
                || inicioDiurno_.equalsIgnoreCase("") || inicioNoturno_.equalsIgnoreCase("")
                || horarioAbertura_.equalsIgnoreCase("") || horarioFechamento_.equalsIgnoreCase("")) {
            throw new DescricaoEmBrancoException();
        }
        int capacidade = Integer.parseInt(capacidade_);
        float valorFracao = Float.parseFloat(valorFracao_);
        float valorHora = Float.parseFloat(valorHora_);
        float valorDiurna = Float.parseFloat(valorDiurna_);
        float valorNoturna = Float.parseFloat(valorNoturna_);
        LocalTime inicioNoturno = LocalTime.parse(inicioNoturno_);
        LocalTime inicioDiurno = LocalTime.parse(inicioDiurno_);
        LocalTime horarioAbertura = LocalTime.parse(horarioAbertura_);
        LocalTime horarioFechamento = LocalTime.parse(horarioFechamento_);

        Estacionamento e = null;

        e = Estacionamento.criarEstacionamento(nome, horarioAbertura, horarioFechamento, inicioNoturno,
                inicioDiurno, valorFracao, valorHora, valorDiurna, valorNoturna, valorMensal, valorEvento,
                retornoContratante, capacidade);

        estacionamentos.add(e);
        relatorioEstacionamento(e);

    }

    private void editarEstacionamento(Estacionamento e) {
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do estacionamento:");
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a capacidade do estacionamento:"));
        LocalTime inicioNoturno = LocalTime.parse(
                JOptionPane.showInputDialog(null, "Insira o horário de início do período noturno do estacionamento no formato hh:mm :"));
        LocalTime inicioDiurno = LocalTime.parse(
                JOptionPane.showInputDialog(null, "Insira o horário de início do período diurno do estacionamento no formato hh:mm :"));
        LocalTime horarioAbertura = LocalTime
                .parse(JOptionPane.showInputDialog(null, "Insira o horário de abertura do estacionamento no formato hh:mm :"));
        LocalTime horarioFechamento = LocalTime
                .parse(JOptionPane.showInputDialog(null, "Insira o horário de fechamento do estacionamento no formato hh:mm :"));
        float valorFracao = Float
                .parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da fração de 15 min do estacionamento:"));
        float valorHora = Float
                .parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da hora cheia do estacionamento:"));
        float valorDiurna = Float
                .parseFloat(JOptionPane.showInputDialog(null, "Insira o valor da diária diurna do estacionamento:"));
        float valorNoturna = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Insira o valor da porcentagem diária noturna do estacionamento em decimal:"));
        float valorMensal = Float
                .parseFloat(JOptionPane.showInputDialog(null, "Insira o valor do acesso mensal do estacionamento:"));
        float valorEvento = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Insira o valor do acesso por evento do estacionamento:"));
        float retornoContratante = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Insira o valor do retorno do contratante do estacionamento:"));
        e.setNome(nome);
        e.setCapacidade(capacidade);
        e.setInicioNoturno(inicioNoturno);
        e.setInicioDiurno(inicioDiurno);
        e.setHorarioAbertura(horarioAbertura);
        e.setHorarioFechamento(horarioFechamento);
        e.setValorFracao(valorFracao);
        e.setValorHora(valorHora);
        e.setValorDiurna(valorDiurna);
        e.setValorNoturna(valorNoturna);
        e.setValorMensal(valorMensal);
        e.setValorEvento(valorEvento);
        e.setRetornoContratante(retornoContratante);
    }

    public void relatorioEstacionamento(Estacionamento e) {
        String[] op = { "Ok", "Editar", "Apagar" };
        int escolha = JOptionPane.showOptionDialog(null,
                "Nome: " + e.getNome() +
                        "\nHorário de Abertura: " + e.getHorarioAbertura() +
                        "\nHorário de Fechamento: " + e.getHorarioFechamento() +
                        "\nInício Noturno: " + e.getInicioNoturno() +
                        "\nInício Diurno: " + e.getInicioDiurno() +
                        "\nValor Fração de Hora: " + e.getValorFracao() +
                        "\nValor Hora Cheia: " + e.getValorHora() +
                        "\nValor Diária Diurna: " + e.getValorDiurna() +
                        "\nValor Diária Noturna: " + e.getValorNoturna() +
                        "\nValor Mensal: " + e.getValorMensal() +
                        "\nValor Acesso por Evento: " + e.getValorEvento() +
                        "\nCapacidade: " + e.getCapacidade() +
                        "\nPorcentagem de retorno do contratante: " + e.getRetornoContratante() +
                        "\nRendimento total pro contratante " + e.calcularRetornoTotal() * e.getRetornoContratante()+
                        "\nRendimento total pro contratado " + e.calcularRetornoTotal() * (1 - e.getRetornoContratante()),
                "Relatório Estacionamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                op,
                op[0]);
        switch (escolha) {
            case 0:
                break;
            case 1:
                editarEstacionamento(e);
                relatorioEstacionamento(e);
                break;
            case 2:
                apagarEstacionamento(e);
        }
    }

    private void apagarEstacionamento(Estacionamento e) {
        estacionamentos.remove(e);
        JOptionPane.showMessageDialog(null, "Estacionamento apagado com sucesso!");
    };

    public Estacionamento findEstacionamento(String nome) throws ObjetoNaoEncontradoException {
        Estacionamento resposta = null;
        for (Estacionamento e : estacionamentos) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                resposta = e;
            }
        }
        if (resposta == null) {
            throw new ObjetoNaoEncontradoException();
        }
        return resposta;
    }
}
