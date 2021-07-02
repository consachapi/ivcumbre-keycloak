package pe.regioncusco.ivcumbre.evento;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends PagingAndSortingRepository<ParticipateEntity, String> {
}
