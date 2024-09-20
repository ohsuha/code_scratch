package streamtest;

import java.io.*;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.ToString;

public class StreamEx1 {
	@Test
	public void test1() {
		Student[] students = {
			new Student("이자바", 3, 300),
			new Student("김자바", 1, 200),
			new Student("박자바", 2, 200),
			new Student("최자바", 2, 100),
			new Student("황자바", 1, 290),
			new Student("소자바", 3, 200),
			new Student("나자바", 3, 180)
		};

		Stream<Student> studentStream = Stream.of(students);

		studentStream.sorted(Comparator.comparing(Student::getBan))
			.forEach(System.out::println);

		Stream<Student> studentStream2 = Stream.of(students);
		IntStream stuScoreStream = studentStream2.mapToInt(Student::getTotalScore);

		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count : "+stat.getCount());
		System.out.println("average : "+stat.getAverage());
		System.out.println("min : "+stat.getMin());
		System.out.println("max : "+stat.getMax());
		System.out.println("sum : "+stat.getSum());
	}

	@Getter
	@ToString
	class Student implements Comparable<Student> {
		String name;
		int ban;
		int totalScore;

		public Student(String name, int ban, int totalScore) {
			this.name = name;
			this.ban = ban;
			this.totalScore = totalScore;
		}

		@Override
		public int compareTo(Student o) {
			return o.totalScore - this.totalScore;
		}
	}

	@Test
	public void test2() {
		File[] files = {new File("Ex1.java"),
			new File("Ex2.java"),
			new File("Ex3.java"),
			new File("Ex1"),
			new File("Ex1.txt"),
			new File("Ex1.bak")
		};

		Stream<File> fileStream = Stream.of(files);

		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);

		fileStream = Stream.of(files);

		fileStream.map(File::getName)
			.filter(s -> s.indexOf('.')!=-1)
			.map(s -> s.substring(s.lastIndexOf('.')+1))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);

		System.out.println();
	}

	@Test
	public void test3() {

	}
}
