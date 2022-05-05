package com.design.pattern.observer2;

public class Client {

    public static void main(String[] args) throws InterruptedException {
//        LiSi liSi = new LiSi();
//        HanFeiZi hanFeiZi = new HanFeiZi();
//
//        Spy spyBreakFast = new Spy(hanFeiZi, liSi, "breakfast");
//        spyBreakFast.start();
//        Spy spyFun = new Spy(hanFeiZi, liSi, "fun");
//        spyFun.start();
//        Thread.sleep(1000);
//
//
//        hanFeiZi.haveBreakfast();
//
//        Thread.sleep(1000);
//        hanFeiZi.haveFun();

        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
