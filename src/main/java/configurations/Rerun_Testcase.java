package configurations;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun_Testcase implements IRetryAnalyzer{

	private int retry=0;
	private static final int maxcount =0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retry < maxcount) {
			retry++;
			return true;
		}
		return false;
	}

}
