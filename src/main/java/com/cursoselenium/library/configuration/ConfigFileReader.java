/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.configuration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author pablo
 */

public class ConfigFileReader {
    
    private String browser;
    private String user;
    private String password;
    private String portal;
    private String closeBrowser;

    private void setBrowser(String browser) {
        this.browser = browser;
    }
    
    private void setCloseBrowser(String closeBrowser) {
        this.closeBrowser = closeBrowser;
    }
    
    private void setUser(String user) {
        this.user = user;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setPortal(String portal) {
        this.portal = portal;
    }

    private String getBrowser() {
        return browser;
    }

    private String getUser() {
        return user;
    }

    private String getPassword() {
        return password;
    }

    private String getPortal() {
        return portal;
    }
    
    private String getCloseBrowser() {
        return closeBrowser;
    }    
    
    
    public void  extractParameter(){
	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File("C:\\Users\\pablo\\Documents\\NetBeansProjects\\cursoselenium\\ConfigFile.xml");    
	  try {
		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("parameters");
                Element node = (Element) list.get(0);
                
                this.setBrowser(node.getChildText("browser"));
                this.setPassword(node.getChildText("password"));
                this.setPortal(node.getChildText("portal"));
                this.setUser(node.getChildText("user"));
                this.setCloseBrowser(node.getChildText("closeBrowser"));
                
            } catch (IOException | JDOMException io) {
		System.out.println(io.getMessage());
            }
        }   
    
    public Map<String, String> getHashMap(){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("browser", this.getBrowser());
        hashMap.put("password", this.getPassword());
        hashMap.put("portal", this.getPortal());
        hashMap.put("user", this.getUser());
        hashMap.put("closeBrowser", this.getCloseBrowser());
        return hashMap;  
    }
    
}
