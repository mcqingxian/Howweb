package com.hoau.how.module.common.shared.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

	public static String formatDate(Date date, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		return sdf.format(date);
	}

	public static Date getDateFromString(String value) throws ParseException {
		return getDateFromString(value, Locale.getDefault());
	}

	public static Date getDateFromString(String value, String formatPattern)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		return sdf.parse(value);
	}

	public static Date getDateFromString(String value, Locale locale)
			throws ParseException {
		Date result = null;
		DateFormat[] dfs = getDateFormats(locale);

		DateFormat df = null;
		for (DateFormat df1 : dfs) {
			try {
				result = df1.parse(value);
				df = df1;
				if (result != null) {
					break;
				}
			} catch (ParseException ignore) {
			}
		}
		if (df == null) {
			df = DateFormat.getDateInstance(3, locale);
		}
		df.setLenient(false);
		result = df.parse(value);
		return result;
	}

	private static DateFormat[] getDateFormats(Locale locale) {
		DateFormat dt1 = DateFormat.getDateTimeInstance(3, 1, locale);

		DateFormat dt2 = DateFormat.getDateTimeInstance(3, 2, locale);

		DateFormat dt3 = DateFormat.getDateTimeInstance(3, 3, locale);

		DateFormat d1 = DateFormat.getDateInstance(3, locale);
		DateFormat d2 = DateFormat.getDateInstance(2, locale);
		DateFormat d3 = DateFormat.getDateInstance(1, locale);
		DateFormat d4 = new SimpleDateFormat("yyyy-MM-dd");

		DateFormat rfc3399 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		DateFormat dt4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		DateFormat[] dfs = { dt1, dt2, dt3, rfc3399, dt4, d1, d2, d3, d4 };
		return dfs;
	}

}
