package mobile_phone2.Potoki;

import mobile_phone2.MobilePhone.Phone;

public class Operator extends Thread{
    private Phone phone;
    final CallCenter callCenter;

    public void setPhoneOperator(Phone phone){
        this.phone = phone;
    }

    public Operator(Phone phone, CallCenter callCenter) {
        this.phone = phone;
        this.callCenter = callCenter;
    }
    @Override
    public void run() {
        while (true){
            callCenter.doOperatorWork();
        }
    }
}