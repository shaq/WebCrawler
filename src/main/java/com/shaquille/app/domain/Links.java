package com.shaquille.app.domain;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class Links {

    public Links(){}

    public Elements findLinks(Document doc) {
        Elements links = doc.select("a[href]");
        return links;
    }

    public ArrayList<String> getLinks(Elements links, URL domain) {
        ArrayList<String> linksFound = new ArrayList<String>();

        for(Element link : links) {
            String absLink = link.attr("abs:href");
            if(absLink.contains(domain.getHost())) {
                linksFound.add(absLink);
            }
        }

        return linksFound;
    }

}
