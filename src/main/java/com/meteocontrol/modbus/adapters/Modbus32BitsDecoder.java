package com.meteocontrol.modbus.adapters;

import java.nio.ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

public class Modbus32BitsDecoder {

	/**
	 * Reading the holding registers (when 32 bits) through Modbus the response
	 * comes in 4 bytes being the last two bytes the most significant ones that is why
	 * is necessary this conversion.
	 * The word (32 bits) order is low register before high register (little endian)
	 * The byte order is high byte before low byte (big endian)
	 * @param byteBuf
	 * @return
	 */
	public static byte[] decodeResponse(ByteBuf byteBuf) {

		byte[] swappingBuffer = new byte[4];

		swappingBuffer[0] = byteBuf.getByte(2);
		swappingBuffer[1] = byteBuf.getByte(3);
		swappingBuffer[2] = byteBuf.getByte(0);
		swappingBuffer[3] = byteBuf.getByte(1);
		
		byteBuf.release();

		return swappingBuffer;
	}
	
	public static float getFloatFromRegisterResponse(ByteBuf byteBuf) {
		
		return ByteBuffer.wrap(decodeResponse(byteBuf)).getFloat();
	}
	
	public static int getIntFromRegisterResponse(ByteBuf byteBuf) {
		
		return ByteBuffer.wrap(decodeResponse(byteBuf)).getInt();
	}
	
	public static String getHexDumpFromRegisterResponse(ByteBuf byteBuf) {
		return ByteBufUtil.hexDump(byteBuf);
	}

}
