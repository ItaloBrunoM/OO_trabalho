package MVC;
public class AlunoModel {
    private String nomeString, cursoString, matriculaString, emailString;
    
    public void coletaDados(String nome, String curso, String matricula, String email){
        nomeString = nome;
        cursoString = curso;
        matriculaString = matricula;
        emailString = email;          
    }
    public String getNome(){
        return nomeString;
    } 
    public String getCurso(){
        return cursoString;
    } 
    public String getMatricula(){
        return matriculaString;
    } 
    public String getEmail(){
        return emailString;
    } 
}
