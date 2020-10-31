package com.company.loss.adjusters.domain.bussiness;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ADJUSTER_ADDRESS")
public class AdjusterAddress extends AbstractEntity {

    private String country;

    private String city;

    private String street;

    @Column(name = "flat_number")
    private String flatNumber;

    //jpa
    public AdjusterAddress() {
    }

    public AdjusterAddress(UUID id, String country, String city, String street, String flatNumber) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.flatNumber = flatNumber;
    }

    public String country() {
        return country;
    }

    public String city() {
        return city;
    }

    public String street() {
        return street;
    }

    public String flatNumber() {
        return flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AdjusterAddress that = (AdjusterAddress) o;
        return country.equals(that.country) &&
                city.equals(that.city) &&
                street.equals(that.street) &&
                flatNumber.equals(that.flatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, city, street, flatNumber);
    }
}
