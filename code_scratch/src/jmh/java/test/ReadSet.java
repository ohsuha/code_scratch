package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
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
public class ReadSet {
	int READ_COUNT = 1000;
	String data = "abcdefghijklmnopqrxyz";
	Set<String> hashSet;
	Set<String> treeSet;
	Set<String> linkedHashSet;
	String result = null;

	/**
	 ReadSet.iterateHashSet            avgt   10   7.070 ± 0.015  us/op
	 ReadSet.iterateLinkedHashSet      avgt   10   3.538 ± 0.095  us/op
	 ReadSet.iterateTreeSet            avgt   10   7.270 ± 0.628  us/op
	 */

	// @Setup(Level.Trial)
	public void SetUp() {
		hashSet = new HashSet<>();
		treeSet = new TreeSet<>();
		linkedHashSet = new LinkedHashSet<>();
		for (int i = 0; i < READ_COUNT; i++) {
			String tempData = data + i;
			hashSet.add(tempData);
			treeSet.add(tempData);
			linkedHashSet.add(tempData);
		}
	}

	// @Benchmark
	public void iterateHashSet() {
		Iterator<String> iter = hashSet.iterator();
		while (iter.hasNext()){
			result = iter.next();
		}
	}

	// @Benchmark
	public void iterateTreeSet() {
		Iterator<String> iter = treeSet.iterator();
		while (iter.hasNext()){
			result = iter.next();
		}
	}

	// @Benchmark
	public void iterateLinkedHashSet() {
		Iterator<String> iter = linkedHashSet.iterator();
		while (iter.hasNext()){
			result = iter.next();
		}
	}
}
