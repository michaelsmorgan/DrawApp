package cs2410.assn6.control;


import cs2410.assn6.model.ContractWorker;
import cs2410.assn6.model.Hobbit;
import cs2410.assn6.model.HourlyWorker;
import cs2410.assn6.model.Simpleton;

import java.util.ArrayList;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public class PersonArray {
    /**
     * ArrayList that holds type Simpleton, which all three workers are
     */
    ArrayList<Simpleton> people = new ArrayList<>();

    /**
     * constructor for the PersonArray class, adds some default workers to be displayed.
     */
    public PersonArray() {
        ContractWorker worker1 = new ContractWorker("Bob", "4 / 2 = 2", "The stars shine bright at night", 110, 5, 7500);
        people.add(worker1);
        ContractWorker worker2 = new ContractWorker("Wilma", "10 / 5 = 2", "The moon orbits the earth", 130, 20, 46000);
        people.add(worker2);
        Hobbit hobbit1 = new Hobbit("Sam", "2 + 2 = 4", "Potatoes are our friends", 23);
        people.add(hobbit1);
        Hobbit hobbit2 = new Hobbit("Frodo", "10 + 3 = 13", "Weed the garden to get good food", 35);
        people.add(hobbit2);
        HourlyWorker hWorker1 = new HourlyWorker("Walter", "3 x 4 = 12", "Pigs eat corn", 90, 50, 1057);
        people.add(hWorker1);
        HourlyWorker hWorker2 = new HourlyWorker("Mary", "12 x 12 = 144","Horses are dehorned unicorns", 100, 45,2287);
        people.add(hWorker2);

    }

    /**
     * creates hourly worker with the information given by the user
     * @param name worker's name
     * @param math math the worker can do
     * @param smart smart thing the worker can say
     * @param IQ worker's IQ
     * @param hours hours the worker worked
     * @param income worker's income
     */
    public void createHourlyWorker(String name, String math, String smart, int IQ, int hours, double income) {
        HourlyWorker hourlyWorker = new HourlyWorker(name, math, smart, IQ, hours, income);
        people.add(hourlyWorker);
    }

    /**
     * creates contract worker with information provided by the user
     * @param name worker's name
     * @param math math the worker can do
     * @param smart smart thing the worker can say
     * @param IQ worker's IQ
     * @param contracts contracts completed
     * @param perContract worker's income
     */
    public void createContractWorker(String name, String math, String smart, int IQ, int contracts, double perContract) {
        ContractWorker contractWorker = new ContractWorker(name, math, smart, IQ, contracts, perContract);
        people.add(contractWorker);
    }

    /**
     * creates a hobbit with information provided by the user
     * @param name hobbit's name
     * @param math math the hobbit can do
     * @param smart smart thing the hobbit can say
     * @param carrots how many carrots the hobbit has
     */
    public void createHobbit(String name, String math, String smart, int carrots) {
        Hobbit hobbit = new Hobbit(name, math, smart, carrots);
        people.add(hobbit);

    }

    /**
     * gets information about all workers that can do math, and displays them as a single String
     * @return returns the String containing information about workers that can do math
     */
    public String getMathList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            output += people.get(i).getName() + ", ";
            if (people.get(i) instanceof HourlyWorker) {
                output += ((HourlyWorker) people.get(i)).getPersonType();
            }
            else if (people.get(i) instanceof ContractWorker) {
                output += ((ContractWorker) people.get(i)).getPersonType();
            }
            else {
                output += ((Hobbit) people.get(i)).getPersonType();
            }

            output += (": " + people.get(i).doMath() + "\n");
        }
        return output;
    }

    /**
     * method that returns information about workers who have an income
     * @return returns one String containing all workers that have an income
     */
    public String getIncomeList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
         if (people.get(i) instanceof ContractWorker) {
             output += people.get(i).getName() + ", ";
             output += (((ContractWorker) people.get(i)).getPersonType() + ": $" + ((ContractWorker) people.get(i)).getIncome());
             output += (" is my income\n");
         }
         else if (people.get(i) instanceof  HourlyWorker) {
             output += people.get(i).getName() + ", ";
             output += (((HourlyWorker) people.get(i)).getPersonType() + ": $" + ((HourlyWorker) people.get(i)).getIncome());
             output += (" is my income\n");
         }
        }
        return output;
    }

    /**
     * method that returns all hourly workers in a single String
     * @return returns a String containing information about hourly workers
     */
    public String getHoursList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof HourlyWorker) {
                output += people.get(i).getName() + ", ";
                output += (((HourlyWorker) people.get(i)).getPersonType() + ": ");
                output += (((HourlyWorker) people.get(i)).getIncome() + " hours worked\n");

            }
        }
        return output;
    }

    /**
     * gets information about workers with an IQ
     * @return returns a string with information on all workers that have an IQ
     */
    public String getIQList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof ContractWorker) {
                output += people.get(i).getName() + ", ";
                output += (((ContractWorker) people.get(i)).getPersonType() + ": " + ((ContractWorker) people.get(i)).getIQ());
                output += (" is my IQ\n");
            }
            else if (people.get(i) instanceof  HourlyWorker) {
                output += people.get(i).getName() + ", ";
                output += (((HourlyWorker) people.get(i)).getPersonType() + ": " + ((HourlyWorker) people.get(i)).getIQ());
                output += (" is my IQ\n");
            }
        }
        return output;
    }

    /**
     * gets information about all workers that can say something smart
     * @return returns String of information about workers that have something to say
     */
    public String getSayList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            output += people.get(i).getName() + ", ";
            if (people.get(i) instanceof HourlyWorker) {
                output += ((HourlyWorker) people.get(i)).getPersonType();
            }
            else if (people.get(i) instanceof ContractWorker) {
                output += ((ContractWorker) people.get(i)).getPersonType();
            }
            else {
                output += ((Hobbit) people.get(i)).getPersonType();
            }

            output += (": " + people.get(i).saySomethingSmart() + "\n");
        }
        return output;
    }

    /**
     * gets information about workers with carrots
     * @return returns a String containing information on workers with carrots
     */
    public String getCarrotList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Hobbit) {
                output += people.get(i).getName() + ", ";
                output += (((Hobbit) people.get(i)).getPersonType() + ": ");
                output += (((Hobbit) people.get(i)).getCarrotsPicked() + " Carrots picked.\n");
            }
        }
        return output;
    }

    /**
     * gets information about contract workers
     * @return returns a String containing information about contract workers
     */
    public String getContractsList() {
        String output = "";
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof ContractWorker) {
                output += people.get(i).getName() + ", ";
                output += (((ContractWorker) people.get(i)).getPersonType() + ": ");
                output += (((ContractWorker) people.get(i)).getContracts() + " Contracts completed.\n");
            }
        }
        return output;
    }
}
