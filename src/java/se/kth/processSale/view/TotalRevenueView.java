package se.kth.processSale.view;

import se.kth.processSale.model.ChangeDTO;
import se.kth.processSale.model.IncomeObserver;

public class TotalRevenueView implements IncomeObserver{
    private double currentRevenue;

    public TotalRevenueView(){
        this.currentRevenue = 0;

    }
    @Override
    public void paymentDone(double paidAmount){
        this.currentRevenue+=paidAmount;
        String message = "Total revenue since start of program: " + this.currentRevenue + " kr";
        System.out.println(message);
    }


}
