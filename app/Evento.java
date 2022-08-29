package app;

public class Evento {
    String nome,
           data,
           horaInicio,
           horaFim;

    private Evento (String nome, String data, String horaInicio, String horaFim) {
        this.nome = nome;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public static Evento criarEvento (String nome, String data, String horaInicio, String horaFim) {
        Evento e = new Evento(nome, data, horaInicio, horaFim);
        return e;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
    
}
