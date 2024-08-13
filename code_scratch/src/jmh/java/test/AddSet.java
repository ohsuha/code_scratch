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

// @State(Scope.Thread)
// @BenchmarkMode(Mode.AverageTime)
// @OutputTimeUnit(TimeUnit.MICROSECONDS)
public class AddSet {
	int LOOP_COUNT = 1000;
	Set<String> set;
	String data = "abcdefghijklmnopqrxyz";

	// @Benchmark
	public void addHashSetWithInitialSize() {
		set = new HashSet<>(LOOP_COUNT);
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 Result "test.BestSet.addHashSetWithInitialSize":
		 50.281 ±(99.9%) 2.683 us/op [Average]
		 (min, avg, max) = (48.294, 50.281, 52.109), stdev = 1.775
		 CI (99.9%): [47.597, 52.964] (assumes normal distribution)
		 */
	}

	// @Benchmark
	public void addHashSet() {
		set = new HashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * Result "test.BestSet.addHashSet":
		 *   55.994 ±(99.9%) 1.410 us/op [Average]
		 *   (min, avg, max) = (54.814, 55.994, 57.797), stdev = 0.932
		 *   CI (99.9%): [54.585, 57.404] (assumes normal distribution)
		 */
	}

	// @Benchmark
	public void addTreeSet() {
		set = new TreeSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * Result "test.BestSet.addTreeSet":
		 *   8204.519 ±(99.9%) 150.467 us/op [Average]
		 *   (min, avg, max) = (8113.675, 8204.519, 8403.339), stdev = 99.525
		 *   CI (99.9%): [8054.052, 8354.986] (assumes normal distribution)
		 */
	}

	// @Benchmark
	public void addLinkedHashSet() {
		set = new LinkedHashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
		/**
		 * Result "test.BestSet.addLinkedHashSet":
		 *   60.942 ±(99.9%) 1.763 us/op [Average]
		 *   (min, avg, max) = (59.010, 60.942, 62.298), stdev = 1.166
		 *   CI (99.9%): [59.179, 62.705] (assumes normal distribution)
		 */
	}
}