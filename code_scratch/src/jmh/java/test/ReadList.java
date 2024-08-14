package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

// @State(Scope.Thread)
// @BenchmarkMode(Mode.AverageTime)
// @OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ReadList {
	int LOOP_COUNT = 1000;
	List<String> arrayList;
	List<String> linkedList;
	List<String> vector;
	String data = "abcdefghijklmnopqrxyz";
	String result;

	/**
	 * Benchmark                  Mode  Cnt    Score    Error  Units
	 * ReadList.arrayList         avgt   10    1.970 ±  0.008  us/op
	 * ReadList.arrayListForeach  avgt   10    1.680 ±  0.055  us/op
	 * ReadList.linkedList        avgt   10  416.806 ± 41.180  us/op
	 * ReadList.linkedListPeek    avgt   10    9.663 ±  0.868  us/op
	 * ReadList.vector            avgt   10   13.317 ±  0.036  us/op
	 */

	// @Setup(Level.Trial)
	public void setUp() {
		arrayList = new ArrayList<>();
		linkedList = new LinkedList<>();
		vector = new Vector<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			String temp = data + i;
			arrayList.add(temp);
			linkedList.add(temp);
			vector.add(temp);
		}
	}

	// @Benchmark
	public void arrayList() {
		for (int i = 0; i < LOOP_COUNT; i++) {
			result = arrayList.get(i);
		}
	}

	// @Benchmark
	public void vector() {
		for (int i = 0; i < LOOP_COUNT; i++) {
			result = vector.get(i);
		}
	}

	// @Benchmark
	public void linkedList() {
		for (int i = 0; i < LOOP_COUNT; i++) {
			result = linkedList.get(i);
		}
	}

	// @Benchmark
	public void linkedListPeek() {
		for (int i = 0; i < LOOP_COUNT; i++) {
			linkedList.stream().peek(d -> result = d);
		}
	}

	// @Benchmark
	public void arrayListForeach() {
		arrayList.forEach(i -> result = i);
	}
}
