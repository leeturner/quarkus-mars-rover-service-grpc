package com.leeturner

import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni

@GrpcService
class MarsRoverGrpcService : MarsRoverGrpc {

  val rovers = listOf("Spirit", "Opportunity", "Curiosity", "Perseverance", "Sojourner")
  
  override fun rovers(request: MarsRoverRequest): Uni<MarsRoverResponse> {
    return Uni.createFrom().item(MarsRoverResponse.newBuilder().addAllRovers(rovers.mapIndexed { index, rover ->  
      MarsRover.newBuilder().setId(index).setName(rover).build()
    }).build())
  }
}