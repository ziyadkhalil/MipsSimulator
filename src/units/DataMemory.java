package units;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MipsUtils;

import java.util.HashMap;
import java.util.Map;

public class DataMemory {
    private Map<String,String> memory;
    private boolean memWrite ;
    private boolean memRead ;
    private String memOp ;
    private String address;
    private String dataToWrite;
    private String dataRead = "11111111111111111111111111111111";
    private int offset;
    public DataMemory() {
        memory = new HashMap<>();
    }
    public void setAddress (String address){
        long tempTemp = Long.parseLong(address,2);
        int temp = (int) tempTemp;
        offset = temp%4;
        temp-=offset;
        String x = Integer.toString(temp,2);
        System.out.println(temp  + "       " + x);
        this.address = x;

    }
    public void setDataToWrite(String dataToWrite){

        this.dataToWrite = dataToWrite;
    }
    public void injectFlags (boolean memWrite, boolean memRead, String memOp){
            this.memWrite = memWrite;
            this.memRead = memRead;
            this.memOp = memOp;
    }
    public void execute(){
        if (memWrite) {
           writeData();
        }
        if (memRead){
            dataRead=readData();
        }
    }
    private String readData() {
        String x;
        switch (memOp){
            case "00":
                x = memory.get(address);
                if (x==null) return MipsUtils.setBits("",32);
                else return x;
            case "01":
                x = memory.get(address);
                if (x==null) return MipsUtils.setBits("",16);
                if(offset==0)
                    return x.substring(16,32);
                else if(offset==2)
                    return x.substring(0,16);
                else System.out.println("ERRORRRRR 66"); //TODO WRONG OFFSET
                break;
            case "10":
                x=memory.get(address);
                if(x==null) return MipsUtils.setBits("",8);
                if (offset==0)
                    return x.substring(24,32);
                else if (offset==1)
                    return x.substring(16,24);
                else if (offset==2)
                    return x.substring(8,16);
                else if (offset==3)
                    return x.substring(0,8);
                else System.out.println("ERRORRRRRRRRRR"+offset); //TODO WRONG OFFSET
            default:
                System.out.println("ERRRRR");


        }
        return "";
    }
    private void writeData(){
        String temp;
        String x;
        switch (memOp){
            case "00":
                memory.put(address, dataToWrite);
                break;
            case "01":
                temp = dataToWrite.substring(16,32);
                x = memory.get(address);
                if (x==null){
                    if (offset==0) {
                        temp = MipsUtils.setBits(temp,32);
                    }
                    else if (offset==2){
                        temp += MipsUtils.setBits("",16);
                    }
                    else
                        System.out.println("ERRRRRRRRRROR 74"); //TODO: WrongOffset
                    memory.put(address,temp);
                    break;
                }
                else{
                    if(offset==0)
                        temp = x.substring(0,16).concat(temp);
                    else if (offset==2)
                        temp = temp.concat(x.substring(16, 32));
                    else
                        System.out.println("ERRRRRRRRORRRRRRRRRRRRR 84");//TODO: WrongOffset
                    memory.put(address,temp);
                    break;
                }
            case "10":
                temp = dataToWrite.substring(24,32);
                x = memory.get(address);
                if (x==null){
                    if(offset==0)
                        temp = MipsUtils.setBits(temp,32);
                    else if(offset==1)
                        temp = MipsUtils.setBits("",16).concat(temp).concat(MipsUtils.setBits("",8));
                    else if (offset==2)
                        temp = MipsUtils.setBits("",8).concat(temp).concat(MipsUtils.setBits("",16));
                    else if (offset==3)
                        temp = temp.concat(MipsUtils.setBits("",24));
                    else System.out.println("ERRROR 96"); //TODO: WrongOffset
                    memory.put(address,temp);
                    break;
                }
                else{
                    if(offset==0)
                        temp = x.substring(0,24).concat(temp);
                    else if (offset == 1)
                        temp = x.substring(0,16)+temp+x.substring(24,32);
                    else if (offset == 2)
                        temp = x.substring(0,8)+temp+x.substring(16,32);
                    else if (offset==3)
                        temp += x.substring(8,32);
                    else System.out.println("ERRORRRRR 109"); //TODO: WrongOffset
                    memory.put(address,temp);
                    break;
                }
            default:
                System.out.println("Error Line:72"); //TODO: ERROR EXCEPTION
        }
    }

    public String getDataRead() {
        return dataRead;
    }

    public Map<String, String> getMemory() {
        return memory;
    }
}
