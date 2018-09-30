package form16;

public class test1 extends ExcelApiTest {

	public static void main(String[] args) throws Exception {
		
////		String id="ID : 8000005010";
////		String[] ids=id.split(":");
////		System.out.println(ids[1]);
//		
		//ExcelApiTest eat = new ExcelApiTest("C:\\Users\\ajay1.biswal\\Desktop\\TestData.xlsx");
        //ExcelApiTest.setCellData("NewReqTab",1,4,"8000005013");
        String id=sheet.getRow(2).getCell(5).getStringCellValue();
        System.out.println(id);
//        eat.setCellData("Credentials",0,1,"PASS1");
				

	}

}
