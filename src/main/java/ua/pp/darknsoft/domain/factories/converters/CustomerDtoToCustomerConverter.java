package ua.pp.darknsoft.domain.factories.converters;

import org.springframework.core.convert.converter.Converter;
import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.entities.Customer;

public enum CustomerDtoToCustomerConverter implements Converter<CustomerDto, Customer> {
    INSTANCE;

    @Override
    public Customer convert(CustomerDto source) {
        if (source == null) {
            return null;
        }

        Customer customer = new Customer(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail()
        );

        return customer;
    }
}
