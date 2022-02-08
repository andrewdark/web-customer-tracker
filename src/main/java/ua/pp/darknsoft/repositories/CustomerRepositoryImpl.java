package ua.pp.darknsoft.repositories;


import org.springframework.stereotype.Repository;
import ua.pp.darknsoft.domain.entities.Customer;

@Repository
public class CustomerRepositoryImpl extends RepositoryImpl<Customer, Long> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }
}
