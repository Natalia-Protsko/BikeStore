package com.nata;

/**
 * Created by nata on 28.04.2017.
 */
public class ShippingErrorInfo {
    private int maxAmount;
    private int curAmount;

    public ShippingErrorInfo(int maxAmount, int curAmount){
       this.curAmount = curAmount;
       this.maxAmount = maxAmount;
    }

    public String getMsg(){return "Max:"+maxAmount+";Actual:"+curAmount;}
}
