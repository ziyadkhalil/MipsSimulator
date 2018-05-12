package units;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;
import java.util.function.BiConsumer;

public class MemElemet {
    private String address;
    private String dataValue;

    private  ObservableList<MemElemet> memElements;
    Map<String,String> memory;

    public MemElemet(Map<String, String> memory) {
        this.memory = memory;
        memElements = FXCollections.observableArrayList();
    }

    public MemElemet (String address,String value){
        this.address = address;
        this.dataValue = value;
    }


    public  ObservableList<MemElemet> getMemElements(){
        memory.forEach((address, value) -> {
            memElements.add(new MemElemet(address,value));
        });
        return memElements;
    }

    public String getAddress() {
        return address;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

