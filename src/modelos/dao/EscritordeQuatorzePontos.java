/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblPercentual;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblProcessando;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.pgbProcessando;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.TotaldeRepeticoes;

/**
 *
 * @author Pituba
 */
public class EscritordeQuatorzePontos {
    public void EscritordeQuatorzePontos(File fourteenpointsfile, String fourteenpoints){
        try(FileWriter fourteenpointsfilewriter = new FileWriter(fourteenpointsfile, true)){
                      fourteenpointsfilewriter.write(fourteenpoints.trim()+" "+ 1 +"\n");
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quatorze pontos!", "Salvando quatorze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
    
    
    public void AtualizadordeQuatorzePontos(File fourteenpointsfile, List<String> sequenciaquatorzepontosmaissoma){
        
        String sequencias = "", vetorquinzestr, sequenciaslist = "";
        int vetorquinzeint, contadordelinhas = 0;
        long quantidade = 0, percent, totallinhas;
        
        TotaldeRepeticoes totalderepeticoes = new TotaldeRepeticoes();
        
          try(BufferedReader bufferedfilereaderfourteenpoints = new BufferedReader(new FileReader(fourteenpointsfile))){
            String countline = bufferedfilereaderfourteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            while(countline != null){
                   contadordelinhas += 1;
                   countline = bufferedfilereaderfourteenpoints.readLine();
            }
            bufferedfilereaderfourteenpoints.close();
          }catch(IOException e){
                                JOptionPane.showMessageDialog(null, "Erro: " + e + " ao receber o tamanho do buffer"
                                , "Dimensionando buffer", JOptionPane.ERROR_MESSAGE);
                    }
        
        try(BufferedReader bufferedfilereaderfourteenpoints = new BufferedReader(new FileReader(fourteenpointsfile))){
            String line = bufferedfilereaderfourteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            totalderepeticoes.setVetordezesseisstr(Integer.toString(0));
            while(line != null){
                        String vect[] = line.split(" ");
                        vetorquinzeint = Integer.valueOf(vect[15]);
                        for(int i = 0; i < 15; i++){
                                sequencias = sequencias + vect[i] +" ";
                        }
  //String hasthirteenpoints = sequenciatrezepontosmaissoma.stream().filter(x -> x.get()).findFirst().orElse(null);
                            for(int j = 0; j < sequenciaquatorzepontosmaissoma.size(); j++){
                                String listvect[] = sequenciaquatorzepontosmaissoma.get(j).split(" ");
                                for(int n = 0; n < 15; n++){
                                    sequenciaslist += listvect[n] +" ";
                                }
                                if(sequenciaslist.trim().equals(sequencias.trim())){
                                   totalderepeticoes.setVetordezesseisstr(Integer.toString(vetorquinzeint));
                                   sequenciaquatorzepontosmaissoma.remove(j);
                                }
                                sequenciaslist = "";
                            }
                            
                            vetorquinzestr = Integer.toString(vetorquinzeint + 1);     
                            sequencias = sequencias + vetorquinzestr;
                            sequenciaquatorzepontosmaissoma.add(sequencias);
                            sequencias = "";
                            line = bufferedfilereaderfourteenpoints.readLine();

                    quantidade += 1;
                    percent = (quantidade*100/contadordelinhas);
                    lblProcessando.setText("Atualizando 14 pontos..." + Long.toString(quantidade));
                    pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    lblPercentual.setText(String.valueOf(percent) + "%");
            }
             
            bufferedfilereaderfourteenpoints.close();
        }catch(IOException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e + " ao encher a lista");
        }
       
        fourteenpointsfile.delete();
        
        try(FileWriter thirteenpointsfilewriter = new FileWriter(fourteenpointsfile, true)){
            Collections.sort(sequenciaquatorzepontosmaissoma);
            for(int i = 0; i< sequenciaquatorzepontosmaissoma.size(); i++){
                      thirteenpointsfilewriter.write(sequenciaquatorzepontosmaissoma.get(i).trim()+ "\n");
            }
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quatorze pontos!", "Salvando quatorze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
}
