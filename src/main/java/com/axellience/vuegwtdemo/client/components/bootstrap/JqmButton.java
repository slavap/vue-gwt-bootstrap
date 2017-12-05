package com.axellience.vuegwtdemo.client.components.bootstrap;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.VueComponent;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

@Component //(hasTemplate = false)
public class JqmButton extends VueComponent {
    @Prop @JsProperty boolean mini;
    @Prop @JsProperty String variant;
    @Prop @JsProperty String size;

    @Computed public String getCalcSize() {
        return mini ? "sm" : size;
    }

    @JsMethod void onClick() {
        this.$emit("click");
    }

}
