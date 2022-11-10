package mk.finki.ukim.mk.wplab.repository;


import mk.finki.ukim.mk.wplab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wplab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll() {
        return DataHolder.manufacturers;
    }


    public Optional<Manufacturer> findById(Long id) {
        return DataHolder.manufacturers.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}
