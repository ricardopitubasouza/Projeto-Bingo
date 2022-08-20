/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Pituba
 */
public class GraficoNivel {
    public void GraficoNivel(File dotingraficlevelfile){
        int contando = 0;
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
     try {
              BufferedReader bufferedreader = new BufferedReader(new FileReader(dotingraficlevelfile));
              String line = bufferedreader.readLine();
              dataset.setValue(-2, "", "");
              dataset.setValue(2, "", "");
              while(line != null){
                 contando += 1;
                 dataset.addValue(Integer.parseInt(line), "Nível", String.valueOf(contando));
                 line = bufferedreader.readLine();
              }
              JFreeChart chart = ChartFactory.createLineChart("Níveis dos sorteios",
                      "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);
              
              chart.setBackgroundPaint(Color.WHITE);
              chart.getTitle().setPaint(Color.BLUE);
              CategoryPlot p = chart.getCategoryPlot();
              p.setForegroundAlpha(0.9f);
              p.setRangeGridlinePaint(Color.black);
              p.setDomainGridlinesVisible(true);
              p.setDomainGridlinePaint(Color.BLACK);
              CategoryItemRenderer renderer = p.getRenderer();
              renderer.setSeriesPaint(1, Color.GREEN);
              renderer.setSeriesPaint(0, Color.WHITE);
              ChartFrame Frame1 = new ChartFrame("Gráfico de Linha", chart);
              Frame1.setVisible(true);
              Frame1.setSize(1360, 300);
          } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar pegar o Index", "Encontrando o Index"
                    , JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar pegar o Index", "Encontrando o Index"
                    , JOptionPane.ERROR_MESSAGE);
          }
    }
}
