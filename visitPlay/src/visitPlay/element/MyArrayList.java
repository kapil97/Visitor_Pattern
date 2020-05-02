package visitPlay.element;

import visitPlay.util.FileProcessor;
import visitPlay.util.Iterator;
import visitPlay.visitor.Visitor;

public class MyArrayList implements Element, Iterator {
    @Override
    public void accept(Visitor visit) {
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    public static class Builder{
        public Builder withFileProcessor(FileProcessor fileProcessorIn){
            return null;
        }
        public MyArrayList build(){
            return null;
        }
    }
}
