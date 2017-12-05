package com.axellience.vuegwtdemo.client.components.temperaturecalc;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.VueComponent;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

@Component
public class BoilingVerdict extends VueComponent {
    @Prop @JsProperty String celsius;

    @JsMethod double parseFloat(String value) {
        if (value == null) return 0;
        String s = value.trim();
        if (s.isEmpty()) return 0;
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }
}