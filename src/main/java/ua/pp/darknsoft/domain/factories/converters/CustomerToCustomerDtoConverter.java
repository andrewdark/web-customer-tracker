package ua.pp.darknsoft.domain.factories.converters;

import org.springframework.core.convert.converter.Converter;
import ua.pp.darknsoft.domain.dto.CustomerDto;
import ua.pp.darknsoft.domain.entities.Customer;

public enum CustomerToCustomerDtoConverter implements Converter<Customer, CustomerDto> {
    INSTANCE;

    @Override
    public CustomerDto convert(Customer source) {
        CustomerDto customerDto = new CustomerDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail()
        );

        return customerDto;
    }
}
