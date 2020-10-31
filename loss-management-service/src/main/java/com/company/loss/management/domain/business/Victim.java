package com.company.loss.management.domain.business;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "VICTIM")
public class Victim extends AbstractEntity {

    private String name;
    private String surname;
    private String email;

    //jpa
    private Victim() {

    }

    public Victim(UUID id, String name, String surname, String email) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }
}
