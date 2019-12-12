package com.meteocontrol.modbus.requests;

import java.util.concurrent.CompletableFuture;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.requests.WriteMultipleRegistersRequest;
import com.digitalpetri.modbus.requests.WriteSingleRegisterRequest;
import com.digitalpetri.modbus.responses.WriteMultipleRegistersResponse;
import com.meteocontrol.modbus.adapters.Modbus32BitsEncoder;
import com.digitalpetri.modbus.responses.WriteSingleRegisterResponse;

public class WritingRegistersRequest {
	
	/**
	 * By default 16 bits register
	 * @param modbusTcpMaster
	 * @param registerAddres
	 * @param unitId
	 * @param valueToWrite
	 */
	public static CompletableFuture<WriteSingleRegisterResponse> writeRegister(ModbusTcpMaster modbusTcpMaster, int registerAddres, int unitId, int valueToWrite) {
		return modbusTcpMaster.sendRequest(new WriteSingleRegisterRequest(registerAddres, valueToWrite), unitId);
	}
	
	public static CompletableFuture<WriteMultipleRegistersResponse> writeFloat32BitsRegister(ModbusTcpMaster modbusTcpMaster, int registerAddres, int unitId, float valueToWrite) {
		return modbusTcpMaster.sendRequest(new WriteMultipleRegistersRequest(registerAddres, 2, Modbus32BitsEncoder.encodeFloatRequest(valueToWrite)), unitId);
	}
	
	public static CompletableFuture<WriteMultipleRegistersResponse> writeInt32BitsRegister(ModbusTcpMaster modbusTcpMaster, int registerAddres, int unitId, int valueToWrite) {
		return modbusTcpMaster.sendRequest(new WriteMultipleRegistersRequest(registerAddres, 2, Modbus32BitsEncoder.encodeIntRequest(valueToWrite)), unitId);
	}

}
