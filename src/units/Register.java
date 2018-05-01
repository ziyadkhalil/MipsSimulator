package units;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;


public class Register {
    private String name;
    private String code;
    private StringProperty value = new SimpleStringProperty();
    private final static ArrayList<String> REGISTER_NAME = new ArrayList<>(Arrays.asList("$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"));



    public Register(String name) {
        this.name=name;
        this.code= Integer.toBinaryString(REGISTER_NAME.indexOf(name));
        if (name.equals("$sp"))
            this.setValue("00000000000000000010011100010100");
        else
            this.value.setValue("00000000000000000000000000000000");
    }

    public void setValue(String value) {
        this.value.setValue(value);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public String getValue(){
        return value.getValue();
    }

    public StringProperty getValueProperty() {
        return value;
    }

    //used in the InstructionLine
    public static String getCodeAssembler(String name)
    {
        System.out.println(name + "->" + Integer.toBinaryString(REGISTER_NAME.indexOf(name)));
        return Integer.toBinaryString(REGISTER_NAME.indexOf(name));
    }
}
