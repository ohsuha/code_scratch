package test;

import java.nio.file.Path;
import java.nio.file.Paths;

import test.watcherservicetest.WatcherThread;

public class Main {
	public static void main(String[] args) {
		Path filePath;
			filePath = Paths.get("/Users/suha/Documents/study/code_scratch/code_scratch/src/main/resources");

		WatcherThread watcherThread = new WatcherThread(filePath);
		watcherThread.start();
	}
}
