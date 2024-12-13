package ma.emsi.grpchotel.map;


import ma.emsi.grpchotel.entities.Client;
import org.springframework.stereotype.Component;
import ma.emsi.grpchotel.stub.client.Client.clientRequest;
import ma.emsi.grpchotel.stub.client.Client.clientResponse;

@Component
public class ClientMap {

    public static clientResponse toResponseDTO(Client client) {
        return clientResponse.newBuilder()
                .setId(client.getId())
                .setNom(client.getNom())
                .setEmail(client.getEmail())
                .setTel(client.getTel())
                .build();
    }

    public static Client toEntity(clientRequest dto) {
        return Client.builder()
                .nom(dto.getNom())
                .email(dto.getEmail())
                .tel(dto.getTel())
                .build();
    }
}
