package se.kth.processSale.view;

import se.kth.processSale.controller.Controller;
import se.kth.processSale.integration.ItemDTO;
import se.kth.processSale.model.*;

import java.util.Date;
/**
 * Class simulating the applications view
 * */
public class View {
    private Controller controller;
    private final String CURRENCY = "kr";
    /** Create an instance of the view
     * @param controller reference to the applications controller
     * */
    public View(Controller controller){
        this.controller = controller;
    }

    /**
     * Runs a sample execution of the program.
     */
    public void sampleExecution(){
        System.out.println("Begin sample execution");

        controller.beginSale();
        SaleDTO currentSale = controller.searchItem("abc1001");
        showItemDescriptionRunningTotal(currentSale);
        currentSale = controller.searchItem("abc1002");
        showItemDescriptionRunningTotal(currentSale);
        currentSale = controller.searchItem("abc1003");
        showItemDescriptionRunningTotal(currentSale);
        TaxTotalDTO taxAndTotal = controller.allItemsRegistered();
        showTotalWithTax(taxAndTotal);
        double payedAmount = 200.50;
        ChangeDTO change = controller.enterPayment(payedAmount);
        showChange(change);





    }

    /**
     * Displays information about the latest item added and shows the running total
     * @param currentSale contains information about items and running total of the sale
     */
    private void showItemDescriptionRunningTotal(SaleDTO currentSale){

        ItemDTO latestItem = currentSale.getLatestItemAdded();
        System.out.println("Item description: " + latestItem.getItemDescription() + " Item price: " +
                latestItem.getPrice() + " "+ CURRENCY);
        System.out.println("Running total: " + currentSale.getRunningTotal() + " "+ CURRENCY);
    }

    /**
     * Displays the total and total with tax
     * @param taxAndTotal contains information about the total and total with tax for the sale
     */
    private void showTotalWithTax(TaxTotalDTO taxAndTotal){
        System.out.println("Running total: " + taxAndTotal.getTotalWithoutTaxes() + " "+ CURRENCY);
        System.out.println("Running total with tax: " + taxAndTotal.getTotalWithTaxApplied() + " "+ CURRENCY);

    }

    /**
     * Displays the returned change
     * @param change Data object with information about the change given in the sale
     */

    private void showChange(ChangeDTO change){
        System.out.println("Change: " + change.getChange()+ " "+ CURRENCY);
    }







}
