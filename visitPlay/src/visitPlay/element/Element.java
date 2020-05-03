package visitPlay.element;

import visitPlay.visitor.Visitor;

import java.util.Iterator;

public interface Element {
    void accept(Visitor visit);

}
