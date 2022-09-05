package ui;

import javax.swing.JOptionPane;

import app.Estacionamento;
import app.GerenciadorEstacionamentos;
import exceptions.DescricaoEmBrancoException;
import exceptions.ObjetoNaoEncontradoException;

public class Principal {

    public static void main(String[] Args) {
        GerenciadorEstacionamentos gerenciador = new GerenciadorEstacionamentos();
        int escolha;
        String[] op1 = { "Criar novo estacionamento", "Acessar estacionamento existente", "Sair" };

        do {
            escolha = JOptionPane.showOptionDialog(null,
                    "Bem vindo ao sistema gerenciador de estacionamentos SGE+!",
                    "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    op1,
                    op1[0]);
            switch (escolha) {
                case 0:
                    try {
                        gerenciador.cadastrarEstacionamento();
                    } catch (DescricaoEmBrancoException exc) {
                        exc.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        String nome = JOptionPane.showInputDialog(null, "Digite o nome do estacionamento desejado:");
                        Estacionamento e = gerenciador.findEstacionamento(nome);
                        int menu = 0;
                        String[] op2 = { "Novo Acesso", "Novo Evento", "Relatório do Estacionamento",
                                "Pesquisar Acesso por Placa", "Pesquisar evento", "Sair" };
                        do {
                            menu = JOptionPane.showOptionDialog(null,
                                    "Bem vindo ao menu do Estacionamento " + e.getNome(),
                                    "Escolha uma opção",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    op2,
                                    op2[0]);
                            switch (menu) {
                                case 0:
                                    e.cadastrarAcesso();
                                    break;
                                case 1:
                                    e.cadastrarEvento();
                                    break;
                                case 2:
                                    gerenciador.relatorioEstacionamento(e);
                                    break;
                                case 3:
                                    String placa = JOptionPane.showInputDialog(null, "Digite a placa do acesso:");
                                    try {
                                        e.findAcesso(placa);
                                    }catch (ObjetoNaoEncontradoException exc) {
                                        exc.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    String nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");
                                    try{
                                        e.findEvento(nomeEvento);
                                    } catch (ObjetoNaoEncontradoException exc) {
                                        exc.printStackTrace();
                                    }
                                    
                                    break;
                                case 5:
                                    break;

                            }
                        } while (menu != 5);

                    } catch (ObjetoNaoEncontradoException exc) {
                        exc.printStackTrace();
                    }
                    break;
            }

        } while (escolha != 2);

    }
}
