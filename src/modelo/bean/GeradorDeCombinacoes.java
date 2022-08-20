
package modelo.bean;

import FabricaDeConexao.ConexaoFireBird;
import ViewBingo.frmGerarCombinacoes;
import static ViewBingo.frmGerarCombinacoes.lblCarregando;
import static ViewBingo.frmGerarCombinacoes.lblPercentualgerador;
import static ViewBingo.frmGerarCombinacoes.pgbGerarCombinacoes;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.dao.TotalProbabilidadeDAO;
import modelos.dao.TotalProbabilidadesTextoDAO;
/**
 *
 * @author Pituba
 */
public class GeradorDeCombinacoes {
    
     TotalProbabilidadeDAO prob = new TotalProbabilidadeDAO();
     TotalProbabilidadesTextoDAO probtexto = new TotalProbabilidadesTextoDAO();
     File file = new File("C:\\Meusbd\\Lotofacil.txt");
    
        int[] resto = new int[25];
        int[] quociente = new int[25];
        int[] fator = new int[25];
        int confirmar;

    public GeradorDeCombinacoes() {
    }

    public GeradorDeCombinacoes(int confirmar) {
        this.confirmar = confirmar;  
    }
                 //try {
                     //ConexaoFireBird conec = new ConexaoFireBird();
                 //} catch (ClassNotFoundException | SQLException ex) {
                     //Logger.getLogger(frmGerarCombinacoes.class.getName()).log(Level.SEVERE, null, ex);
                 //}
    public void GerandoCombinacoes(){
    
       DecimalFormat df = new DecimalFormat("00 ");
       confirmar = JOptionPane.showConfirmDialog(null, "Confirma a geração de combinações possíveis ?",
                "Loto Fácil", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(confirmar == 0){
          lblCarregando.setVisible(true);
          new Thread(){ 
              int valor, divisor, subdivisor, valordereferencia, limitador, marcador, percent;
              String selecionado = "", comparador = "";
        
          @Override
          public void run(){            
             valor = 0;
             valordereferencia = 32767;
             divisor = 1;
             subdivisor = 1;
             limitador = 0;
             marcador = 1;
             
             while(!comparador.trim().equals("11 12 13 14 15 16 17 18 19 20 21 22 23 24 25")){
                 resto[0] = valor % 2;
                 quociente[0] = (valor - resto[0])/2;
                 fator[0] = resto[0];
                 
                 for(int I = 1; I <= 24; I++){
                     resto[I] = quociente[I - 1] % 2;
                     quociente[I] = (quociente[I - 1] - resto[I]) / 2;
                     fator[I] = resto[I];
                 }
                 
                 for(int I = 0; I <= 24; I++){
                     if(fator[I] == 1){
                         selecionado = selecionado + df.format(I + 1);
                     }                 
                 }
             
                 if(selecionado.length() == 45){          
                     probtexto.salvar_totalprobabilidadestexto(file, selecionado);
                     percent = (probtexto.getQuantidade()*100/3268760);
                     lblCarregando.setText("Carregando..." + Integer.toString(probtexto.getQuantidade()));
                     pgbGerarCombinacoes.setValue(Integer.parseInt(String.valueOf(percent)));
                     lblPercentualgerador.setText(String.valueOf(percent) + "%");
                 } 
                 
               comparador = selecionado;
               selecionado = "";
               valor += 1;    
              }
                   
                    JOptionPane.showMessageDialog(null, probtexto.getQuantidade() + " Combinações foram geradas!"
                                          , "Loto Fácil", JOptionPane.INFORMATION_MESSAGE);
                }
            }.start();
          
       }else{
          JOptionPane.showMessageDialog(null, "Processamento abortado!"
                  , "Loto Fácil", JOptionPane.CANCEL_OPTION);
       }
    }
}
