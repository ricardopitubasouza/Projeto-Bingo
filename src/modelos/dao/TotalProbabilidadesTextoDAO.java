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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;

/**
 *
 * @author Pituba
 */
public class TotalProbabilidadesTextoDAO {
    
      int quantidade, somadetrezeequatorze = 0, percent;
      boolean condicaoinicialzerada;
      List<String>sequenciatrezepontosmaissoma = new ArrayList<>();
      List<String>sequenciaquatorzepontosmaissoma = new ArrayList<>();
      File matriztrezepontos = new File("C:\\Meusbd\\matriztrezepontos.txt");
      File matrizquatorzepontos = new File("C:\\Meusbd\\matrizquatorzepontos.txt");
  
      
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean getCondicaoInicialZerada(){
        return condicaoinicialzerada;
    }
    
    public void setCondicaoInicialZerada(boolean condicaoinicial){
        this.condicaoinicialzerada = condicaoinicial;
    }
    
    public void salvar_totalprobabilidadestexto(File file, String probabilidades){
        try(FileWriter filewriter = new FileWriter(file, true)){
                        filewriter.write(probabilidades.trim()+"\n");
                        quantidade += 1;
                    }
                    catch(IOException e){
                         JOptionPane.showMessageDialog(null, "Erro: " + e + " ao tentar salvar "
                                 + "possibilidades!", "Loto Fácil", JOptionPane.ERROR_MESSAGE);
                    }
    }
    
    public void salvarmatriztrezepontos(File matrizthirteenpointsfile, String probabilidades){
        try(FileWriter filewriter = new FileWriter(matrizthirteenpointsfile, true)){
                        filewriter.write(probabilidades.trim()+"\n");
                    }
                    catch(IOException e){
                         JOptionPane.showMessageDialog(null, "Erro: " + e + " ao tentar salvar "
                                 + "matriz treze pontos!", "Loto Fácil", JOptionPane.ERROR_MESSAGE);
                    }
    }
    
    public void salvarmatrizquatorzepontos(File matrizfourteenpointsfile, String probabilidades){
        try(FileWriter filewriter = new FileWriter(matrizfourteenpointsfile, true)){
                        filewriter.write(probabilidades.trim()+"\n");
                    }
                    catch(IOException e){
                         JOptionPane.showMessageDialog(null, "Erro: " + e + " ao tentar salvar "
                                 + "matriz quatorze pontos!", "Loto Fácil", JOptionPane.ERROR_MESSAGE);
                    }
    }
    
    public void salvarpontonograficolevel(File dotingraficlevelfile, String dotingraficlevel){
        try(FileWriter filewriter = new FileWriter(dotingraficlevelfile, true)){
                        filewriter.write(dotingraficlevel.trim()+"\n");
                    }
                    catch(IOException e){
                         JOptionPane.showMessageDialog(null, "Erro: " + e + " ao tentar salvar "
                                 + "o ponto do gráfico!", "Loto Fácil", JOptionPane.ERROR_MESSAGE);
                    }
    }
    
