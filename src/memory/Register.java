package memory;

import java.util.ArrayList;
import java.util.Arrays;


public class Register {
    private String name;
    private String code;
    private MemElement memElement;
    private final static ArrayList<String> REGISTER_NAME = new ArrayList<>(Arrays.asList("$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"));



    public Register(String name) {
        this.name=name;
        this.code= Integer.toBinaryString(REGISTER_NAME.indexOf(name));
        memElement=new MemElement(REGISTER_NAME.indexOf(name),name); //addrees is the index and label is the name
        //TODO add register(MemElement) to RegMemory
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public MemElement getMemElement() {
        return memElement;
    }

    public static String getCodeAssembler(String name)
    {
        return Integer.toBinaryString(REGISTER_NAME.indexOf(name));
    }
}
