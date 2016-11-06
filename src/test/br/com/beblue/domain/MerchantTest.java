package br.com.beblue.domain;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class MerchantTest {
	
	private Merchant m;
	private HashMap<DayOfWeek, Double> cashbacks;
	private DateFormat sdf = new SimpleDateFormat("EEEE",Locale.US);
	
	@Before
	public void setUp() {
		m = new Merchant("Estabelecimento de Teste");
		cashbacks = new HashMap<>();
		cashbacks.put(DayOfWeek.SUNDAY, 5d);
		cashbacks.put(DayOfWeek.MONDAY, 10d);
		cashbacks.put(DayOfWeek.TUESDAY, 15d);
		cashbacks.put(DayOfWeek.WEDNESDAY, 20d);
		cashbacks.put(DayOfWeek.THURSDAY, 25d);
		cashbacks.put(DayOfWeek.FRIDAY, 30d);
		cashbacks.put(DayOfWeek.SATURDAY, 35d);
	}

	@Test
	public void setCashBackMerchant() {
		m.setCashbacks(cashbacks);
		assertEquals(Double.valueOf(5), m.getCashbacks().get(DayOfWeek.SUNDAY));
	}
	
	@Test
	public void getCashBackFromString() {
		m.setCashbacks(cashbacks);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dayOfWeek = sdf.format(d);
		Double value = m.getCashBackFromString(dayOfWeek);
		assertEquals(Double.valueOf(5.0), value);
	}
	
	@Test
	public void cashbackMonday() {
		Date day = null;
		try {
			day = new SimpleDateFormat("dd-MM-yyyy").parse("07-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(day).toUpperCase()));
		assertEquals(Double.valueOf(10.0), d);
	}
	
	@Test
	public void cashbackTuesday() {
		Date tue = null;
		try {
			tue = new SimpleDateFormat("dd-MM-yyyy").parse("08-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(tue).toUpperCase()));
		assertEquals(Double.valueOf(15.0), d);
	}
	
	@Test
	public void cashbackWed() {
		Date wed = null;
		try {
			wed = new SimpleDateFormat("dd-MM-yyyy").parse("09-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(wed).toUpperCase()));
		assertEquals(Double.valueOf(20.0), d);
	}
	
	@Test
	public void cashbackThursday() {
		Date thu = null;
		try {
			thu = new SimpleDateFormat("dd-MM-yyyy").parse("10-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(thu).toUpperCase()));
		assertEquals(Double.valueOf(25.0), d);
	}
	
	@Test
	public void cashbackFriday() {
		Date fri = null;
		try {
			fri = new SimpleDateFormat("dd-MM-yyyy").parse("11-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(fri).toUpperCase()));
		assertEquals(Double.valueOf(30.0), d);
	}
	
	@Test
	public void cashbackSaturday() {
		Date sat = null;
		try {
			sat = new SimpleDateFormat("dd-MM-yyyy").parse("12-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(sat).toUpperCase()));
		assertEquals(Double.valueOf(35.0), d);
	}
	
	@Test
	public void cashbackSunday() {
		Date sunday = null;
		try {
			sunday = new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double d = cashbacks.get(DayOfWeek.valueOf(sdf.format(sunday).toUpperCase()));
		assertEquals(Double.valueOf(5.0), d);
	}

}
