package com.symphony.spring.api.trust;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import com.symphony.id.PemSymphonyIdentity;
import com.symphony.id.SymphonyIdentity;
import com.symphony.spring.api.TestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes={TestApplication.class})
@ActiveProfiles("crt")
public class PemTrustStoreConfigTest {

	@Autowired
	TrustManagerFactory tmf;
	
	@Autowired
	SymphonyIdentity id;
	
	/**
	 * Checks instantiation of trust managers
	 */
	@Test
	public void checkPemCertificatesWork() throws Exception {
		TrustManager[]  tm = tmf.getTrustManagers();
		Assert.assertEquals(1, tm.length);
		X509TrustManager t = (X509TrustManager) tm[0];

		InputStream so = this.getClass().getResourceAsStream("/stackoverflow.cer");
		X509Certificate cert = PemSymphonyIdentity.createCertificate(StreamUtils.copyToString(so, Charset.defaultCharset()));

		
		t.checkClientTrusted(new X509Certificate[] { cert }, "RSA");

	}
}
