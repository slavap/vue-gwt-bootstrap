package com.axellience.vuegwtdemo.client.components.temperaturecalc;

import java.util.HashMap;
import java.util.Map;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Emit;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;

import elemental2.dom.DomGlobal;
import jsinterop.annotations.JsMethod;

@Component
public class TemperatureInput implements IsVueComponent {
    @Prop String value;
    @Prop String scale;

    private static final Map<String, String> scaleNames = new HashMap<String, String>() {{
        put("c", "Celsius");
        put("f", "Fahrenheit");
    }};

    /** @param value - new entered value */
    @Emit("input") @JsMethod public void onChanged(String value) {
        DomGlobal.console.log("Entered: " + value + scale);
    }

    @Computed public void setVal(String val) {
        onChanged(val);
    }

    @Computed public String getVal() {
        return value;
    }

    @Computed public String getScaleName() {
      return scaleNames.get(scale);
    }
}
