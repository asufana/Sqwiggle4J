package com.github.asufana.resources;

import lombok.*;
import lombok.Value;
import lombok.experimental.*;

@Value
@Accessors(fluent = true)
@ToString
public class User {
    
    private Integer id;
}
