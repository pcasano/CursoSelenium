package com.cursoselenium.library.actions.xpathbuilder;

public class XpathBuilder {

    public static XpathFragment any() {
        StringBuilder sb = new StringBuilder();
        sb.append("//*");
        return new XpathFragment(sb);
        }

    public static XpathFragment any(String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("//").append(value);
        return new XpathFragment(sb);
        }

    }




