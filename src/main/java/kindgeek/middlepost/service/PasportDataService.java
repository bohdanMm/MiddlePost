package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.responce.PasportDataResponce;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.entityes.PasportData;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.PasportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasportDataService {

    @Autowired
    PasportDataRepository pasportDataRepository;

    public PasportData getPasportDataEntityById(Long id){
        return pasportDataRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are not locality with id: "+ id));
    }

    public List<PasportDataResponce> getAll(){
        return pasportDataRepository
                .findAll()
                .stream()
                .map(PasportDataResponce::new)
                .collect(Collectors.toList());
    }
}
