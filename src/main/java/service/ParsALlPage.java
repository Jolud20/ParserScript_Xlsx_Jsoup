package service;

import java.io.IOException;

public class ParsALlPage {
    int countPages=0;
    public void AllPageParser() throws IOException {
        while (countPages<=2){
            new WriteInXlsx().writeInFile(new PageParser().parsePage("https://xn--80az8a.xn--d1aqf.xn--p1ai/%D1%81%D0%B5%D1%" +
                    "80%D0%B2%D0%B8%D1%81%D1%8B/%D0%BA%D0%B0%D1%82%D0%B0%D0%BB%D0%BE%D0%B3-%D0%BD%D0%BE%D0%B2%" +
                    "D0%BE%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BA/%D1%81%D0%BF%D0%B8%D1%81%D0%BE%D0%BA-%D0%BE%D0%B1" +
                    "%D1%8A%D0%B5%D0%BA%D1%82%D0%BE%D0%B2/%D1%81%D0%BF%D0%B8%D1%81%D0%BE%D0%BA?objStatus=0%3A2&pa" +
                    "ge="+countPages+"&limit=100&objectIds=44852%2C47044%2C49370&sortName=objReady100PercDt&sortDirection=desc" +
                    "&fromDatePubl=2022-01-01&toDatePubl=2023-07-31&residentialBuildings=1"));
            System.out.println("Страница-" + countPages);
            countPages++;
        }
    }
}
