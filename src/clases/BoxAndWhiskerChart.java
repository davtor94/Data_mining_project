package clases;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;

/*import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChart extends ApplicationFrame {

  public BoxAndWhiskerChart(String titel) {
  super(titel);

  final BoxAndWhiskerCategoryDataset dataset = createSampleDataset();
  final JFreeChart chart = createChart(dataset);

  final ChartPanel chartPanel = new ChartPanel(chart);
  //chartPanel.setPreferredSize(new java.awt.Dimension(1500, 1300));
  setContentPane(chartPanel);

  }
 
   private BoxAndWhiskerCategoryDataset createSampleDataset() {
         final int seriesCount = 3;
        final int categoryCount = 6;
        final int entityCount = 1;
        
        final DefaultBoxAndWhiskerCategoryDataset dataset 
            = new DefaultBoxAndWhiskerCategoryDataset();
        for (int i = 0; i < seriesCount; i++) {
            for (int j = 0; j < categoryCount; j++) {
                final List list = new ArrayList();
                // add some values...
                for (int k = 0; k < entityCount; k++) {
                    final double value1 = 10.0 + Math.random() * 3;
                    list.add(new Double(value1));
                    final double value2 = 11.25 + Math.random(); // concentrate values in the middle
                    list.add(new Double(value2));
                    list.add(new Double(12));
                }

                dataset.add(list, "Series "+j, " Type "+i);
            }
            
        }

        return dataset;
    }

  private JFreeChart createChart(
   final BoxAndWhiskerCategoryDataset dataset) {
  JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
  "UniVariable", " ", " ", dataset, false);
  chart.setBackgroundPaint(new Color(249, 231, 236));
  

  return chart;
  }

  public static void main(final String[] args) {

   BoxAndWhiskerChart demo = new BoxAndWhiskerChart("");
  demo.pack();
  
  RefineryUtilities.centerFrameOnScreen(demo);
  
  demo.setVisible(true);
  }

}
*/