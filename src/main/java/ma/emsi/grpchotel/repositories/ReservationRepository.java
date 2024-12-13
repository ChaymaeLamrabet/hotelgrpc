package ma.emsi.grpchotel.repositories;

import ma.emsi.grpchotel.entities.Chambre;
import ma.emsi.grpchotel.entities.Client;
import ma.emsi.grpchotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByChambre(Chambre chambre);
    List<Reservation> findByClient(Client chambre);

}
