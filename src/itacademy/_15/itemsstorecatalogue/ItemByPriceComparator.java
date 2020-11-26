package itacademy._15.itemsstorecatalogue;

import java.util.Comparator;
import java.util.Map;

public class ItemByPriceComparator implements Comparator<String>  {

    private final Map<String, Item> base;

    public ItemByPriceComparator(Map<String, Item> base) {
        this.base = base;
    }

    @Override
    public int compare(String o1, String o2) {
        return Double.compare(base.get(o1).getPrice(), base.get(o2).getPrice());
    }
}
