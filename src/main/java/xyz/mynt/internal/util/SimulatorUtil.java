package xyz.mynt.internal.util;

import java.util.Random;

public class SimulatorUtil {
	
	private final static String idKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	public static String getTransactionID() {
        
        StringBuilder transID = new StringBuilder();
        Random rnd = new Random();
        while (transID.length() < 15) {
            int index = (int) (rnd.nextFloat() * idKey.length());
            transID.append(idKey.charAt(index));
        }
        return transID.toString();

    }
}
