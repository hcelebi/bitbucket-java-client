package io.github.hcelebi.bitbucket.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;

public class CustomDateTimeDeserializer extends StdDeserializer<DateTime> {

    public CustomDateTimeDeserializer() {
        super(DateTime.class);
    }

    @Override
    public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String str = jp.getText().trim();
        if (str.equalsIgnoreCase("none")) {
            return null;
        } else {
            return DateTime.parse(str);
        }
    }
}