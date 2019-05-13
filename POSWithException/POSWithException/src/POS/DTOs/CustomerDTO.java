package POS.DTOs;
/**
 * 
 * @author Mohamed Mahdi
 *contains information about one Customer
 */
public class CustomerDTO {
    private String customerName;
    private String customerID;

    /**
	 * creates a new instans representing a new Customer; 
	 * @param  customer name      		the name of an customer
	 * @param  customerID     		    the ID that indetifies customer
	 */


    public CustomerDTO(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;


    }

    /**
     * returns the name of a customer
     * @return the name of a customer
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     * returns the identification of a customer
     * @return the identification of a customer 
     */
    public String getCustomerID(){
        return this.customerID;
    }


}

