package javaCode.dataConnection;

import javaCode.Cook;

public class DataAdaptor {
	private InterfaceData dataProvider; 

	public DataAdaptor()
	{
		// variable que l'on pourrait récupérer dans un fichier de config
		String env = "dev";
		if (env.equals("dev"))
		{
			 dataProvider = new DataInJava();
		}
		else
		{
			 dataProvider = new DataInBDD();
		}
		//data = new DataInJava();
		
	}
	
	public void SaveCook (Cook cook)
	{
		this.dataProvider.saveCook(cook);
	}
}
