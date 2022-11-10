package mk.finki.ukim.mk.wplab.repository;

import mk.finki.ukim.mk.wplab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wplab.model.Balloon;
import mk.finki.ukim.mk.wplab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {


    public List<Balloon> findAllBalloons() {
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return DataHolder.balloons.stream().filter(b -> b.getName().contains(text) || b.getDescription().contains(text)).collect(Collectors.toList());
    }

    public void deleteBalloon(Long id) {
        DataHolder.balloons.removeIf(b -> b.getId().equals(id));
    }


    public Optional<Balloon> saveBalloon(String name, String description, Manufacturer manufacturer) {

        DataHolder.balloons.removeIf(b -> b.getName().equals(name));

        Balloon balloon = new Balloon(name, description, manufacturer);
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);

    }

    public Optional<Balloon> findById(Long id) {
        return DataHolder.balloons.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}
