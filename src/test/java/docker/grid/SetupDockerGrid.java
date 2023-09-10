package docker.grid;

import org.testng.annotations.Test;

import java.io.IOException;
// TO DO :- workaround to automate execute .sh
public class SetupDockerGrid {
    @Test(priority = 1)
    void start() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start /selenium-java/start_docker.sh");
        String[] command = { "sh", "/selenium-java/start_docker.sh" };
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.start();
//        Thread.sleep(15000);
    }

    @Test(priority = 2)
    void stop() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start /selenium-java/stop_docker.sh");
        String[] command = { "sh", "/selenium-java/start_docker.sh" };
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.start();
//        Thread.sleep(5000);
//        Runtime.getRuntime().exec("taskkill /f /m /cmd.exe");
    }
}
