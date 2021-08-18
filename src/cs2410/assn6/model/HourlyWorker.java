package cs2410.assn6.model;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public class HourlyWorker extends Smarty implements Simpleton {
    String m_personType = "Hourly Worker";
    int m_IQ;
    double m_income;
    int m_hours;
    String m_name;
    String m_math;
    String m_smart;

    /**
     * constructor for the HourlyWorker class, creates an hourly worker
     * @param name name of the worker
     * @param math math the worker can do
     * @param smart the smart thing the worker can say
     * @param IQ the worker's IQ
     * @param hours hours the worker worked
     * @param income the worker's income
     */
    public HourlyWorker(String name, String math, String smart, int IQ, int hours, double income) {
        m_IQ = IQ;
        m_income = income;
        m_hours = hours;
        m_name = name;
        m_math = math;
        m_smart = smart;
    }

    /**
     *
     * @return returns the worker's IQ
     */
    public int getIQ() {
        return m_IQ;
    }

    /**
     *
     * @return returns the worker's income
     */
    public double getIncome() {
        return m_income;
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
     * @return returns the hours the worker has worked
     */
    public int getHoursWorked() {
        return m_hours;
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
     * @return returns the smart thing the worker can say
     */
    @Override
    public String saySomethingSmart() {
        return m_smart;
    }

    /**
     *
     * @return returns the type of worker this worker is
     */
    @Override
    public String getPersonType() {
        return m_personType;
    }
}
