package com.axellience.vuegwtdemo.client;

import com.axellience.vuegwt.core.client.Vue;
import com.axellience.vuegwt.core.client.VueGWT;
import com.axellience.vuegwtdemo.client.components.counter.CounterComponent;
import com.axellience.vuegwtdemo.client.components.temperaturecalc.TemperatureCalc;
import com.axellience.vuegwtdemo.client.components.todolist.TodoListComponent;
import com.google.gwt.core.client.EntryPoint;

public class BootstrapVueGwtApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        VueGWT.initWithoutVueLib();

        // Create a simple GWT panel containing a CounterComponent
        Vue.attach("#simpleCounterComponentContainer", CounterComponent.class);

        Vue.component("TemperatureCalc", TemperatureCalc.class);
        Vue.attach("#temperatureCalcContainer", TemperatureCalc.class);

        Vue.attach("#todoListComponentContainer", TodoListComponent.class);
    }

}
