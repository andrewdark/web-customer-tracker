package ua.pp.darknsoft.services;

import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.factories.filters.CustomerFilter;
import ua.pp.darknsoft.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);

    void addInterviewer(CustomerDto customerDto);

    Optional<CustomerDto> findById(Long id);

    Optional<CustomerDto> update(CustomerDto customerDto);

    List<CustomerDto> findWithFilter(CustomerFilter filter);

    Boolean isExist(CustomerDto interviewDto);

    List<Customer> findAll();

    void deleteById(Long id);
}