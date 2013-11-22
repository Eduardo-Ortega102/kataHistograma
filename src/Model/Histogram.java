package Model;

import java.util.HashMap;

public class Histogram<T> extends HashMap<T, Integer> {

    @Override
    public Integer get(Object key) {
        return containsKey((T) key) ? super.get(key) : 0;
    }
}
