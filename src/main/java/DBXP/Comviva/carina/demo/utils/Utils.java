package DBXP.Comviva.carina.demo.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Utils {

    private Utils() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Extract only numeric data from the text available Eg Text is : Rs. 520.30 it will return 520.30
     *
     * @param texts
     * @return
     */
    public static String extractOnlyAmountFromText(String texts) {
        return texts.replaceAll("[^0-9\\.]", "");
    }

    public static String uuidString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getRandomString(int characterLength) {
        return RandomStringUtils.randomAlphabetic(characterLength);
    }

    public static String getRandomNumber(int characterLength) {
        return RandomStringUtils.randomNumeric(characterLength);
    }

    public static long differenceInMinutesFromNow(@Nonnull String time, String format) {
        LocalTime now = LocalTime.now();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("h:mm a");
        try {
            LocalTime parsedTime = LocalTime.parse(sd.format(sd.parse(time.trim())), df);
            long diff = Math.abs(Duration.between(now, parsedTime).toMinutes());
            LOGGER.info(String.format("The Time Difference from now is %d mins", diff));
            return diff;
        } catch (ParseException e) {
            LOGGER.info(e.getMessage());
        }
        return 0;
    }

    public static String convertDateString(String date, String fromFormat, String toFormat) {
        try {
            Date parseDate = new SimpleDateFormat(fromFormat).parse(date);
            String output = new SimpleDateFormat(toFormat).format(parseDate);
            LOGGER.info(String.format("Successfully converted the %s to %s format", date, output));
            return output;
        } catch (ParseException e) {
            LOGGER.info(e.getMessage());
            return e.getMessage();
        }
    }

    public static boolean isTomorrow(int date) {
        return LocalDate.now().plusDays(1).getDayOfMonth() == date;
    }

    public static Date getDateInDateFormat(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if (date.equalsIgnoreCase("Today")) {
            try {
                LOGGER.info(String.format("Successfully converted the %s to %s format", date, format));
                return formatter.parse(formatter.format(new Date()));
            } catch (ParseException e) {
                e.getMessage();
            }
        } else {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return null;
    }

    public static long getDifferenceInDays(@Nonnull Date date1, Date date2, String format) {

        long diffInMillies = Math.abs(date1.getTime() - date2.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;

    }

}
