package mk.finki.ukim.mk.wplab.model;

import lombok.Data;

import java.util.Optional;

@Data
public class Balloon {

    private Long id;
    private String name;
    private String description;

    private Manufacturer manufacturer;

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }


}
