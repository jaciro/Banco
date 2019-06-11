package banco1;

import javax.swing.JOptionPane;

public class Conta_corrente extends Conta {

    private final double BI = 1000;
    private final double REGIS_CRIMI = 500;
    private final double ATEST_MEDIC = 1000;

    String tipConta = "CONTA CORRENTE";

    public Conta_corrente(double saldo, String nome, String numBI, String nif) {
        super(saldo, nome, numBI, nif);
    }

    public Conta_corrente() {
    }

    public String getTipConta() {
        return tipConta;
    }

    public void setTipConta(String tipConta) {
        this.tipConta = tipConta;
    }

    @Override
    public void CadastrarConta() {
        super.CadastrarConta(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deposito(double valor) {
        return super.deposito(valor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levenatamento_cot(double valor) {

        super.levenatamento_cot(valor);
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
    public void trasferir(Conta conta1, double valor) {
        super.trasferir(conta1, valor); //To change body of generated methods, choose Tools | Templates.
    }

    public void paga_bi() {
        if (this.saldo < BI) {
            JOptionPane.showMessageDialog(null, "O SEU SALDO É INFERIOR NÃO PODE RALIZAR PAGAMENTO DO BI", " ERRO PAGAMENTO ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.saldo -= BI;
            JOptionPane.showMessageDialog(null, "FOI RETIRADO " + BI + "\n" + " DO SENHOR(RA) " + nome + "REFERENTE AO PAGAMENTO DO BI", "PAGAMENTO REALIZADO", JOptionPane.INFORMATION_MESSAGE);
        }
}
    
     public void paga_regCri() {
        if (this.saldo < REGIS_CRIMI) {
            JOptionPane.showMessageDialog(null, "O SEU SALDO É INFERIOR NÃO PODE RALIZAR PAGAMENTO DO REGISTO CRIM", " ERRO PAGAMENTO ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.saldo -=REGIS_CRIMI ;
            JOptionPane.showMessageDialog(null, "FOI RETIRADO " + REGIS_CRIMI+ "\n" + " DO SENHOR(RA) " + nome + "REFERENTE AO PAGAMENTO DO REGIS_CRIMI", "PAGAMENTO REALIZADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     public void paga_ateMedi() {
        if (this.saldo < ATEST_MEDIC ) {
            JOptionPane.showMessageDialog(null, "O SEU SALDO É INFERIOR NÃO PODE RALIZAR PAGAMENTO DO ATEST_MEDIC ", " ERRO PAGAMENTO ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.saldo -=ATEST_MEDIC  ;
            JOptionPane.showMessageDialog(null, "FOI RETIRADO " + ATEST_MEDIC + "\n" + " DO SENHOR(RA) " + nome + "REFERENTE AO PAGAMENTO DO ATEST_MEDIC ", "PAGAMENTO REALIZADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

