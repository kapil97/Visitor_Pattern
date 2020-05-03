package visitPlay.visitor;

import visitPlay.element.Element;
import visitPlay.element.MyElement;
import visitPlay.util.Results;

public class SpellCheckAnalyzer implements Visitor {
    String spellCheckOutputFilename;
    Results spellCheckAnalyzer;
    public SpellCheckAnalyzer(String spellCheckOutputFilenameIn, Results spellCheckAnalyzerIn){
        spellCheckAnalyzer=spellCheckAnalyzerIn;
        spellCheckOutputFilename=spellCheckOutputFilenameIn;
    }

    @Override
    public void visit(Element myElement) {

    }
}
