package visitPlay.element;

import visitPlay.util.FileProcessor;
import visitPlay.util.Iterator;
import visitPlay.visitor.Visitor;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements Element, Iterator {
    public List<MyElement> myElements;
    private MyArrayList(List<MyElement> myElementsIn){
        myElements=myElementsIn;
    }

    @Override
    public String getLine() {
        return null;
    }

    @Override
    public void accept(Visitor visit) {
    }

    @Override
    public Iterator getIterator() {
        return null;
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

            System.out.println("Control Reached Here in build()");
            System.out.println("List:" +myElements);
            for (MyElement myElement : myElements) {
                System.out.println("Lines in List: " + myElement.getLine());
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
