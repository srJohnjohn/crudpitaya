package john.lima.crudpitaya.controller;

import john.lima.crudpitaya.exception.ResourceNotFoundException;
import john.lima.crudpitaya.model.Personagem;
import john.lima.crudpitaya.repository.PersonagemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pitaya")
public class PersonagemController {

    @Autowired
    private PersonagemRespository pR;

    @GetMapping("/personagens")
    public List<Personagem> getAllPersonagens(){
        return pR.findAll();
    }

    @GetMapping("/personagens/{id}")
    public ResponseEntity<Personagem> getPersonagemById(@PathVariable(value = "id") Long personagemId) throws ResourceNotFoundException{
        Personagem p = pR.findById(personagemId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return ResponseEntity.ok().body(p);
    }

    @PostMapping("/personagens")
    public Personagem createPersonagem(@Valid @RequestBody Personagem p){
        return pR.save(p);
    }

    @PutMapping("/personagens/{id}")
    public ResponseEntity<Personagem> updatePersonagem(@PathVariable(value = "id") Long personagemId,
                                                       @Valid @RequestBody Personagem personagemDetails) throws ResourceNotFoundException{
        Personagem p = pR.findById(personagemId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        p.setNome(personagemDetails.getNome());
        p.setAltura(personagemDetails.getAltura());
        p.setPeso(personagemDetails.getPeso());
        p.setSexo(personagemDetails.getSexo());
        p.setAnoDeNacimento(personagemDetails.getAnoDeNacimento());

        final Personagem updatePersonagem = pR.save(p);
        return  ResponseEntity.ok(updatePersonagem);
    }

    @DeleteMapping("/personagens/{id}")
    public Map<String, Boolean> deletePersonagem(@PathVariable(value = "id") Long personagemid)
        throws ResourceNotFoundException{
        Personagem p = pR.findById(personagemid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        pR.delete(p);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
