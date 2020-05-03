package visitPlay.util;

import java.util.Comparator;

public class ElementComparator implements Comparator<WordMap> {
    @Override
    public int compare(WordMap element1, WordMap element2) {
        int element1Count = element1.getCount();
        int element2Count = element2.getCount();
        return Integer.compare(element2Count, element1Count);
    }
}
