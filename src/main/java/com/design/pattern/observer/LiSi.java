package com.design.pattern.observer;

public class LiSi implements ILisi {

    @Override
    public void update(String context) {
        System.out.println("李斯：观察到韩非子活动，开始向老板回报了...");
        this.reportToQinShiHuang(context);
        System.out.println("李斯：汇报完毕...\n");
    }


    private void reportToQinShiHuang(String reportContext) {
        System.out.println("李斯：报告，秦老板！韩非子有活动了--->" + reportContext);
    }
}
