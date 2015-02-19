package com.github.asufana.resources;

import java.util.*;

import lombok.*;
import lombok.Value;
import lombok.experimental.*;

import org.joda.time.*;
import org.joda.time.format.*;

@Value
@Accessors(fluent = true)
@ToString
public class User {
    
    private Integer id;
    private String role;
    private String media_device_id;
    private String status;
    private String message;
    private String name;
    private String email;
    private String avatar;
    private String snapshot;
    private Integer snapshot_interval;
    private boolean confirmed;
    private String time_zone;
    private String time_zone_offset;
    private String created_at;
    private String last_active_at;
    private String last_connected_at;
    
    public Role role() {
        return Arrays.asList(Role.values())
                     .stream()
                     .filter(r -> r.name().toLowerCase().equals(role))
                     .findAny()
                     .get();
    }
    
    public Status status() {
        return Arrays.asList(Status.values())
                     .stream()
                     .filter(r -> r.name().toLowerCase().equals(status))
                     .findAny()
                     .get();
    }
    
    public DateTime created_at() {
        return toDateTime(created_at);
    }
    
    public DateTime last_active_at() {
        return toDateTime(last_active_at);
    }
    
    public DateTime last_connected_at() {
        return toDateTime(last_connected_at);
    }
    
    private DateTime toDateTime(final String isoDateTimeFormatString) {
        return ISODateTimeFormat.dateTime()
                                .parseDateTime(isoDateTimeFormatString);
    }
    
    public static enum Role {
        user,
        owner,
        manager,
        banned;
    }
    
    public static enum Status {
        busy,
        available;
    }
}
