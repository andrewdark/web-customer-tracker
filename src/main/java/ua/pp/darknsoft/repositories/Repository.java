package ua.pp.darknsoft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    Optional<T> findById(ID var1);

    Iterable<T> findAll();

    Page<T> findAll(Pageable var1);

    <S extends T> S save(S var1);

    <S extends T> S saveAndFlush(S var1);

    void deleteById(ID var1);

    void delete(T var1);

    long count();

    boolean existsById(ID var1);

    void flush();

    void refresh(T var1);

    T getReference(ID var1);

    List<T> query(Specification<T> specification);

}
