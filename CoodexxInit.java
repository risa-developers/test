package Coodexx;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.jdom2.JDOMException;

import gr.Util.fileSys;

import Coodexx.DataBase.DataBase;
import Coodexx.Kernel.PathInfo;
import Coodexx.Kernel.Vars;
import Coodexx.startup.ReadWriteIniFile;

// this is aggelos branch
public class CoodexxInit
{
	private static boolean initialized = false;
	public CoodexxInit(String iniFile) throws SQLException, IOException, JDOMException
	{
		
		System.out.println("initialized:" + initialized);
		if (initialized)
			return;
		try
		{
			
			System.out.println("1ini file path:" + new File(iniFile).getAbsolutePath());
			System.out.println("Working directory: " + System.getProperty("user.dir"));
			PathInfo.setPath(fileSys.CurDir());
			new fileSys(PathInfo.getPath());
			Vars.setUpApplicationSpecificSettings();
			new gr.Util.Datatypes();
			Vars.setIniFile(new File(iniFile));
			Vars.getBasicApplication().getLocale();
			ReadWriteIniFile.setIniParams();
			PathInfo.setAdminPath(PathInfo.getPath() + fileSys.DIRECTORY + "data" + fileSys.DIRECTORY + "admin");
			PathInfo.setDataPath(PathInfo.getPath() + fileSys.DIRECTORY + "data" + fileSys.DIRECTORY + "rawdata");
			new DataBase();
			new Coodexx.Security.DBMethods();
			initialized = true;
		}
		catch (IOException e)
		{
			// File not found exception can be serialized, so we will throw an
			// IOException
			e.printStackTrace();
			throw new IOException(e.getMessage()+"merge");

		}

		System.out.println("initializAAAAA2222222222222222222222Aed:");
	}
	
}
