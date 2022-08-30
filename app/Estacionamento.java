package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import exceptions.DescricaoEmBrancoException;

public class Estacionamento {
    private String nome,
           horarioAbertura,
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

    private List<Evento> eventos;

    private Estacionamento(String nome, String horarioAbertura, String horarioFechamento, String inicioNoturno, String inicioDiurno, float valorFracao, float valorHora, float valorDiurna, float valorNoturna, float valorMensal, float valorEvento, float retornoContratante, int capacidade) {
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
    }

    public static Estacionamento criarEstacionamento(String nome, String horarioAbertura, String horarioFechamento, String inicioNoturno, String inicioDiurno, float valorFracao, float valorHora, float valorDiurna, float valorNoturna, float valorMensal, float valorEvento, float retornoContratante, int capacidade ) throws DescricaoEmBrancoException{
        Estacionamento e = new Estacionamento(nome, horarioAbertura, horarioFechamento, inicioNoturno, inicioDiurno, valorFracao, valorHora, valorDiurna, valorNoturna, valorMensal, valorEvento, retornoContratante, capacidade);
        return e;

    }

    public void cadastrarEvento () {
       String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento:");
       String data = JOptionPane.showInputDialog(null, "Insira a data do evento:");
       String horaInicio = JOptionPane.showInputDialog(null, "Insira o horário de início do evento:");
       String horaFim = JOptionPane.showInputDialog(null, "Insira o horário de fim do evento:");
       Evento e = null;
       e = Evento.criarEvento(nome, data, horaInicio, horaFim);
       relatorioEvento(e);
       eventos.add(e);
    }

    public void relatorioEvento(Evento e) {
            String [] op = {"Ok", "Editar", "Apagar"};
            int escolha = JOptionPane.showOptionDialog(null,
                                        "Nome: "+ e.getNome() +
                                        "\nData: " + e.getData() +
                                        "\nHorário de Início: " + e.getHoraInicio() +
                                        "\nHorário de Fim: " + e.getHoraFim(), 
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
    
    private void editarEvento (Evento e) {
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do evento:");
       String data = JOptionPane.showInputDialog(null, "Insira a data do evento:");
       String horaInicio = JOptionPane.showInputDialog(null, "Insira o horário de início do evento:");
       String horaFim = JOptionPane.showInputDialog(null, "Insira o horário de fim do evento:");
       e.setNome(nome);
       e.setData(data);
       e.setHoraInicio(horaInicio);
       e.setHoraFim(horaFim);
    }

    public void findEvento(String nome) {
        Evento resposta = null;
        for(Evento e:eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                resposta = e;
            }
        }
        relatorioEvento(resposta);
    }

    public String getNome() {
        return nome;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public String getInicioNoturno() {
        return inicioNoturno;
    }

    public String getInicioDiurno() {
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

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public void setInicioNoturno(String inicioNoturno) {
        this.inicioNoturno = inicioNoturno;
    }

    public void setInicioDiurno(String inicioDiurno) {
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
 