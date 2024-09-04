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

	/**
	 * Benchmark                         Mode  Cnt     Score     Error  Units
	 * AddSet.addHashSet                 avgt   10    55.701 ±   1.981  us/op
	 * AddSet.addHashSetWithInitialSize  avgt   10    51.183 ±   1.629  us/op
	 * AddSet.addLinkedHashSet           avgt   10    60.475 ±   4.723  us/op
	 * AddSet.addTreeSet                 avgt   10  8279.264 ± 323.274  us/op
	 */
	// @Benchmark
	public void addHashSetWithInitialSize() {
		set = new HashSet<>(LOOP_COUNT);
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
	}

	// @Benchmark
	public void addHashSet() {
		set = new HashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
	}

	// @Benchmark
	public void addTreeSet() {
		set = new TreeSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
	}

	// @Benchmark
	public void addLinkedHashSet() {
		set = new LinkedHashSet<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			set.add(data + i);
		}
	}
}