package org.thehellnet.smlgr.web.model.dto;

import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.Inverter;

import java.io.Serializable;

/**
 * Created by sardylan on 16/05/15.
 */
public class DataPayloadDTO implements Serializable {
    private int dcVoltage;
    private int dcCurrent;
    private int acVoltage;
    private int acCurrent;
    private int outPower;
    private int temp;
    private int frequency;
    private int todayProduction;

    public int getDcVoltage() {
        return dcVoltage;
    }

    public void setDcVoltage(int dcVoltage) {
        this.dcVoltage = dcVoltage;
    }

    public int getDcCurrent() {
        return dcCurrent;
    }

    public void setDcCurrent(int dcCurrent) {
        this.dcCurrent = dcCurrent;
    }

    public int getAcVoltage() {
        return acVoltage;
    }

    public void setAcVoltage(int acVoltage) {
        this.acVoltage = acVoltage;
    }

    public int getAcCurrent() {
        return acCurrent;
    }

    public void setAcCurrent(int acCurrent) {
        this.acCurrent = acCurrent;
    }

    public int getOutPower() {
        return outPower;
    }

    public void setOutPower(int outPower) {
        this.outPower = outPower;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTodayProduction() {
        return todayProduction;
    }

    public void setTodayProduction(int todayProduction) {
        this.todayProduction = todayProduction;
    }
}
