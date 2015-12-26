package org.thehellnet.smlgr.web.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;

/**
 * Created by sardylan on 25/12/15.
 */
public class DateTimeJsonSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeNumber(value.getMillis());
    }
}
