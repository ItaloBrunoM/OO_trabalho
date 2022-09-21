package MVC;
import java.awt.event.ActionListener;
public class AlunoView extends javax.swing.JFrame {

    public AlunoView() {
        initComponents();
    }
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        enviarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameText = new java.awt.TextField();
        cursoText = new java.awt.TextField();
        matriculaText = new java.awt.TextField();
        emailText = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        newEmail = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        newNome = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        newCurso = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        newMatricula = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enviarButton.setText("Enviar");
        enviarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarButtonActionPerformed(evt);
            }
        });
        desktopPane.add(enviarButton);
        enviarButton.setBounds(30, 210, 83, 23);

        jLabel1.setText("Email");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(210, 150, 84, 14);

        nameText.setText("Nome Completo");
        desktopPane.add(nameText);
        nameText.setBounds(30, 50, 100, 20);

        cursoText.setText("Curso");
        desktopPane.add(cursoText);
        cursoText.setBounds(30, 90, 100, 20);

        matriculaText.setText("Matricula");
        desktopPane.add(matriculaText);
        matriculaText.setBounds(30, 130, 100, 20);

        emailText.setText("Email");
        desktopPane.add(emailText);
        emailText.setBounds(30, 170, 100, 20);

        jLabel2.setText("Nome");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(210, 30, 57, 14);

        jLabel3.setText("Curso");
        desktopPane.add(jLabel3);
        jLabel3.setBounds(210, 70, 80, 14);

        jLabel4.setText("Matricula");
        desktopPane.add(jLabel4);
        jLabel4.setBounds(210, 110, 80, 14);

        jScrollPane2.setViewportView(newEmail);

        desktopPane.add(jScrollPane2);
        jScrollPane2.setBounds(210, 170, 110, 42);

        jScrollPane3.setViewportView(newNome);

        desktopPane.add(jScrollPane3);
        jScrollPane3.setBounds(210, 50, 110, 22);

        jScrollPane4.setViewportView(newCurso);

        desktopPane.add(jScrollPane4);
        jScrollPane4.setBounds(210, 90, 110, 22);

        jScrollPane5.setViewportView(newMatricula);

        desktopPane.add(jScrollPane5);
        jScrollPane5.setBounds(210, 130, 110, 22);

        jLabel5.setText("Nome");
        desktopPane.add(jLabel5);
        jLabel5.setBounds(30, 30, 57, 14);

        jLabel6.setText("Curso");
        desktopPane.add(jLabel6);
        jLabel6.setBounds(30, 70, 54, 14);

        jLabel7.setText("Matricula");
        desktopPane.add(jLabel7);
        jLabel7.setBounds(30, 110, 80, 14);

        jLabel8.setText("Email");
        desktopPane.add(jLabel8);
        jLabel8.setBounds(30, 150, 80, 14);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );
        pack();
    }
    private void enviarButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public String getNome(){
        return nameText.getText();
    }
    public String getCurso(){
        return cursoText.getText();
    }
    public String getMatricula(){
        return matriculaText.getText();
    }
    public String getEmail(){
        return emailText.getText();
    }
    /*public String getNewNome(){
        return newNome.getText();
    }
    public String getNewCurso(){
        return newCurso.getText();
    }
    public String getNewMatricula(){
        return newMatricula.getText();
    }
    public String getNewEmail(){
        return newEmail.getText();
    }*/
    public void setNewNome(String nome){
        newNome.setText(nome);
    }
    public void setNewCurso(String curso){
        newCurso.setText(curso);
    }
    public void setNewMatricula(String matricula){
        newMatricula.setText(matricula);
    }
    public void setNewEmail(String email){
        newEmail.setText(email);
    }
    void addNewText(ActionListener listenForEnviarButton){
        enviarButton.addActionListener(listenForEnviarButton);
    }
    
    private java.awt.TextField cursoText;
    private javax.swing.JDesktopPane desktopPane;
    private java.awt.TextField emailText;
    private javax.swing.JButton enviarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private java.awt.TextField matriculaText;
    private javax.swing.JMenuBar menuBar;
    private java.awt.TextField nameText;
    private javax.swing.JTextPane newCurso;
    private javax.swing.JTextPane newEmail;
    private javax.swing.JTextPane newMatricula;
    private javax.swing.JTextPane newNome;

}
