package com.cursoselenium.library.configuration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {

    @XmlElement
    private String browser;
    @XmlElement
    private String portal;
    @XmlElement
    private String user;
    @XmlElement
    private String password;
    @XmlElement
    private String closeBrowser;

    public String getBrowser() {
        return browser;
    }

    public String getPortal() {
        return portal;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getCloseBrowser() {
        return closeBrowser;
    }
}
