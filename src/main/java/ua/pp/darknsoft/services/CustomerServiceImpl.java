package ua.pp.darknsoft.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.entities.Customer;
import ua.pp.darknsoft.domain.factories.converters.CustomerDtoToCustomerConverter;
import ua.pp.darknsoft.domain.factories.converters.CustomerToCustomerDtoConverter;
import ua.pp.darknsoft.domain.factories.filters.CustomerFilter;
import ua.pp.darknsoft.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void addCustomer(CustomerDto customerDto) {

        Customer customer = CustomerDtoToCustomerConverter.INSTANCE.convert(customerDto);
        if (customer != null && customer.getId() != null) {
            Customer oldCustomer = new Customer();
            oldCustomer.setId(customer.getId());
            oldCustomer = customerRepository.getReference(customer.getId());
            oldCustomer.setFirstName(customer.getFirstName());
            oldCustomer.setLastName(customer.getLastName());
            oldCustomer.setEmail(customer.getEmail());
            customer = oldCustomer;
        }
        customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return Optional.ofNullable(CustomerToCustomerDtoConverter.INSTANCE.convert(customer));
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        return Optional.empty();
    }

    @Override
    public List<CustomerDto> findWithFilter(CustomerFilter filter) {
        return null;
    }

    @Override
    public Boolean isExist(CustomerDto interviewDto) {
        return null;
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return customers.stream().map(CustomerToCustomerDtoConverter.INSTANCE::convert).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
