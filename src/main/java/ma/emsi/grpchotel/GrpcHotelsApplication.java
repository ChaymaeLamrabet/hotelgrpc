package ma.emsi.grpchotel;

import lombok.RequiredArgsConstructor;
import ma.emsi.grpchotel.services.ChambreService;
import ma.emsi.grpchotel.services.ClientService;
import ma.emsi.grpchotel.services.ReservationService;
import ma.emsi.grpchotel.stub.chambre.Chambre;
import ma.emsi.grpchotel.stub.client.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.emsi.grpchotel.stub.reservation.Reservation.reservationRequest;

@SpringBootApplication
@RequiredArgsConstructor
public class GrpcHotelsApplication {
	private final ClientService clientService;
	private final ChambreService chambreService;
	private final ReservationService reservationService;


	public static void main(String[] args) {
		SpringApplication.run(GrpcHotelsApplication.class, args);
	}
	@Bean
	public CommandLineRunner run() {
		return args -> {

			for (int i = 1; i <= 5; i++) {
				clientService.save(Client.clientRequest.newBuilder().setNom("NomClient" + i).setEmail("client" + i + "@gmail.com").setTel("0612345678").build());
			}

			for (int i = 1; i <= 5; i++) {
				chambreService.save( Chambre.ChambreRequest.newBuilder().setId(i).setPrix(200).setType("DOUBLE").setDisponible(true).build());
			}
			for (int i = 1; i <= 5; i++) {
				chambreService.save( Chambre.ChambreRequest.newBuilder().setId(i).setPrix(100).setType("SIMPLE").setDisponible(true).build());
			}

			for (int i = 1; i <= 3; i++) {
				reservationService.save(reservationRequest.newBuilder().setChambreId(i).setClientId(i).setDateDebut("2024-12-01").setDateFin("2024-12-05").setPreferences("TEXT").build());
			}

		};
	}
}
