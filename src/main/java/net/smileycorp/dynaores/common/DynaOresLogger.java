package net.smileycorp.dynaores.common;

import com.google.common.collect.Lists;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DynaOresLogger {
    
    private static Path log_file = Paths.get("logs/dynaores.log");
    
    public static void clearLog() {
        try {
            Files.write(log_file, Lists.newArrayList(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void logInfo(Object message) {
        writeToFile(message);
    }
    
    public static void logError(Object message, Exception e) {
        writeToFile(message + " " + e);
        for (StackTraceElement traceElement : e.getStackTrace()) writeToFile(traceElement);
        e.printStackTrace();
    }
    
    public static boolean writeToFile(Object message) {
        return writeToFile(Lists.newArrayList(String.valueOf(message)));
    }
    
    private static boolean writeToFile(List<String> out) {
        try {
            Files.write(log_file, out, StandardCharsets.UTF_8, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
