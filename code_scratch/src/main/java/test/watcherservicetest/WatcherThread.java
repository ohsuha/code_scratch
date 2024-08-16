package test.watcherservicetest;

import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatcherThread extends Thread {
    Path dirPath;

    public WatcherThread(Path dirPath) {
        this.dirPath = dirPath;
    }

    @Override
    public void run() {
        System.out.println("Watcher is started");
        fileWatcher();
        System.out.println("Watcher is ended");
    }

    public void fileWatcher() {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dirPath.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            while (true) { // 무한 루프를 사용하여 지속적인 감시
                WatchKey key = watcher.take();
                String watchedTime = new Date().toString();
                List<WatchEvent<?>> eventList = key.pollEvents();

                for (WatchEvent<?> event : eventList) {
                    Path name = (Path) event.context();
                    if (event.kind() == ENTRY_CREATE) {
                        System.out.format("%s created at %s%n", name, watchedTime);
                    } else if (event.kind() == ENTRY_DELETE) {
                        System.out.format("%s deleted at %s%n", name, watchedTime);
                    } else if (event.kind() == ENTRY_MODIFY) {
                        System.out.format("%s modified at %s%n", name, watchedTime);
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    System.out.println("WatchKey has been unregistered");
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
