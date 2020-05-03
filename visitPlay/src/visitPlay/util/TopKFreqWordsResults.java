package visitPlay.util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopKFreqWordsResults implements Results{
    String TopKOutputFileName;
    static List<List<String>> outputList=new ArrayList<>();
    public TopKFreqWordsResults(String TopKOutputFileNameIn){
        TopKOutputFileName=TopKOutputFileNameIn;
    }
    @Override
    public void addToResultList(List<String> output) {
        outputList.add(output);
    }

    @Override
    public void printList() {
        System.out.println(outputList);
    }

    @Override
    public void writeToFile() {

            try {
                File resultFile=new File(TopKOutputFileName);
                if (resultFile.exists()){
                    FileWriter fileWriter=new FileWriter(TopKOutputFileName,true);
                    for (List<String> strings : outputList) {
                        fileWriter.write(strings.toString());
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
}
