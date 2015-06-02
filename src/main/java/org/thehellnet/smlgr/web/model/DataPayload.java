package org.thehellnet.smlgr.web.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.dto.DataPayloadDTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sardylan on 14/05/15.
 */
@Entity
@Table(name = "data_payload", schema = "public", indexes = {
        @Index(name = "data_payload_whenquery_idx", columnList = "whenquery"),
        @Index(name = "data_payload_ac_power_idx", columnList = "ac_power")
})
public class DataPayload implements Serializable {
    private long id;
    private DateTime dateTime;
    private Inverter inverter;
    private int acPower;
    private int acVoltage;
    private int acCurrent;
    private int acFrequency;
    private int dc1Voltage;
    private int dc1Current;
    private int dc2Voltage;
    private int dc2Current;
    private int temperature;
    private int production;

    public DataPayload() {
        setDateTime(new DateTime());
    }

    public DataPayload(DataPayloadDTO item) {
        setDateTime(new DateTime());

        setAcPower(item.getAc_power());
        setAcVoltage(item.getAc_voltage());
        setAcCurrent(item.getAc_current());
        setAcFrequency(item.getAc_frequency());
        setDc1Voltage(item.getDc1_voltage());
        setDc1Current(item.getDc1_current());
        setDc2Voltage(item.getDc2_voltage());
        setDc2Current(item.getDc2_current());
        setTemperature(item.getTemperature());
        setProduction(item.getProduction());
    }

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

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "whenquery", insertable = true, updatable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inverter_id", referencedColumnName = "id", nullable = false)
    public Inverter getInverter() {
        return inverter;
    }

    public void setInverter(Inverter inverter) {
        this.inverter = inverter;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ac_power", insertable = true, updatable = true)
    public int getAcPower() {
        return acPower;
    }

    public void setAcPower(int acPower) {
        this.acPower = acPower;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ac_voltage", insertable = true, updatable = true)
    public int getAcVoltage() {
        return acVoltage;
    }

    public void setAcVoltage(int acVoltage) {
        this.acVoltage = acVoltage;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ac_current", insertable = true, updatable = true)
    public int getAcCurrent() {
        return acCurrent;
    }

    public void setAcCurrent(int acCurrent) {
        this.acCurrent = acCurrent;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ac_frequency", insertable = true, updatable = true)
    public int getAcFrequency() {
        return acFrequency;
    }

    public void setAcFrequency(int acFrequency) {
        this.acFrequency = acFrequency;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "dc1_voltage", insertable = true, updatable = true)
    public int getDc1Voltage() {
        return dc1Voltage;
    }

    public void setDc1Voltage(int dc1Voltage) {
        this.dc1Voltage = dc1Voltage;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "dc1_current", insertable = true, updatable = true)
    public int getDc1Current() {
        return dc1Current;
    }

    public void setDc1Current(int dc1Current) {
        this.dc1Current = dc1Current;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "dc2_voltage", insertable = true, updatable = true)
    public int getDc2Voltage() {
        return dc2Voltage;
    }

    public void setDc2Voltage(int dc2Voltage) {
        this.dc2Voltage = dc2Voltage;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "dc2_current", insertable = true, updatable = true)
    public int getDc2Current() {
        return dc2Current;
    }

    public void setDc2Current(int dc2Current) {
        this.dc2Current = dc2Current;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "temperature", insertable = true, updatable = true)
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "production", insertable = true, updatable = true)
    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }
}
