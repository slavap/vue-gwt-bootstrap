package com.axellience.vuegwtdemo.client.components.temperaturecalc;

import java.util.function.Function;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.client.component.VueComponent;

import jsinterop.annotations.JsProperty;

@Component(components = { BoilingVerdict.class, TemperatureInput.class })
public class TemperatureCalc extends VueComponent {

    @JsProperty String temperature = "";
    @JsProperty String scale = "c";

    private static final Function<Double, Double> toCelsius = fahrenheit -> (fahrenheit - 32) * 5 / 9;
    private static final Function<Double, Double> toFahrenheit = celsius -> (celsius * 9 / 5) + 32;

    private static String tryConvert(String temperature, Function<Double, Double> convert) {
      if (temperature == null || temperature.isEmpty()) return "";
      try {
        double input = Double.parseDouble(temperature);
        double output = convert.apply(input);
        double rounded = Math.round(output * 1000) / 1000;
        return String.valueOf(rounded);
      } catch (Exception e) {
          return "";
      }
    }

    @Computed public String getCelsius() {
        return "f".equals(scale) ? tryConvert(temperature, toCelsius) : temperature;
    }

    @Computed public void setCelsius(String value) {
      scale = "c";
      temperature = value;
    }

    @Computed public String getFahrenheit() {
        return "c".equals(scale) ? tryConvert(temperature, toFahrenheit) : temperature;
    }

    @Computed public void setFahrenheit(String value) {
        scale = "f";
        temperature = value;
    }
}
