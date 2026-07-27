package java17.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * Exercice 07 - Instant
 */
public class DateAndTime_07_Test {

	@Test
	public void test_date_to_localdate() throws Exception {

		// TODO Créer une date Java 1 (12/02/2017)
		Date date = new GregorianCalendar(2017, Calendar.FEBRUARY, 12).getTime();

		// TODO transformer la date en Instant
		Instant result1 = date.toInstant();

		// TODO transformer la date en LocalDate
		LocalDate result2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// TODO valoriser les différentes variables afin de rendre le test passant
		Date date1 = new GregorianCalendar(2017, Calendar.FEBRUARY, 12).getTime();
		LocalDate result = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		assertThat(result.getYear(), is(2017));
		assertThat(result.getMonth(), is(Month.FEBRUARY));
		assertThat(result.getDayOfMonth(), is(12));

	}
}
