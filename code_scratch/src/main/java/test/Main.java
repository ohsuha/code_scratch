package test;

import test.synchronizedtest.Contribute;
import test.synchronizedtest.statictest.ContributeStatic;
import test.watcherservicetest.WatcherThread;

import java.io.FileReader;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path filePath;
			filePath = Paths.get("/Users/suha/Documents/study/code_scratch/code_scratch/src/main/resources");

		WatcherThread watcherThread = new WatcherThread(filePath);
		watcherThread.start();
	}
}
