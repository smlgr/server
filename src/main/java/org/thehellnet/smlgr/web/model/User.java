package org.thehellnet.smlgr.web.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by sardylan on 16/05/15.
 */
@Entity
@Table(name = "user", schema = "public")
public class User {
    private long id;
    private String email;
    private String password;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "data_payload_id_seq")
    @SequenceGenerator(name = "data_payload_id_seq", sequenceName = "data_payload_id_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Email
    @Column(name = "email",  nullable = false, length = 255, unique = true, updatable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    @Column(name = "password",  nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
