package qr_goats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.delphinity.qr_goats.domain.PasswordHashing;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;

public class TestPasswordHashing {
	@Test
	public void PasswordHashing() {
		String broodje = "broodje";

		try {
			assertTrue(PasswordHashing.verifyPassword(broodje, PasswordHashing.createHash(broodje)));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidHashException e) {
			e.printStackTrace();
		}
	}
}
