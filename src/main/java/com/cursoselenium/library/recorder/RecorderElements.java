/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.recorder;

/**
 *
 * @author pablo
 */
public class RecorderElements {
    
    private String message;
    private boolean success;
    private String[] stackTraceArray;
    private String actionTime;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }
    
    public String[] getStackTraceArray() {
        return stackTraceArray;
    }

    public void setStackTraceArray(String[] stackTraceArray) {
        this.stackTraceArray = stackTraceArray;
    }
        
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
