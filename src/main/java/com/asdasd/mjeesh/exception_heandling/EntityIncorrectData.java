package com.asdasd.mjeesh.exception_heandling;

import lombok.Data;

@Data
public class EntityIncorrectData {
    private String info;

    public EntityIncorrectData(String info) {
        this.info = info;
    }
}
