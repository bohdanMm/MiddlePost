package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.LocationRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
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
    public DataResponce<LocationResponce> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return locationService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public LocationResponce getById(@PathVariable Long id){
        return locationService.getById(id);
    }

    @PostMapping
    public LocationResponce save(@RequestBody LocationRequest locationRequest){
        return locationService.save(locationRequest);
    }

    @PutMapping("/{id}")
    public LocationResponce update(@PathVariable Long id, @RequestBody LocationRequest locationRequest){
        return locationService.update(id, locationRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return locationService.delete(id);
    }

}
