
public class Main {

	public static void main(String[] args) {
		
		Data dat = new Data(); //import data from dat.txt file
		
		Login tttg = new Login( dat.loginInfo() );
		
		dat.dataSave(); //this method will be called by the Menu object!

	}

}
