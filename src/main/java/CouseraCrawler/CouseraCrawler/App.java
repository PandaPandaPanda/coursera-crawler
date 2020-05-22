package CouseraCrawler.CouseraCrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import org.json.*;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;

import me.tongfei.progressbar.*;

/**
 * Hello world!
 *
 */
public class App {

	static final String link = "https://api.coursera.org/api/courses.v1?start=0&limit=2150&includes=v1Details";
	static ArrayList<Course> courseCareerRanking = new ArrayList<Course>();
	static ArrayList<Course> courseBenefitRanking = new ArrayList<Course>();
	static ArrayList<Course> coursePromotionRanking = new ArrayList<Course>();

	public static void main(String[] args) throws IOException {

		try (ProgressBar pb = new ProgressBar("Crawling...", 2000)) {

			String str = GET(link);
			JSONObject obj = new JSONObject(str);
			JSONArray arr = obj.getJSONArray("elements");

			pb.stepTo(2);

			for (int i = 0; i < arr.length(); i++) {
				JSONObject courseInfo = arr.getJSONObject(i);
				Course newCourse = new Course(courseInfo.getString("name"), courseInfo.getString("id"),
						courseInfo.getString("slug"));

				// Perform Jsoup request to Cousera and boolean test
				if (crawl(courseInfo.getString("slug"), newCourse)) {
					rankIt(courseCareerRanking, newCourse, 0);
					rankIt(courseBenefitRanking, newCourse, 1);
					rankIt(coursePromotionRanking, newCourse, 2);
				}
				pb.step();
			}
			pb.stepTo(2000);
			pb.setExtraMessage("This is pretty much it. Just need to write them into files.");
		}
		
		System.out.println("When a element has a value of -1, it means that element is not listed in Cousera");
		Gson gson = new Gson();
		String temp = gson.toJson(courseCareerRanking);
		writeFile("Cousera: New Career Ranking.json", temp);

		temp = gson.toJson(courseBenefitRanking);
		writeFile("Cousera: Tangible Benefit Ranking.json", temp);

		temp = gson.toJson(coursePromotionRanking);
		writeFile("Cousera: Promotion Ranking.json", temp);

		// What course is the best?
		System.out.println("Career: ");
		System.out.println("Name: " + courseCareerRanking.get(0).getName());
		System.out.println("Rate: " + courseCareerRanking.get(0).getCareer() + "%");

		System.out.println("Benefit: ");
		System.out.println("Name: " + courseBenefitRanking.get(0).getName());
		System.out.println("Rate: " + courseBenefitRanking.get(0).getBenefit() + "%");

		System.out.println("Promotion: ");
		System.out.println("Name: " + coursePromotionRanking.get(0).getName());
		System.out.println("Rate: " + coursePromotionRanking.get(0).getPromotion() + "%");
	}

	public static void writeFile(String name, String content) {
		try {
			File careerRankingFile = new File(name);
			if (careerRankingFile.createNewFile()) {
				System.out.println("File created: " + careerRankingFile.getName());
			} else {
				System.out.println("File already exists.");
			}

			// Write to file
			FileWriter myWriter = new FileWriter(careerRankingFile);

			myWriter.write(content);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static boolean crawl(String slug, Course course) {
		String url = "https://www.coursera.org/learn/" + slug;

		// Get Document object after parsing the html from given url.
		Document document;

		try {
			document = Jsoup.connect(url).get();

			Elements percentRates = document.select("._1l2q8kho.m-x-1.m-b-0");

			if (percentRates.size() == 6) { // Three stats: NewCareer, Benefit, Promotion

				StringBuffer number = new StringBuffer(percentRates.get(0).text()).deleteCharAt(2);
				course.updateCareer(Integer.parseInt(number.toString()));

				number = new StringBuffer(percentRates.get(1).text()).deleteCharAt(2);
				course.updateBenefit(Integer.parseInt(number.toString()));

				number = new StringBuffer(percentRates.get(2).text()).deleteCharAt(2);
				course.updatePromotion(Integer.parseInt(number.toString()));

				return true;

			} else if (percentRates.size() == 4) { // Two stats: NewCareer, Benefit
				StringBuffer number = new StringBuffer(percentRates.get(0).text()).deleteCharAt(2);
				course.updateCareer(Integer.parseInt(number.toString()));

				number = new StringBuffer(percentRates.get(1).text()).deleteCharAt(2);
				course.updateBenefit(Integer.parseInt(number.toString()));

				return true;

			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void rankIt(ArrayList<Course> list, Course course, int type) {
		switch (type) {
		// Career ranking
		case 0:
			int index0 = 0;
			while (index0 < list.size() && course.getCareer() < list.get(index0).getCareer()) {
				index0++;
			}

			list.add(index0, course);
			break;

		// Benefit ranking
		case 1:
			int index1 = 0;
			while (index1 < list.size() && course.getBenefit() < list.get(index1).getBenefit()) {
				index1++;
			}

			list.add(index1, course);
			break;

		// Promotion ranking
		case 2:
			int index2 = 0;
			while (index2 < list.size() && course.getPromotion() < list.get(index2).getPromotion()) {
				index2++;
			}

			list.add(index2, course);
			break;
		}
	}

	public static String GET(String link) throws IOException {
		URL url = new URL(link);
		URL urlForGetRequest = url;
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			// print result
			System.out.println("GET WORKED");

			// Return api information
			return response.toString();

			// GetAndPost.POSTRequest(response.toString());
		} else {
			System.out.println("GET NOT WORKED");
		}
		return null;
	}
}
