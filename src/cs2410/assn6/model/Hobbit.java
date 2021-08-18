package cs2410.assn6.model;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public class Hobbit implements Simpleton, PersonType {
    String m_personType = "Hobbit";
    String m_name;
    String m_math;
    String m_smart;
    int m_carrots;

    /**
     * constructor for the Hobbit class
     * @param name name of the hobbit
     * @param math what math the hobbit can do
     * @param smart the smart thing the hobbit can say
     * @param carrots how many carrots the hobbit has
     */
    public Hobbit(String name, String math, String smart, int carrots) {

        m_name = name;
        m_math = math;
        m_smart = smart;
        m_carrots = carrots;
    }

    /**
     *
     * @return returns carrots the specific hobbit has
     */
    public int getCarrotsPicked() {
        return m_carrots;
    }

    /**
     *
     * @return returns hobbit's name
     */
    @Override
    public String getName() {
        return m_name;
    }

    /**
     *
     * @return returns the math the hobbit can do
     */
    @Override
    public String doMath() {
        return m_math;
    }

    /**
     *
     * @return returns the smart thing the hobbit says
     */
    @Override
    public String saySomethingSmart() {
        return m_smart;
    }

    /**
     *
     * @return returns the type of worker
     */
    @Override
    public String getPersonType() {
        return m_personType;
    }
}
