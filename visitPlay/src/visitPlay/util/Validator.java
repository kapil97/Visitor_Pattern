package visitPlay.util;

import java.io.File;

public class Validator implements ValidatorI {
    /**
     * Check Validity of the file using given constraints.
     * @return
     */
    String inputFilename,acceptableFilename,k;

    public Validator(String inputFilenameIn, String acceptableFilenameIn, String kIn){
        inputFilename=inputFilenameIn;
        acceptableFilename=acceptableFilenameIn;
        k=kIn;
    }

    @Override
    public boolean valid(){
        File inputFile=new File(inputFilename);
        File acceptableWordFile=new File(acceptableFilename);
        if(!inputFile.exists()){
            System.out.println("input file does not exist");
            return false;
        }
        if(inputFile.length()==0){
            System.out.println("input file is empty");
            return false;
        }
        if(!acceptableWordFile.exists()){
            System.out.println("Acceptable Words file does not exist");
            return false;
        }
        if(acceptableWordFile.length()==0){
            System.out.println("Acceptable Words file is empty");
            return false;
        }

        else if(Integer.parseInt(k)<=0){
            System.out.println("K Value cannot be zero or negative");
            return false;
        }

        return true;
    }
    @Override
    public String toString(){
        return "Validator";
    }

}

