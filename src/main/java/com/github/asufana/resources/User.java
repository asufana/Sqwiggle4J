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
    private String status;
    private boolean confirmed;
    private String message;
    private String email;
    private String name;
    private String avatar;
    @SerializedName("time_zone")
    private String timeZone;
    @SerializedName("is_contact")
    private boolean isContact;
    private Contact contact;
    @SerializedName("time_zone_offset")
    private String timeZoneOffset;
    private String snapshot;
    @SerializedName("snapshot_interval")
    private Integer snapshotInterval;
    @SerializedName("last_active_at")
    private String lastActiveAt;
    @SerializedName("last_connected_at")
    private String lastConnectedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("media_device_id")
    private String mediaDeviceId;
    @SerializedName("idle_at")
    private String idleAt;
    private boolean support;
    
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
