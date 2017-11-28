package com.shaquille.app.main;

import com.shaquille.app.domain.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CrawlerMain {

    public static void main(String[] args) throws IOException {

        WebPage webPage = new WebPage();
        Links links = new Links();
        Crawler crawler = new Crawler();


        URL site = webPage.getWebPage();

        Document doc = webPage.connect(site.toString());

        Elements listOfLinks = links.findLinks(doc);
        ArrayList<String> linksFound = links.getLinks(listOfLinks, site);
        crawler.crawlEachLink(linksFound);


    }

}
