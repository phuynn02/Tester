package Common;

import java.io.File;

public class Utilities {
    public static String getProjectPath() {
    String projectPath = new File("D:\\download\\Selenium1-main\\Selenium1-main").getAbsolutePath();
    return projectPath;
    }
}
