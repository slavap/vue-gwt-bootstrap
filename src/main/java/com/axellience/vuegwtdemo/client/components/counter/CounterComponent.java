package com.axellience.vuegwtdemo.client.components.counter;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.client.component.VueComponent;
import com.axellience.vuegwtdemo.client.components.bootstrap.JqmButton;

import jsinterop.annotations.JsProperty;

@Component(components = { JqmButton.class })
public class CounterComponent extends VueComponent {
    @JsProperty int counterValue = 0;
}