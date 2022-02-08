package ua.pp.darknsoft.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.entities.Customer;
import ua.pp.darknsoft.domain.factories.filters.CustomerFilter;
import ua.pp.darknsoft.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void addInterviewer(CustomerDto customerDto) {

    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        return Optional.empty();
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
    public List<Customer> findAll() {

        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

    }
}
