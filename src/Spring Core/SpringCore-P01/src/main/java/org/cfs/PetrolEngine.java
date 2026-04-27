package org.cfs;

public class PetrolEngine implements Engine{
    public PetrolEngine() {
        System.out.println("Petrol Constructor");
    }

    public int start(){
        return 1;
    }
}
