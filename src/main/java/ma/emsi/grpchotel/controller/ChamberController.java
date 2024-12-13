package ma.emsi.grpchotel.controller;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import ma.emsi.grpchotel.services.ChambreService;
import ma.emsi.grpchotel.stub.chambre.Chambre;
import ma.emsi.grpchotel.stub.chambre.ChambreServiceGrpc;
import ma.emsi.grpchotel.stub.chambre.Chambre.ChambreResponse;

import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@RequiredArgsConstructor
@GrpcService
public class ChamberController extends ChambreServiceGrpc.ChambreServiceImplBase {
    private final ChambreService service;

    @Override
    public void findAll(Chambre.FindByRequest request, StreamObserver<Chambre.FindAllResponse> responseObserver) {
        List<ChambreResponse>res=service.findAll();
        Chambre.FindAllResponse list = Chambre.FindAllResponse.newBuilder().addAllChambres(res).build();
        responseObserver.onNext(list);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(Chambre.FindByIdRequest request, StreamObserver<Chambre.ChambreResponse> responseObserver) {
        ChambreResponse response=service.findById(request.getId()).orElseThrow(()->new RuntimeException("Chambre not found"));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delete(Chambre.FindByIdRequest request, StreamObserver<Chambre.ChambreResponse> responseObserver) {
        ChambreResponse response=service.delete(request.getId()).orElseThrow(()->new RuntimeException("Chambre not found"));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(Chambre.ChambreRequest request, StreamObserver<Chambre.ChambreResponse> responseObserver) {
       ChambreResponse response=service.update(request, request.getId()).orElseThrow(()->new RuntimeException("Chambre not found"));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void create(Chambre.ChambreRequest request, StreamObserver<Chambre.ChambreResponse> responseObserver) {
        ChambreResponse response=service.save(request).orElseThrow(()->new RuntimeException("Chambre not found"));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
