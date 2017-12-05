package com.axellience.vuegwtdemo.client;

import com.axellience.vuegwt.core.client.Vue;
import com.axellience.vuegwt.core.client.VueGWT;
import com.axellience.vuegwt.gwt2.client.widget.VueGwtWidget;
import com.axellience.vuegwtdemo.client.components.counter.CounterComponent;
import com.axellience.vuegwtdemo.client.components.temperaturecalc.TemperatureCalc;
import com.axellience.vuegwtdemo.client.components.todolist.TodoListComponent;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class VueGwtDemoApp implements EntryPoint
{
    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad()
    {
        VueGWT.init();

        // Create a simple GWT panel containing a CounterComponent
        RootPanel
            .get("simpleCounterComponentContainer")
            .add(new VueGwtWidget<>(CounterComponent.class));

        Vue.component("TemperatureCalc", TemperatureCalc.class);
        Vue.attach("#temperatureCalcContainer", TemperatureCalc.class);

        Vue.attach("#todoListComponentContainer", TodoListComponent.class);
    }
}
