import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void limparTela() {
        try {
             new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }    
        }

    public static void main(String [] args) throws Exception {
        limparTela();
        criarArquivoBinarioSerializado();
        lerArquivoBinarioSerializado();
    }

    public static void criarArquivoBinarioSerializado() {
        Pessoa p1 = new Pessoa(1, "Paulo Freire", 2500, "142536");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("C:/Users/wzek8/Desktop/power bi/arquivo.bin/"); //colocar neste local o endereço ficticio onde o arquivo será gerado.
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");    
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar arquivo.");     
                }
            }    
       } 
    }
    public static void lerArquivoBinarioSerializado() { 
        Pessoa p1 = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("arquivo.bin");
            ois = new ObjectInputStream(fis);
            p1 = (Pessoa)ois.readObject();
            System.out.printf("Id: %2d\nNome: %s\nSalario: %.2f\nSenha: %s\n",
               p1.getId(), p1.getNome(), p1.getSalario(), p1.getSenha());
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");    
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar arquivo.");     
                }
            }    
       } 

    }

}