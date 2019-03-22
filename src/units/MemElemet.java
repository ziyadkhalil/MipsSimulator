package units;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.Map;
import java.util.function.BiConsumer;

public class MemElemet {
    private StringProperty address=new SimpleStringProperty();
    private StringProperty dataValue= new SimpleStringProperty();

    private  ObservableList<MemElemet> memElements;
    ObservableMap<String,String> memory;

    public MemElemet(ObservableMap<String, String> memory) {
        this.memory = memory;
        memElements = FXCollections.observableArrayList();
    }

    public MemElemet (String address,String value){
        this.address.setValue(address);
        this.dataValue.setValue(value);
    }


    public  ObservableList<MemElemet> getMemElements(){
        memory.forEach((address, value) -> {
            memElements.add(new MemElemet(address,value));
        });
        return memElements;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getDataValue() {
        return dataValue.get();
    }

    public StringProperty dataValueProperty() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue.set(dataValue);
    }
}

