package com.axellience.vuegwtdemo.client;

import com.axellience.vuegwt.core.client.Vue;
import com.axellience.vuegwt.core.client.VueGWT;
import com.axellience.vuegwtdemo.client.components.counter.CounterComponentFactory;
import com.axellience.vuegwtdemo.client.components.temperaturecalc.TemperatureCalcFactory;
import com.axellience.vuegwtdemo.client.components.todolist.TodoListComponentFactory;
import com.google.gwt.core.client.EntryPoint;

public class BootstrapVueGwtApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        VueGWT.initWithoutVueLib();

        // Create a simple GWT panel containing a CounterComponent
        Vue.attach("#simpleCounterComponentContainer", CounterComponentFactory.get());

        Vue.component("TemperatureCalc", TemperatureCalcFactory.get());
        Vue.attach("#temperatureCalcContainer", TemperatureCalcFactory.get());

        Vue.attach("#todoListComponentContainer", TodoListComponentFactory.get());
    }

}
