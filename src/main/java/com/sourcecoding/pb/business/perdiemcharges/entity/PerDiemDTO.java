/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sourcecoding.pb.business.perdiemcharges.entity;

import com.sourcecoding.pb.business.restconfig.JsonDateAdapter;
import com.sourcecoding.pb.business.restconfig.JsonDateTimeAdapter;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Matthias
 */
public class PerDiemDTO {

    public PerDiemDTO() {
    }

    public PerDiemDTO(Date perDiemDate, Double timeFrom, Double timeTo, long projectId, long travelExpenseRateId, BigDecimal charges) {
        this.perDiemDate = perDiemDate;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.projectId = projectId;
        this.travelExpenseRateId = travelExpenseRateId;
        this.charges = charges;
    }

    @XmlJavaTypeAdapter(JsonDateTimeAdapter.class)
    public Date perDiemDate;
    public Double timeFrom;
    public Double timeTo;
    public long projectId;
    public long travelExpenseRateId;
    public BigDecimal charges;
}
