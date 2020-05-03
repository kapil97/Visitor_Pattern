package visitPlay.util;

public class ElementCheck implements WordMap{
    String word;
    int count;
    public ElementCheck(String wordIn,int countIn){
        word=wordIn.toLowerCase();
        count=countIn;
    }

    /**
     * Method to get the count of the corresponding Word.
     * @return
     */
    @Override
    public int getCount(){
    return count;
    }

    /**
     * Method to get the word.
     * @return
     */
    @Override
    public String getWord(){
        return word;
    }

    /**
     * Overriding Equals method.
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ElementCheck)) return false;
        ElementCheck element = (ElementCheck) object;
        return element.word.equals(word) && (element.count == count);
    }

    @Override
    public String toString() {
        return "Word:["+word+"] Count["+count+"]";
    }
}
