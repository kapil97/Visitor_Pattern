package visitPlay.util;

public class SpellCheckResults implements Results {
    String spellCheckOutputFilename;
    public SpellCheckResults(String spellCheckOutputFilenameIn){
        spellCheckOutputFilename=spellCheckOutputFilenameIn;
    }
    @Override
    public void addToResultList(String output) {

    }

    @Override
    public void printList() {

    }

    @Override
    public void writeToFile() {

    }
}
