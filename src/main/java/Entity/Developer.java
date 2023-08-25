package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Developer {
    private String developerName;
    private String name;
    private String adress;
    private String date;
    private String classDeveloper;
    private String id;
    public Developer(String developerName, String adress,String date,String id,String name,String classDeveloper){
        this.developerName = developerName;
        this.adress=adress;
        this.date=date;
        this.id=id;
        this.name=name;
        this.classDeveloper=classDeveloper;
    }
}
