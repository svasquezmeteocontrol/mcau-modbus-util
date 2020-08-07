package com.meteocontrol.modbus.adapters;

import java.nio.ByteBuffer;

import io.netty.buffer.ByteBuf;

public class Modbus64BitsDecoder {

	public static byte[] decodeResponse(ByteBuf byteBuf) {

		byte[] swappingBuffer = new byte[8];

		swappingBuffer[0] = byteBuf.getByte(6);
		swappingBuffer[1] = byteBuf.getByte(7);
		swappingBuffer[2] = byteBuf.getByte(4);
		swappingBuffer[3] = byteBuf.getByte(5);
		swappingBuffer[4] = byteBuf.getByte(2);
		swappingBuffer[5] = byteBuf.getByte(3);
		swappingBuffer[6] = byteBuf.getByte(0);
		swappingBuffer[7] = byteBuf.getByte(1);
		
		byteBuf.release();

		return swappingBuffer;
	}

	public static double getDoubleFromRegisterResponse(ByteBuf byteBuf) {

		return ByteBuffer.wrap(decodeResponse(byteBuf)).getDouble();
	}

	public static long getLongFromRegisterResponse(ByteBuf byteBuf) {

		return ByteBuffer.wrap(decodeResponse(byteBuf)).getLong();
	}

}