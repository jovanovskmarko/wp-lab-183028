package mk.finki.ukim.mk.wplab.service;

import mk.finki.ukim.mk.wplab.model.Balloon;
import mk.finki.ukim.mk.wplab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {

    List<Balloon> listAll();

    List<Balloon> searchByNameOrDescription(String text);

    void deleteBalloon(Long id);

    Optional<Balloon> saveBalloon(String name, String description, Long manId);

    Optional<Balloon> findById(Long id);
}
