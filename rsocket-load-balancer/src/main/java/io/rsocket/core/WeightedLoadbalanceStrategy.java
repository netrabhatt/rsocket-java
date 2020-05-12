package io.rsocket.core;

// public class WeightedLoadbalanceStrategy implements StatsBasedLoadbalanceStrategy {
//
//  volatile int nextIndex;
//
//  static final AtomicIntegerFieldUpdater<WeightedLoadbalanceStrategy> NEXT_INDEX =
//      AtomicIntegerFieldUpdater.newUpdater(WeightedLoadbalanceStrategy.class, "nextIndex");
//
//  @Override
//  public PooledRSocket select(PooledRSocket[] sockets) {
//    int size = sockets.length;
//    if (size == 1) {
//      return activeSockets.get(0);
//    }
//
//    LoadBalancedRSocketMono.WeightedSocket rsc1 = null;
//    LoadBalancedRSocketMono.WeightedSocket rsc2 = null;
//
//    Random rng = ThreadLocalRandom.current();
//    for (int i = 0; i < EFFORT; i++) {
//      int i1 = rng.nextInt(size);
//      int i2 = rng.nextInt(size - 1);
//      if (i2 >= i1) {
//        i2++;
//      }
//      rsc1 = activeSockets.get(i1);
//      rsc2 = activeSockets.get(i2);
//      if (rsc1.availability() > 0.0 && rsc2.availability() > 0.0) {
//        break;
//      }
//      if (i + 1 == EFFORT && !pool.isPoolEmpty()) {
//        addSockets(1);
//      }
//    }
//
//    double w1 = algorithmicWeight(rsc1);
//    double w2 = algorithmicWeight(rsc2);
//    if (w1 < w2) {
//      return rsc2;
//    } else {
//      return rsc1;
//    }
//  }
//
//  private double algorithmicWeight(LoadBalancedRSocketMono.WeightedSocket socket) {
//    if (socket == null || socket.availability() == 0.0) {
//      return 0.0;
//    }
//
//    int pendings = socket.getPending();
//    double latency = socket.getPredictedLatency();
//
//    double low = lowerQuantile.estimation();
//    double high =
//            Math.max(
//                    higherQuantile.estimation(),
//                    low * 1.001); // ensure higherQuantile > lowerQuantile + .1%
//    double bandWidth = Math.max(high - low, 1);
//
//    if (latency < low) {
//      double alpha = (low - latency) / bandWidth;
//      double bonusFactor = Math.pow(1 + alpha, expFactor);
//      latency /= bonusFactor;
//    } else if (latency > high) {
//      double alpha = (latency - high) / bandWidth;
//      double penaltyFactor = Math.pow(1 + alpha, expFactor);
//      latency *= penaltyFactor;
//    }
//
//    return socket.availability() * 1.0 / (1.0 + latency * (pendings + 1));
//  }
// }
