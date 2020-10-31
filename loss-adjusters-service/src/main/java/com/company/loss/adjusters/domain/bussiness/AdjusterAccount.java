package com.company.loss.adjusters.domain.bussiness;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ADJUSTER_ACCOUNT")
public class AdjusterAccount extends AbstractEntity {

    private String privateEmail;
    private String businessEmail;

    //jpa
    public AdjusterAccount() {
    }

    public AdjusterAccount(UUID id, String privateEmail, String businessEmail) {
        super(id);
        this.privateEmail = privateEmail;
        this.businessEmail = businessEmail;
    }

    public String privateEmail() {
        return privateEmail;
    }

    public String businessEmail() {
        return businessEmail;
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
        AdjusterAccount that = (AdjusterAccount) o;
        return privateEmail.equals(that.privateEmail) &&
                businessEmail.equals(that.businessEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), privateEmail, businessEmail);
    }
}
