package org.thehellnet.smlgr.web.repository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;

import java.util.List;

/**
 * Created by sardylan on 25/12/15.
 */
@Repository
public interface DataPayloadRepository extends JpaRepository<DataPayload, Long>, DataPayloadRepositoryCustom {
    public List<DataPayload> findByInverterAndDateTimeBetweenOrderByDateTimeAsc(
            Inverter inverter,
            DateTime dateTimeStart,
            DateTime dateTimeEnd);
}
