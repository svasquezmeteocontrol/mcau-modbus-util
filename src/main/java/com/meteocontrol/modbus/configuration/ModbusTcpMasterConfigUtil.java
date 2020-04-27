package com.meteocontrol.modbus.configuration;

import java.util.HashMap;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;

public class ModbusTcpMasterConfigUtil {

	private static HashMap<String, ModbusTcpMaster> modbusTcpMasterHM = new HashMap<String, ModbusTcpMaster>();;

	public static ModbusTcpMaster getModbusTcpMaster(String ipAddress) {

		ModbusTcpMaster modbusTcpMaster = modbusTcpMasterHM.get(ipAddress);

		if (modbusTcpMaster == null) {
			ModbusTcpMasterConfig modbusConfig = new ModbusTcpMasterConfig.Builder(ipAddress).build();
			modbusTcpMaster = new ModbusTcpMaster(modbusConfig);
			modbusTcpMasterHM.put(ipAddress, modbusTcpMaster);
		}

		return modbusTcpMaster;
	}

	public static void clearModbusTcpMasterHM() {
		modbusTcpMasterHM.values().forEach(master -> {
			master.disconnect();
		});
		modbusTcpMasterHM.clear();
		modbusTcpMasterHM = null;
		modbusTcpMasterHM = new HashMap<String, ModbusTcpMaster>();
	}

}