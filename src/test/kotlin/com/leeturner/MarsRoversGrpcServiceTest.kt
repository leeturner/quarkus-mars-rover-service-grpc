package com.leeturner

import io.quarkus.grpc.GrpcClient
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

@QuarkusTest
class MarsRoversGrpcServiceTest {

  @GrpcClient
  lateinit var marsRoverGrpc: MarsRoverGrpc
  
  @Test
  fun `mars rovers grpc service returns all rovers`() {
    val roversResponse = marsRoverGrpc.rovers(MarsRoverRequest.getDefaultInstance()).await().indefinitely()
    assert(roversResponse.roversList.size == 5)
    assert(roversResponse.roversList[0].id == 0)
    assert(roversResponse.roversList[0].name == "Spirit")
    assert(roversResponse.roversList[1].id == 1)
    assert(roversResponse.roversList[1].name == "Opportunity")
    assert(roversResponse.roversList[2].id == 2)
    assert(roversResponse.roversList[2].name == "Curiosity")
    assert(roversResponse.roversList[3].id == 3)
    assert(roversResponse.roversList[3].name == "Perseverance")
    assert(roversResponse.roversList[4].id == 4)
    assert(roversResponse.roversList[4].name == "Sojourner")
  }
}