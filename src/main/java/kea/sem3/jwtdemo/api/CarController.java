package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/cars")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getCars(){
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public CarResponse getCars(@PathVariable int id) throws Exception {
        return carService.getCar(id, false);
    }

    @PostMapping
    public CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    @PutMapping("/{id}")
    public CarResponse editCar(@RequestBody CarRequest body, @PathVariable int id){
        return carService.editCar(body, id);
    }

    @PatchMapping("/{id}/{newprice}")
    public void getPrice(@PathVariable int id, @PathVariable double newprice) throws Exception {
        carService.updatePrice(id, newprice);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id){
        carService.deleteCar(id);
    }

}

