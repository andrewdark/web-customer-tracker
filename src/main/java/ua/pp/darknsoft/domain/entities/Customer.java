package ua.pp.darknsoft.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(name = "UC_CANDIDATE_EMAIL", columnNames = "email")})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name="customer_generator", sequenceName = "customer_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z]{1,180}$")
    @Column(name = "first_name", nullable = false, columnDefinition = "VARCHAR(180)")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z]{1,180}$")
    @Column(name="last_name" , nullable = false, columnDefinition = "VARCHAR(180)")
    private String lastName;

    @Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")
    @Column(name="email", nullable = false)
    private String email;

    @Version
    private Long version;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
