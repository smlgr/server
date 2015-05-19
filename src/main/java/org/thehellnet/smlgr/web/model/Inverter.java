package org.thehellnet.smlgr.web.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sardylan on 15/05/15.
 */
@Entity
@Table(name = "inverter", schema = "public")
public class Inverter implements Serializable {
    private long id;
    private User user;
    private String producer;
    private String model;
    private int maxPower;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "inverter_id_seq")
    @SequenceGenerator(name = "inverter_id_seq", sequenceName = "inverter_id_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "producer",  nullable = true)
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Basic
    @Column(name = "model", nullable = true)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "max_power", nullable = false)
    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }
}
