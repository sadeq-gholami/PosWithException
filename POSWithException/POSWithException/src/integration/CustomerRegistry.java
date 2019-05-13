package dbHandler;
import POS.DTOs.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerRegistry {
        private List<CustomerDTO> RegisterdCustomer = new ArrayList<>();
        private static final String CustomerID1 = "123ABC";
        private static final String CustomerID2 = "ABC123";
        private static final String CustomerID3 = "A1B2C3";

        /**
         * Creates a instance of a CustomerRegistry
         */
        public CustomerRegistry(){
            addCustomer();
        }

        /**
         * Checks if customer with his custemorID is in the database
         * @param customerID  Identifies Customer
         * @return True if in the database, False if not in database
         */
        public boolean isEligible(String customerID) {
        	boolean isCustomer = false;
            for (CustomerDTO customer : RegisterdCustomer) {
                if (customer.getCustomerID().equals(customerID)) {
                   isCustomer = true;
                   break;
                }          
                 
           }
            return isCustomer;
            
        }

        private void addCustomer() {
            RegisterdCustomer.add(new CustomerDTO("Mohamed",CustomerID1));
            RegisterdCustomer.add(new CustomerDTO("Zeineb",CustomerID2));
            RegisterdCustomer.add(new CustomerDTO("Abdi",CustomerID3));
        }
    }

