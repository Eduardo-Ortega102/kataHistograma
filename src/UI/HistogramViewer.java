package UI;

import Model.Histogram;

public abstract class HistogramViewer<T> {
    private Histogram<T> histogram;

    public HistogramViewer(Histogram<T> histogram) {
        this.histogram = histogram;
    }

    public Histogram<T> getHistogram() {
        return histogram;
    }
    
    public abstract void show();
    
}
