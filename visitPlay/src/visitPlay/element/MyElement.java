package visitPlay.element;

import visitPlay.visitor.Visitor;

public class MyElement implements Element {
    String line;
    public MyElement(String lineIn){
        line=lineIn;
    }

    @Override
    public String getLine() {
        return line;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
