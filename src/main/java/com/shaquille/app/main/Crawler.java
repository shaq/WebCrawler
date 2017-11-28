package com.shaquille.app.main;

import com.shaquille.app.domain.*;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Crawler implements ICrawler {

    public Crawler(){}

    public void crawlEachLink (ArrayList<String> linksFound) {
        Assets assets  = new Assets();
        int i = 1;
        for (String link : linksFound) {
            Document doc = WebPage.connect(link);
            System.out.printf("\n\n#%d Retrieving assets for <%s> ...\n", i, link);
            assets.getAssets(assets.findAssets(doc));
            i++;
        }
    }


}
