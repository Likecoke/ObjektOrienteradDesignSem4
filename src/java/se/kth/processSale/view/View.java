package se.kth.processSale.view;

import se.kth.processSale.controller.Controller;
import se.kth.processSale.controller.OperationErrorException;
import se.kth.processSale.controller.ServiceNotAvailableException;
import se.kth.processSale.integration.ItemDTO;
import se.kth.processSale.model.*;
import se.kth.processSale.util.CurrentTimeGenerator;
import se.kth.processSale.util.ErrorLogger;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Date;
/**
 * Class simulating the applications view
 * */
public class View {
    private Controller controller;
    private final String CURRENCY = "kr";
    ErrorLogger errorLogger;
    DisplayError displayError;
    TotalRevenueView totalRevenueView;
    /** Create an instance of the view
     * @param controller reference to the applications controller
     * */
    public View(Controller controller) throws IOException{
        this.controller = controller;
        this.errorLogger = new ErrorLogger(new CurrentTimeGenerator());
        this.displayError = new DisplayError(new CurrentTimeGenerator());
        this.totalRevenueView = new TotalRevenueView();
        this.controller.addIncomeObserver(this.totalRevenueView);

    }

    /**
     * Runs a sample execution of the program.
     */
    public void sampleExecution(){
        System.out.println("Begin sample execution");

        controller.beginSale();
        searchItemAndDisplayRunningTotal("abc999");
        searchItemAndDisplayRunningTotal("abc1002");
        searchItemAndDisplayRunningTotal("abc1003");
        TaxTotalDTO taxAndTotal = controller.allItemsRegistered();
        showTotalWithTax(taxAndTotal);
        double payedAmount = 200.50;
        ChangeDTO change = controller.enterPayment(payedAmount);
        showChange(change);

    }

    /**
     *Searches for an item that should be added to the sale and displays the current running total
     * @param identifier The identifier for the searched item
     */
    private void searchItemAndDisplayRunningTotal(String identifier){
        try{
            SaleDTO currentSale = controller.searchItem(identifier);
            showItemDescriptionRunningTotal(currentSale);
        }
        catch (OperationErrorException exception){

            displayError.showErrorMessage("The searched for item with the given identifier: " + identifier +
                    ", \ncould not be found and was not added to the sale");
            errorLogger.logException(exception);

        }
        catch (ServiceNotAvailableException exc){
            displayError.showErrorMessage("The service you were trying to use is not currently available," +
                    "\nplease try again!");
            errorLogger.logException(exc);
        }


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
