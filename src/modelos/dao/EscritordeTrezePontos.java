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
public class EscritordeTrezePontos {
    
    public void EscritordeTrezepontos(File thirteenpointsfile, String thirteenpoints){
        try(FileWriter thirteenpointsfilewriter = new FileWriter(thirteenpointsfile, true)){
                      thirteenpointsfilewriter.write(thirteenpoints.trim()+" "+ 1 +"\n");
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar treze pontos!", "Salvando treze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
    
    
    public void AtualizadordeTrezepontos(File thirteenpointsfile,List<String> sequenciatrezepontosmaissoma){
        
        String sequencias = "", vetorquinzestr, sequenciaslist = "";
        int vetorquinzeint, contadordelinhas = 0;
        long quantidade = 0, percent, totallinhas;
        
          TotaldeRepeticoes totalderepeticoes = new TotaldeRepeticoes();
        
          try(BufferedReader bufferedfilereaderthirteenpoints = new BufferedReader(new FileReader(thirteenpointsfile))){
            String countline = bufferedfilereaderthirteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            while(countline != null){
                   contadordelinhas += 1;
                   countline = bufferedfilereaderthirteenpoints.readLine();
            }
            bufferedfilereaderthirteenpoints.close();
          }catch(IOException e){
                                JOptionPane.showMessageDialog(null, "Erro: " + e + " ao receber o tamanho do buffer"
                                , "Dimensionando buffer", JOptionPane.ERROR_MESSAGE);
                    }
        
        try(BufferedReader bufferedfilereaderthirteenpoints = new BufferedReader(new FileReader(thirteenpointsfile))){
            String line = bufferedfilereaderthirteenpoints.readLine();
            //totallinhas = bufferedfilereaderthirteenpoints.lines().count();
            totalderepeticoes.setVetorquinzestr(Integer.toString(0));
            while(line != null){
                        String vect[] = line.split(" ");
                        vetorquinzeint = Integer.valueOf(vect[15]);
                        for(int i = 0; i < 15; i++){
                                sequencias = sequencias + vect[i] +" ";
                        }
  //String hasthirteenpoints = sequenciatrezepontosmaissoma.stream().filter(x -> x.get()).findFirst().orElse(null);
                            for(int j = 0; j < sequenciatrezepontosmaissoma.size(); j++){
                                String listvect[] = sequenciatrezepontosmaissoma.get(j).split(" ");
                                for(int n = 0; n < 15; n++){
                                    sequenciaslist += listvect[n] +" ";
                                }
                                if(sequenciaslist.trim().equals(sequencias.trim())){
                                   totalderepeticoes.setVetorquinzestr(Integer.toString(vetorquinzeint));
                                   sequenciatrezepontosmaissoma.remove(j);
                                }
                                sequenciaslist = "";
                            }
                            
                            vetorquinzestr = Integer.toString(vetorquinzeint + 1); 
                            sequencias = sequencias + vetorquinzestr;
                            sequenciatrezepontosmaissoma.add(sequencias);
                            sequencias = "";
                            line = bufferedfilereaderthirteenpoints.readLine();

                    quantidade += 1;
                    percent = (quantidade*100/contadordelinhas);
                    lblProcessando.setText("Atualizando 13 pontos..." + Long.toString(quantidade));
                    pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    lblPercentual.setText(String.valueOf(percent) + "%");
            }
             
            bufferedfilereaderthirteenpoints.close();
        }catch(IOException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e + " ao encher a lista");
        }
       
        thirteenpointsfile.delete();
        
        try(FileWriter thirteenpointsfilewriter = new FileWriter(thirteenpointsfile, true)){
            Collections.sort(sequenciatrezepontosmaissoma);
            for(int i = 0; i< sequenciatrezepontosmaissoma.size(); i++){
                      thirteenpointsfilewriter.write(sequenciatrezepontosmaissoma.get(i).trim()+ "\n");
            }
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar treze pontos!", "Salvando treze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }
}
