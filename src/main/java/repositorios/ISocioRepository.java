package repositorios;
import modelos.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocioRepository extends JpaRepository<Socio, Integer> {}


