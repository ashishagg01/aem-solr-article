package com.adobe.aem.core.models;

import com.adobe.cq.sightly.WCMUse;

public class HelloWorldModel extends WCMUse {

    private String myTitle;

    @Override
    public void activate() {
        String text = get("text", String.class);
        myTitle = "My Project " + text + getCurrentPage().getTitle() + " : " + getProperties().get("title", "");
    }

    public String getMyTitle() {
        return myTitle;
    }

}
