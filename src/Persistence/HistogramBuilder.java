package Persistence;

import Model.Histogram;

public class HistogramBuilder<T> {

    private T[] collection;

    public HistogramBuilder(T[] collection) {
        this.collection = collection;
    }

//    Antes de modificarlo, el build() estaba así:
//
//    public Histogram<T> build() {
//        Histogram<T> histogram = new Histogram<>();
//        for (T item : collection) {
//            histogram.put(item, histogram.get(item) + 1);
//        }
//        return histogram;
//    }
    
    public <A> Histogram<A> build(AttributeExtractor<T, A> extractor) {
        Histogram<A> histogram = new Histogram<>();
        for (T item : collection) {
            A attribute = extractor.extract(item);
            histogram.put(attribute, histogram.get(attribute) + 1);
        }
        return histogram;
    }
}
