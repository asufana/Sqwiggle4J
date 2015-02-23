package com.github.asufana.resources;

import java.util.*;

import lombok.*;
import lombok.Value;
import lombok.experimental.*;

import org.joda.time.*;

import com.google.gson.annotations.*;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Message extends AbstractResource {
    
    private Integer id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("conversation_id")
    private Integer conversationId;
    @SerializedName("stream_id")
    private Integer streamId;
    private List<Mention> mentions;
    private Author author;
    private String type;
    private String text;
    private List<Attachment> attachments;
    
    public DateTime created_at() {
        return toDateTime(createdAt);
    }
    
    public DateTime updated_at() {
        return toDateTime(updatedAt);
    }
    
    @Value
    @Accessors(fluent = true)
    @EqualsAndHashCode(callSuper = true)
    @ToString
    public static class Mention extends AbstractResource {
        @SerializedName("subject_type")
        private String subjectType;
        @SerializedName("subject_id")
        private String subjectId;
        private String text;
        private String name;
        private List<Integer> indices;
        @SerializedName("message_id")
        private Integer messageId;
        private Integer id;
    }
    
    @Value
    @Accessors(fluent = true)
    @EqualsAndHashCode(callSuper = true)
    @ToString
    public static class Author extends AbstractResource {
        private Integer id;
        private String name;
        private String avatar;
        private String type;
        private boolean support;
    }
    
    @Value
    @Accessors(fluent = true)
    @EqualsAndHashCode(callSuper = true)
    @ToString
    public static class Attachment extends AbstractResource {
        private Integer id;
        private String title;
        private boolean animated;
        private String type;
        private String image;
        private String status;
        private String width;
        private String height;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        
        public DateTime created_at() {
            return toDateTime(createdAt);
        }
        
        public DateTime updated_at() {
            return toDateTime(updatedAt);
        }
    }
}
