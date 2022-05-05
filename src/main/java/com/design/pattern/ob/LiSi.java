package com.design.pattern.ob;

public class LiSi implements ILiSi{

    private  IHanFeiZi hanFeiZi;

    @Override
    public void getMsg() {
        hanFeiZi=new HanFeiZi();
        hanFeiZi.eat();

//        if(hanFeiZi)
    }
}
