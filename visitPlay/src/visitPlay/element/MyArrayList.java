package visitPlay.element;

import visitPlay.util.FileProcessor;
import visitPlay.util.IteratorI;
import visitPlay.visitor.Visitor;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList implements Element, IteratorI {
    public MyArrayList(){};
    public static List<MyElement> myElements;

    private MyArrayList(List<MyElement> myElementsIn){
        myElements=myElementsIn;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Iterator getIterator() {
        return myElements.iterator();
    }


    public static class Builder{

        static FileProcessor fileProcessor;
        public Builder withFileProcessor(FileProcessor fileProcessorIn){
            fileProcessor=fileProcessorIn;
            return new Builder();
        }
        public MyArrayList build(){
            List<MyElement> myElements=new ArrayList<>();
            try {
                String line = fileProcessor.poll();
                System.out.println("line: "+line);
                while (line != null) {
                    String[] lineArray=splitSentences(line);
                    for (String s : lineArray) {
                        MyElement myElement;
                        myElement = encapsulateString(s);
                        myElements.add(myElement);
                    }
                    line = fileProcessor.poll();
                }
                fileProcessor.close();

            } catch (InvalidPathException | IOException e) {
                e.printStackTrace();
            }

            return new MyArrayList(myElements);
        }
        private MyElement encapsulateString(String sentence){
            return new MyElement(sentence);
        }
        private String[] splitSentences(String sentences){
            return sentences.split("\\.");

        }
    }

}
