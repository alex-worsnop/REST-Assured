package datadriven;
import org.testng.annotations.DataProvider;

public class DataForTests {
	

//		Using Object because it can store both strings and integers etc
		
//	@DataProvider(name = "DataUsersForPost1")
//	public Object [] [] dataForPost() {
//		
//		Object [] [] data = new Object[2][3]; //(2 columns and 3 rows)
//		
//		data [0][0] = "Albert"; //(1st row, 1st column)
//		data [0][1] = "Einstein"; //(1st row, 2nd column)
//		data [0][2] = 2; //(1st row, 3rd column)
//		
//		data [1][0] = "Thomas"; //(2nd row, 1st column)
//		data [1][1] = "Edison"; //(2nd row, 2nd column)
//		data [1][2] = 1; //(2nd row, 3rd column)
//		
//		return data;
//	}	
	
	@DataProvider(name = "DataUsersForPost")
		public Object [] [] dataForPost() {
			
			return new Object [][] {
				{"Graham", "Bell", 1},
				{"Henry", "Ford", 2},
				{"Hillary", "Rodham", 2}
			};
		}
		
		@DataProvider(name = "DeleteUsersData")
		public Object[] DataUsersForDelete() {
			
			return new Object[] {
					4,5,6
			};

		}

}
