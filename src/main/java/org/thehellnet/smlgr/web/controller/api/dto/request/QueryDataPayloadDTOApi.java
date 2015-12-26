package org.thehellnet.smlgr.web.controller.api.dto.request;

import org.joda.time.DateTime;

/**
 * Created by sardylan on 25/12/15.
 */
public class QueryDataPayloadDTOApi extends AbstractApiRequestDTO {
    public String tag;
    public DateTime startInterval;
    public DateTime stopInterval;
}
