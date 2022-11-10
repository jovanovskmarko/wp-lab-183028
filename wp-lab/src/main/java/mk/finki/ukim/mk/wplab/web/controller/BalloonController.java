package mk.finki.ukim.mk.wplab.web.controller;


import mk.finki.ukim.mk.wplab.model.Balloon;
import mk.finki.ukim.mk.wplab.model.Manufacturer;
import mk.finki.ukim.mk.wplab.service.BalloonService;
import mk.finki.ukim.mk.wplab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Balloon> balloonList = balloonService.listAll();
        model.addAttribute("balloonList", balloonList);
        return "listBalloons";
    }


    @GetMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {

        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        if (this.balloonService.findById(id).isPresent()) {
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "add-ballon";
        }
        return "redirect:/products?error=ProductNotFound";

    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model) {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-ballon";
    }

    @PostMapping("/add")
    public String getAddBalloonPage(@RequestParam String color, @RequestParam String description, @RequestParam Long manufacturer) {
        this.balloonService.saveBalloon(color, description, manufacturer);
        return "redirect:/balloons";
    }

    @PostMapping("/add/{id}")
    public String saveBalloon(@PathVariable Long id, @RequestParam String color, @RequestParam String description, @RequestParam Long manufacturer) {
        this.balloonService.deleteBalloon(id);
        this.balloonService.saveBalloon(color, description, manufacturer);
        return "redirect:/balloons";
    }

}
