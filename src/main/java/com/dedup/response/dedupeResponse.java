package com.dedup.response;

import com.dedup.model.UserInfo;
import lombok.Data;

@Data
public class dedupeResponse {
    private String message;
    private boolean isDuplicate;


    public dedupeResponse(String message, boolean isDuplicate) {
        this.message = message;
        this.isDuplicate = isDuplicate;

    }
}
