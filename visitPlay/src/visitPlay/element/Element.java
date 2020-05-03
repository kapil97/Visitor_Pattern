package visitPlay.element;

import visitPlay.visitor.Visitor;

public interface Element {
    String getLine();
    void accept(Visitor visit);
}
