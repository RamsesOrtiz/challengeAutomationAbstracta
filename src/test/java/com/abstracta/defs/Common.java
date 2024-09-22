package com.abstracta.defs;

import com.abstracta.config.ConfigPage;
import com.abstracta.utils.PropertyManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common {

    @Before
    public void setup(){
        ConfigPage.setup(PropertyManager.getProperty("browser"));
    }

    @After
    public void quit(){
        ConfigPage.quit();
    }
}
