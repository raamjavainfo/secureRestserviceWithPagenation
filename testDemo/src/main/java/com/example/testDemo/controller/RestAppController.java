package com.example.testDemo.controller;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testDemo.dao.TransactionDAO;
import com.example.testDemo.model.CSVObject;
import com.opencsv.CSVReader;

@RestController
public class RestAppController {

	@Autowired
	private TransactionDAO dao;

	//  request : http://localhost.8080/testDemo/transactionByCustId=222?start=1?size=10
	@GetMapping("/transactionByCustId")
	List<CSVObject> getTransactionByCustomerId(@RequestParam("id") String id, @QueryParam("start") int start,
			@QueryParam("size") int size) {

		List<CSVObject> modelData = dao.findByCustomerId(id);
		if (start >= 0 && size >= 0) {
			modelData = modelData.subList(start, size);
		}

		return modelData;
	}

	@GetMapping("/transactionByAccountNumber")
	List<CSVObject> getTransactionByAccountNumber(@RequestParam("id") String id, @QueryParam("start") int start,
			@QueryParam("size") int size) {

		List<CSVObject> modelData = dao.findByCustomerId(id);
		if (start >= 0 && size >= 0) {
			modelData = modelData.subList(start, size);
		}
		return modelData;
	}

	public void onlyOnceExecuteToInsert() {

		List<CSVObject> modelData = new ArrayList<CSVObject>();

		// parsing a CSV file into Scanner class constructor
		/*
		 * Scanner sc; try { URL resource =
		 * getClass().getClassLoader().getResource("data.txt"); sc = new Scanner(new
		 * File(resource.getFile())); sc.useDelimiter(","); //sets the delimiter pattern
		 * int i = 0; while (sc.hasNext()) //returns a boolean value {
		 * //System.out.print(sc.findInLine("/t")); System.out.print(sc.next()); //find
		 * and returns the next complete token from this scanner
		 * 
		 * } sc.close(); //closes the scanner
		 * 
		 * // dao.saveAll(modelData); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		// CsvIOFactory.createFactory(CSVObject.class);

		CSVReader reader = null;
		try {
			URL resource = getClass().getClassLoader().getResource("datasource.txt");

			reader = new CSVReader(new FileReader(resource.getFile()));
			String[] nextLine;
			int i = 0;
			// read one line at a time
			while ((nextLine = reader.readNext()) != null) {
				for (String token : nextLine) {
					if (i == 0) {
						i++;
						continue;
					}
					// System.out.println(token);

					CSVObject csv = new CSVObject();
					StringTokenizer st = new StringTokenizer(token, "|");
					int j = 0;
					while (st.hasMoreTokens()) {
						if (j == 0) {
							csv.setAccountNumber(st.nextToken());
						}
						if (j == 1) {
							csv.setTrxAmount(st.nextToken());
						}
						if (j == 2) {
							csv.setDesc(st.nextToken());
						}
						if (j == 3) {
							csv.setTrxDate(st.nextToken());
						}
						if (j == 4) {
							csv.setTrxTime(st.nextToken());
						}
						if (j == 5) {
							csv.setCustomerId(st.nextToken());
						}

						j++;

					}
					modelData.add(csv);

				}
				// System.out.print("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dao.saveAll(modelData);
		/*int k = 0;
		for (CSVObject obj : modelData) {
			System.out.println("customer ID: " + obj.getCustomerId());
			k++;

		}
		System.out.println(k);*/

	}

	/*public static void main(String a[]) {
		RestAppController con = new RestAppController();
		con.onlyOnceExecuteToInsert();
	}*/

}
