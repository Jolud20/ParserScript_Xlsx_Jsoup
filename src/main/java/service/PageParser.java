package service;

import Entity.Developer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

//Парсит 1 страницу и через конструктор создаёт list сущностей Developer
public class PageParser {
    SinglPageParser singlPageParser = new SinglPageParser();
    String name;
    String developerName;
    String adress;
    String id;
    String deadline;
    String classDeveloper;
    SeleniumStarter seleniumStarter = new SeleniumStarter();
    public List<Developer> parsePage(String url){
        List<String> qw;
        List<Developer> result = new ArrayList<>();
            Document doc = Jsoup.parse(seleniumStarter.seleniumStart(url));
            Elements elements = doc.getElementsByAttributeValueContaining("class", "juOdVa");
            for(Element element: elements){
                deadline = element.select(".fiRgDP").text().substring(element.select(".fiRgDP").text().length()-11);
                    developerName = element.select(".hrAtrR").text();
                    adress=element.select(".bAMYVU a").text();
                    id=element.select(".kdslYa").text();
                    System.out.println(id);
                    qw=singlPageParser.ss(id);
                    if(!qw.isEmpty()){
                        classDeveloper=qw.get(0).substring(18);
                        name=qw.get(1);
                    }
                    result.add(new Developer(developerName, adress, deadline,id,name,classDeveloper));
            }
        return result;
    }
}