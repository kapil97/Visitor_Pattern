package visitPlay.visitor;

import visitPlay.util.Results;

public class SpellCheckAnalyzer implements Visitor {
    String spellCheckOutputFilename;
    Results spellCheckAnalyzer;
    public SpellCheckAnalyzer(String spellCheckOutputFilenameIn, Results spellCheckAnalyzerIn){
        spellCheckAnalyzer=spellCheckAnalyzerIn;
        spellCheckOutputFilename=spellCheckOutputFilenameIn;
    }


}
