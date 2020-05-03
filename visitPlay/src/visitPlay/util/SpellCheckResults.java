package visitPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpellCheckResults implements Results {
    String spellCheckOutputFilename;
    static List<String> outputList=new ArrayList<>();
    public SpellCheckResults(String spellCheckOutputFilenameIn){
        spellCheckOutputFilename=spellCheckOutputFilenameIn;
    }

    /**
     * Setting List to result List
     * @param output
     */
    @Override
    public void addToResultList(List<String> output) {
        outputList=output;
    }

    /**
     * Printing Result List
     */

    @Override
    public void printList() {
    System.out.println("Output List: "+outputList);
    }

    /**
     * Writing to Output File Method.
     */
    @Override
    public void writeToFile() {
        try {
            File resultFile=new File(spellCheckOutputFilename);
            if (resultFile.exists()){
                FileWriter fileWriter=new FileWriter(spellCheckOutputFilename,true);
                for (String string : outputList) {
                    fileWriter.write(string);
                    fileWriter.write(System.getProperty("line.separator"));
                }
                fileWriter.close();
            }
            else{
                resultFile.createNewFile();
                System.out.println("File Created:" + resultFile.getName());
                writeToFile();
            }
        }
        catch ( IOException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        finally {
            System.out.println("Process Complete");
        }
    }
    @Override
        public String toString(){
            return "SpellCheckResults";
    }
}
