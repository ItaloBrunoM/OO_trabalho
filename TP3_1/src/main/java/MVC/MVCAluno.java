package MVC;
public class MVCAluno {
    public static void main(String[] args){
        AlunoView theView = new AlunoView();
        AlunoModel theModel = new AlunoModel();
        AlunoController theController = new AlunoController(theModel, theView);
        
        theView.setVisible(true);
    }
}
