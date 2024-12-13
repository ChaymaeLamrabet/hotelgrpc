package ma.emsi.grpchotel.map;

import ma.emsi.grpchotel.entities.Reservation;
import org.springframework.stereotype.Component;
import ma.emsi.grpchotel.stub.reservation.Reservation.reservationResponse;
import java.time.format.DateTimeFormatter;
@Component
public class ReservationMap {

        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static reservationResponse toResponseDTO(Reservation reservation) {
        return reservationResponse.newBuilder()
                .setId(reservation.getId())
                .setClientId(reservation.getClient().getId())
                .setChambreId(reservation.getChambre().getId())
                .setDateDebut(DATE_FORMATTER.format(reservation.getDatedebut()))
                .setDateFin(DATE_FORMATTER.format(reservation.getDatefin()))
                .setPreferences(reservation.getPreferences())
                .build();
    }


}
