package banco1;

import static banco1.Sistema.menu;
import javax.swing.JOptionPane;

public class Banco1 {

    public static void main(String[] args) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "1-CADASTRAR CLIENTE".toUpperCase() + "\n" + "2-VER CLIENTE" + "\n" + "3-CADASTRAR CONTA" + "\n" + "4-VER CONTA CADASTRADAS" + "\n" + "5-SAIR DO SISTEMA", "menu-selecione o quer".toUpperCase(), JOptionPane.PLAIN_MESSAGE));

        switch (op) {
            case 1:
                String nome = JOptionPane.showInputDialog(null, "nome do cliente", "dados do cliente", JOptionPane.QUESTION_MESSAGE);
                String numBI = JOptionPane.showInputDialog(null, "numero de BI", "dados do cliente", JOptionPane.QUESTION_MESSAGE);
                String nif = JOptionPane.showInputDialog(null, "Numero de nif ", "dados do cliente", JOptionPane.QUESTION_MESSAGE);
                Cliente cl = new Cliente(nome, numBI, nif);
                cl.CadasCliente();
                menu();
                //perguntar se quer ciar uma conta
                break;

            case 2:
                Cliente ver_cli = new Cliente();
                ver_cli.verCliente();
                menu();
                break;

            case 3:
                double saldo;
                saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "O VALOR INICIAR NA ABERTURA DA CONTA", "DADOS DA CONTA", JOptionPane.QUESTION_MESSAGE));
                while (saldo < 0) {

                    JOptionPane.showMessageDialog(null, "O SALDO INICIAL NÃO PODE SER NEGATIVO", "ALERTA", JOptionPane.WARNING_MESSAGE);
                    saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "O VALOR INICIAR NA ABERTURA DA CONTA", "DADOS DA CONTA", JOptionPane.QUESTION_MESSAGE));
                }

                String nome_clie_co = JOptionPane.showInputDialog(null, "NOME DO TITULAR DA CONTA", "DADOS DA CONTA", JOptionPane.QUESTION_MESSAGE);
                String numBI_clie_co = JOptionPane.showInputDialog(null, "NÚMERO DO BI DO TITULAR ", "DADOS DA CONTA", JOptionPane.QUESTION_MESSAGE);
                String nif_clie_co = JOptionPane.showInputDialog(null, "NIF DO TITULAR DA CONTA ", "DADOS DA CONTA", JOptionPane.QUESTION_MESSAGE);

                int tipo_cont = Integer.valueOf(JOptionPane.showInputDialog(null, "1-CONTA POUPANÇA" + "\n" + "2-CONTA CORRENTE", "ESCOLHA O TIPO DE CONTA ", JOptionPane.QUESTION_MESSAGE));

                //menu dos assutos da conta 
                Conta_poupa cntP = new Conta_poupa(saldo, nome_clie_co, numBI_clie_co, nif_clie_co);
                switch (tipo_cont) {

                    case 1:
                        cntP.CadastrarConta();
                        JOptionPane.showMessageDialog(null, "A CONTA DO SENHOR(RA): " + cntP.getNome().toUpperCase() + " FOI CRIADA COM SUCESSO " + "\n" + " O SEU NÚMERO DE CONTA É: " + cntP.getNumConta(), "Conta cadastrada".toUpperCase(), JOptionPane.INFORMATION_MESSAGE);

                        int OpcWhil = Integer.valueOf(JOptionPane.showInputDialog(null, "1-ENTRAR NO MENU" + "\n" + "0-PARA NÃO ENTRAR", "ESCOLHA A OPEREÇÃO A SER RELIZADA NA CONTA PP ", JOptionPane.QUESTION_MESSAGE));
                        while (OpcWhil != 0) {

                            int OpcContPou = Integer.valueOf(JOptionPane.showInputDialog(null, "1-RENDER JUROS" + "\n" + "2-VER SALDO NA CONTA" + "\n" + "3-REALIZAR LEVANTAMENTO" + "\n" + "4-EXTRATO" + "\n" + "5-DEPOSITAR" + "\n" + "\n" + "6-VOLTAR NO MUNE PRINCIPAL" + "\n", "ESCOLHA NA CONTA PP ", JOptionPane.QUESTION_MESSAGE));

                            switch (OpcContPou) {
                                case 1:
                                    double valor = Double.valueOf(JOptionPane.showInputDialog(null, "QUANTO VAI REDER PARA O JURO?", "dit o valor", JOptionPane.QUESTION_MESSAGE));
                                    cntP.renderJuros(valor);
                                    cntP.CadastrarConta();
                                    break;

                                case 2:
                                    cntP.ver_saldo();
                                    cntP.CadastrarConta();
                                    break;

                                case 3:
                                    double valor_lev = Double.valueOf(JOptionPane.showInputDialog(null, "LEVANTAR QUANTO?", "dit o valor", JOptionPane.QUESTION_MESSAGE));
                                    cntP.levenatamento_cot(valor_lev);
                                    cntP.CadastrarConta();
                                    break;

                                case 4:
                                    cntP.Extrato_Cont();
                                    cntP.CadastrarConta();
                                    break;

                                case 5:
                                    double valor_dep = Double.valueOf(JOptionPane.showInputDialog(null, "VALOR A DEPOSITAR ?", "dit o valor", JOptionPane.QUESTION_MESSAGE));
                                    cntP.deposito(valor_dep);

                                    break;

                                case 6:
                                    menu();
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "ESCOLHA ERRADA TENDE OUTRA VZ", "ERRO", JOptionPane.QUESTION_MESSAGE);

                                    break;

                            }
break;
                        }

                     

                    case 2:

                        //OPERAÇÕES A SEREM REALIZDAS NA  CONTA CC
                        Conta_corrente cont_cor = new Conta_corrente(saldo, nome_clie_co, numBI_clie_co, nif_clie_co);
                        cont_cor.CadastrarConta();
                        //boas vindas
                        JOptionPane.showMessageDialog(null, "A CONTA DO SENHOR(RA): " + cont_cor.getNome().toUpperCase() + " FOI CRIADA COM SUCESSO " + "\n" + " O SEU NÚMERO DE CONTA É: " + cont_cor.getNumConta(), "Conta cadastrada".toUpperCase(), JOptionPane.INFORMATION_MESSAGE);

                       double OpcWhil1 = Integer.valueOf(JOptionPane.showInputDialog(null, "1-ENTRAR NO MENU " + "\n" + "0-PARA NÃO ENTRAR ", "ESCOLHA A OPEREÇÃO A SER RELIZADA NA CONTA PP ", JOptionPane.QUESTION_MESSAGE));

                        while ( OpcWhil1 != 0) {
                            int OpcContCC = Integer.valueOf(JOptionPane.showInputDialog(null, "1-DEPOSITAR " + "\n" + "2-LEVANTAR " + "\n" + "3-EXTRATO " + "\n" + "4-VER SALDO " + "\n" + "5-TRASFERENCIA " + "\n" + "**REALIZAR PAGAMENTOS** " + "\n" + "6-PAGAR BI" + "\n" + "7-PAGAR REGISTO CRIMINAL " + "\n" + "8-ATESTADO MEDICO " + "9-VOLTAR NO MENU PRINCIPAL " + "\n", "ESCOLHA NA CONTA CC ", JOptionPane.QUESTION_MESSAGE));

                            switch (OpcContCC) {
                                case 1:
                                    double valor_dep;
                                    valor_dep = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A DEPOSITAR", "VALOR A DEPOSITAR ", JOptionPane.QUESTION_MESSAGE)));

                                    while (valor_dep < 0) {

                                        JOptionPane.showMessageDialog(null, "O VALOR NÃO PODE SER NEGATIVO", "ALERTA", JOptionPane.WARNING_MESSAGE);
                                        valor_dep = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A DEPOSITAR", "VALOR A DEPOSITAR ", JOptionPane.QUESTION_MESSAGE)));
                                    }
                                    cont_cor.deposito(valor_dep);
                                    cont_cor.CadastrarConta();

                                    break;
                                case 2:
                                    //levantar

                                    double valor_lev;
                                    valor_lev = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A LEVANTAR", "VALOR A LEVANTAR ", JOptionPane.QUESTION_MESSAGE)));

                                    while (valor_lev < 0) {

                                        JOptionPane.showMessageDialog(null, "O VALOR NÃO PODE SER NEGATIVO", "ALERTA", JOptionPane.WARNING_MESSAGE);
                                        valor_lev = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A LEVANTAR", "VALOR A LEVANTAR ", JOptionPane.QUESTION_MESSAGE)));
                                    }
                                    cont_cor.levenatamento_cot(valor_lev);
                                    cont_cor.CadastrarConta();

                                    break;
                                case 3:
                                    cont_cor.Extrato_Cont();
                                    cont_cor.CadastrarConta();
                                    break;
                                case 4:
                                    //VER SALDO CONTA 
                                    cont_cor.ver_saldo();
                                    cont_cor.CadastrarConta();
                                    break;
                                case 5:
                                    //TRASFERENCIA
                                    double valor_tras;
                                    valor_tras = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A TRASFERENCIA", "VALOR A TRASFERIR ", JOptionPane.QUESTION_MESSAGE)));
                                    while (valor_tras < 0) {

                                        JOptionPane.showMessageDialog(null, "O VALOR NÃO PODE SER NEGATIVO", "ALERTA", JOptionPane.WARNING_MESSAGE);
                                        valor_tras = Double.valueOf((JOptionPane.showInputDialog(null, "INSIRA O VALOR A TRASFERENCIA", "VALOR A TRASFERIR ", JOptionPane.QUESTION_MESSAGE)));

                                    }
                                    String numeroConttra = JOptionPane.showInputDialog(null, "INSIRA O NÚMERO DE CONTA PARA RELAIZAR A TRASFERENCIA", "CONTA  À TRASFERIR ", JOptionPane.QUESTION_MESSAGE);
                                    cont_cor.trasferir(new Conta(0, nome_clie_co, numBI_clie_co, nif_clie_co), valor_tras);
                                       
                                    break;
                                case 6:
                                    cont_cor.paga_bi();
                                    cont_cor.CadastrarConta();
                                    break;
                                case 7:
                                    cont_cor.paga_regCri();
                                    cont_cor.CadastrarConta();
                                    break;
                                case 8:
                                    cont_cor.paga_ateMedi();
                                    break;
                                case 9:
                                    menu();
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "ESCOLHA ERRADA TENDE OUTRA VZ", "ERRO", JOptionPane.QUESTION_MESSAGE);

                                    break;

                            }
  
                             break;
                        }

                       
                      
                        
                    default:
                        JOptionPane.showMessageDialog(null, "OPERAÇÃO ERRADA", "ERRO ", JOptionPane.ERROR_MESSAGE);
                        break;

                }
          

            case 4:
                Conta cnt = new Conta();
                cnt.ver_conta();
                menu();

                break;

            case 5:
                System.exit(op);

                break;

            default:
                JOptionPane.showMessageDialog(null, "OPERAÇÃO ERRADA", "ERRO ", JOptionPane.ERROR_MESSAGE);
                menu();
                break;
                

    }

}
    
}