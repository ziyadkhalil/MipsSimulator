package assembler;

import units.InstructionMemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Assembler {
    private int initialLocation=2000;
    private int instructionIndex=0;
    private ArrayList<InstructionLine> instructions = new ArrayList<>();
    private String path = "programs\\input.txt";
    private ArrayList<String> tempInstructions = new ArrayList<>();
    private Map<String , String>  labels = new HashMap<>();



    public  void assemble() throws FileNotFoundException {
        readInput();
        handleLabels();
        handleLines();
    }


    private void readInput() throws FileNotFoundException {
        File input = new File(path);
        Scanner sc = new Scanner(input);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.contains("#"))                 //Ignoring comments if any,l
                line=line.split("#")[0];

            if (!(line.trim().isEmpty()))           //If line contains ONLY white spaces or is empty, assembler ignores it.
                tempInstructions.add(line) ;
        }

    }
    private void handleLabels(){
        for (int j = 0; j< tempInstructions.size(); j++) {
            if (tempInstructions.get(j).contains(":"))
            {
                while(tempInstructions.get(j).split(":").length==1&&j!=tempInstructions.size()-1) {   //handles empty lines with labels
                    tempInstructions.set(j+1,(tempInstructions.get(j).split(":"))[0]+":"+tempInstructions.get(j+1));
                    tempInstructions.remove(j);
                    System.out.println(tempInstructions.get(j));
                    System.out.println(j);
                }
                String  index = String.valueOf(initialLocation + 4*j);
                int i = tempInstructions.get(j).indexOf(":");
                System.out.println(tempInstructions.get(j).substring(0,i).trim());
                labels.put(tempInstructions.get(j).substring(0,i).trim(),index);
                tempInstructions.set(j, tempInstructions.get(j).substring(i+1, tempInstructions.get(j).length()).trim());
                if (tempInstructions.get(j).isEmpty()) tempInstructions.remove(j);
                //TODO: EXCEPTION HANDLING IF A LABEL IS ALREADY DEFINED
            }
        }
        InstructionLine.injectLabels(labels);

    }
    private void handleLines(){

        for (int i=0;i<tempInstructions.size();i++){
            instructions.add(new InstructionLine(tempInstructions.get(i),String.valueOf(initialLocation+4*i)));
        }
    }


    public int getInitialLocation() {
        return initialLocation;
    }

    public ArrayList<InstructionLine> getInstructions() {
        return instructions;
    }
}
