package helpers;

import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

import static helpers.ConsoleColors.*;

public class ColorPrinter {
    public static void printMessageInYellow(String message) {
        System.out.println(BLUE_BACKGROUND + YELLOW_BRIGHT + message + RESET);
    }

    public static void printMessageInYellow(String message, Logger logger) {
        logger.info(YELLOW_BRIGHT + message + RESET);
    }

    public static void printColorMessage(String message, Logger logger, Level level) {
        switch (level) {
            case INFO:
                logger.info(GREEN + message + RESET);
                break;
            case DEBUG:
                logger.info(BLUE + message + RESET);
                break;
            case ERROR:
                logger.info(RED + message + RESET);
                break;
        }
    }
}
