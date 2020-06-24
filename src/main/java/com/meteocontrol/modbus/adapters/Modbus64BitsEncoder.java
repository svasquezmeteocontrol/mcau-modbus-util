package com.meteocontrol.modbus.adapters;

import java.nio.ByteBuffer;

public class Modbus64BitsEncoder {

	public static byte[] encodeRequest(byte[] toEncode) {
		byte[] encoded = new byte[8];

		encoded[0] = toEncode[6];
		encoded[1] = toEncode[7];
		encoded[2] = toEncode[4];
		encoded[3] = toEncode[5];
		encoded[4] = toEncode[2];
		encoded[5] = toEncode[3];
		encoded[6] = toEncode[0];
		encoded[7] = toEncode[1];

		return encoded;
	}

	public static byte[] encodeDoubleRequest(float toEncode) {
		return encodeRequest(ByteBuffer.allocate(8).putDouble(toEncode).array());
	}

	public static byte[] encodeLongRequest(int toEncode) {
		return encodeRequest(ByteBuffer.allocate(8).putLong(toEncode).array());
	}

}
