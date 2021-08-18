package cs2410.assn6.model;

/**
 * Created by Mike on 3/26/2017.
 */
public class ContractWorker extends Smarty implements Simpleton {
    String m_personType = "Contract Worker";
    int m_IQ;
    int m_contracts;
    double m_perContract;
    String m_name;
    String m_math;
    String m_smart;

    /**
     * constructor for the ContractWorker class, sets up information about the worker
     * @param name worker's name
     * @param math math problem the worker can do
     * @param smart smart thing the worker can say
     * @param IQ worker's IQ
     * @param contracts contracts the worker has completed
     * @param perContract income of the worker
     */
    public ContractWorker(String name, String math, String smart, int IQ, int contracts, double perContract) {
        m_IQ = IQ;
        m_contracts = contracts;
        m_perContract = perContract;
        m_name = name;
        m_math = math;
        m_smart = smart;
    }

    /**
     *
     * @return returns worker's IQ
     */
    public int getIQ() {
        return m_IQ;
    }

    /**
     *
     * @return returns worker's income
     */
    public double getIncome() {
        return m_perContract;
    }

    /**
     *
     * @return returns worker's completed contracts
     */
    public int getContracts() {
        return m_contracts;
    }

    /**
     *
     * @return returns the worker's name
     */
    public String getName() {
        return m_name;
    }

    /**
     *
     * @return returns the math the worker can do
     */
    @Override
    public String doMath() {
        return m_math;
    }

    /**
     *
     * @return returns the smart thing the worker can do
     */
    @Override
    public String saySomethingSmart() {
        return m_smart;
    }

    /**
     *
     * @return gets the type of worker this worker is
     */
    @Override
    public String getPersonType() {
        return m_personType;
    }
}
