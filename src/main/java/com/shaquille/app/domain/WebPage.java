package com.shaquille.app.domain;

import com.google.common.net.InternetDomainName;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {

    public WebPage() {}

    public String getDomain(URL url) {
        return InternetDomainName.from(url.toString().replaceAll("http://", "")).topPrivateDomain().toString().
                replaceAll("/", "");
    }

    public URL getWebPage() {
        System.out.println("Please enter the webpage you want to crawl ...");
        Scanner input = new Scanner(System.in);
        String site = input.next();
        if (!site.contains("http://") || !site.contains("https://")){
            site = "http://" + site;
        }
        URL webPage = null;
        try {
            webPage = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webPage;
    }

    public static Document connect(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

}
