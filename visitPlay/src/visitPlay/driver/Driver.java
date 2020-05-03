package visitPlay.driver;

import visitPlay.element.Element;
import visitPlay.element.MyArrayList;
import visitPlay.util.*;
import visitPlay.visitor.SpellCheckAnalyzer;
import visitPlay.visitor.TopKMostFreqAnalyzer;
import visitPlay.visitor.Visitor;
import java.io.IOException;

public class Driver {
    private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) {
        Element myArrayList = new MyArrayList.Builder()
                .withFileProcessor(fileProcessor)
                .build();

        for (Visitor visitor : visitors) {
            myArrayList.accept(visitor);
        }
    }

    private static void persistResults(Results... analysisResults) {
        for (Results results : analysisResults) {
            results.writeToFile();
        }
    }

    public static void main(String[] args) {

        final int REQUIRED_NUMBER_OF_ARGS = 5;
        if ((args.length != REQUIRED_NUMBER_OF_ARGS)||
                (args[0].equals("${input}")) ||
                (args[1].equals("${acceptableWordsFile}")) ||
                (args[2].equals("${k}"))||
                (args[3].equals("${topKOutputFileName}")) ||
                (args[4].equals("${spellCheckOutputFilename}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments. Provided: %d " , REQUIRED_NUMBER_OF_ARGS, args.length );
            System.exit(0);
        }
        String inputFilename=args[0],
                acceptableWordsFilename=args[1],
                k=args[2],
                topKOutputFilename=args[3],
                spellCheckOutputFilename=args[4];
        ValidatorI validator=new Validator(inputFilename,acceptableWordsFilename,k);
        if(validator.valid()) {
            FileProcessor fileProcessor = null;
            try {
                fileProcessor = new FileProcessor(inputFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Results topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
            Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

            Results spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
            Visitor spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);

            runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);
            persistResults(topKFreqWordsResults, spellCheckResults);
        }
        else
        {
            System.exit(0);
        }
    }
}
