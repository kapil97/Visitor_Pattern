package visitPlay.visitor;

import visitPlay.element.Element;
import visitPlay.element.MyArrayList;
import visitPlay.util.FileProcessor;
import visitPlay.util.IteratorI;
import visitPlay.util.Results;
import java.io.IOException;
import java.util.*;

public class SpellCheckAnalyzer implements Visitor {
    String acceptableWordsFilename;
    Results spellCheckAnalyzerResults;
    List<String> resultList=new ArrayList<>();
    private final Map<Integer, List<String>> acceptableWords=new HashMap<>();
    IteratorI myIterator=new MyArrayList();

    /**
     * Spell Check Analyzer Constructor to process acceptable words file.
     * @param acceptableWordsFilenameIn
     * @param spellCheckAnalyzerResultsIn
     */
    public SpellCheckAnalyzer(String acceptableWordsFilenameIn, Results spellCheckAnalyzerResultsIn){
        spellCheckAnalyzerResults=spellCheckAnalyzerResultsIn;
        acceptableWordsFilename=acceptableWordsFilenameIn;
        processAcceptableFile(acceptableWordsFilenameIn);
    }

    /**
     * Process Acceptable Words File.
     * @param acceptableWordsFilename
     */
    private void processAcceptableFile(String acceptableWordsFilename){
        try {
            FileProcessor fileProcessor=new FileProcessor(acceptableWordsFilename);
            String line=fileProcessor.poll();
            while(line!=null){
                //System.out.println("Line in Acceptable file is: "+line);
                addToAcceptableWordsMap(line);
                line = fileProcessor.poll();
            }
            fileProcessor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Visit method of SpellCheckAnalyzer method.
     * @param myElement
     */
    @Override
    public void visit(Element myElement) {
        Iterator iterator=myIterator.getIterator();
        while(iterator.hasNext()) {
            Element currentElement=(Element) iterator.next();
            spellCheckByLength(currentElement);
            //System.out.println("Element in Spell Check Analyser is: " + currentElement.toString());
        }
        //System.out.println("MAP: "+acceptableWords);
        spellCheckAnalyzerResults.addToResultList(resultList);
        System.out.println("Result List of SpellCheck >>> "+resultList);
    }

    /**
     * Private methods to perform spell Check.
     * @param element
     */
    private void spellCheckByLength(Element element){
        String[] words=element.toString().split(" ");
        System.out.println();
        for(int i=0;i<words.length;i++){
            words[i]=words[i].toLowerCase();
        }
        for(String word:words) {
            for (Map.Entry mapElement : acceptableWords.entrySet()) {
                int length = word.length();
                if(length>2) {
                    if ((int) mapElement.getKey() == length) {
                        List<String> acceptableWordsListByLength = (List<String>) mapElement.getValue();
                        spellCheck(word, acceptableWordsListByLength);
                    }
                }
            }
        }
    }
    private void spellCheck(String word,List<String> acceptableList){
        String result="";
        //System.out.println("Word: "+ word+" List: "+ acceptableList);
        for (String string : acceptableList) {
            boolean ifMatches = comparator(word,string);
            if(ifMatches){
                  if(result.isEmpty())
                      result=result+word+"::["+string;
                  else
                      result=result+", "+string;
            }
        }
        result+="]";
        if(result.length()>1)
            resultList.add(result);
    }
    private boolean comparator(String word, String wordFromList){
        int count=0;
        char[] wordArray=word.toCharArray();
        char[] acceptableWordArray=wordFromList.toCharArray();
        for(int i=0;i<word.length();i++){
            if(wordArray[i]!=acceptableWordArray[i])
                count++;

        }
        //System.out.println("COUNT>> "+count);
        return count == 1;

    }
    private void addToAcceptableWordsMap(String word){
        int length=word.length();
        if (!acceptableWords.containsKey(length)) {
            acceptableWords.put(length, new ArrayList<>());
        }
        acceptableWords.get(length).add(word.toLowerCase());
        }
    @Override
    public String toString(){
        return "SpellCheckAnalyzer";
    }
}

