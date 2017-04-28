package com.nata;

/**
 * Created by nata on 28.04.2017.
 */
public class TooManyBikesException extends Exception {
    ShippingErrorInfo shippingErrorInfo;

    TooManyBikesException (String msgText,ShippingErrorInfo shippingErrorInfo){
        super(msgText);
        this.shippingErrorInfo = shippingErrorInfo;
    }

    ShippingErrorInfo getShippingErrorInfo(){
        return shippingErrorInfo;
    }

}
