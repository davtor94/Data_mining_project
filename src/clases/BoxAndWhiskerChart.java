package clases;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;

public class BoxAndWhiskerChart extends JFrame {
    atributo atribut;
  public BoxAndWhiskerChart(String titel, atributo atr) {
  super(titel);
  atribut = atr;
  final DefaultBoxAndWhiskerXYDataset dataset = createDataset();
  final JFreeChart chart = createChart(dataset);

  final ChartPanel chartPanel = new ChartPanel(chart);
  chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
  setContentPane(chartPanel);


  }
 
   private DefaultBoxAndWhiskerXYDataset createDataset() {

        final List list = new ArrayList();
        RegularTimePeriod t = new Day();
        final DefaultBoxAndWhiskerXYDataset dataset 
            = new DefaultBoxAndWhiskerXYDataset("atributo");
         for(int i =0;i<atribut.getInstancias().size();i++){
                    list.add(new Double(atribut.getInstancias().get(i)));
                }
         dataset.add(t.getStart(),
                    BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(
                    list)); 
        return dataset;
    }

  private JFreeChart createChart(
   final DefaultBoxAndWhiskerXYDataset dataset) {
  DateAxis domainAxis = new DateAxis(atribut.getNombre());
        NumberAxis rangeAxis = new NumberAxis("Valor");
        XYItemRenderer renderer = new XYBoxAndWhiskerRenderer();
        XYPlot plot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);
        JFreeChart chart = new JFreeChart("Box-Plot "+atribut.getNombre(), plot);

        chart.setBackgroundPaint(Color.BLACK);
        plot.setBackgroundPaint(Color.CYAN);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme(chart);
        return chart;

  }

  public static void main(final String[] args) {
  }

}
