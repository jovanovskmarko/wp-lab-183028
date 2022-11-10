package mk.finki.ukim.mk.wplab.bootstrap;

import mk.finki.ukim.mk.wplab.model.Balloon;
import mk.finki.ukim.mk.wplab.model.Manufacturer;
import mk.finki.ukim.mk.wplab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    public static List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init() {
        Manufacturer m1 = new Manufacturer("Manufacturer 1", "Macedonia", "Partizanski Odredi");
        manufacturers.add(m1);
        Manufacturer m2 = new Manufacturer("Manufacturer 2", "Greece", "8 Mart");
        manufacturers.add(m2);
        Manufacturer m3 = new Manufacturer("Manufacturer 3", "Serbia", "Blazo Aleksov");
        manufacturers.add(m3);
        Manufacturer m4 = new Manufacturer("Manufacturer 4", "Bulgaria", "Siska");
        manufacturers.add(m4);
        Manufacturer m5 = new Manufacturer("Manufacturer 5", "Albania", "Goli Otok");
        manufacturers.add(m5);

        balloons.add(new Balloon("Red Balloon", "Balloon-category", m1));
        balloons.add(new Balloon("Yellow Balloon", "Balloon-category", m2));
        balloons.add(new Balloon("Green Balloon", "Balloon-category", m3));
        balloons.add(new Balloon("White Balloon", "Balloon-category", m4));
        balloons.add(new Balloon("Black Balloon", "Balloon-category", m5));
        balloons.add(new Balloon("Orange Balloon", "Balloon-category", m5));
        balloons.add(new Balloon("Pink Balloon", "Balloon-category", m4));
        balloons.add(new Balloon("Purple Balloon", "Balloon-category", m3));
        balloons.add(new Balloon("Blue Balloon", "Balloon-category", m2));
        balloons.add(new Balloon("Grey Balloon", "Balloon-category", m1));


    }

}
