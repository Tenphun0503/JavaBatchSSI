package hw1.topic5;

import java.io.Serializable;

public class AppleDesignerFactory implements Serializable, Cloneable {
    private static AppleDesignerFactory instance;

    // private constructor
    private AppleDesignerFactory(){}

    // static synchronized getInstance() method
    public static synchronized AppleDesignerFactory getInstance(){
        if (instance == null) instance = new AppleDesignerFactory();
        return instance;
    }

    // prevent clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // prevent Serializable/Deserializable
    protected Object readResolve(){
        return instance;
    }
}
