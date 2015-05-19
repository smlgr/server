package org.thehellnet.smlgr.web.model.service;

import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.dao.IDAO;

/**
 * Created by sardylan on 16/05/15.
 */
public interface DataPayloadService extends IDAO<DataPayload> {
    public DataPayload findLast();
}
