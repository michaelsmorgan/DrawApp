package cs2410.assn6.model;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public abstract class Smarty implements Simpleton, PersonType {
    /**
     *
     * @return returns an arbitrary number for IQ.
     * This method is overridden in in the HourlyWorker, ContractWorker and Hobbit classes.
     */
    public int getIQ() {
        return 0;
    }

    /**
     *
     * @return returns an arbitrary number for income.
     * This method is overridden in in the HourlyWorker, ContractWorker and Hobbit classes.
     */
    public int getM_income() {
        return 0;
    }
}
