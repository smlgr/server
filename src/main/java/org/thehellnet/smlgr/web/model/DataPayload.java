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
@Table(name = "data_payload", schema = "public")
public class DataPayload implements Serializable {
    private long id;
    private DateTime dateTime;
    private Inverter inverter;
    private int dcVoltage;
    private int dcCurrent;
    private int acVoltage;
    private int acCurrent;
    private int outPower;
    private int temp;
    private int frequency;
    private int todayProduction;

    public DataPayload() {
        setDateTime(new DateTime());
    }

    public DataPayload(DataPayloadDTO item) {
        setDateTime(new DateTime());

        setDcVoltage(item.getDcVoltage());
        setDcCurrent(item.getDcCurrent());
        setAcVoltage(item.getAcVoltage());
        setAcCurrent(item.getAcCurrent());
        setOutPower(item.getOutPower());
        setTemp(item.getTemp());
        setFrequency(item.getFrequency());
        setTodayProduction(item.getTodayProduction());
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

    @Basic
    @Column(name = "whenquery", insertable = true, updatable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    @JoinColumn(name="inverter_id", referencedColumnName = "id", nullable = false)
    public Inverter getInverter() {
        return inverter;
    }

    public void setInverter(Inverter inverter) {
        this.inverter = inverter;
    }

    @Basic
    @Column(name = "dc_voltage", insertable = true, updatable = true)
    public int getDcVoltage() {
        return dcVoltage;
    }

    public void setDcVoltage(int dcVoltage) {
        this.dcVoltage = dcVoltage;
    }

    @Basic
    @Column(name = "dc_current", insertable = true, updatable = true)
    public int getDcCurrent() {
        return dcCurrent;
    }

    public void setDcCurrent(int dcCurrent) {
        this.dcCurrent = dcCurrent;
    }

    @Basic
    @Column(name = "ac_voltage", insertable = true, updatable = true)
    public int getAcVoltage() {
        return acVoltage;
    }

    public void setAcVoltage(int acVoltage) {
        this.acVoltage = acVoltage;
    }

    @Basic
    @Column(name = "ac_current", insertable = true, updatable = true)
    public int getAcCurrent() {
        return acCurrent;
    }

    public void setAcCurrent(int acCurrent) {
        this.acCurrent = acCurrent;
    }

    @Basic
    @Column(name = "out_power", insertable = true, updatable = true)
    public int getOutPower() {
        return outPower;
    }

    public void setOutPower(int outPower) {
        this.outPower = outPower;
    }

    @Basic
    @Column(name = "temperature", insertable = true, updatable = true)
    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Basic
    @Column(name = "frequency", insertable = true, updatable = true)
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Basic
    @Column(name = "production", insertable = true, updatable = true)
    public int getTodayProduction() {
        return todayProduction;
    }

    public void setTodayProduction(int todayProduction) {
        this.todayProduction = todayProduction;
    }
}
