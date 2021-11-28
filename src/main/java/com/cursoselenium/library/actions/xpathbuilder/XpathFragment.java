package com.cursoselenium.library.actions.xpathbuilder;

import org.openqa.selenium.By;

public class XpathFragment {


    private StringBuilder sb;

    XpathFragment(StringBuilder sb) {
        this.sb = sb;
    }

    public XpathFragment child(String value){
        sb.append("/").append(value);
        return this;
    }
    public XpathFragment down(String value){
        sb.append("//").append(value);
        return this;
    }

    public XpathFragment attribute(String attribute, String value){
        sb.append("[@").append(attribute).append("='").append(value).append("']");
        return this;
    }

    public XpathFragment text(String value){
        sb.append("[text()='").append(value).append("']");
        return this;
    }

    public XpathFragment textContains(String value){
        sb.append("[contains(text(),'").append(value).append("')]");
        return this;
    }
    public XpathFragment parent(String value){
        sb.append("/parent::").append(value);
        return this;
    }

    public XpathFragment attributeContains(String attribute, String value){
        sb.append("[contains(@").append(attribute).append(",'").append(value).append("')]");
        return this;
    }
    public XpathFragment attributeStartsWith(String attribute, String value){
        sb.append("[starts-with(@").append(attribute).append(",'").append(value).append("')]");
        return this;
    }

    public XpathFragment textStartsWith(String text){
        sb.append("[starts-with(text(),'").append(text).append("')]");
        return this;
    }
    public XpathFragment following(String value){
        sb.append("/following::").append(value);
        return this;
    }
    public XpathFragment id(String value){
        return this.attribute("id", value);
    }


    public By toBy(){
        return By.xpath(sb.toString());
    }

    @Override
    public String toString(){
        return sb.toString();
    }
}
