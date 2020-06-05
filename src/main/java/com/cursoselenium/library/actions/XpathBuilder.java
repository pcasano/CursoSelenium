/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.actions;

import org.openqa.selenium.By;


/**
 *
 * @author pablo
 */
public class XpathBuilder {
 
//div[@class='mini-tours']//a
//*[text()='España']/parent::div//a[contains(text(),'strenos')]
//*[@class='movie-card-13']//div[starts-with(text(),'The')]
//*[text()='España' and @class='lsmheader']/parent::div//a[contains(text(),'strenos')]   =   //*[text()='España'][@class='lsmheader']/parent::div//a[contains(text(),'strenos')]

    //XpathBuilder.any("div").text("España").attribute("class", "lsmheader).toBy
    
    private StringBuilder sb = new StringBuilder();
    
    public XpathBuilder any(){
        sb.append("//*");
        return this;
    }
    
    public XpathBuilder any(String value){
        sb.append("//").append(value);
        return this;
    }   
    
    public XpathBuilder child(String value){
        sb.append("/").append(value);
        return this;
    }    

    public XpathBuilder down(String value){
        sb.append("//").append(value);
        return this;
    }  
    
    public XpathBuilder attribute(String attribute, String value){
        sb.append("[@").append(attribute).append("='").append(value).append("']");
        return this;
    }
    
    public XpathBuilder text(String value){
        sb.append("[text()='").append(value).append("']");
        return this;
    }      
    
    public XpathBuilder textContains(String value){
        sb.append("[contains(text(),'").append(value).append("')]");
        return this;
    } 


    public XpathBuilder parent(String value){
        sb.append("/parent::").append(value);
        return this;
    } 
    
    public XpathBuilder attributeContains(String attribute, String value){
        sb.append("[contains(@").append(attribute).append(",'").append(value).append("')]");
        return this;
    } 

    public XpathBuilder attributeStartsWith(String attribute, String value){
        sb.append("[starts-with(@").append(attribute).append(",'").append(value).append("')]");
        return this;
    }
    
    public XpathBuilder textStartsWith(String text){
        sb.append("[starts-with(text(),'").append(text).append("')]");
        return this;
    } 

    public XpathBuilder following(String value){
        sb.append("/following::").append(value); 
        return this;
    }

    public XpathBuilder id(String value){
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
