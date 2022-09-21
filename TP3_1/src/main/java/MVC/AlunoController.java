package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoController {
        private AlunoModel theModel;
        private AlunoView theView;
        
        public AlunoController(AlunoModel theModel, AlunoView theView){
            this.theModel = theModel;
            this.theView = theView;
            
            this.theView.addNewText((ActionListener) new newText());
        }
        class newText implements ActionListener{

            public void actionPerformed(ActionEvent arg0){
                String nome, curso, matricula, email;
                try{
                    nome = theView.getNome();
                    curso = theView.getCurso();
                    matricula = theView.getMatricula();
                    email = theView.getEmail();
                    theModel.coletaDados(nome, curso, matricula, email);
                    theView.setNewNome(theModel.getNome());
                    theView.setNewCurso(theModel.getCurso());
                    theView.setNewMatricula(theModel.getMatricula());
                    theView.setNewEmail(theModel.getEmail());
                }
                catch(NullPointerException exc){
                }
            }
        }
}
