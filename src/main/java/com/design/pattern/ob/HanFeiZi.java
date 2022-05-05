package com.design.pattern.ob;


public class HanFeiZi implements IHanFeiZi {

    private boolean isEat = false;

    private boolean isFun = false;


    @Override
    public void eat() {
        this.setEat(true);
    }

    @Override
    public void fun() {
        this.setFun(true);
    }


    public boolean isEat() {
        return isEat;
    }

    public void setEat(boolean eat) {
        isEat = eat;
    }

    public boolean isFun() {
        return isFun;
    }

    public void setFun(boolean fun) {
        isFun = fun;
    }
}
