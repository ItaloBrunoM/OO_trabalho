package ui;

import javax.swing.JOptionPane;

import app.Estacionamento;
import app.GerenciadorEstacionamentos;

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
                    gerenciador.cadastrarEstacionamento();
                    break;
                case 1:
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
                                e.findAcesso(placa);
                                break;
                            case 4:
                            String nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");
                                e.findEvento(nomeEvento);
                                break;
                            case 5:
                                break;

                        }
                    } while (menu != 5);

                    break;
            }

        } while (escolha != 2);

    }
}
