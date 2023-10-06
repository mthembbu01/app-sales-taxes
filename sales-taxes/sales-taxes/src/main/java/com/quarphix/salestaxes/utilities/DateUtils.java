package com.quarphix.salestaxes.utilities;

import com.quarphix.salestaxes.constants.Constant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_PATTERN);
	private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(Constant.TIME_PATTERN);
	private static final DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern(Constant.DAY_PATTERN);
	/**
	 * 
	 * @return
	 */
	private static LocalDate getDate() { return LocalDate.now(ZoneId.of(Constant.TIME_ZONE_ZA)); }
	
	/**
	 * 
	 * @return
	 */
	private static LocalDateTime getTime() { return LocalDateTime.now(ZoneId.of(Constant.TIME_ZONE_ZA)); }
	/**
	 * 
	 * @return
	 */
	private static String getFormattedDate() { return formatter.format(getDate());}
	/**
	 * 
	 * @return
	 */
	private static String getFormattedTime() { return getTime().format(timeFormatter);}
	/**
	 * 
	 * @return
	 */
	public static LocalDate getCurrentDate() {
		return LocalDate.parse(getFormattedDate(), formatter);
	}
	/**
	 * 
	 * @param dateOfBirth
	 * @return
	 */
	public static LocalDate getLocalDate(String dateOfBirth) {
		String fd =  formatter.format(LocalDate.parse(dateOfBirth));
		return LocalDate.parse(fd, formatter);
	}
	/**
	 * 
	 * @return
	 */
	public static LocalDate getMaxDate() { return LocalDate.parse(Constant.MAX_DATE, formatter); }
	/**
	 * 
	 * @return
	 */
	public static LocalTime getCurrentTime() { return LocalTime.parse(getFormattedTime(), timeFormatter); }
}
