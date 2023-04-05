package org.example;

public class Car implements Vehicle {

    public Tire ty;

    public Car(Tire ty){
        this.ty = ty;
    }
//    public Tire getTy() {
//        return ty;
//    }
//
//    public void setTy(Tire ty) {
//        this.ty = ty;
//    }

    public void drive(){
        System.out.println("I am driving a car..."+ty);
    }
}
