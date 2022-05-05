package com.design.pattern.observer2;

public class HanFeiZi implements IHanFeiZi {

    private  ILiSi liSi = new LiSi();

    private boolean isHavingBreakfast=false;

    private boolean isHavingFun=false;

    private String type ="";


    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭类...");
        this.liSi.update("韩非子在吃饭");
//        this.isHavingBreakfast=true;
//        this.type="breakfast";
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐了...");
        this.liSi.update("韩非子在娱乐");
//        this.isHavingFun=true;
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
