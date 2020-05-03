package visitPlay.util;

public class ElementCheck implements WordMap{
    String word;
    int count;
    public ElementCheck(String wordIn,int countIn){
        word=wordIn.toLowerCase();
        count=countIn;
    }
    @Override
    public int getCount(){
    return count;
    }
    @Override
    public String getWord(){
        return word;
    }
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
