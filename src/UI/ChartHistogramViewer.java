package UI;

import Model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class ChartHistogramViewer<T> extends HistogramViewer<T> {

    public ChartHistogramViewer(Histogram<T> histogram) {
        super(histogram);
    }

    @Override
    public void show() {
        ApplicationFrame frame = new ApplicationFrame("Histogram");
        frame.add(createChartPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private ChartPanel createChartPanel() {
        ChartPanel chartPanel= new ChartPanel(createChart());
        return chartPanel;
    }

    private JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", "Categories", "Frequency", createDataset());
        return chart;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T item : getHistogram().keySet()) {
            dataset.addValue(getHistogram().get(item), "Categories", (String)item);
        }
        return dataset;
    }
}
