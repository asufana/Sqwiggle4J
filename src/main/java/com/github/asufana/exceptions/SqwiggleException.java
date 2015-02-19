package com.github.asufana.exceptions;

import org.slf4j.*;

public class SqwiggleException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SqwiggleException.class);
    
    private final String message;
    
    public SqwiggleException(final Exception e) {
        super(e);
        message = String.format("SqwiggleException: %s", e.getMessage());
        logger.error(message);
    }
    
    public String message() {
        return message;
    }
}
