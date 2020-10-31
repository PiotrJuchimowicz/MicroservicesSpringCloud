package com.company.loss.adjusters.domain.bussiness;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ADJUSTER")
public class Adjuster extends AbstractEntity {

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private AdjusterAccount account;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adjuster_id", nullable = false)
    private Set<AdjusterAddress> addresses;

    //jpa
    public Adjuster() {
    }

    public Adjuster(UUID id, String firstName, String lastName, AdjusterAccount account, Set<AdjusterAddress> addresses) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.addresses = new HashSet<>(addresses);
    }



    void addAddress(AdjusterAddress address) {
        addresses.add(address);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public AdjusterAccount account() {
        return account;
    }

    public Set<AdjusterAddress> addresses() {
        return new HashSet<>(addresses);
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
        Adjuster adjuster = (Adjuster) o;
        return firstName.equals(adjuster.firstName) &&
                lastName.equals(adjuster.lastName) &&
                account.equals(adjuster.account) &&
                addresses.equals(adjuster.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, account, addresses);
    }
}