    public void retornaIndex(File file, File dotingraficlevelfile, String combination){
        int contalinhas = 0;
        Integer pontonograficolevel = 0;
        String pontonograficolevelstring;     
          try {
              BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
              String line = bufferedreader.readLine();
              while(line != null){
                 contalinhas += 1;
                 if(line.equals(combination)){
                    break;
                 }
                 line = bufferedreader.readLine();
              }
          } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar pegar o Index", "Encontrando o Index"
                    , JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar ler a linha com Index", "Encontrando o Index"
                    , JOptionPane.ERROR_MESSAGE);
          }
        
        if(contalinhas <= 653752){
            pontonograficolevel = 2;
        }else if(contalinhas > 653752 && contalinhas <= 1307504){
            pontonograficolevel = 1;
        }else if(contalinhas > 1307504 && contalinhas <= 1961256){
            pontonograficolevel = 0;
        }else if(contalinhas > 1961256 && contalinhas <= 2615008){
            pontonograficolevel = -1;
        }else if (contalinhas > 2615008){
            pontonograficolevel = -2; 
        }
        
        pontonograficolevelstring = Integer.toString(pontonograficolevel);
        salvarpontonograficolevel(dotingraficlevelfile, pontonograficolevelstring);
        pontonograficolevel = 0;
        contalinhas = 0;
    }
    
    public void selecionaresalvartrezeequatorzepontos(File file, File thirteenpointsfile,
                                                      File fourteenpointsfile, File fifteenpointsfile, String probabilidade){
        
        EscritordeTrezePontos escritordetrezepontos = new EscritordeTrezePontos();
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();  
        
             String combinationwiththirteenpoints, combinationwithfourteenpoints;
             quantidade = 0;
             String vectprobabilidade[] = probabilidade.split(" ");
      new Thread(){
         @Override
         public void run(){
            try(BufferedReader bufferedreader = new BufferedReader(new FileReader(file))){
                String line = bufferedreader.readLine();
                salvarquinzepontos(fifteenpointsfile, probabilidade);      
                while(line != null){
                    quantidade = quantidade + 1;
                    String vect[] = line.split(" ");
                    for(String dezena:vectprobabilidade){
                        int compara = Arrays.binarySearch(vect, dezena);
                            if(compara >= 0){
                                somadetrezeequatorze = somadetrezeequatorze + 1;
                            }
                          compara = 0;
                        }
                switch(somadetrezeequatorze){
                    case 13:
                    //JOptionPane.showMessageDialog(null, "para treze "+somadetrezeequatorze);
                         salvartrezepontos(thirteenpointsfile, line);
                        
                             break;
                    case 14:
                    //JOptionPane.showMessageDialog(null, "para quatorze "+somadetrezeequatorze);
                         salvarquatorzepontos(fourteenpointsfile, line);
                        
                             break;
                }
                    line = bufferedreader.readLine();
                
                    somadetrezeequatorze = 0;
                    percent = (quantidade*100/3268760);
                    lblProcessando.setText("Processando..." + Integer.toString(quantidade));
                    pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    lblPercentual.setText(String.valueOf(percent) + "%");
                }
                
                   if(condicaoinicialzerada == false){
                       escritordetrezepontos.AtualizadordeTrezepontos(thirteenpointsfile, sequenciatrezepontosmaissoma);
                       escritordequatorzepontos.AtualizadordeQuatorzePontos(fourteenpointsfile, sequenciaquatorzepontosmaissoma);
                       escritordequinzepontos.AtualizadordeQuinzepontos(fifteenpointsfile, probabilidade);
                       //deletethirteenpointsfile(thirteenpointsfile);
                       //deletefourteenpointsfile(fourteenpointsfile);
                   }
            }catch(IOException e)
                    {
                        JOptionPane.showMessageDialog(null,"Erro: " + e);
                    }
         }
      }.start();
      //setCondicaoInicialZerada(false);
    }
    
    public void salvartrezepontos(File thirteenpointsfile, String thirteenpoints){
        
        EscritordeTrezePontos escritordetrezepontos = new EscritordeTrezePontos();
       
            if(condicaoinicialzerada == true){
                 escritordetrezepontos.EscritordeTrezepontos(thirteenpointsfile, thirteenpoints);
            }else
                {
                    sequenciatrezepontosmaissoma.add(thirteenpoints.trim() + " " + 1);
                }
                 
                          
    }
    
    
    
    public void deletethirteenpointsfile (File thirteenpointsfile){
        EscritordeTrezePontos escritordetrezepontos = new EscritordeTrezePontos();
        //JOptionPane.showMessageDialog(null, sequenciatrezepontosmaissoma.size());
        String sequencias = "", sequenciastemp = "";
        setQuantidade(0);
        percent = 0;
          File newthirteenpointsfiletemp = new File("C:\\Meusbd\\TrezepontosTemp.txt");
              if(!newthirteenpointsfiletemp.exists()){
            try {
                newthirteenpointsfiletemp.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ ex + "ao criar o arquivo Treze temp!", "Criando"
                        + "Quatorze temp", JOptionPane.ERROR_MESSAGE);
            }
           }
           for(String combina:sequenciatrezepontosmaissoma){
                escritordetrezepontos.AtualizadordeTrezepontos(newthirteenpointsfiletemp, sequenciatrezepontosmaissoma);
           }
               try(BufferedReader bufferedfilereaderthirteenpoints = new BufferedReader(new FileReader(thirteenpointsfile))){                
                   String thirteenpointsline = bufferedfilereaderthirteenpoints.readLine();
                       try(BufferedReader bufferedfilereaderthirteenpointstemp = new BufferedReader(new FileReader(newthirteenpointsfiletemp))){
                           String thirteenpointslinetemp = bufferedfilereaderthirteenpointstemp.readLine();
                               while(thirteenpointsline != null){
                                   String vect[] = thirteenpointsline.split(" ");
                                       for(int i=0;i<15;i++){
                                           sequencias = sequencias + vect[i] +" ";
                                       }
                                           while(thirteenpointslinetemp != null){
                                               String vecttemp[] = thirteenpointslinetemp.split(" ");
                                               for(int i=0;i<15;i++){
                                                   sequenciastemp = sequenciastemp + vecttemp[i] +" ";
                                               }
                                                   if(sequencias.trim().equals(sequenciastemp.trim())){
                                                       //sequenciatrezepontosmaissoma.add(sequencias);
                                                       sequenciastemp = "";
                                                       break;
                                                   }
                                               sequenciastemp = "";
                                               thirteenpointslinetemp = bufferedfilereaderthirteenpointstemp.readLine();
                                           }
                                       if(thirteenpointsline == null){
                                           sequenciatrezepontosmaissoma.add(thirteenpointsline);
                                       }    
                                    sequencias = "";
                                    thirteenpointsline = bufferedfilereaderthirteenpoints.readLine();
                                    
                   quantidade += 1;
                   percent = (quantidade*100/thirteenpointsline.length());
                   lblProcessando.setText("Processando treze temp..." + Integer.toString(quantidade));
                   pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                   lblPercentual.setText(String.valueOf(percent) + "%");

                              }
                           
                    }catch(IOException ioex)
                         {
                             JOptionPane.showMessageDialog(null, "Erro: "+ ioex + " ao abrir treze pontos temp!", 
                                     "Treze pontos temp", JOptionPane.ERROR_MESSAGE);
                         }
                    
               }catch(IOException e)
                    {
                         JOptionPane.showMessageDialog(null, "Erro: "+ e + " ao abrir treze pontos!", 
                                     "Treze pontos temp", JOptionPane.ERROR_MESSAGE);
                    }
               thirteenpointsfile.delete();
               setQuantidade(0);
               percent = 0;
               File newthirteenpointsfile = new File("C:\\Meusbd\\Trezepontos.txt");
               for(String combina:sequenciatrezepontosmaissoma){
                   escritordetrezepontos.AtualizadordeTrezepontos(newthirteenpointsfile, sequenciatrezepontosmaissoma);
                   quantidade += 1;
                   percent = (quantidade*100/sequenciatrezepontosmaissoma.size());
                   lblProcessando.setText("Salvando treze temp..." + Integer.toString(quantidade));
                   pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                   lblPercentual.setText(String.valueOf(percent) + "%");
                 }
              sequenciatrezepontosmaissoma.clear();
              setQuantidade(0);
              percent = 0;
    }
    
    public void salvarquatorzepontos(File fourteenpointsfile, String fourteenpoints){
      //String sequencias = "", vetorquinzestr;
        //int vetorquinzeint;
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
        //Combinacoes combinacoes = new Combinacoes();
        
        //try(BufferedReader bufferedfilereaderfourteenpoints = new BufferedReader(new FileReader(fourteenpointsfile))){
            //String line = bufferedfilereaderfourteenpoints.readLine();
            if(condicaoinicialzerada == true){
                 escritordequatorzepontos.EscritordeQuatorzePontos(fourteenpointsfile, fourteenpoints);
            }else
                {
                    sequenciaquatorzepontosmaissoma.add(fourteenpoints.trim() + " " + 1);
                }
                  /*  while(line != null){
                        String vect[] = line.split(" ");
                        vetorquinzeint = Integer.valueOf(vect[15]);
                        for(int i=0;i<15;i++){
                            sequencias = sequencias + vect[i] +" ";
                        }
                            if(sequencias.trim().equals(fourteenpoints.trim())){
                                vect[15] = Integer.toString(vetorquinzeint + 1);
                                vetorquinzestr = vect[15];
                                sequencias = sequencias + vetorquinzestr;
                                //salvarmatrizquatorzepontos(matrizquatorzepontos, sequencias);
                                sequenciaquatorzepontosmaissoma.add(sequencias);
                                bufferedfilereaderfourteenpoints.close();
                                vetorquinzeint = 0;
                                sequencias = "";
                                break;
                            }   
                            sequencias = "";
                            line = bufferedfilereaderfourteenpoints.readLine();
                    }   
                if(line == null){
                    sequenciaquatorzepontosmaissoma.add(fourteenpoints + " " + 0);    
                }
                      bufferedfilereaderfourteenpoints.close();
                */
        //}catch(IOException e){
             //JOptionPane.showMessageDialog(null, "Erro: " + e + " ao encher a lista");
        //}
        
    }
    
    public void deletefourteenpointsfile(File fourteenpointsfile){
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
        //fourteenpointsfile.delete();
        String sequencias = "", sequenciastemp = "";
        setQuantidade(0);
        percent = 0;
           File newfourteenpointsfiletemp = new File("C:\\Meusbd\\QuatorzepontosTemp.txt");
           if(!newfourteenpointsfiletemp.exists()){
            try {
                newfourteenpointsfiletemp.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ ex + "ao criar o arquivo quatorze temp!", "Criando"
                        + "Quatorze temp", JOptionPane.ERROR_MESSAGE);
            }
           }
           for(String combina:sequenciatrezepontosmaissoma){
                escritordequatorzepontos.AtualizadordeQuatorzePontos(newfourteenpointsfiletemp, sequenciatrezepontosmaissoma);
           }
                try(BufferedReader bufferedfilereaderfourteenpoints = new BufferedReader(new FileReader(fourteenpointsfile))){                
                   String fourteenpointsline = bufferedfilereaderfourteenpoints.readLine();
                       try(BufferedReader bufferedfilereaderfourteenpointstemp = new BufferedReader(new FileReader(newfourteenpointsfiletemp))){
                           String fourteenpointslinetemp = bufferedfilereaderfourteenpointstemp.readLine();
                               while(fourteenpointsline != null){
                                   String vect[] = fourteenpointsline.split(" ");
                                       for(int i=0;i<15;i++){
                                           sequencias = sequencias + vect[i] +" ";
                                       }
                                           while(fourteenpointslinetemp != null){
                                               String vecttemp[] = fourteenpointslinetemp.split(" ");
                                               for(int i=0;i<15;i++){
                                                   sequenciastemp = sequenciastemp + vecttemp[i] +" ";
                                               }
                                                   if(sequencias.trim().equals(sequenciastemp.trim())){
                                                       //sequenciatrezepontosmaissoma.add(sequencias);
                                                       sequenciastemp = "";
                                                       break;
                                                   }
                                               sequenciastemp = "";
                                               fourteenpointslinetemp = bufferedfilereaderfourteenpointstemp.readLine();
                                           }
                                       if(fourteenpointsline == null){
                                           sequenciaquatorzepontosmaissoma.add(fourteenpointsline);
                                       }    
                                    sequencias = "";
                                    fourteenpointsline = bufferedfilereaderfourteenpoints.readLine();
                                    
                   quantidade += 1;
                   percent = (quantidade*100/fourteenpointsline.length());
                   lblProcessando.setText("Processando quatorze temp..." + Integer.toString(quantidade));
                   pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                   lblPercentual.setText(String.valueOf(percent) + "%");

                              }
                           
                    }catch(IOException ioex)
                         {
                             JOptionPane.showMessageDialog(null, "Erro: "+ ioex + " ao abrir quatorze pontos temp!", 
                                     "Treze pontos temp", JOptionPane.ERROR_MESSAGE);
                         }
                    
               }catch(IOException e)
                    {
                         JOptionPane.showMessageDialog(null, "Erro: "+ e + " ao abrir quatorze pontos!", 
                                     "Quatorze pontos temp", JOptionPane.ERROR_MESSAGE);
                    }
               fourteenpointsfile.delete();
               setQuantidade(0);
               percent = 0;
               File newfourteenpointsfile = new File("C:\\Meusbd\\Quatorzepontos.txt");
               for(String combina:sequenciaquatorzepontosmaissoma){
                   escritordequatorzepontos.AtualizadordeQuatorzePontos(newfourteenpointsfile, sequenciaquatorzepontosmaissoma);
                   quantidade += 1;
                   percent = (quantidade*100/sequenciaquatorzepontosmaissoma.size());
                   lblProcessando.setText("Salvando quatorze temp..." + Integer.toString(quantidade));
                   pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                   lblPercentual.setText(String.valueOf(percent) + "%");
                 }
              sequenciaquatorzepontosmaissoma.clear();
              setQuantidade(0);
              percent = 0;
    }
    
    public void salvarquinzepontos(File fifteenpointsfile, String fifteenpoints){
        
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
       
            if(condicaoinicialzerada == true){
                 escritordequinzepontos.EscritordeQuinzepontos(fifteenpointsfile, fifteenpoints);
            //}else
                //{
                    //sequenciaquinzepontosmaissoma.add(fifteenpoints.trim() + " " + 1);
                }
                 
                          
    }
    
    public void buscarsequenciaemtrezepontos(File thirteenpointsfilereader, String thirteenpointssequence){
        int somarumasequencia = 0;
        try(BufferedReader bufferedreaderthirteenpoints = new BufferedReader(new FileReader(thirteenpointsfilereader))){
            String linethirteenpoints = bufferedreaderthirteenpoints.readLine();
               while(linethirteenpoints != null){
                   if(linethirteenpoints.compareTo(thirteenpointssequence) == 0){
                       String vectthirteenpoints[] = thirteenpointssequence.split(" ");
                       somarumasequencia = (Integer.valueOf(vectthirteenpoints[14])) + 1;                      
                       
                   }
                   linethirteenpoints = bufferedreaderthirteenpoints.readLine();
               }
        }catch(IOException e)
             {
                 JOptionPane.showMessageDialog(null, "Erro: " + e + " ao atualizar treze pontos!", "Atualizando"
                         + "treze pontos", JOptionPane.ERROR_MESSAGE);
             }
    }
    
    public void salvarteste(File thirteenpointsfile, String thirteenpoints){
        try(FileWriter thirteenpointsfilewriter = new FileWriter(thirteenpointsfile, true)){
            thirteenpointsfilewriter.write(thirteenpoints.trim()+"\n");
        }catch(IOException e)
             {
                JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                        + "salvar treze pontos!", "Salvando treze pontos",
                        JOptionPane.ERROR_MESSAGE);
             }
                          
    }
    
}