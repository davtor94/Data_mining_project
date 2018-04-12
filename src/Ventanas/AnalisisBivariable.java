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

    public AnalisisBivariable(int atributo1, int atributo2, DataSet baseDatos) {
        initComponents();
        //carga global de las variables recibidas
        this.indiceVariable1 = atributo1;
        this.indiceVariable2 = atributo2;
        this.baseDatos = baseDatos;

        String tipo = baseDatos.getAtributos().get(indiceVariable1).getTipoDato();
        if (tipo.equals("Numerico") || tipo.equals("numerico") || tipo.equals("Numeric")
                || tipo.equals("numeric")) {
            calculosNumericos = new CoeficienteCorrelacion();
            representarNumericos();
        } else {
            representarCategoricos();
            calculosCategoricos = new CoeficienteContingencia(baseDatos.getAtributos().get(indiceVariable1), baseDatos.getAtributos().get(indiceVariable2));
            calculosCategoricos.createTable();
            calculosCategoricos.calcularFrecuenciaEsperada();
            calculosCategoricos.calcularEquisCuadrada();
            calculosCategoricos.calcularCoeficiente();
            this.actualizarTextAreaCategorico();
        }
        
    }

    public void representarCategoricos() {
        CategoryDataset dataset = createDatasetCategorico();
        JFreeChart chart = createChartStacked(dataset);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setSize(panelGrafica.getWidth(), panelGrafica.getHeight());
        panel.setVisible(true);
        panelGrafica.add(panel);
        panelGrafica.repaint();
    }

    /*    private CategoryDataset createDatasetCategorico() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(20, "Product 1 (US)", "Jan 04");
        result.addValue(20, "Product 1 (US)", "Feb 04");
        result.addValue(20, "Product 1 (US)", "Mar 04");
        result.addValue(20, "Product 1 (Europe)", "Jan 04");
        result.addValue(10.9, "Product 1 (Europe)", "Feb 04");
        result.addValue(18.4, "Product 1 (Europe)", "Mar 04");
        result.addValue(20, "Product 1 (Asia)", "Jan 04");
        result.addValue(15.9, "Product 1 (Asia)", "Feb 04");
        result.addValue(16.1, "Product 1 (Asia)", "Mar 04");
        result.addValue(20, "Product 1 (Middle East)", "Jan 04");
        result.addValue(14.4, "Product 1 (Middle East)", "Feb 04");
        result.addValue(13.7, "Product 1 (Middle East)", "Mar 04");

        result.addValue(23.3, "Product 2 (US)", "Jan 04");
        result.addValue(16.2, "Product 2 (US)", "Feb 04");
        result.addValue(28.7, "Product 2 (US)", "Mar 04");
        result.addValue(12.7, "Product 2 (Europe)", "Jan 04");
        result.addValue(17.9, "Product 2 (Europe)", "Feb 04");
        result.addValue(12.6, "Product 2 (Europe)", "Mar 04");
        result.addValue(15.4, "Product 2 (Asia)", "Jan 04");
        result.addValue(21.0, "Product 2 (Asia)", "Feb 04");
        result.addValue(11.1, "Product 2 (Asia)", "Mar 04");
        result.addValue(23.8, "Product 2 (Middle East)", "Jan 04");
        result.addValue(23.4, "Product 2 (Middle East)", "Feb 04");
        result.addValue(19.3, "Product 2 (Middle East)", "Mar 04");

        result.addValue(11.9, "Product 3 (US)", "Jan 04");
        result.addValue(31.0, "Product 3 (US)", "Feb 04");
        result.addValue(22.7, "Product 3 (US)", "Mar 04");
        result.addValue(15.3, "Product 3 (Europe)", "Jan 04");
        result.addValue(14.4, "Product 3 (Europe)", "Feb 04");
        result.addValue(25.3, "Product 3 (Europe)", "Mar 04");
        result.addValue(23.9, "Product 3 (Asia)", "Jan 04");
        result.addValue(19.0, "Product 3 (Asia)", "Feb 04");
        result.addValue(10.1, "Product 3 (Asia)", "Mar 04");
        result.addValue(13.2, "Product 3 (Middle East)", "Jan 04");
        result.addValue(15.5, "Product 3 (Middle East)", "Feb 04");
        result.addValue(10.1, "Product 3 (Middle East)", "Mar 04");
        return result;
    }*/
    private CategoryDataset createDatasetCategorico() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(10D, "Series 1", "Jan");
        defaultcategorydataset.addValue(12D, "Series 1", "Feb");
        defaultcategorydataset.addValue(13D, "Series 1", "Mar");
        defaultcategorydataset.addValue(4D, "Series 2", "Jan");
        defaultcategorydataset.addValue(3D, "Series 2", "Feb");
        defaultcategorydataset.addValue(2D, "Series 2", "Mar");
        defaultcategorydataset.addValue(2D, "Series 3", "Jan");
        defaultcategorydataset.addValue(3D, "Series 3", "Feb");
        defaultcategorydataset.addValue(2D, "Series 3", "Mar");
        defaultcategorydataset.addValue(2D, "Series 4", "Jan");
        defaultcategorydataset.addValue(3D, "Series 4", "Feb");
        defaultcategorydataset.addValue(4D, "Series 4", "Mar");
        return defaultcategorydataset;
    }

    private JFreeChart createChartStacked(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Stacked Bar Chart Demo 1", // chart title
                "Category", // domain axis label
                "Value", // range axis label
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
        ChartPanel panel = new ChartPanel(chart);
        panel.setSize(panelGrafica.getWidth(), panelGrafica.getHeight());
        panel.setVisible(true);
        panelGrafica.add(panel);
        panelGrafica.repaint();

        //setContentPane(panel);
        //Calculo del Coeficiente de Correlacion
        int valorX;
        int valorY;
        for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
            valorX = Integer.parseInt(baseDatos.getAtributos().get(indiceVariable1).getInstancias().get(i));
            valorY = Integer.parseInt(baseDatos.getAtributos().get(indiceVariable2).getInstancias().get(i));
            calculosNumericos.getListaX().add(valorX);
            calculosNumericos.getListaY().add(valorY);
        }
        calculosNumericos.calcularVariables();
        calculosNumericos.calcularTotal();
        calculosNumericos.calcularDesviacion();
        calculosNumericos.calcularCoeficienteCorrelacion();
        this.actualizarTextAreaNumerico();
    }

    private XYDataset createDatasetNumerico() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Boys (Age,weight) series
        XYSeries series1 = new XYSeries("Relacion");
        int valorX;
        int valorY;
        for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
            valorX = Integer.parseInt(baseDatos.getAtributos().get(indiceVariable1).getInstancias().get(i));
            valorY = Integer.parseInt(baseDatos.getAtributos().get(indiceVariable2).getInstancias().get(i));
            series1.add(valorX, valorY);
        }
        dataset.addSeries(series1);
        return dataset;
    }

    public void actualizarTextAreaNumerico() {
        textAreaDatos.setText("");
        textAreaDatos.append("Coeficiente de Correlacion: " + calculosNumericos.getCoeficienteCorrelacion() + "\n");
        textAreaDatos.append("Desviacion Estandar de X: " + calculosNumericos.getDesviacionEstandarX() + "\n");
        textAreaDatos.append("Desviacion Estandar de Y: " + calculosNumericos.getDesviacionEstandarY() + "\n");
        textAreaDatos.append("Desviacion Estandar de XY: " + calculosNumericos.getCovarianzaXY().toString() + "\n");
        textAreaDatos.append("Total de X: " + calculosNumericos.getTotalX().toString() + "\n");
        textAreaDatos.append("Total de Y: " + calculosNumericos.getTotalY().toString() + "\n");
        textAreaDatos.append("Total de XY: " + calculosNumericos.getTotalXY().toString() + "\n");
        textAreaDatos.append("Total de X2: " + calculosNumericos.getTotalX2().toString() + "\n");
        textAreaDatos.append("Total de Y2: " + calculosNumericos.getTotalY2().toString() + "\n");
        textAreaDatos.append("Media de X: " + calculosNumericos.getMediaX() + "\n");
        textAreaDatos.append("Media de Y: " + calculosNumericos.getMediaY() + "\n");
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

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
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
                .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGrafica;
    private javax.swing.JTextArea textAreaDatos;
    // End of variables declaration//GEN-END:variables

}
