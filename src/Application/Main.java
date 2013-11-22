package Application;

import Persistence.HistogramBuilder;
import Persistence.AttributeExtractor;
import Persistence.PersonLoader;
import Model.Email;
import Model.Histogram;
import Model.Person;
import Model.Sex;
import UI.ChartHistogramViewer;
import UI.ConsoleHistogramViewer;
import UI.HistogramViewer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PersonLoader loader = createPersonLoader();
        HistogramBuilder<Person> builder = createBuilder(loader.load());
        HistogramViewer<String> viewer = createHistogramViewer(builder.build(createAttributeExtractor()));
        
        viewer.show();
        
        
        
    }

    private static PersonLoader createPersonLoader() {
        return new PersonLoader() {
            @Override
            public Person[] load() {
                ArrayList<Person> list = new ArrayList<>();
                list.add(new Person("Eduardo", new Email("ed@gmail.com"), Sex.MALE));
                list.add(new Person("Marcos", new Email("mac@hotmail.com"), Sex.MALE));
                list.add(new Person("Antonio", new Email("tony@gmail.com"), Sex.MALE));
                list.add(new Person("Melinda", new Email("melinda@yahoo.com"), Sex.FEMALE));
                list.add(new Person("Ana", new Email("ana@hotmail.es"), Sex.FEMALE));
                list.add(new Person("Socrates", new Email("socrates@hotmail.es"), Sex.MALE));
                return list.toArray(new Person[0]);
            }
        };
    }

    private static HistogramBuilder<Person> createBuilder(Person[] collection) {
        return new HistogramBuilder<>(collection);
    }

    private static HistogramViewer<String> createHistogramViewer(Histogram<String> histogram) {
        return new ChartHistogramViewer<>(histogram);
    }
    
    private static AttributeExtractor<Person,String> createAttributeExtractor(){
        return new AttributeExtractor<Person, String>() {
            @Override
            public String extract(Person person) {
                return person.getEmail().getDomain();
            }
        };
    }
}
