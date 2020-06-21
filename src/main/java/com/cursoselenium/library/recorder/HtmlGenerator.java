/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.recorder;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Hr;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Img;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Ul;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author pablo
 */
public class HtmlGenerator {    
    private ArrayList<RecorderElements> listOfMessagesForReport;
    private String testCaseName;    
    private int numberOfFailedTests;
    private String htmlReportPath;
    
    public HtmlGenerator(ArrayList<RecorderElements> listOfMessagesForReport, RecorderConfiguration recorderConfiguration) {
        this.listOfMessagesForReport = listOfMessagesForReport;
        this.testCaseName = recorderConfiguration.getTestCaseName();
        this.numberOfFailedTests = recorderConfiguration.getNumberOfFailedTests();
        this.htmlReportPath = recorderConfiguration.getPathHtmlReport();
    } 
    
    public void htmlGenerator() throws IOException{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, kk:mm");

        Html html = new Html();
        Head head = new Head();
        Title title = new Title();
        Hr hr = new Hr();
        Body body = new Body();
        Div headerDiv = new Div();
        File f = new File(htmlReportPath);

        f.createNewFile();

        FileWriter fw = new FileWriter(f);
        BufferedWriter out = new BufferedWriter(fw);

        html.appendChild(body);
        
        title.appendText("Html Report");
        html.appendChild(title);
        body.appendChild(hr);
        hr.setSize("15");
        hr.setStyle(this.getStyleForHr(numberOfFailedTests));
        body.appendChild(headerDiv);
        H1 h1ForHeaderDiv = new H1();
        headerDiv.appendChild(h1ForHeaderDiv);
        h1ForHeaderDiv.appendText(dateFormat.format(date)+ " - " + testCaseName);

        List<Node> listOfDivs = new ArrayList<>();
        Div div1;
        H3 h3;
        Ul ul;
        Img img;
        
        for(RecorderElements element:listOfMessagesForReport){                
        div1 = new Div();
        div1.setStyle(this.getStyleForDiv(element.isSuccess()));

        h3 = new H3();
        h3.setStyle(this.getStyleForH3(element.isSuccess()));
        h3.appendText(element.getActionTime() + " - " + element.getMessage() + "  ");

        ul = new Ul();
        for(String stack:element.getStackTraceArray()){
            ul.appendChild(new Li().appendText(stack));
        }   
        img = new Img("screenshot","data:image/jpg;base64,"+element.getImage());
        img.setHeight("450");
        img.setWidth("800");
        h3.appendChild(ul);                
        div1.appendChild(h3);
        div1.appendChild(img);
        listOfDivs.add(div1);
        }
        body.appendChild(listOfDivs);

        out.write(html.write());
        out.flush();
        out.close();
    }
    
    private String getStyleForDiv(Boolean success){
        if (success){
            return "border-style: solid; border-width:thin; border-color:Green; border-width: medium;";
        }else{
            return "border-style: solid; border-width:thin; border-color:red; border-width: medium;";
        }        
    }

    private String getStyleForH3(Boolean success){
        if (success){
            return "background-color:LimeGreen ;color:black; display: inline";
        }else{
            return "background-color:Crimson;color:black; display: inline";
        }        
    }
    
    private String getStyleForHr(int numberOfFailed){
        if (numberOfFailed<1){
            return "background-color:Green";
        }else{
            return "background-color:Red";
        }        
    }
    

    
    
    
}
