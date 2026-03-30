package br.edu.utfpr.tsi.td.raspador.atv.one;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class IgnoreSsl {

	public static void disableSSLVerification() {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Ignorar hostname também
			HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

		} catch (Exception e) {
			System.out.println("Erro ao desabilitar SSL");
		}
	}
}
