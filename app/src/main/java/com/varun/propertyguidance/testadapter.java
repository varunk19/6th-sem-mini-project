package com.varun.propertyguidance;

public class testadapter {
    private String state;
    private String prop;
    private String val;

    public testadapter(String state,String prop,String val){
        this.state=state;
        this.prop=prop;
        this.val=val;
    }
    public String getState(){
        return state;
    }
    public void setState(String State){
        this.state=state;
    }
    public String getProp(){
        return prop;
    }
    public void setProp(String prop){
        this.prop=prop;
    }
    public String getVal(){
        return val;
    }
    public void setVal(String val){
        this.val=val;
    }
}
