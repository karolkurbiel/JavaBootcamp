package itacademy._15.itemsstorecatalogue;

import java.util.Comparator;
import java.util.Map;

public class ItemByPriceComparator implements Comparator<Map.Entry<String, Item>>  {

    @Override
    public int compare(Map.Entry<String, Item> o1, Map.Entry<String, Item> o2) {
        return Double.compare(o1.getValue().getPrice(),o2.getValue().getPrice());
    }
}
