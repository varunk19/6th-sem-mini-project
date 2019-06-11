package com.varun.propertyguidance;

public class testadapter2 {
    private String state;
    private String prop1;
    private String val1;
    private String prop2;
    private String val2;

    public testadapter2(String state,String prop1,String val1,String prop2,String val2){
        this.state=state;
        this.prop1=prop1;
        this.val1=val1;
        this.prop2=prop2;
        this.val2=val2;
    }
    public String getState(){
        return state;
    }
    public void setState(String State){
        this.state=state;
    }
    public String getProp1(){
        return prop1;
    }
    public void setProp1(String prop1){
        this.prop1=prop1;
    }
    public String getVal1(){
        return val1;
    }
    public void setVal1(String val1){
        this.val1=val1;
    }
    public String getProp2(){
        return prop2;
    }
    public void setProp2(String prop2){
        this.prop2=prop2;
    }
    public String getVal2(){
        return val2;
    }
    public void setVal2(String val2){
        this.val2=val2;
    }
}
