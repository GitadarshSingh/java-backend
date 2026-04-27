package org.cfs;

public class DieselEngine implements Engine{
    public DieselEngine() {
        System.out.println("Diesel Constructor...");
    }

    public int start(){
        return 1;
    }
}
