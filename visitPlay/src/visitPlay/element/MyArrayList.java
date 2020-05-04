package visitPlay.element;

import visitPlay.util.FileProcessor;
import visitPlay.visitor.Visitor;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList implements Element{
    public static List<MyElement> myElements;

    /**
     * MyArrayList Constructor
     * @param myElementsIn
     */
    private MyArrayList(List<MyElement> myElementsIn){
        myElements=myElementsIn;
    }

    /**
     * Method to accept the visitor
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Method to get Iterator
     * @return
     */

    public Iterator getIterator() {
        return myElements.iterator();
    }

    /**
     * Builder Class is a inner class to build the MyArrayList Class.
     */
    public static class Builder{

        static FileProcessor fileProcessor;

        /**
         * Accepting file processor instance to build the MyArrayList Constructor
         * @param fileProcessorIn
         * @return
         */
        public Builder withFileProcessor(FileProcessor fileProcessorIn){
            fileProcessor=fileProcessorIn;
            return new Builder();
        }

        /**
         * Building the MyArrayList
         * @return instance of MyArrayList
         */
        public MyArrayList build(){
            List<MyElement> myElements=new ArrayList<>();
            try {
                String line = fileProcessor.poll();
                System.out.println("line: "+line);
                while (line != null) {
                    String[] lineArray=splitSentences(line);
                    for (String s : lineArray) {
                        Element myElement;
                        myElement = encapsulateString(s);
                        myElements.add((MyElement)myElement);
                    }
                    line = fileProcessor.poll();
                }
                fileProcessor.close();

            } catch (InvalidPathException | IOException e) {
                e.printStackTrace();
            }

            return new MyArrayList(myElements);
        }

        /**
         * Encapsulating String to MyElement
         * @param sentence
         * @return
         */
        private Element encapsulateString(String sentence){
            return new MyElement(sentence);
        }

        /**
         * Splitting Sentences.
         * @param sentences
         * @return
         */
        private String[] splitSentences(String sentences){
            return sentences.split("\\.");

        }

        @Override
        public String toString(){
            return "Builder";
        }

    }
    @Override
        public String toString(){
            return "MyArrayList";
    }
}
