package com.shaquille.app.domain;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Assets {

    public Assets() {}

    public Elements findAssets(Document doc) {
        Elements links = doc.select("[src]");
        return links;
    }

    public void getAssets(Elements assets) {
        for (Element src : assets) {
            if (src.tagName().equals("img") || src.tagName().equals("image")) {
                System.out.printf(" --> %s: <%s> %sx%s\n", src.tagName(), src.attr("abs:src"), src.attr("width"),
                        src.attr("height"));
            } else {
                System.out.printf(" ~~> %s: <%s>\n", src.tagName(), src.attr("abs:src"));
            }
        }
    }
}
