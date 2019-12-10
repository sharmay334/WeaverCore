package com.stpl.pms.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.EmailValidator;

public class UserValidation {

	private static final Logger logger = Logger.getLogger(UserValidation.class);

	/**
	 * checks if a string is empty
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return (value == null || value.length() == 0);
	}

	/**
	 * checks if a date is empty
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Date value) {
		return (value == null);
	}

	/**
	 * checks if a date is empty
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Double value) {
		return (value == null);
	}

	/**
	 * checks if a date is empty
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Long value) {
		return (value == null);
	}

	/**
	 * checks if the value is a integer
	 * 
	 * @param value
	 * @return
	 * @throws ValidationException
	 */
	public static boolean isInteger(String checkStr) {
		try {
			Integer.parseInt(checkStr);
			return true; // Did not throw, must be a number
		} catch (NumberFormatException err) {
			return false; // Threw, So is not a number
		}
	}

	/**
	 * checks if the value is a integer
	 * 
	 * @param value
	 * @return
	 * @throws ValidationException
	 */
	public static boolean isDouble(Double checkStr) {
		return (!Double.isNaN(checkStr));
	}

	public static boolean isDouble(String checkStr, boolean isSpace) {
		return Pattern.matches("[0-9]+(\\.[0-9])?$", checkStr);
	}

	/**
	 * validates a email
	 * 
	 * @param email
	 * @return boolean
	 */

	/*
	 * public static boolean validateEmail(String email) {
	 * 
	 * // EmailValidator em = new EmailValidator(); // String emailpattern =
	 * em.emailAddressPattern; return
	 * Pattern.matches("^[A-Za-z0-9._%+\\-]+@[A-Za-zs.\\-]+\\.[a-zA-Z]{2,4}$",
	 * email); // .+@.+\\.[a-z]+ // return email.matches(emailpattern); }
	 */

	public static boolean validateEmail(String email) {
		String emailpattern = EmailValidator.EMAIL_ADDRESS_PATTERN;
		return email.matches(emailpattern);
	}

	/**
	 * validates a date
	 * 
	 * @param date
	 * @return
	 */
	public static boolean validateDate(String date) {
		try {

			String format = "MM/dd/yyyy";
			String strDate = date.toString();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			sdf.parse(strDate);
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

		return true;
	}

	/**
	 * selected date is before current date
	 * 
	 * @param arg
	 */
	public static boolean beforeCurrentDate(Date date) {

		return date.before(new Date());
	}

	/**
	 * selected date is after current date
	 * 
	 * @param arg
	 */
	public static boolean afterCurrentDate(Date date) {

		return date.after(new Date());
	}

	/**
	 * Calculates the number of days between two calendar days in a manner which
	 * is independent of the Calendar type used.
	 * 
	 * @param d1
	 *            The first date.
	 * @param d2
	 *            The second date.
	 * 
	 * @return The number of days between the two dates. Zero is returned if the
	 *         dates are the same, one if the dates are adjacent, etc. The order
	 *         of the dates does not matter, the value returned is always >= 0.
	 *         If Calendar types of d1 and d2 are different, the result may not
	 *         be accurate.
	 */
	static int getDaysBetween(Date date) {
		GregorianCalendar d1 = new GregorianCalendar();
		d1.setTime(date);

		GregorianCalendar d2 = new GregorianCalendar();
		d2.setTime(new Date());

		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			GregorianCalendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(GregorianCalendar.DAY_OF_YEAR)
				- d1.get(GregorianCalendar.DAY_OF_YEAR);
		int y2 = d2.get(GregorianCalendar.YEAR);
		if (d1.get(GregorianCalendar.YEAR) != y2) {
			d1 = (GregorianCalendar) d1.clone();
			do {
				days += d1.getActualMaximum(GregorianCalendar.DAY_OF_YEAR);
				d1.add(GregorianCalendar.YEAR, 1);
			} while (d1.get(GregorianCalendar.YEAR) != y2);
		}
		return days;
	} // getDaysBetween()

	/**
	 * check if age is above 16 years
	 * 
	 * @param arg
	 */
	public static boolean validateAge(Date date) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int userday = cal.get(Calendar.DAY_OF_MONTH);
		int usermonth = cal.get(Calendar.MONTH) + 1;
		int useryear = cal.get(Calendar.YEAR);

		GregorianCalendar cal1 = new GregorianCalendar();
		cal1.setTime(new Date());
		int currentday = cal1.get(Calendar.DAY_OF_MONTH);
		int currentmonth = cal1.get(Calendar.MONTH) + 1;
		int currentyear = cal1.get(Calendar.YEAR);

		if (currentyear - useryear < 16) {
			return false;
		}
		if (currentyear - useryear > 16) {
			return true;
		}
		if (currentyear - useryear == 16) {

			if (currentmonth > usermonth) {
				return true;
			}
			if (currentmonth < usermonth) {
				return false;
			}
			if (currentmonth == usermonth) {

				if (currentday > userday) {
					return true;
				}
				if (currentday < userday) {
					return false;
				}
				if (currentday == userday) {
					return false;
				}

			}

		}
		return true;

	}

