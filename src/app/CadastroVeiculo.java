// package app;

// import javax.swing.JOptionPane;
// import java.util.LinkedList;
// import java.util.List;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.time.Duration;
// import java.time.Period;

// public class CadastroVeiculo {
//     String placa;
//     List<Acesso> acessos;

//     private CadastroVeiculo(String placa) {
//         this.placa = placa;
//         acessos = new LinkedList<Acesso>();
//     }

//     public static CadastroVeiculo CriarCadastroVeiculo (String placa) {
//        CadastroVeiculo c = new CadastroVeiculo(placa);
//        return c;
//     }

//     void 1cadastrarAcesso() {
//         String[] op = { "Padrão", "Mensal", "Por Evento" };
//         int menu = JOptionPane.showOptionDialog(null,
//                 "Escolha o tipo de acesso:",
//                 "Escolha uma opção",
//                 JOptionPane.DEFAULT_OPTION,
//                 JOptionPane.INFORMATION_MESSAGE,
//                 null,
//                 op,
//                 op[0]);
//         switch (menu) {
//             case 0:
//                 DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//                 LocalDate dataEnt = LocalDate.parse(
//                         JOptionPane.showInputDialog(null, "Insira a data de entrada no formato dd/mm/aaaa:"),
//                         formatoData);
//                 LocalDate dataSai = LocalDate.parse(
//                         JOptionPane.showInputDialog(null, "Insira a data de saída no formato dd/mm/aaaa:"),
//                         formatoData);
//                 Period deltaData = Period.between(dataEnt, dataSai);
//                 JOptionPane.showMessageDialog(null, deltaData);
//                 LocalTime horaEnt = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de entrada no formato hh:mm:"));
//                 LocalTime horaSai = LocalTime.parse(JOptionPane.showInputDialog(null, "Insira o horário de saída  no formato hh:mm:"));
//                 Duration deltaHorario = Duration.between(horaEnt, horaSai);
//                 if (horaEnt < ) {
                    
//                 }
                
//                 break;
//             case 1:
//                 break;
//             case 2:
//                 break;
//         }

//     }

// }
