/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import clases.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

/**
 *
 * @author juan_
 */
public class AnalisisBivariable extends javax.swing.JFrame {

    int indiceVariable1;
    int indiceVariable2;
    DataSet baseDatos;
    CoeficienteContingencia calculosCategoricos;
    CoeficienteCorrelacion calculosNumericos;
    ChartPanel panel;

    public AnalisisBivariable(int atributo1, int atributo2, DataSet baseDatos) {
        initComponents();
        //carga global de las variables recibidas
        this.indiceVariable1 = atributo1;
        this.indiceVariable2 = atributo2;
        this.baseDatos = baseDatos;

        String tipo = baseDatos.getAtributos().get(indiceVariable1).getTipoDato();
        if (tipo.equals("Numerico") || tipo.equals("numerico") || tipo.equals("Numeric")
                || tipo.equals("numeric")) {
            calculosNumericos = new CoeficienteCorrelacion(indiceVariable1, indiceVariable2, baseDatos);
            representarNumericos();
            calculosNumericos.calcularVariables();
            calculosNumericos.calcularTotal();
            calculosNumericos.calcularDesviacion();
            calculosNumericos.calcularCoeficienteCorrelacion();
            this.actualizarTextAreaNumerico();
        } else {
            calculosCategoricos = new CoeficienteContingencia(indiceVariable1, indiceVariable2, baseDatos);
            calculosCategoricos.createTable();
            calculosCategoricos.calcularFrecuenciaEsperada();
            calculosCategoricos.calcularEquisCuadrada();
            calculosCategoricos.calcularCoeficiente();
            this.actualizarTextAreaCategorico();
            representarCategoricos();
        }

    }

    public void representarCategoricos() {
        CategoryDataset dataset = createDatasetCategorico();
        JFreeChart chart = createChartStacked(dataset);

        // Create Panel
        panel = new ChartPanel(chart);
        panel.setSize(panelGrafica.getWidth(), panelGrafica.getHeight());
        panel.setVisible(true);
        panelGrafica.add(panel);
        panelGrafica.repaint();
    }

    private CategoryDataset createDatasetCategorico() {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        String nombreVertical = "";
        String nombreHorizontal = "";
        long frecuencia = 0;
        for (int i = 0; i < calculosCategoricos.getListaNombresHorizontal().size(); i++) {
            nombreHorizontal = calculosCategoricos.getListaNombresHorizontal().get(i);
            for (int j = 0; j < calculosCategoricos.getListaNombresVertical().size(); j++) {
                nombreVertical = calculosCategoricos.getListaNombresVertical().get(j);
                frecuencia = calculosCategoricos.getTablaFrecuencias().get(i).getListaValores().get(j);
                defaultcategorydataset.addValue(frecuencia, nombreVertical, nombreHorizontal);
            }
        }
        return defaultcategorydataset;
    }

    private JFreeChart createChartStacked(CategoryDataset dataset) {
        String nombre1 = baseDatos.getAtributos().get(indiceVariable1).getNombre();
        String nombre2 = baseDatos.getAtributos().get(indiceVariable2).getNombre();
        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Diagrama de Columnas Apilada " + nombre1 + " vs " + nombre2, // chart title
                "Categoria", // domain axis label
                "Frecuencia", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // the plot orientation
                true, // legend
                true, // tooltips
                false // urls
        );
        return chart;
    }

    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        return result;
    }

    private void representarNumericos() {
        // Create dataset
        XYDataset dataset = createDatasetNumerico();
        String nombre1 = baseDatos.getAtributos().get(indiceVariable1).getNombre();
        String nombre2 = baseDatos.getAtributos().get(indiceVariable2).getNombre();
        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Diagrama de Dispersion " + nombre1 + " vs " + nombre2,
                "X-" + nombre1, "Y-" + nombre2, dataset);

        //Changes background color
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));

        // Create Panel
        panel = new ChartPanel(chart);
        panel.setSize(panelGrafica.getWidth(), panelGrafica.getHeight());
        panel.setVisible(true);
        panelGrafica.add(panel);
        panelGrafica.repaint();

        //setContentPane(panel);
    }

    private XYDataset createDatasetNumerico() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Boys (Age,weight) series
        XYSeries series1 = new XYSeries("Relacion");
        double valorX;
        double valorY;
        String auxiliar1 = "";
        String auxiliar2 = "";
        String dominio1 = baseDatos.getAtributos().get(indiceVariable1).getDominio();
        String dominio2 = baseDatos.getAtributos().get(indiceVariable1).getDominio();
        for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
            auxiliar1 = baseDatos.getAtributos().get(indiceVariable1).getInstancias().get(i);
            auxiliar2 = baseDatos.getAtributos().get(indiceVariable1).getInstancias().get(i);
            if (!auxiliar1.equals(baseDatos.getFaltante()) && !auxiliar2.equals(baseDatos.getFaltante())
                    && Pattern.matches(dominio1, auxiliar1) && Pattern.matches(dominio2, auxiliar2)) {
                valorX = Double.parseDouble(baseDatos.getAtributos().get(indiceVariable1).getInstancias().get(i));
                valorY = Double.parseDouble(baseDatos.getAtributos().get(indiceVariable2).getInstancias().get(i));
                series1.add(valorX, valorY);
            }
        }
        dataset.addSeries(series1);
        return dataset;
    }

    public void actualizarTextAreaNumerico() {
        textAreaDatos.setText("");
        textAreaDatos.append("Coeficiente de Correlacion: " + calculosNumericos.getCoeficienteCorrelacion() + "\n");
        /*        textAreaDatos.append("Desviacion Estandar de X: " + calculosNumericos.getDesviacionEstandarX() + "\n");
        textAreaDatos.append("Desviacion Estandar de Y: " + calculosNumericos.getDesviacionEstandarY() + "\n");
        textAreaDatos.append("Desviacion Estandar de XY: " + calculosNumericos.getCovarianzaXY().toString() + "\n");
        textAreaDatos.append("Total de X: " + calculosNumericos.getTotalX().toString() + "\n");
        textAreaDatos.append("Total de Y: " + calculosNumericos.getTotalY().toString() + "\n");
        textAreaDatos.append("Total de XY: " + calculosNumericos.getTotalXY().toString() + "\n");
        textAreaDatos.append("Total de X2: " + calculosNumericos.getTotalX2().toString() + "\n");
        textAreaDatos.append("Total de Y2: " + calculosNumericos.getTotalY2().toString() + "\n");
        textAreaDatos.append("Media de X: " + calculosNumericos.getMediaX() + "\n");
        textAreaDatos.append("Media de Y: " + calculosNumericos.getMediaY() + "\n");*/
    }

    public void actualizarTextAreaCategorico() {
        textAreaDatos.setText("");
        textAreaDatos.append("Coeficiente de Tschuprow: " + calculosCategoricos.getCoeficienteTschuprow() + "\n");
        textAreaDatos.append("Equis Cuadrada: " + calculosCategoricos.getEquisCuadrada() + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrafica = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDatos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGrafica.setBackground(new java.awt.Color(204, 204, 255));
        panelGrafica.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelGraficaComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        textAreaDatos.setEditable(false);
        textAreaDatos.setColumns(20);
        textAreaDatos.setRows(5);
        jScrollPane1.setViewportView(textAreaDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelGraficaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelGraficaComponentResized
 //       if (panelGrafica != null) {
 //           panel.setSize(panelGrafica.getWidth(), panelGrafica.getHeight());
 //       }
    }//GEN-LAST:event_panelGraficaComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGrafica;
    private javax.swing.JTextArea textAreaDatos;
    // End of variables declaration//GEN-END:variables

}
