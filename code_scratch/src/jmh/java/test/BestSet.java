package test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BestSet {
	int LOOP_COUNT = 1000;
	Set<String> set;
	String data = "abcdefghijklmnopqrxyz";

	// @Setup // 성능 측정 전 사전에 필요한 작업

	@Benchmark
	public void addHashSet() {
		set = new HashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * # Benchmark: test.BestSet.addHashSet
		 *
		 * # Run progress: 0.00% complete, ETA 00:10:00
		 * # Fork: 1 of 2
		 * # Warmup Iteration   1: 57.097 us/op
		 * # Warmup Iteration   2: 55.906 us/op
		 * # Warmup Iteration   3: 55.705 us/op
		 * # Warmup Iteration   4: 55.712 us/op
		 * # Warmup Iteration   5: 55.620 us/op
		 * Iteration   1: 56.419 us/op
		 * Iteration   2: 57.229 us/op
		 * Iteration   3: 57.797 us/op
		 * Iteration   4: 55.887 us/op
		 * Iteration   5: 56.088 us/op
		 *
		 * # Run progress: 16.67% complete, ETA 00:08:48
		 * # Fork: 2 of 2
		 * # Warmup Iteration   1: 56.573 us/op
		 * # Warmup Iteration   2: 55.292 us/op
		 * # Warmup Iteration   3: 55.945 us/op
		 * # Warmup Iteration   4: 55.272 us/op
		 * # Warmup Iteration   5: 55.358 us/op
		 * Iteration   1: 55.331 us/op
		 * Iteration   2: 55.780 us/op
		 * Iteration   3: 54.814 us/op
		 * Iteration   4: 55.275 us/op
		 * Iteration   5: 55.323 us/op
		 *
		 *
		 * Result "test.BestSet.addHashSet":
		 *   55.994 ±(99.9%) 1.410 us/op [Average]
		 *   (min, avg, max) = (54.814, 55.994, 57.797), stdev = 0.932
		 *   CI (99.9%): [54.585, 57.404] (assumes normal distribution)
		 */
	}

	@Benchmark
	public void addTreeSet() {
		set= new TreeSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * # Benchmark: test.BestSet.addTreeSet
		 *
		 * # Run progress: 66.67% complete, ETA 00:03:31
		 * # Fork: 1 of 2
		 * # Warmup Iteration   1: 8325.357 us/op
		 * # Warmup Iteration   2: 8253.015 us/op
		 * # Warmup Iteration   3: 8235.599 us/op
		 * # Warmup Iteration   4: 8233.013 us/op
		 * # Warmup Iteration   5: 8233.532 us/op
		 * Iteration   1: 8231.959 us/op
		 * Iteration   2: 8256.440 us/op
		 * Iteration   3: 8333.887 us/op
		 * Iteration   4: 8142.178 us/op
		 * Iteration   5: 8113.675 us/op
		 *
		 * # Run progress: 83.33% complete, ETA 00:01:45
		 * # Fork: 2 of 2
		 * # Warmup Iteration   1: 8200.419 us/op
		 * # Warmup Iteration   2: 8124.623 us/op
		 * # Warmup Iteration   3: 8116.421 us/op
		 * # Warmup Iteration   4: 8142.395 us/op
		 * # Warmup Iteration   5: 8171.578 us/op
		 * Iteration   1: 8116.784 us/op
		 * Iteration   2: 8141.650 us/op
		 * Iteration   3: 8403.339 us/op
		 * Iteration   4: 8164.048 us/op
		 * Iteration   5: 8141.231 us/op
		 *
		 *
		 * Result "test.BestSet.addTreeSet":
		 *   8204.519 ±(99.9%) 150.467 us/op [Average]
		 *   (min, avg, max) = (8113.675, 8204.519, 8403.339), stdev = 99.525
		 *   CI (99.9%): [8054.052, 8354.986] (assumes normal distribution)
		 */
	}

	@Benchmark
	public void addLinkedHashSet() {
		set= new LinkedHashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * # Benchmark: test.BestSet.addLinkedHashSet
		 *
		 * # Run progress: 33.33% complete, ETA 00:07:02
		 * # Fork: 1 of 2
		 * # Warmup Iteration   1: 62.733 us/op
		 * # Warmup Iteration   2: 62.033 us/op
		 * # Warmup Iteration   3: 62.790 us/op
		 * # Warmup Iteration   4: 64.385 us/op
		 * # Warmup Iteration   5: 61.946 us/op
		 * Iteration   1: 61.669 us/op
		 * Iteration   2: 61.570 us/op
		 * Iteration   3: 60.809 us/op
		 * Iteration   4: 61.651 us/op
		 * Iteration   5: 61.858 us/op
		 *
		 * # Run progress: 50.00% complete, ETA 00:05:16
		 * # Fork: 2 of 2
		 * # Warmup Iteration   1: 60.607 us/op
		 * # Warmup Iteration   2: 59.378 us/op
		 * # Warmup Iteration   3: 59.534 us/op
		 * # Warmup Iteration   4: 59.315 us/op
		 * # Warmup Iteration   5: 59.354 us/op
		 * Iteration   1: 59.656 us/op
		 * Iteration   2: 61.508 us/op
		 * Iteration   3: 59.010 us/op
		 * Iteration   4: 59.390 us/op
		 * Iteration   5: 62.298 us/op
		 *
		 *
		 * Result "test.BestSet.addLinkedHashSet":
		 *   60.942 ±(99.9%) 1.763 us/op [Average]
		 *   (min, avg, max) = (59.010, 60.942, 62.298), stdev = 1.166
		 *   CI (99.9%): [59.179, 62.705] (assumes normal distribution)
		 */
	}
}