package visitPlay.visitor;

import visitPlay.util.Results;

public class TopKMostFreqAnalyzer implements Visitor {
    String k;
    Results topKMostFreqAnalyzer;
    public TopKMostFreqAnalyzer(String kIn, Results topKMostFreqAnalyzerIn){
        k=kIn;
        topKMostFreqAnalyzer=topKMostFreqAnalyzerIn;
    }


}
