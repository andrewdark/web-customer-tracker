package ua.pp.darknsoft.repositories;

import ua.pp.darknsoft.entities.Customer;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer, Long> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }
}
