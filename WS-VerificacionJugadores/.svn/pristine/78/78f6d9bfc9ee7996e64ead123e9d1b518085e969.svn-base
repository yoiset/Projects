package es.gob.cnjuego.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

/**
 * Esta clase es utilizada por CXF para el parsing y formateo de los objetos de
 * tipo Date. 
 * Realmente es una copia de la implementación de org.apache.cxf.tools.common.DataTypeAdapter,
 * pero con una pequeña modificación para que aparezcan los milisegundos en
 * cuando se formatean objetos de tipo Date.
 * 
 * Este adapter se enlaza con JAXB a través de la declaración de los adapters en
 * el fichero "/resources/wsdl/binding_VerificacionJugadores.xml"
 */
public final class DataTypeAdapter {

	private DataTypeAdapter() {
	}

	public static Date parseDate(String s) {
		if (s == null) {
			return null;
		}
		SimpleDateFormat parse=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return parse.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String printDate(Date dt) {
		if (dt == null) {
			return null;
		}
		SimpleDateFormat parse=new SimpleDateFormat("yyyy-MM-dd");
		return parse.format(dt);
	}

	public static Date parseTime(String s) {
		if (s == null) {
			return null;
		}
		return DatatypeConverter.parseTime(s).getTime();
	}

	public static String printTime(Date dt) {
		if (dt == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		return DatatypeConverter.printTime(c);
	}

	public static Date parseDateTime(String s) {
		if (s == null) {
			return null;
		}
		return DatatypeConverter.parseDateTime(s).getTime();
	}

	/**
	 * Retorna un string con la fecha formateada hasta los milisegundos (aunque los 
	 * milisegundos sean 0).
	 * Ej de los valores devueltos: "2013-03-11T15:00:00.000+01:00"
	 */
	public static String printDateTime(Date dt) {
		if (dt == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		return CalendarFormatter.doFormat("%Y-%M-%DT%h:%m:%s%z", c);
		// La implementación original delega en DatatypeConverter:
		//return DatatypeConverter.printDateTime(c);
	}

	/**
	 * el código fuente de CalendarFormatter se extrajo de
	 * javax.xml.bind.DatatypeConverter
	 */
	private static final class CalendarFormatter {
		public static String doFormat(String format, Calendar cal) throws IllegalArgumentException {
			int fidx = 0;
			int flen = format.length();
			StringBuilder buf = new StringBuilder();

			while (fidx < flen) {
				char fch = format.charAt(fidx++);
				if (fch != '%') { // not a meta character
					buf.append(fch);
					continue;
				}
				// seen meta character. we don't do error check against the
				// format
				switch (format.charAt(fidx++)) {
				case 'Y': // year
					formatYear(cal, buf);
					break;
				case 'M': // month
					formatMonth(cal, buf);
					break;
				case 'D': // days
					formatDays(cal, buf);
					break;
				case 'h': // hours
					formatHours(cal, buf);
					break;
				case 'm': // minutes
					formatMinutes(cal, buf);
					break;
				case 's': // parse seconds.
					formatSeconds(cal, buf);
					break;
				case 'z': // time zone
					formatTimeZone(cal, buf);
					break;
				default:
					// illegal meta character. impossible.
					throw new InternalError();
				}
			}

			return buf.toString();
		}

		private static void formatYear(Calendar cal, StringBuilder buf) {
			int year = cal.get(Calendar.YEAR);
			String s;
			if (year <= 0) // negative value
			{
				s = Integer.toString(1 - year);
			} else // positive value
			{
				s = Integer.toString(year);
			}

			while (s.length() < 4) {
				s = '0' + s;
			}
			if (year <= 0) {
				s = '-' + s;
			}

			buf.append(s);
		}

		private static void formatMonth(Calendar cal, StringBuilder buf) {
			formatTwoDigits(cal.get(Calendar.MONTH) + 1, buf);
		}

		private static void formatDays(Calendar cal, StringBuilder buf) {
			formatTwoDigits(cal.get(Calendar.DAY_OF_MONTH), buf);
		}

		private static void formatHours(Calendar cal, StringBuilder buf) {
			formatTwoDigits(cal.get(Calendar.HOUR_OF_DAY), buf);
		}

		private static void formatMinutes(Calendar cal, StringBuilder buf) {
			formatTwoDigits(cal.get(Calendar.MINUTE), buf);
		}

		/**
		 * Agrega el valor de los milisegundos al final.
		 */
		private static void formatSeconds(Calendar cal, StringBuilder buf) {
			formatTwoDigits(cal.get(Calendar.SECOND), buf);
			buf.append(".000");
		}

		/** formats time zone specifier. */
		private static void formatTimeZone(Calendar cal, StringBuilder buf) {
			TimeZone tz = cal.getTimeZone();
			if (tz == null) {
				return;
			}
			// otherwise print out normally.
			int offset = tz.getOffset(cal.getTime().getTime());
			if (offset == 0) {
				buf.append('Z');
				return;
			}
			if (offset >= 0) {
				buf.append('+');
			} else {
				buf.append('-');
				offset *= -1;
			}
			offset /= 60 * 1000; // offset is in milli-seconds
			formatTwoDigits(offset / 60, buf);
			buf.append(':');
			formatTwoDigits(offset % 60, buf);
		}

		/** formats Integer into two-character-wide string. */
		private static void formatTwoDigits(int n, StringBuilder buf) {
			// n is always non-negative.
			if (n < 10) {
				buf.append('0');
			}
			buf.append(n);
		}
	}

}