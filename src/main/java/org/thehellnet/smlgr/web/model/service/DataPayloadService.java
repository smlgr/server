package org.thehellnet.smlgr.web.model.service;

import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.dao.IDAO;

/**
 * Created by sardylan on 16/05/15.
 */
public interface DataPayloadService extends IDAO<DataPayload> {
    public DataPayload findLastByInverterId(long inverterId);
    public DataPayload findTodayFirstByInverterId(long inverterId);
    public DataPayload findTodayLastByInverterId(long inverterId);
    public DataPayload findTodayMaxByInverterId(long inverterId);
    public DataPayload findYesterdayFirstByInverterId(long inverterId);
    public DataPayload findYesterdayLastByInverterId(long inverterId);
    public DataPayload findYesterdayMaxByInverterId(long inverterId);
}