	/**
	 * checks whether the string passed is alphabetic with spaces
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphabetic(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[a-zA-Z ]+", value);
		} else {
			return Pattern.matches("[a-zA-Z]+", value);
		}

	}

	/**
	 * checks whether the string passed is alpahanumeric with spaces
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphanumeric(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[0-9A-Za-z ]+", value);
		} else {
			return Pattern.matches("[0-9A-Za-z]+", value);
		}

	}

	public static boolean isAlphanumericComma(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[0-9A-Za-z, ]+", value);
		} else {
			return Pattern.matches("[0-9A-Za-z,]+", value);
		}

	}
	public static boolean isAlphanumericCommaFullStop(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[0-9A-Za-z,. ]+", value);
		} else {
			return Pattern.matches("[0-9A-Za-z,.]+", value);
		}

	}

	public static boolean isAlphanumericPostal(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[A-Za-z0-9 ]*[0-9]+[A-Za-z0-9 ]*", value);
		} else {
			return Pattern.matches("[A-Za-z0-9]*[0-9]+[A-Za-z0-9]*", value);
		}

	}

	/* returns true when from date is after the to date */
	public static boolean compareDates(String fromDate, String toDate) {

		Date fromDate1 = null;
		Date toDate1 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			fromDate1 = (Date) formatter.parse(fromDate);
			logger.info(fromDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			toDate1 = (Date) formatter.parse(toDate);
			logger.info(toDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (fromDate1.compareTo(toDate1) > 0)
			return true;
		else if (fromDate1.compareTo(toDate1) < 0)
			return false;
		return false;
	}

	/**
	 * checks whether the string passed is alpahanumeric with spaces
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[0-9 ]+", value);
		} else {
			return Pattern.matches("[0-9]+", value);
		}

	}

	public static boolean isNumericNew(String value) {

		return Pattern.matches("[-0-9]+", value);

	}

	public static boolean isValidMoney(String value, boolean spaces) {

		return Pattern
				.matches(
						"\\b(([0-9]{4})|([0-9]{3})|([0-9]{2})|([0-9]{1})$)*\\.(([0-9]{2})|([0-9]{1})$)",
						value);

		// return Pattern.matches("[1-9]+[0-9]*[.]?[0-9]",value);
	}

	public static boolean isValidCity(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[0-9A-Za-z.\\- ]+", value);
		} else {
			return Pattern.matches("[0-9A-Za-z.\\-]+", value);
		}
	}

	public static Date convertString2Date(String datestring) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = sdf.parse(datestring);
		} catch (java.text.ParseException pe) {
			pe.printStackTrace();
		}
		return date;
	}

	public static String convertDate2String(Date date) {

		String datestring = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		datestring = sdf.format(date);

		return datestring;
	}

	public static boolean isNumberNumeric(String value) {

		return Pattern.matches("[0-9]+", value);

	}

	public static boolean isUserName(String value) {
		return Pattern.matches("[A-Za-z]+[A-Za-z0-9._]*", value);
		// return true;
	}

	public static boolean isAlphabeticWithMinus(String value, boolean spaces) {

		if (spaces) {
			return Pattern.matches("[-a-zA-Z ]+", value);
		} else {
			return Pattern.matches("[-a-zA-Z]+", value);
		}
	}

	public static String fetchFileExtension(String fileName) {
		String extension[] = fileName.split("\\.");
		int length = extension.length;
		String ext = extension[length - 1];
		return ext;
	}

	public static boolean isValidURL(String value) {
		return Pattern.matches("[a-zA-Z0-9._/:?-]*", value);
	}

}
