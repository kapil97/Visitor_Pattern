package visitPlay.element;

import visitPlay.visitor.Visitor;

import java.util.Iterator;

public class MyElement implements Element {
    String line;
    public MyElement(String lineIn){
        line=lineIn;
    }
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }




    @Override
    public String toString(){
        return line;
    }
}
