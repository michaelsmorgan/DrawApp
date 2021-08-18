package cs2410.assn6.model;

/**
 * Created by Mike on 3/26/2017.
 */
public interface Simpleton {
    /**
     * abstract methods that are overridden in the HourlyWorker, ContractWorker and Hobbit classes.
     */
    public abstract String getName();
    public abstract String doMath();
    public abstract String saySomethingSmart();
}
