package visitPlay.util;

import java.util.List;

public class SpellCheckResults implements Results {
    String spellCheckOutputFilename;
    public SpellCheckResults(String spellCheckOutputFilenameIn){
        spellCheckOutputFilename=spellCheckOutputFilenameIn;
    }

    @Override
    public void addToResultList(List<String> output) {

    }

    @Override
    public void printList() {

    }

    @Override
    public void writeToFile() {

    }


}
