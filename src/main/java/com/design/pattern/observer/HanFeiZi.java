package com.design.pattern.observer;

public class HanFeiZi implements IHanFeiZi {

    private boolean isHavingBreakfast=false;

    private boolean isHavingFun=false;

    private String type ="";


    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭类...");
        this.isHavingBreakfast=true;
//        this.type="breakfast";
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐了...");
        this.isHavingFun=true;
//        this.type="fun";
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }
}
