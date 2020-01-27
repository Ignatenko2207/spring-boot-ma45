package com.mainacad.model;

import lombok.Getter;

@Getter
public enum CartStatus {
    OPEN("open"),
    CLOSED("closed");

    private final String name;

    CartStatus(String name) {
        this.name = name;
    }
}
