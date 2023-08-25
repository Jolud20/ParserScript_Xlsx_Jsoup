package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SinglPageParser {
    String class1;
    String name;
    public List<String> ss(String idDeveloper){
        List<String> result= new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://xn--80az8a.xn--d1aqf.xn--p1ai/%D1%81%D0%B5%D1%80%D0%B2%D0%" +
                    "B8%D1%81%D1%8B/%D0%BA%D0%B0%D1%82%D0%B0%D0%BB%D0%BE%D0%B3-%D0%BD%D0%BE%D0%B2%D0%BE%D1%81%D1" +
                    "%82%D1%80%D0%BE%D0%B5%D0%BA/%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82/"+idDeveloper+"\n").get();
            Elements elements1 = doc.getElementsByClass("blur-overlay");
            for(Element element: elements1){
                if(element.select(".fdOkFM").hasText()){
                    class1 = element.select(".fdOkFM").first().text();
                }
                if(element.select(".fuLxCe").hasText()){
                     name =element.select(".fuLxCe").text();
                }
            }
            result.add(class1);
            result.add(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
