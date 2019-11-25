package john.lima.crudpitaya.controller;

import john.lima.crudpitaya.exception.ResourceNotFoundException;
import john.lima.crudpitaya.model.Nave;
import john.lima.crudpitaya.repository.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pitaya")
public class NaveController {

    @Autowired
    private NaveRepository nR;

//    @GetMapping("/naves")
//    public List<Nave> getAllNaves{
//        return nR.findAll();
//    }

    @GetMapping("/naves/{id}")
    public ResponseEntity<Nave> getNaveById(@PathVariable(value = "id")Long naveId) throws ResourceNotFoundException{
        Nave n = nR.findById(naveId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found "));
        return ResponseEntity.ok().body(n);
    }

    @PostMapping("/naves")
    public Nave createNave(@Valid @RequestBody Nave n){
        return nR.save(n);
    }

    @PutMapping("/naves/{id}")
    public ResponseEntity<Nave> updateNave(@PathVariable(value = "id") Long naveId,
                                           @Valid @RequestBody Nave naveDetails) throws ResourceNotFoundException{
        Nave n = nR.findById(naveId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found "));
        n.setNome(naveDetails.getNome());
        n.setModelo(naveDetails.getModelo());
        n.setClasseNave(naveDetails.getClasseNave());
        n.setFabricante(naveDetails.getFabricante());
        n.setTamanho(naveDetails.getTamanho());
        n.setCapacidadedeCarga(naveDetails.getCapacidadedeCarga());
        n.setVelocidadeMaxima(naveDetails.getVelocidadeMaxima());
        final Nave updateNave = nR.save(n);
        return ResponseEntity.ok(updateNave);
    }

    @DeleteMapping("/pitaya/{id}")
    public Map<String, Boolean> deleteNave(@PathVariable(value = "id") Long naveId)
            throws ResourceNotFoundException{
        Nave n = nR.findById(naveId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        nR.delete(n);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
