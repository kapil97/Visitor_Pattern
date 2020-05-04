package visitPlay.visitor;

import visitPlay.element.Element;
import visitPlay.element.MyArrayList;
import visitPlay.util.ElementCheck;
import visitPlay.util.ElementComparator;
import visitPlay.util.Results;
import visitPlay.util.WordMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.LinkedHashMap;


public class TopKMostFreqAnalyzer implements Visitor {
    String k;
    Results topKMostFreqAnalyzerResults;
    /**
     * TopKMostFreqAnalyzer Constructor.
     * @param kIn
     * @param topKMostFreqAnalyzerResultsIn
     */
    public TopKMostFreqAnalyzer(String kIn, Results topKMostFreqAnalyzerResultsIn){
        k=kIn;
        topKMostFreqAnalyzerResults=topKMostFreqAnalyzerResultsIn;
    }

    /**
     * Visit method of the visitor.
     * @param element
     */
    @Override
    public void visit(Element element) {
        Iterator iterator=((MyArrayList)element).getIterator();
        while(iterator.hasNext()) {
            Element currentElement=(Element) iterator.next();
            //System.out.println("Element is: " + currentElement.toString());
            calculateTopKFreqWords(currentElement);
        }
    }

    /**
     * Private Methods for Calculate Top K frequent words.
     * @param element
     */
    private void calculateTopKFreqWords(Element element){

        Map<String, Integer> wordFrequency=new LinkedHashMap<>();
        List<String> resultList=new ArrayList<>();
        String[] words=element.toString().split(" ");

        for(int i=0;i<words.length;i++){
            words[i]=words[i].toLowerCase();
        }

        for (String word : words) {
            if(!word.equals(""))
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else
                wordFrequency.put(word, 1);
        }

        Queue<WordMap> priorityQueue = new PriorityQueue<WordMap>(new ElementComparator());

        for (Map.Entry mapElement : wordFrequency.entrySet()) {
                String currentWord=(String)mapElement.getKey();
                int count=(int)mapElement.getValue();
                priorityQueue.add(new ElementCheck(currentWord,count));
            }

        WordMap currentElement;

        for(int i=0;i<Integer.parseInt(k);i++){
            currentElement=priorityQueue.poll();
            if (currentElement != null) {
                resultList.add(currentElement.getWord());
                //System.out.println("Word: "+currentElement.getWord()+" Count: "+currentElement.getCount());
            }
        }

        System.out.println("Result List of TopK >>> "+resultList);
        topKMostFreqAnalyzerResults.addToResultList(resultList);
    }
    @Override
    public String toString(){
        return "TopKMostFreqAnalyzer";
    }
}
