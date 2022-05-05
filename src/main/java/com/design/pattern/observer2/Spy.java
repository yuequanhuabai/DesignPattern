package com.design.pattern.observer2;

public class Spy extends Thread {

    private HanFeiZi hanFeiZi;

    private LiSi liSi;

    private String type;



    // 通过构造函数传递参数，我要监控的是谁，谁来监控，要监控什么
    public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {

       while (true) {

           synchronized (this) {
               if (this.type.equals("breakfast")) {
                   // 如果发现韩非子在吃饭，就通知李斯

                   if (this.hanFeiZi.isHavingBreakfast()) {
                       System.out.println("this.hanFeiZi.isHavingBreakfast():"+this.hanFeiZi.isHavingBreakfast());
                       //
                       this.liSi.update("韩非子在吃饭");
                       // 重置状态，继续监控
                       this.hanFeiZi.setHavingBreakfast(false);
                   }
               } else {

                   if (this.hanFeiZi.isHavingFun()) {
                       System.out.println("this.hanFeiZi.isHavingFun():"+this.hanFeiZi.isHavingFun());
                       this.liSi.update("韩非子在娱乐");
                       this.hanFeiZi.setHavingFun(false);
                   }
               }

           }
       }

    }
}
