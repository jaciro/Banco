package banco1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Cliente {

    String nome;
    String numBI;
    String nif;

    public Cliente(String nome, String numBI, String nif) {
        this.nome = nome;
        this.numBI = numBI;
        this.nif = nif;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void CadasCliente() {

        Cliente cl = new Cliente(nome, numBI, nif);
        try {
            PrintWriter arq = null;
            arq = new PrintWriter(nome + ".txt");
            arq.println(cl.nome);
            arq.println(cl.numBI);
            arq.println(cl.nif);
            arq.close();
            JOptionPane.showMessageDialog(null, "O CLIENTE " + nome + " FOI CRIADO COM SUCESSO " + "\n" + "", "CLIENTE CADASTRADO ".toUpperCase(), JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception Error) {
            JOptionPane.showMessageDialog(null, "Não foi possivél cadastrar", "Erro de cadastro".toUpperCase(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verCliente() {
        nome = JOptionPane.showInputDialog(null, "Insira o nome para verificar", "Quem deseja verificar".toUpperCase(), JOptionPane.QUESTION_MESSAGE);
        try {
            BufferedReader arq = new BufferedReader(new FileReader(nome + ".txt"));

            JOptionPane.showMessageDialog(null, "O nome é " + arq.readLine() + "\n" + "O se BI " + arq.readLine() + "\n"
                    + "O SEU NIF" + arq.readLine());
            arq.close();

        } catch (Exception Error) {
            JOptionPane.showMessageDialog(null, "Este cliente não esta cadastrado", "erro de localização".toUpperCase(), JOptionPane.ERROR_MESSAGE);

        }
    }

}
