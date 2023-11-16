package commonLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class ExcelHandler {
	private String username;
	private String password;
	private List<String> usernames = new ArrayList<>();
	private List<String> passwords = new ArrayList<>();
	public void loadExcelData() throws EncryptedDocumentException, IOException {
		String data = null;
		String path = "C:\\MyFolder\\TestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		//Sheet sheet = book.getSheetAt(0);
		Row row = sheet.getRow(1);
		int rowCnt = sheet.getLastRowNum() + 1;
		int colCnt = row.getLastCellNum();
		Cell cell = row.getCell(0);
		username = row.getCell(1).toString();
		password = row.getCell(2).toString();
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		for(int i=1;i<=rowCnt-1;i++) {
			row = sheet.getRow(i);
			for(int j=1;j<=colCnt-1;j++) {
				cell = row.getCell(j);
				data = cell.toString();
				System.out.print(data + "  ");
				if(j==1) {
					usernames.add(data);
				}
				else {
					passwords.add(data);
				}
			}
			System.out.println();
		}
		file.close();
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public List<String> getUsernames() {
		return usernames;
	}
	public List<String> getPasswords() {
		return passwords;
	}
	
	
}
