import jdk.jshell.execution.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class IOCreateDeleteAPI {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TeamPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        // To check if File exists
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        // To delete the file and also to check if the file doesn't exist.
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath))
            FileUtils.deleteFiles(playPath.toFile());

        Assert.assertTrue(Files.notExists(playPath));

        // Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assert.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            } catch (IOException e) { }
            Assert.assertTrue(Files.exists(tempFile));
        });

        // List Files, Directories as well as Files with extension

        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }
}

