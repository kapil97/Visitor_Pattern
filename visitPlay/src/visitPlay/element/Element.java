package visitPlay.element;

import visitPlay.visitor.Visitor;

public interface Element {
    void accept(Visitor visit);

}
