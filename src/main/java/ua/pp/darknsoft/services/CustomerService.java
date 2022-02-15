package ua.pp.darknsoft.services;

import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.factories.filters.CustomerFilter;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);

    void addCustomer(CustomerDto customerDto);

    Optional<CustomerDto> findById(Long id);

    Optional<CustomerDto> update(CustomerDto customerDto);

    List<CustomerDto> findWithFilter(CustomerFilter filter);

    Boolean isExist(CustomerDto interviewDto);

    List<CustomerDto> findAll();

    void deleteById(Long id);
}
