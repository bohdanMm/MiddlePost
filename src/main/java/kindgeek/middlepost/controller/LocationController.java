package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.LocationRequest;
import kindgeek.middlepost.dto.responce.LocationResponce;
import kindgeek.middlepost.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationResponce> getAll(){
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    public LocationResponce getById(@PathVariable Long id){
        return locationService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody LocationRequest locationRequest){
        locationService.save(locationRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody LocationRequest locationRequest){
        locationService.update(id, locationRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        locationService.delete(id);
    }

}
