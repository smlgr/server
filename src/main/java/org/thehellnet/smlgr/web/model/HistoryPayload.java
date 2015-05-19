package org.thehellnet.smlgr.web.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by sardylan on 18/05/15.
 */
@Entity
@Table(name = "history", schema = "public")
public class HistoryPayload {
    private DateTime whenquery;
    private int udc;
    private int idc;
    private int ul1;
    private int il1;
    private int pac;
    private int prl;
    private int tkk;
    private int tnf;
    private int kdy;

    @Id
    @Column(name = "whenquery", unique = true, nullable = false, insertable = false, updatable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getWhenquery() {
        return whenquery;
    }

    public void setWhenquery(DateTime whenquery) {
        this.whenquery = whenquery;
    }

    @Basic
    @Column(name = "udc", unique = true, nullable = false, insertable = false, updatable = false)
    public int getUdc() {
        return udc;
    }

    public void setUdc(int udc) {
        this.udc = udc;
    }

    @Basic
    @Column(name = "idc", unique = true, nullable = false, insertable = false, updatable = false)
    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    @Basic
    @Column(name = "ul1", unique = true, nullable = false, insertable = false, updatable = false)
    public int getUl1() {
        return ul1;
    }

    public void setUl1(int ul1) {
        this.ul1 = ul1;
    }

    @Basic
    @Column(name = "il1", unique = true, nullable = false, insertable = false, updatable = false)
    public int getIl1() {
        return il1;
    }

    public void setIl1(int il1) {
        this.il1 = il1;
    }

    @Basic
    @Column(name = "pac", unique = true, nullable = false, insertable = false, updatable = false)
    public int getPac() {
        return pac;
    }

    public void setPac(int pac) {
        this.pac = pac;
    }

    @Basic
    @Column(name = "prl", unique = true, nullable = false, insertable = false, updatable = false)
    public int getPrl() {
        return prl;
    }

    public void setPrl(int prl) {
        this.prl = prl;
    }

    @Basic
    @Column(name = "tkk", unique = true, nullable = false, insertable = false, updatable = false)
    public int getTkk() {
        return tkk;
    }

    public void setTkk(int tkk) {
        this.tkk = tkk;
    }

    @Basic
    @Column(name = "tnf", unique = true, nullable = false, insertable = false, updatable = false)
    public int getTnf() {
        return tnf;
    }

    public void setTnf(int tnf) {
        this.tnf = tnf;
    }

    @Basic
    @Column(name = "kdy", unique = true, nullable = false, insertable = false, updatable = false)
    public int getKdy() {
        return kdy;
    }

    public void setKdy(int kdy) {
        this.kdy = kdy;
    }
}
