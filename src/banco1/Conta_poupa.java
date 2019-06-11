/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco1;

import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class Conta_poupa extends Conta {

    String tipConta = "CONTA POUPANCA";

    private final int limite = 1000;
    private int variacao = 0;

    public Conta_poupa() {
    }

    public Conta_poupa(double saldo, String nome, String numBI, String nif) {
        super(saldo, nome, numBI, nif);
    }
//apagar depois

    public String getTipConta() {
        return tipConta;
    }

    public void setTipConta(String tipConta) {
        this.tipConta = tipConta;
    }

    public int getVariacao() {
        return variacao;
    }

    public void setVariacao(int variacao) {
        this.variacao = variacao;
    }

    public void renderJuros(double taxa) {
        if (taxa < 0) {
            JOptionPane.showMessageDialog(null, "NÃO PODE TER TAXA NEGATIVA ", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            this.deposito(this.getSaldo() * taxa);
            JOptionPane.showMessageDialog(null, "FOI RENDIDA UM TAXA DE JURO DE: " + taxa + " KZ NA SUA CONTA SENHOR(RA) " + this.nome + "\n", "RENDER  JUROS", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    public void Extrato_Cont() {
        super.Extrato_Cont(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ver_saldo() {
        super.ver_saldo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ver_conta() {
        super.ver_conta(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CadastrarConta() {
        super.CadastrarConta(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levenatamento_cot(double valor) {
        variacao++;
        if (variacao == 3) {

            JOptionPane.showMessageDialog(null, "NÃPO É POSSIVEL REALIZAR A OPREAÇÃO POIS JÁ SE FOI", "ERRO DE LEVANTAMENTO", JOptionPane.ERROR_MESSAGE);

        } else if (this.getSaldo() <= limite) {
            JOptionPane.showMessageDialog(null, "NÃPO É POSSIVEL REALIZAR A OPREAÇÃO", "ERRO DE LEVANTAMENTO", JOptionPane.ERROR_MESSAGE);
        } else {
            super.levenatamento_cot(valor);
        }

    }

        //this.levenatamento_cot(this.getSaldo()-valor);
}
