package tdse.parcial;

import java.util.ArrayList;
import java.util.List;

public class PellSeq {

    public static int sequence(int value){

        if (value == 0){
            return 0;
        }
        if (value == 1){
            return 1;
        }

        return 2*sequence(value - 1) + sequence(value - 2);
    }

    public static String generatingSequence(int value){

        List<Integer> sequenceList = new ArrayList<>();

        for (int i = 0; i <= value; i++){
            sequenceList.add(sequence(i));
        }

        return sequenceList.toString();

    }

}