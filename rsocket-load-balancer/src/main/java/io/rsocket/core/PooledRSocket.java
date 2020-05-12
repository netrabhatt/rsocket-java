package io.rsocket.core;

import io.rsocket.RSocket;

public interface PooledRSocket extends RSocket {

  Stats stats();

  LoadbalanceTarget supplier();

  boolean markForRemoval();

  boolean markActive();
}
