// Crie um exemplo de como funcionam a serialização e a desserialização de um sistema qualquer.
// Utilize as classes, os objetos e métodos padrões da Java e insira um endereço físico fictício.


import java.io.Serializable;

public class Pessoa implements Serializable {

    private int id;
    private String nome;
    private double salario;
    private String senha;

    public Pessoa(int id, String nome, double salario, String senha) {
        this.setId(id);
        this.setNome(nome);
        this.setSalario(salario);
        this.setSenha(senha);
    }

    public int getId() {
         return id;
    }

    public void  setId(int  id) {
        this.id = id;
}

    public String  getNome() {
        return nome;
   }

    public void  setNome(String  nome) {
        this.nome = nome;
}

    public String  getSenha() {
        return senha;
   }

    public void  setSenha(String  senha) {
        this.senha = senha;
}

    public double  getSalario() {
        return salario;
}

    public void  setSalario(double  salario) {
        this.salario = salario;
}
}
