package john.lima.crudpitaya.repository;

import john.lima.crudpitaya.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRespository extends JpaRepository<Personagem, Long> {
}
