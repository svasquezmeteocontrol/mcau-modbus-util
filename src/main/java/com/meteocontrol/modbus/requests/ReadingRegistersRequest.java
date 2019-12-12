package com.meteocontrol.modbus.requests;

import java.util.concurrent.CompletableFuture;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.requests.ReadHoldingRegistersRequest;
import com.digitalpetri.modbus.responses.ReadHoldingRegistersResponse;

public class ReadingRegistersRequest {
	
	public static CompletableFuture<ReadHoldingRegistersResponse> readHoldingRegisters(ModbusTcpMaster modbusTcpMaster, int regiterAddress, int regiterQuantity, int unitId){
		
		return modbusTcpMaster.sendRequest(new ReadHoldingRegistersRequest(regiterAddress, regiterQuantity), unitId);
	}
	
	public static CompletableFuture<ReadHoldingRegistersResponse> read32BitsHoldingRegisters(ModbusTcpMaster modbusTcpMaster, int regiterAddress, int unitId){
		
		return readHoldingRegisters(modbusTcpMaster, regiterAddress, 2, unitId);
	}

}
