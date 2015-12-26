package org.thehellnet.smlgr.web.repository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.Inverter;

/**
 * Created by sardylan on 25/12/15.
 */
@Repository
public interface InverterRepository extends JpaRepository<Inverter, Long> {
    public Inverter findByTag(String tag);

    public Inverter findByTagAndToken(String tag, String token);
}
