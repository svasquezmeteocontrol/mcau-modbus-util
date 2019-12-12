package com.meteocontrol.modbus.adapters;

import java.nio.ByteBuffer;

public class Modbus32BitsEncoder {

	/**
	 * Reading the holding registers (when 32 bits) through Modbus the response
	 * comes in 4 bytes being the last two bytes the most significant ones that is
	 * why is necessary this conversion. The word (32 bits) order is low register
	 * before high register (little endian) The byte order is high byte before low
	 * byte (big endian)
	 * 
	 * @param toEncode
	 * @return
	 */
	public static byte[] encodeRequest(byte[] toEncode) {
		byte[] encoded = new byte[4];

		encoded[0] = toEncode[2];
		encoded[1] = toEncode[3];
		encoded[2] = toEncode[0];
		encoded[3] = toEncode[1];

		return encoded;
	}

	public static byte[] encodeFloatRequest(float toEncode) {
		return encodeRequest(ByteBuffer.allocate(4).putFloat(toEncode).array());
	}

	public static byte[] encodeIntRequest(int toEncode) {
		return encodeRequest(ByteBuffer.allocate(4).putInt(toEncode).array());
	}

}
