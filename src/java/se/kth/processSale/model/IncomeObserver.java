package se.kth.processSale.model;

/** Interface that's implemented to allow <Code>ChangeCalculator</Code> to inform observers when a
 * payment made by s customer */
public interface IncomeObserver {
        /** The method that is called by <Code>ChangeCalculator</Code> to inform observers about a payment done by a customer
         * @param paidAmount The amount paid by the customer */
        void paymentDone(double paidAmount);



}
