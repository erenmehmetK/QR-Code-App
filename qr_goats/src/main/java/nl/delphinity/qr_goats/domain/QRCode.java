package nl.delphinity.qr_goats.domain;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class QRCode {
	private int activeSince; // unix timestamp (sec)
	public int getActiveSince() {
		return activeSince;
	}
	public void setActiveSince(int activeSince) {
		this.activeSince = activeSince;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activeSince);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QRCode other = (QRCode) obj;
		return activeSince == other.activeSince;
	}
	@Override
	public String toString() {
		return "QRCode [activeSince=" + activeSince + "]";
	}
	public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
			result.append("&");
		}
		String resultString = result.toString();
		return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
	}
	public String generateQR(Student student) {
		if (activeSince < activeSince + 60) { // werkt voor 1 minuut
			URL url;
			try {
				url = new URL("https://api.qrserver.com/v1/create-qr-code/");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				Map<String, String> params = new HashMap<>();
				params.put("size", "300x300");
				params.put("format", "svg");
				params.put("data", "236406");
				conn.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(conn.getOutputStream());
				out.writeBytes(getParamsString(params));
				out.flush();
				out.close();
				conn.setConnectTimeout(10000);
				conn.setReadTimeout(10000);
				BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				conn.disconnect();
				return content.toString();
			} catch (IOException e) {e.printStackTrace();}
			return null;
		} else {
			return "qr code expired";
		}
	}
}