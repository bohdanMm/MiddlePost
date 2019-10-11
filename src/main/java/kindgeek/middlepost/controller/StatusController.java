package kindgeek.middlepost.controller;

import kindgeek.middlepost.service.StatusService;
import kindgeek.middlepost.dto.responce.StatusResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @RequestMapping
    public List<StatusResponce> getStatuses(){
        return statusService.getAllAdresses();
    }

    @RequestMapping("/save")
    public void insertStatuses(){
        statusService.save();
    }



}
