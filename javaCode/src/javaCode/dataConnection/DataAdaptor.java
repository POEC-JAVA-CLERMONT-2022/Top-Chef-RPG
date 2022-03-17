package javaCode.dataConnection;

import javaCode.Cook;

public class DataAdaptor {
	private DataInJava DataJ;
	private DataInBDD DataB;

	public DataAdaptor()
	{
		// variable que l'on pourrait récupérer dans un fichier de config
		/*String env = "dev";
		if (env.equals("dev"))
		{
			DataInJava DataJ = new DataInJava();
		}
		else
		{
			DataInBDD DataB = new DataInBDD();
		}*/
		DataInJava DataJ = new DataInJava();
	}
	
	public void SaveCook (Cook cook)
	{
		this.DataJ.saveCook(cook);
	}
}
