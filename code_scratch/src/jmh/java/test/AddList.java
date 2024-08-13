package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
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
public class AddList {
	int LOOP_COUNT = 1000;
	List<String> list;
	String data = "abcdefghijklmnopqrxyz";

	/**
	 AddList.addArrayList                 avgt   10  15.185 ± 0.058  us/op
	 AddList.addArrayListWithInitialSize  avgt   10  14.977 ± 0.456  us/op
	 AddList.addLinkedList                avgt   10  15.091 ± 0.305  us/op
	 AddList.addVector                    avgt   10  23.087 ± 1.036  us/op
	 AddList.addVectorWithInitialSize     avgt   10  30.402 ± 1.377  us/op
	 */

	@Benchmark
	public void addArrayListWithInitialSize() {
		list = new ArrayList<>(LOOP_COUNT);
		for (int i = 0; i < LOOP_COUNT; i++) {
			list.add(data + i);
		}
	}

	@Benchmark
	public void addArrayList() {
		list = new ArrayList<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			list.add(data + i);
		}
	}

	@Benchmark
	public void addLinkedList() {
		list = new LinkedList<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			list.add(data + i);
		}
	}

	@Benchmark
	public void addVectorWithInitialSize() {
		list = new Vector<>(LOOP_COUNT);
		for (int i = 0; i < LOOP_COUNT; i++) {
			list.add(data + i);
		}
	}

	@Benchmark
	public void addVector() {
		list = new Vector<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			list.add(data + i);
		}
	}

}
