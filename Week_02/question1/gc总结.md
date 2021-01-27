1、堆内存过大过小都会影响JVM性能

a、过小会因对象过多导致内存溢出

b、过大，单次gc时间越长

2、G1的GC频率高，整体吞吐不如Parallel GC，可预估指定matespace初始值，防止matespace扩容引起Full GC

3、根据吞吐优先或者响应时间优先来定制不同的JVM调优策略

