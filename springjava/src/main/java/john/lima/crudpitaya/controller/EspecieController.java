package john.lima.crudpitaya.controller;

import john.lima.crudpitaya.exception.ResourceNotFoundException;
import john.lima.crudpitaya.model.Especie;
import john.lima.crudpitaya.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pitaya")
public class EspecieController {

    @Autowired
    private EspecieRepository eR;

    @GetMapping("/especies")
    public List<Especie> getAllEspecies(){ return eR.findAll(); }

    @GetMapping("/especies/{id}")
    public ResponseEntity<Especie> getEspecieByID(@PathVariable(value = "id") Long especieId) throws ResourceNotFoundException {
        Especie e = eR.findById(especieId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return ResponseEntity.ok().body(e);
    }

    @PostMapping("/especies")
    public Especie createEspecie(@Valid @RequestBody Especie e){
        return eR.save(e);
    }

    @PutMapping("/especies/{id}")
    public ResponseEntity<Especie> updateEspecie(@PathVariable(value = "id") Long especieId,
                                                 @Valid @RequestBody Especie especieDetails) throws ResourceNotFoundException{
        Especie e = eR.findById(especieId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        e.setNome(especieDetails.getNome());
        e.setLinguagem(especieDetails.getLinguagem());
        e.setDescricao(especieDetails.getDescricao());

        final Especie updateEspecie = eR.save(e);
        return ResponseEntity.ok().body(updateEspecie);
    }

    @DeleteMapping("/especies/{id}")
    public Map<String, Boolean> deleteEspecie(@PathVariable(value = "id") Long especieId) throws ResourceNotFoundException{
        Especie e = eR.findById(especieId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        eR.delete(e);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
    
}
