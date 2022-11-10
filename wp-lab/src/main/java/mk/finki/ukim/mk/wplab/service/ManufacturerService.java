package mk.finki.ukim.mk.wplab.service;

import mk.finki.ukim.mk.wplab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    public List<Manufacturer> findAll();

    public Optional<Manufacturer> findById(Long id);
}
