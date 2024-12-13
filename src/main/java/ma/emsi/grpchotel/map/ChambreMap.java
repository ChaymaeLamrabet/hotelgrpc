package ma.emsi.grpchotel.map;


import ma.emsi.grpchotel.entities.Chambre;
import ma.emsi.grpchotel.entities.TypeChambre;
import org.springframework.stereotype.Component;
import ma.emsi.grpchotel.stub.chambre.Chambre.ChambreResponse;
import ma.emsi.grpchotel.stub.chambre.Chambre.ChambreRequest;


@Component
public class ChambreMap {

    public static ChambreResponse toResponseDTO(Chambre chambre) {
        return ChambreResponse.newBuilder()
                .setId(chambre.getId())
                .setType(chambre.getType().toString())
                .setDisponible(chambre.getDisponible())
                .setPrix(chambre.getPrix())
                .build();
    }

    public static Chambre toEntity(ChambreRequest dto) {
        return Chambre.builder()
                .id(dto.getId())
                .type(TypeChambre.valueOf(dto.getType()))
                .prix(dto.getPrix())
                .disponible(dto.getDisponible())
                .build();
    }
}

