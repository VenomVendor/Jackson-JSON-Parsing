package vee.demo.jackson.json.parsing;

import java.io.IOException;
import org.apache.http.impl.client.BasicCookieStore;
import venom.vendor.string.downloader.StringDownloader;
import venom.vendor.string.downloader.StringDownloaderListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GetJSON extends Activity {

	String		url	= "http://dl.dropboxusercontent.com/u/40690073/soDemo.json";
	TextView	mDisplayData;
	String		tag	= "vee.demo.jackson.json.parsing";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.dummy);
		mDisplayData = (TextView) findViewById(R.id.displayData);

		StringDownloader downloader = new StringDownloader(this , false);

		downloader.setStringDownloadListener(new StringDownloaderListener() {

			@Override
			public String stringDownloadedSuccessfully(String result ,
					String url , int number , BasicCookieStore cookie) {
				return null;
			}

			@Override
			public void stringFetchingFailed(String reasonForFailure ,
					String url , int number , BasicCookieStore cookieStore) {
				// TODO Auto-generated method stub
				Log.d(tag , "Failure Msg :: " + reasonForFailure);
			}

			@Override
			public void errorInServerSide(int statusCode ,
					String statusDescription , String url , int i ,
					BasicCookieStore cookieStore) {
				// TODO Auto-generated method stub
				Log.d(tag , "Error in Server Side");
			}

			@Override
			public void isAllStringsDownloadedSuccessfully(boolean status ,
					String lastFetchedResult) {
				// TODO Auto-generated method stub
				Log.v(tag , "status" + " :: " + status);
				StartParsing(lastFetchedResult);
			}

		});

		downloader.execute(url);
	}

	protected void StartParsing(String result) {

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserDetails userDetails = objectMapper.readValue(result , UserDetails.class);

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(result);

			sBuilder.append("\n\n\n" + userDetails.getFirst_name());
			sBuilder.append("\n" + userDetails.getLast_name());
			sBuilder.append("\n" + userDetails.getCity());

			System.out.println(userDetails.getCity());

			for(int i = 0; i < userDetails.getUser_user().size(); i++) {

				sBuilder.append("\n\n"
						+ userDetails.getUser_user().get(i).getId());
				sBuilder.append("\n"
						+ userDetails.getUser_user().get(i).getDomain());

				System.out.println(userDetails.getUser_user().get(i).getId());
				System.out.println(userDetails.getUser_user().get(i)
						.getDomain());

				try {
					for(int k = 0; k < userDetails.getUser_user().get(i)
							.getFav_colors().size(); k++) {
						System.out.println(userDetails.getUser_user().get(i)
								.getFav_colors().get(k));
						sBuilder.append("\n"
								+ userDetails.getUser_user().get(i)
										.getFav_colors().get(k));

					}
				}
				catch (Exception e) {
					System.out.println("NO FAV COLORS");
				}

			}

			mDisplayData.setText(sBuilder.toString() + "\n\n");

		}
		catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
