package com.axellience.vuegwtdemo.client.components.bootstrap;

import jsinterop.annotations.JsMethod;

public enum JqmButtonSize {
    SMALL("sm"), LARGE("lg");

    private final String bsSize;

    private JqmButtonSize(String bsSize) {
        this.bsSize = bsSize;
    }

    @JsMethod public String getBsSize() {
        return bsSize;
    }
}
