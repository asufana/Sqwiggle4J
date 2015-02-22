package com.github.asufana.resources;

import lombok.*;
import lombok.Value;
import lombok.experimental.*;

import org.joda.time.*;

import com.google.gson.annotations.*;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends AbstractResource {
    
    private Integer id;
    private String role;
    @SerializedName("media_device_id")
    private String mediaDeviceId;
    private String status;
    private String message;
    private String name;
    private String email;
    private String avatar;
    private String snapshot;
    @SerializedName("snapshot_interval")
    private Integer snapshotInterval;
    private boolean confirmed;
    @SerializedName("is_contact")
    private boolean isContact;
    private boolean support;
    @SerializedName("idle_at")
    private String idleAt;
    private Contact contact;
    
    @SerializedName("time_zone")
    private String timeZone;
    @SerializedName("time_zone_offset")
    private String timeZoneOffset;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("last_active_at")
    private String lastActiveAt;
    @SerializedName("last_connected_at")
    private String lastConnectedAt;
    
    @Value
    @Accessors(fluent = true)
    @ToString
    public static class Contact {
        private Integer id;
        private String state;
        @SerializedName("user_id")
        private Integer userId;
        @SerializedName("contact_id")
        private Integer contactId;
        @SerializedName("created_at")
        private String createdAt;
    }
    
    public DateTime createdAt() {
        return toDateTime(createdAt);
    }
    
    public DateTime lastActiveAt() {
        return toDateTime(lastActiveAt);
    }
    
    public DateTime lastConnectedAt() {
        return toDateTime(lastConnectedAt);
    }
    
}
