package john.lima.crudpitaya.repository;

import john.lima.crudpitaya.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveRepository extends JpaRepository<Nave, Long> {
}
