package mk.finki.ukim.mk.wplab.service.impl;

import mk.finki.ukim.mk.wplab.model.Balloon;
import mk.finki.ukim.mk.wplab.model.Manufacturer;
import mk.finki.ukim.mk.wplab.repository.BalloonRepository;
import mk.finki.ukim.mk.wplab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.wplab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImp implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImp(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }


    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {

        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void deleteBalloon(Long id) {
        balloonRepository.deleteBalloon(id);
    }


    @Override
    public Optional<Balloon> saveBalloon(String name, String description, Long manId) {

        Optional<Manufacturer> m = manufacturerRepository.findById(manId);

        Manufacturer manufacturer = this.manufacturerRepository.findById(manId).orElseThrow(() -> new RuntimeException());
        return this.balloonRepository.saveBalloon(name, description, manufacturer);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }


}
