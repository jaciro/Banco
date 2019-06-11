package banco1;

import java.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.util.Date;
import javax.swing.JOptionPane;

public class Conta extends Cliente {

    private int numConta;
    private String iban;
    double saldo;
    private Date dataOpera = new Date();
    private String descricOPer;
    private Cliente cliente;
 
    

    public Conta(double saldo, String nome, String numBI, String nif) {
        super(nome, numBI, nif);
        this.numConta = (int) ((random() * 1000000000));
        this.iban = "AO060000" + this.numConta;
        this.saldo = saldo;

    }

    public Conta() {
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataOpera() {
        return dataOpera;
    }

    public void setDataOpera(Date dataOpera) {
        this.dataOpera = dataOpera;
    }

    public String getDescricOPer() {
        return descricOPer;
    }

    public void setDescricOPer(String descricOPer) {
        this.descricOPer = descricOPer;
    }

    public void CadastrarConta() {

        Conta cont = new Conta(saldo, nome, numBI, nif);
        try {
            PrintWriter arq = null;
            arq = new PrintWriter(this.numConta + ".txt");
            arq.println(saldo);
            arq.println(numConta);
            arq.println(iban);
            arq.println(nome);
            arq.println(numBI);
            arq.println(nif);
            arq.close();
            //  JOptionPane.showMessageDialog(null, "A CONTA DO SENHOR(RA): " + cont.nome.toUpperCase() + " FOI CRIADA COM SUCESSO " + "\n" + " O SEU NÚMERO DE CONTA É: " + cont.numConta , "Conta cadastrada".toUpperCase(), JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception Error) {

            JOptionPane.showMessageDialog(null, "Não foi possivél cadastrar", "Erro de cadastro".toUpperCase(), JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ver_conta() {
        numConta = Integer.valueOf(JOptionPane.showInputDialog(null, "INSIRA O NÚMERO DE CONTA QUE PRETENDE VER " + dataOpera, "Quem deseja verificar".toUpperCase(), JOptionPane.QUESTION_MESSAGE));
        try {
            BufferedReader arq = new BufferedReader(new FileReader(numConta + ".txt"));

            JOptionPane.showMessageDialog(null, "O SEU SALDO É: " + arq.readLine() + "\n" + " SEU NUMERO DE CONTA: " + arq.readLine() + "\n"
                    + "O SEU IABN: " + arq.readLine() + "\n" + "O SEU NOME: " + arq.readLine() + "\n" + "O SEU NUMERO DE BI: " + arq.readLine() + "\n" + "O SEU NIF: " + arq.readLine());
            arq.close();

        } catch (Exception Error) {
            JOptionPane.showMessageDialog(null, "Este não esta cadastrado".toUpperCase(), "erro de localização".toUpperCase(), JOptionPane.ERROR_MESSAGE);

        }
    }

   

    public String deposito(double valor) {
        
        String descricOPer_dep = "DEPOSITO NA CONTA";
        dataOpera = dataOpera;
        saldo += valor;
        JOptionPane.showMessageDialog(null, "FOI DEPOSITADO UM VALOR DE " + valor + "\n", "DEPOSITO", JOptionPane.INFORMATION_MESSAGE);

        return String.valueOf(saldo) + "\n " + "DESCRIÇÃO DE OPERAÇÃO " + descricOPer_dep + "\n ";
    }

    public void ver_saldo() {

        JOptionPane.showMessageDialog(null, "O  SEU SALDO É DE " + this.saldo + "\n" + "NA SUA CONTA SENHOR(RA) " + nome + "\n", "VER SALDO NA CONTA", JOptionPane.INFORMATION_MESSAGE);

    }
    int cont = 0;

    public void levenatamento_cot(double valor) {
        cont++;
        if (saldo < valor) {
            JOptionPane.showMessageDialog(null, "NÃO PODE LEVEARTAR ESTES " + valor + " KZ DA SUA CONTA POIS O SEU SALDO E INFERIOR, SENHOR(RA) " + nome + "\n", "LEVANTAMENTO", JOptionPane.ERROR_MESSAGE);
        } else {

            saldo -= valor;
            JOptionPane.showMessageDialog(null, "FOI LEVANTADO UM VALOR DE " + valor + "\n" + " KZ NA SUA CONTA SENHOR(RA) " + nome + "\n", "LEVANTAMENTO", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void trasferir(Conta conta1, double valor) {
        if (saldo > valor) {
            saldo -= valor;
            conta1.deposito(saldo);
            JOptionPane.showMessageDialog(null, "TRASFERENCIA REALIZADA COM SUCESSO DE  " + valor + " KZ  ", " TRASFERENCIA CORRETA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "NÃO PODE TRASFERIR  " + valor + " KZ O SALDO NESTA CONTA É INFERIOR AO VALOR PRETENDIDO ", "ERRO DE TRASFERENCIA", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void Extrato_Cont() {

        JOptionPane.showMessageDialog(null, "ESTAMOS POR ESTE MEIO APRESENTAR A  V.Exa.(s) O EXTRATO DE CONTA  NA QUAL É TITULAR: " + getNome() + "\n" + "O SEU NIF: " + getNif() + " \n" + "O SEU NÚMERO DE BI É: " + getNumBI() + " \n" + "NÚMERO DE conta: " + getNumConta() + "\n" + "COM IBAN DE: " + getIban() + " \n" + "DEPOSITOU/SALDO NA CONTA: " + saldo + " AOS " + dataOpera + " \n" + "LEVANTOU " + Conta.this.cont, " EXTRATO DA CONTA", JOptionPane.PLAIN_MESSAGE);

    }
}
