package com.example.eventsystem;

import com.example.eventsystem.entity.Location;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class LocationSerializer extends JsonSerializer<Location> {

    @Override
    public void serialize(Location value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeEndObject();
    }
}
