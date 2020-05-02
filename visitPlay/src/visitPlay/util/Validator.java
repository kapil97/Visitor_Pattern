package visitPlay.util;

import java.io.File;

public class Validator implements ValidatorI {

    String inputName;
    String baseName;
    String windowSize;

    public Validator(String baseNameIn,String inputNameIn,String windowSizeIn){
        inputName=inputNameIn;
        baseName=baseNameIn;
        windowSize= windowSizeIn;

    }

    /**
     * Check Validity of the file using given constraints.
     * @return
     */
    @Override
    public boolean valid(){

        File file=new File(inputName);
        if(file.length()==0){
            System.out.println("input file is empty");
            return false;
        }

        file=new File(baseName);
        if(file.length()==0){
            System.out.println("Available items file is empty");
            return false;
        }

        if(Integer.parseInt(windowSize)<=0){
            System.out.println("windowSize cannot be Negative or zero");
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public String toString(){
        return "Validator";
    }

}

