package se.kth.processSale.startup;

import se.kth.processSale.controller.Controller;
import se.kth.processSale.integration.AccountingSystem;
import se.kth.processSale.integration.InventorySystem;
import se.kth.processSale.integration.Printer;
import se.kth.processSale.integration.ProductCatalogue;
import se.kth.processSale.view.View;
/** This class handles the initialization of the program
 */
public class Main {



/** Initializes the program and runs a sample execution
 * @param args standard parameter given to main methods in java, not used by the program.
 *
 * */
    public static void main(String[] args){
        AccountingSystem accountingSystem = new AccountingSystem();
        InventorySystem invSystem = new InventorySystem();
        ProductCatalogue productCatalogue = new ProductCatalogue();
        Printer printer = new Printer();
        Controller controller = new Controller(accountingSystem, invSystem, productCatalogue, printer);
        View view = new View(controller);
        view.sampleExecution();



    }
}
