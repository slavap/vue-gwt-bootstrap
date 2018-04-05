package com.axellience.vuegwtdemo.client.components.bootstrap;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.annotations.component.PropValidator;
import com.axellience.vuegwt.core.client.component.IsVueComponent;

import elemental2.dom.DomGlobal;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

@Component //(hasTemplate = false)
public class JqmButton implements IsVueComponent {

    @Prop @JsProperty boolean mini;
    @Prop @JsProperty String variant;
    @Prop @JsProperty JqmButtonSize size;

    @Computed public String getCalcSize() {
        return mini ? "sm" : size != null ? size.getBsSize() : "";
    }

    @JsMethod void onClick() {
        asVue().$emit("click");
    }

    @PropValidator("variant")
    boolean variantValidator(String value) {
        boolean rslt = true; //"secondary".equals(value);
        if (!rslt) DomGlobal.console.error("Prop 'variant' invalid value: " + value);
        return rslt;
    }

}
