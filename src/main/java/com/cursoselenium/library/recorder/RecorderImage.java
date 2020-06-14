/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.recorder;

import com.cursoselenium.library.configuration.TestConfiguration;
import com.cursoselenium.library.configuration.TestLogger;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 *
 * @author pablo
 */
public class RecorderImage {

    public RecorderImage(WebElement webElement) {
        this.webElement = webElement;
    }         
    private WebElement webElement;
    
    public String getImage(boolean drawRectangle){
    File screenshot = ((TakesScreenshot)TestConfiguration.driver).getScreenshotAs(OutputType.FILE);
    BufferedImage fullImg = null;
    
    // Get page screenshot
    try{
        fullImg = ImageIO.read(screenshot);
    }catch(IOException e){
        TestLogger.setErrorLog("Error in buffering image");
    }      
    
    if (drawRectangle){
        // Get the location of element on the page
        Point point = webElement.getLocation();

        Stroke stroke1 = new BasicStroke(6f);

        // Get width and height of the element
        int webElementWidth = webElement.getSize().getWidth();
        int webElementHeight = webElement.getSize().getHeight();    

        // Draw rectangle    
        Graphics2D g2d = fullImg.createGraphics();
        g2d.setColor(Color.MAGENTA);
        g2d.setStroke(stroke1);
        g2d.drawRect(point.getX(), point.getY(), webElementWidth, webElementHeight);  
        g2d.dispose();
    }
    
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            ImageIO.write(fullImg, "png", baos);

        } catch (Exception e) {
            System.out.println("[ERROR] Could not save image.");
        }  

        return new String(Base64.getEncoder().encodeToString(baos.toByteArray()));
    }
   
}
