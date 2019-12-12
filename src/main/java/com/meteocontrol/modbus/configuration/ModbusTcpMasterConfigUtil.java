package com.meteocontrol.modbus.configuration;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;

public class ModbusTcpMasterConfigUtil {

	public static ModbusTcpMaster configModbusTcpMasterConnected(String ipAddress) {
		ModbusTcpMasterConfig modbusConfig = new ModbusTcpMasterConfig.Builder(ipAddress).build();
		ModbusTcpMaster modbusTcpMaster = new ModbusTcpMaster(modbusConfig);
		
		
		return modbusTcpMaster;
	}
	
	public static void connect(ModbusTcpMaster modbusTcpMaster) {
//		CompletableFuture<ModbusTcpMaster> futureConnection = modbusTcpMaster.connect();
		modbusTcpMaster.connect();
	}

}
