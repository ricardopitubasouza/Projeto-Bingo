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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.TotaldeRepeticoes;

/**
 *
 * @author Pituba
 */
public class EscritordeQuinzePontos {

    public void EscritordeQuinzepontos(File fifteenpointsfile, String fifteenpoints){
        try(FileWriter fifteenpointsfilewriter = new FileWriter(fifteenpointsfile, true)){
                      fifteenpointsfilewriter.write(fifteenpoints.trim()+" "+ 0 +" "+ 0 +" "+ 1 +"\n");
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quinze pontos!", "Salvando quinze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
    
    
    public void AtualizadordeQuinzepontos(File fifteenpointsfile, String fifteenpointssequenci){
        
        TotaldeRepeticoes totalderepeticoes = new TotaldeRepeticoes();
        
        String sequencias = "", vetordezessetestr, sequenciaslist = "";
        int vetordezesseteint, contadordelinhas = 0;
        long quantidade = 0, percent, totallinhas;
        List<String>sequenciaquinzepontosmaissoma = new ArrayList<>();
        
          try(BufferedReader bufferedfilereaderfifteenpoints = new BufferedReader(new FileReader(fifteenpointsfile))){
            String countline = bufferedfilereaderfifteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            while(countline != null){
                   contadordelinhas += 1;
                   countline = bufferedfilereaderfifteenpoints.readLine();
            }
            bufferedfilereaderfifteenpoints.close();
          }catch(IOException e){
                                JOptionPane.showMessageDialog(null, "Erro: " + e + " ao receber o tamanho do buffer"
                                , "Dimensionando buffer", JOptionPane.ERROR_MESSAGE);
                    }
        
        try(BufferedReader bufferedfilereaderfifteenpoints = new BufferedReader(new FileReader(fifteenpointsfile))){
            String line = bufferedfilereaderfifteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            while(line != null){
                sequenciaquinzepontosmaissoma.add(line.trim());
                line = bufferedfilereaderfifteenpoints.readLine();
            }
                for(int j = 0; j < sequenciaquinzepontosmaissoma.size(); j++){  
                String vect[] = sequenciaquinzepontosmaissoma.get(j).split(" ");
                vetordezesseteint = Integer.valueOf(vect[17]);
                for(int i = 0; i < 15; i++){
                    sequencias = sequencias + vect[i] +" ";
                }
                if(sequencias.trim().equals(fifteenpointssequenci.trim())){
                    vetordezesseteint += 1;
                    sequenciaquinzepontosmaissoma.remove(j);
                }    
                sequenciaslist = fifteenpointssequenci.trim() + " " + totalderepeticoes.getVetorquinzestr() + " " +
                totalderepeticoes.getVetordezesseisstr() + " " + String.valueOf(vetordezesseteint);
  //String hasthirteenpoints = sequenciatrezepontosmaissoma.stream().filter(x -> x.get()).findFirst().orElse(null);
                    quantidade += 1;
                    percent = (quantidade*100/contadordelinhas);
                    lblProcessando.setText("Atualizando 15 pontos..." + Long.toString(quantidade));
                    pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    lblPercentual.setText(String.valueOf(percent) + "%");
            }    
                
                sequenciaquinzepontosmaissoma.add(sequenciaslist.trim());
            bufferedfilereaderfifteenpoints.close();
        }catch(IOException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e + " ao encher a lista");
        }
       
        fifteenpointsfile.delete();
        
        try(FileWriter fifteenpointsfilewriter = new FileWriter(fifteenpointsfile, true)){
            //Collections.sort(sequenciaquinzepontosmaissoma);
            for(int i = 0; i< sequenciaquinzepontosmaissoma.size(); i++){
                      fifteenpointsfilewriter.write(sequenciaquinzepontosmaissoma.get(i).trim()+ "\n");
            }
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quinze pontos!", "Salvando quinze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
}
