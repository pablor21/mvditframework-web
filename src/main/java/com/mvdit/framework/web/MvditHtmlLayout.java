/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.framework.web;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;

/**
 *
 * @author Pablo Ramírez
 */
public class MvditHtmlLayout extends HTMLLayout {

    @Override
    public String getHeader() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("<div class=\"mvditLog\">");
        sbuf.append("<hr />" + Layout.LINE_SEP);
        sbuf.append("Log session start time " + new java.util.Date() + "<br>" + Layout.LINE_SEP);
        sbuf.append("<br>" + Layout.LINE_SEP);
        sbuf.append("<table>" + Layout.LINE_SEP);
        sbuf.append("<tr>" + Layout.LINE_SEP);
        sbuf.append("<th>Time</th>" + Layout.LINE_SEP);
        sbuf.append("<th>Thread</th>" + Layout.LINE_SEP);
        sbuf.append("<th>Level</th>" + Layout.LINE_SEP);
        sbuf.append("<th>Category</th>" + Layout.LINE_SEP);
        if (getLocationInfo()) {
            sbuf.append("<th>File:Line</th>" + Layout.LINE_SEP);
        }
        sbuf.append("<th>Message</th>" + Layout.LINE_SEP);
        sbuf.append("</tr>" + Layout.LINE_SEP);
        return sbuf.toString();
    }

    @Override
    public String getFooter() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("</table>" + Layout.LINE_SEP);
        sbuf.append("<br />" + Layout.LINE_SEP);
        sbuf.append("</div>");
        return sbuf.toString();
    }

}
