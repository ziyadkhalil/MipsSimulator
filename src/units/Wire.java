package units;

import board.Processor;
import javafx.beans.binding.Binding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import utils.MipsUtils;

import java.beans.Beans;
import java.util.Map;
import java.util.function.BiConsumer;

public class Wire {
    private String name;
    private StringProperty stringValue;
    private BooleanProperty booleanValue;
    private static Map<SVGPath,BooleanProperty> booleanWires;
    private static Map<Label,StringProperty> stringWires;

    public Wire(String name, StringProperty value) {
        this.name=name;
        this.stringValue = value;
    }
    public Wire(String name, BooleanProperty value) {
        this.name=name;
        this.booleanValue=value;
        stringValue = new SimpleStringProperty();
        value.setValue(false);
        value.addListener((observable, oldValue, newValue) -> {
            if(newValue)
                this.stringValue.setValue("1");
            else
                this.stringValue.setValue("0");
        });
        value.setValue(true);
    }


    public static ObservableList<Wire> initControlWires(Map<SVGPath,BooleanProperty> booleanWires, Map<Label,StringProperty> stringWires){
        ObservableList<Wire> controlWires = FXCollections.observableArrayList();
        booleanWires.forEach((svgPath, booleanProperty) -> {

           if(((boolean) booleanProperty.getBean()))
               controlWires.add(new Wire(booleanProperty.getName(),booleanProperty ));
        });

        stringWires.forEach(((svgPath, stringProperty) -> {
            if(((boolean) stringProperty.getBean()))
                controlWires.add(new Wire(stringProperty.getName(),stringProperty));
        }));
        return controlWires;
    }

    public static ObservableList<Wire> initDataPathsWires(Map<SVGPath,BooleanProperty> booleanWires, Map<Label,StringProperty> stringWires){
        ObservableList<Wire> dataPathsWires = FXCollections.observableArrayList();
        booleanWires.forEach((svgPath, booleanProperty) -> {

            if(!((boolean) booleanProperty.getBean()))
                dataPathsWires.add(new Wire(booleanProperty.getName(),booleanProperty ));
        });

        stringWires.forEach(((svgPath, stringProperty) -> {
            if(!((boolean) stringProperty.getBean()))
                dataPathsWires.add(new Wire(stringProperty.getName(),stringProperty));
        }));
        return dataPathsWires;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringValue() {
        return stringValue.get();
    }

    public StringProperty stringValueProperty() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue.set(stringValue);
    }
}
