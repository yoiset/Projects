package es.dgoj.rgiaj.util;
//package es.dgoj.rgiaj.util;
//
//import static org.junit.Assert.*;
//
//import java.io.FileInputStream;
//import java.net.URL;
//
//import org.junit.Test;
//
//public class UtilidadCertificadosTest {
//
//	@Test
//	public void testDecodeBase64StringNormal() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String datosBase64 = "MIID2DCCA0GgAwIBAgIEPNWk8jANBgkqhkiG9w0BAQUFADA2MQswCQYDVQQGEwJFUzENMAsGA1UEChMERk5NVDEYMBYGA1UECxMPRk5NVCBDbGFzZSAyIENBMB4XDTExMTAzMTE0MDk1OFoXDTE1MTAzMTE0MDk1OFoweDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTERMA8GA1UECxMIUFVCTElDT1MxEjAQBgNVBAsTCTUwMDA3MDAxNTEZMBcGA1UEAxQQKi5DTkpVRUdPLkdPQi5FUzCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAqFVAJpqcKOkAgJQSo6tUmehRoj3iLX0IDKgVzxCXlrxug713DVYB+OT8yPYKZ6cwNwJem7UK2I4FtIW6fGi4FJVctGIgjEeel860OZ1RsicOwRo4h88JQIXS3AOH+AT93AhXUUBOIVP0wOsn53Gav90p1H4Ku+lA6iedJnPOujsCAwEAAaOCAa8wggGrMIGeBgNVHREEgZYwgZOkfzB9MRcwFQYJKwYBBAGsZgEPEwhTMjgwMTE5RjE4MDYGCSsGAQQBrGYBDhQpRGlyZWNjafNuIEdlbmVyYWwgZGUgT3JkZW5hY2nzbiBkZWwgSnVlZ28xKDAmBgkrBgEEAaxmAQgUGXdpbGRjYXJkICouQ05KVUVHTy5HT0IuRVOCECouQ05KVUVHTy5HT0IuRVMwCQYDVR0TBAIwADArBgNVHRAEJDAigA8yMDExMTAzMTE0MDk1OFqBDzIwMTUxMDMxMTQwOTU4WjALBgNVHQ8EBAMCBaAwEwYDVR0lBAwwCgYIKwYBBQUHAwEwEQYJYIZIAYb4QgEBBAQDAgZAMB0GA1UdDgQWBBSvk1EWqGg8224PUw1RrvCS0TqgOzAfBgNVHSMEGDAWgBRAmnZEl3QHxKwUyx6NTzpFfDDXYTBbBgNVHR8EVDBSMFCgTqBMpEowSDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTEQMA4GA1UEAxMHQ1JMOTI4ODANBgkqhkiG9w0BAQUFAAOBgQBaJpeIY0CF3QSDbjgGWAOIx6tGBgdJLih5sNhslQiHR9alQM9PZGbuMBFl6oUTjm2hR481OUOBI/Jzv96ro/UrXwW9786scfbmBdCryiFumKjAH50jqnEnj3EQ4QrRzbpKzC4d8Hr5fLEqkwhUlHWlYdd9e+6qt3POnkvrm/FBQQ==";
//		byte[] datos = utilidad.decodeBase64(datosBase64);
//		byte[] expected = {48, -126, 3, -40, 48, -126, 3, 65, -96, 3, 2, 1, 2, 2, 4, 60, -43, -92, -14, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 54, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 48, 30, 23, 13, 49, 49, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 23, 13, 49, 53, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 48, 120, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 49, 17, 48, 15, 6, 3, 85, 4, 11, 19, 8, 80, 85, 66, 76, 73, 67, 79, 83, 49, 18, 48, 16, 6, 3, 85, 4, 11, 19, 9, 53, 48, 48, 48, 55, 48, 48, 49, 53, 49, 25, 48, 23, 6, 3, 85, 4, 3, 20, 16, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -88, 85, 64, 38, -102, -100, 40, -23, 0, -128, -108, 18, -93, -85, 84, -103, -24, 81, -94, 61, -30, 45, 125, 8, 12, -88, 21, -49, 16, -105, -106, -68, 110, -125, -67, 119, 13, 86, 1, -8, -28, -4, -56, -10, 10, 103, -89, 48, 55, 2, 94, -101, -75, 10, -40, -114, 5, -76, -123, -70, 124, 104, -72, 20, -107, 92, -76, 98, 32, -116, 71, -98, -105, -50, -76, 57, -99, 81, -78, 39, 14, -63, 26, 56, -121, -49, 9, 64, -123, -46, -36, 3, -121, -8, 4, -3, -36, 8, 87, 81, 64, 78, 33, 83, -12, -64, -21, 39, -25, 113, -102, -65, -35, 41, -44, 126, 10, -69, -23, 64, -22, 39, -99, 38, 115, -50, -70, 59, 2, 3, 1, 0, 1, -93, -126, 1, -81, 48, -126, 1, -85, 48, -127, -98, 6, 3, 85, 29, 17, 4, -127, -106, 48, -127, -109, -92, 127, 48, 125, 49, 23, 48, 21, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 15, 19, 8, 83, 50, 56, 48, 49, 49, 57, 70, 49, 56, 48, 54, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 14, 20, 41, 68, 105, 114, 101, 99, 99, 105, -13, 110, 32, 71, 101, 110, 101, 114, 97, 108, 32, 100, 101, 32, 79, 114, 100, 101, 110, 97, 99, 105, -13, 110, 32, 100, 101, 108, 32, 74, 117, 101, 103, 111, 49, 40, 48, 38, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 8, 20, 25, 119, 105, 108, 100, 99, 97, 114, 100, 32, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, -126, 16, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, 48, 9, 6, 3, 85, 29, 19, 4, 2, 48, 0, 48, 43, 6, 3, 85, 29, 16, 4, 36, 48, 34, -128, 15, 50, 48, 49, 49, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, -127, 15, 50, 48, 49, 53, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 48, 11, 6, 3, 85, 29, 15, 4, 4, 3, 2, 5, -96, 48, 19, 6, 3, 85, 29, 37, 4, 12, 48, 10, 6, 8, 43, 6, 1, 5, 5, 7, 3, 1, 48, 17, 6, 9, 96, -122, 72, 1, -122, -8, 66, 1, 1, 4, 4, 3, 2, 6, 64, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -81, -109, 81, 22, -88, 104, 60, -37, 110, 15, 83, 13, 81, -82, -16, -110, -47, 58, -96, 59, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 64, -102, 118, 68, -105, 116, 7, -60, -84, 20, -53, 30, -115, 79, 58, 69, 124, 48, -41, 97, 48, 91, 6, 3, 85, 29, 31, 4, 84, 48, 82, 48, 80, -96, 78, -96, 76, -92, 74, 48, 72, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 67, 82, 76, 57, 50, 56, 56, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 90, 38, -105, -120, 99, 64, -123, -35, 4, -125, 110, 56, 6, 88, 3, -120, -57, -85, 70, 6, 7, 73, 46, 40, 121, -80, -40, 108, -107, 8, -121, 71, -42, -91, 64, -49, 79, 100, 102, -18, 48, 17, 101, -22, -123, 19, -114, 109, -95, 71, -113, 53, 57, 67, -127, 35, -14, 115, -65, -34, -85, -93, -11, 43, 95, 5, -67, -17, -50, -84, 113, -10, -26, 5, -48, -85, -54, 33, 110, -104, -88, -64, 31, -99, 35, -86, 113, 39, -113, 113, 16, -31, 10, -47, -51, -70, 74, -52, 46, 29, -16, 122, -7, 124, -79, 42, -109, 8, 84, -108, 117, -91, 97, -41, 125, 123, -18, -86, -73, 115, -50, -98, 75, -21, -101, -15, 65, 65};
//		assertEquals(expected.length, datos.length);
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i], datos[i]);
//		}
//	}
//
//	@Test
//	public void testDecodeBase64StringVacio() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String datosBase64 = "";
//		byte[] datos = utilidad.decodeBase64(datosBase64);
//		byte[] expected = {};
//		assertEquals(expected.length, datos.length);
//	}
//	
//	@Test
//	public void testDecodeBase64Null() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String datosBase64 = null;
//		byte[] datos = utilidad.decodeBase64(datosBase64);
//		assertNull(datos);
//	}
//
//	@Test
//	public void testEncodeBase64StringNormal() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		byte[] datos = {48, -126, 3, -40, 48, -126, 3, 65, -96, 3, 2, 1, 2, 2, 4, 60, -43, -92, -14, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 54, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 48, 30, 23, 13, 49, 49, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 23, 13, 49, 53, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 48, 120, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 49, 17, 48, 15, 6, 3, 85, 4, 11, 19, 8, 80, 85, 66, 76, 73, 67, 79, 83, 49, 18, 48, 16, 6, 3, 85, 4, 11, 19, 9, 53, 48, 48, 48, 55, 48, 48, 49, 53, 49, 25, 48, 23, 6, 3, 85, 4, 3, 20, 16, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -88, 85, 64, 38, -102, -100, 40, -23, 0, -128, -108, 18, -93, -85, 84, -103, -24, 81, -94, 61, -30, 45, 125, 8, 12, -88, 21, -49, 16, -105, -106, -68, 110, -125, -67, 119, 13, 86, 1, -8, -28, -4, -56, -10, 10, 103, -89, 48, 55, 2, 94, -101, -75, 10, -40, -114, 5, -76, -123, -70, 124, 104, -72, 20, -107, 92, -76, 98, 32, -116, 71, -98, -105, -50, -76, 57, -99, 81, -78, 39, 14, -63, 26, 56, -121, -49, 9, 64, -123, -46, -36, 3, -121, -8, 4, -3, -36, 8, 87, 81, 64, 78, 33, 83, -12, -64, -21, 39, -25, 113, -102, -65, -35, 41, -44, 126, 10, -69, -23, 64, -22, 39, -99, 38, 115, -50, -70, 59, 2, 3, 1, 0, 1, -93, -126, 1, -81, 48, -126, 1, -85, 48, -127, -98, 6, 3, 85, 29, 17, 4, -127, -106, 48, -127, -109, -92, 127, 48, 125, 49, 23, 48, 21, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 15, 19, 8, 83, 50, 56, 48, 49, 49, 57, 70, 49, 56, 48, 54, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 14, 20, 41, 68, 105, 114, 101, 99, 99, 105, -13, 110, 32, 71, 101, 110, 101, 114, 97, 108, 32, 100, 101, 32, 79, 114, 100, 101, 110, 97, 99, 105, -13, 110, 32, 100, 101, 108, 32, 74, 117, 101, 103, 111, 49, 40, 48, 38, 6, 9, 43, 6, 1, 4, 1, -84, 102, 1, 8, 20, 25, 119, 105, 108, 100, 99, 97, 114, 100, 32, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, -126, 16, 42, 46, 67, 78, 74, 85, 69, 71, 79, 46, 71, 79, 66, 46, 69, 83, 48, 9, 6, 3, 85, 29, 19, 4, 2, 48, 0, 48, 43, 6, 3, 85, 29, 16, 4, 36, 48, 34, -128, 15, 50, 48, 49, 49, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, -127, 15, 50, 48, 49, 53, 49, 48, 51, 49, 49, 52, 48, 57, 53, 56, 90, 48, 11, 6, 3, 85, 29, 15, 4, 4, 3, 2, 5, -96, 48, 19, 6, 3, 85, 29, 37, 4, 12, 48, 10, 6, 8, 43, 6, 1, 5, 5, 7, 3, 1, 48, 17, 6, 9, 96, -122, 72, 1, -122, -8, 66, 1, 1, 4, 4, 3, 2, 6, 64, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -81, -109, 81, 22, -88, 104, 60, -37, 110, 15, 83, 13, 81, -82, -16, -110, -47, 58, -96, 59, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 64, -102, 118, 68, -105, 116, 7, -60, -84, 20, -53, 30, -115, 79, 58, 69, 124, 48, -41, 97, 48, 91, 6, 3, 85, 29, 31, 4, 84, 48, 82, 48, 80, -96, 78, -96, 76, -92, 74, 48, 72, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 69, 83, 49, 13, 48, 11, 6, 3, 85, 4, 10, 19, 4, 70, 78, 77, 84, 49, 24, 48, 22, 6, 3, 85, 4, 11, 19, 15, 70, 78, 77, 84, 32, 67, 108, 97, 115, 101, 32, 50, 32, 67, 65, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 67, 82, 76, 57, 50, 56, 56, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 90, 38, -105, -120, 99, 64, -123, -35, 4, -125, 110, 56, 6, 88, 3, -120, -57, -85, 70, 6, 7, 73, 46, 40, 121, -80, -40, 108, -107, 8, -121, 71, -42, -91, 64, -49, 79, 100, 102, -18, 48, 17, 101, -22, -123, 19, -114, 109, -95, 71, -113, 53, 57, 67, -127, 35, -14, 115, -65, -34, -85, -93, -11, 43, 95, 5, -67, -17, -50, -84, 113, -10, -26, 5, -48, -85, -54, 33, 110, -104, -88, -64, 31, -99, 35, -86, 113, 39, -113, 113, 16, -31, 10, -47, -51, -70, 74, -52, 46, 29, -16, 122, -7, 124, -79, 42, -109, 8, 84, -108, 117, -91, 97, -41, 125, 123, -18, -86, -73, 115, -50, -98, 75, -21, -101, -15, 65, 65};
//		String datosBase64 = utilidad.encodeBase64(datos); 
//		String expected = "MIID2DCCA0GgAwIBAgIEPNWk8jANBgkqhkiG9w0BAQUFADA2MQswCQYDVQQGEwJFUzENMAsGA1UEChMERk5NVDEYMBYGA1UECxMPRk5NVCBDbGFzZSAyIENBMB4XDTExMTAzMTE0MDk1OFoXDTE1MTAzMTE0MDk1OFoweDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTERMA8GA1UECxMIUFVCTElDT1MxEjAQBgNVBAsTCTUwMDA3MDAxNTEZMBcGA1UEAxQQKi5DTkpVRUdPLkdPQi5FUzCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAqFVAJpqcKOkAgJQSo6tUmehRoj3iLX0IDKgVzxCXlrxug713DVYB+OT8yPYKZ6cwNwJem7UK2I4FtIW6fGi4FJVctGIgjEeel860OZ1RsicOwRo4h88JQIXS3AOH+AT93AhXUUBOIVP0wOsn53Gav90p1H4Ku+lA6iedJnPOujsCAwEAAaOCAa8wggGrMIGeBgNVHREEgZYwgZOkfzB9MRcwFQYJKwYBBAGsZgEPEwhTMjgwMTE5RjE4MDYGCSsGAQQBrGYBDhQpRGlyZWNjafNuIEdlbmVyYWwgZGUgT3JkZW5hY2nzbiBkZWwgSnVlZ28xKDAmBgkrBgEEAaxmAQgUGXdpbGRjYXJkICouQ05KVUVHTy5HT0IuRVOCECouQ05KVUVHTy5HT0IuRVMwCQYDVR0TBAIwADArBgNVHRAEJDAigA8yMDExMTAzMTE0MDk1OFqBDzIwMTUxMDMxMTQwOTU4WjALBgNVHQ8EBAMCBaAwEwYDVR0lBAwwCgYIKwYBBQUHAwEwEQYJYIZIAYb4QgEBBAQDAgZAMB0GA1UdDgQWBBSvk1EWqGg8224PUw1RrvCS0TqgOzAfBgNVHSMEGDAWgBRAmnZEl3QHxKwUyx6NTzpFfDDXYTBbBgNVHR8EVDBSMFCgTqBMpEowSDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTEQMA4GA1UEAxMHQ1JMOTI4ODANBgkqhkiG9w0BAQUFAAOBgQBaJpeIY0CF3QSDbjgGWAOIx6tGBgdJLih5sNhslQiHR9alQM9PZGbuMBFl6oUTjm2hR481OUOBI/Jzv96ro/UrXwW9786scfbmBdCryiFumKjAH50jqnEnj3EQ4QrRzbpKzC4d8Hr5fLEqkwhUlHWlYdd9e+6qt3POnkvrm/FBQQ==";
//		assertEquals(expected.length(), datosBase64.length());
//		assertEquals(expected, datosBase64);
//	}
//
//	@Test
//	public void testEncodeBase64StringVacio() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		byte[] datos = {};
//		String datosBase64 = utilidad.encodeBase64(datos); 
//		String expected = "";
//		assertEquals(expected.length(), datosBase64.length());
//	}
//	
//	@Test
//	public void testEncodeBase64StringNull() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		byte[] datos = null;
//		String datosBase64 = utilidad.encodeBase64(datos); 
//		assertNull(datosBase64);
//	}
//
//	@Test
//	public void testCalcularHashCertificadoSinRetornoLinea() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String certificado = "MIICtDCCAh0CCQCZB/OIdOHO9TANBgkqhkiG9w0BAQUFADCBnzELMAkGA1UEBhMCZXMxDzANBgNVBAgMBm1hZHJpZDEPMA0GA1UEBwwGbWFkcmlkMQ8wDQYDVQQKDAZDQURHT0oxFjAUBgNVBAsMDUNBSU5GT1JNQVRJQ0ExFzAVBgNVBAMMDmNuanVlZ28uZ29iLmVzMSwwKgYJKoZIhvcNAQkBFh1kZ29qLnNvcG9ydGVvcGVyYWRvcmVzQG1laC5lczAeFw0xMTExMTYxMjMwMDNaFw0yMTA5MjQxMjMwMDNaMIGcMQswCQYDVQQGEwJlczEPMA0GA1UECAwGbWFkcmlkMQ8wDQYDVQQHDAZtYWRyaWQxETAPBgNVBAoMCG9wZXJhZG9yMREwDwYDVQQLDAhvcGVyYWRvcjEXMBUGA1UEAwwOY25qdWVnby5nb2IuZXMxLDAqBgkqhkiG9w0BCQEWHWRnb2ouc29wb3J0ZW9wZXJhZG9yZXNAbWVoLmVzMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCr+jsE8atjTGBm9UCHPNMN8trU1cxkkvvHQxP+nVHAL2BCJSyb2CYYqFzqmoO0lhByr8Yw2nf5NWyjl1LPqxz871VyfB8kTi6uR9jCtL6NhUDR8fCmxV0CfY10ajlcIHjSkziVGO6MvXeaEGz3/0O1TiRr+SKm4Y9m+qqaun287QIDAQABMA0GCSqGSIb3DQEBBQUAA4GBAIXH1VHRRYaOe975xV1F3tTRiW3e5i7njhDBeFGpQtMFg1LRl78+E0IY5CgMHOVgny3qHEyOU0hkv/Nu+OTFpb49NrZCDDGMyhX2wP/UmTVGtmv68W4CxGf0HPbRudjRynC/oyQi9WmI0vw/Kg4Nghx7PZT41Hi97tZweSEEcI1L";
//		String hash = utilidad.calcularHashCertificado(certificado); 
//		String expected = "8Mtqm/8fyKc4AszApw1XaDKdRMg=";
//		assertEquals(expected, hash);
//	}
//	
//	@Test
//	public void testCalcularHashCertificadoConRetornoLinea() {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String certificado = "MIID2DCCA0GgAwIBAgIEPNWk8jANBgkqhkiG9w0BAQUFADA2MQswCQYDVQQGEwJF\r\n" + 
//			"UzENMAsGA1UEChMERk5NVDEYMBYGA1UECxMPRk5NVCBDbGFzZSAyIENBMB4XDTEx\r\n" +
//			"MTAzMTE0MDk1OFoXDTE1MTAzMTE0MDk1OFoweDELMAkGA1UEBhMCRVMxDTALBgNV\r\n" +
//			"BAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTERMA8GA1UECxMIUFVC\r\n" +
//			"TElDT1MxEjAQBgNVBAsTCTUwMDA3MDAxNTEZMBcGA1UEAxQQKi5DTkpVRUdPLkdP\r\n" +
//			"Qi5FUzCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAqFVAJpqcKOkAgJQSo6tU\r\n" +
//			"mehRoj3iLX0IDKgVzxCXlrxug713DVYB+OT8yPYKZ6cwNwJem7UK2I4FtIW6fGi4\r\n" +
//			"FJVctGIgjEeel860OZ1RsicOwRo4h88JQIXS3AOH+AT93AhXUUBOIVP0wOsn53Ga\r\n" +
//			"v90p1H4Ku+lA6iedJnPOujsCAwEAAaOCAa8wggGrMIGeBgNVHREEgZYwgZOkfzB9\r\n" +
//			"MRcwFQYJKwYBBAGsZgEPEwhTMjgwMTE5RjE4MDYGCSsGAQQBrGYBDhQpRGlyZWNj\r\n" +
//			"afNuIEdlbmVyYWwgZGUgT3JkZW5hY2nzbiBkZWwgSnVlZ28xKDAmBgkrBgEEAaxm\r\n" +
//			"AQgUGXdpbGRjYXJkICouQ05KVUVHTy5HT0IuRVOCECouQ05KVUVHTy5HT0IuRVMw\r\n" +
//			"CQYDVR0TBAIwADArBgNVHRAEJDAigA8yMDExMTAzMTE0MDk1OFqBDzIwMTUxMDMx\r\n" +
//			"MTQwOTU4WjALBgNVHQ8EBAMCBaAwEwYDVR0lBAwwCgYIKwYBBQUHAwEwEQYJYIZI\r\n" +
//			"AYb4QgEBBAQDAgZAMB0GA1UdDgQWBBSvk1EWqGg8224PUw1RrvCS0TqgOzAfBgNV\r\n" +
//			"HSMEGDAWgBRAmnZEl3QHxKwUyx6NTzpFfDDXYTBbBgNVHR8EVDBSMFCgTqBMpEow\r\n" +
//			"SDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xh\r\n" +
//			"c2UgMiBDQTEQMA4GA1UEAxMHQ1JMOTI4ODANBgkqhkiG9w0BAQUFAAOBgQBaJpeI\r\n" +
//			"Y0CF3QSDbjgGWAOIx6tGBgdJLih5sNhslQiHR9alQM9PZGbuMBFl6oUTjm2hR481\r\n" +
//			"OUOBI/Jzv96ro/UrXwW9786scfbmBdCryiFumKjAH50jqnEnj3EQ4QrRzbpKzC4d\r\n" +
//			"8Hr5fLEqkwhUlHWlYdd9e+6qt3POnkvrm/FBQQ==";
//		String hash = utilidad.calcularHashCertificado(certificado); 
//		String expected = "XVFcf1qnbl6jgruNxRXfwV0qS6E=";
//		assertEquals(expected, hash);
//	}
//	
//	@Test
//	public void testCalcularHashCertificadoDesdeFichero() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		URL path = this.getClass().getResource("/certificado_operador8.crt");
//		String hash = utilidad.calcularHashCertificado(new FileInputStream(path.getFile())); 
//		String expected = "XVFcf1qnbl6jgruNxRXfwV0qS6E=";
//		assertEquals(expected, hash);
//	}
//
//	/**
//	 * En este caso el fichero es correcto y contiene un certificado válido
//	 */
//	@Test
//	public void testGetFingerDesdeFicheroCorrecto() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		URL path = this.getClass().getResource("/certificado_operador8.crt");
//		String finger = utilidad.getFingerPrint(new FileInputStream(path.getFile()));
//		String expected = "5C:4C:CC:D1:05:6F:69:21:80:73:5D:28:99:7E:B8:DB:87:32:B4:99";
//		assertEquals(expected, finger);
//	}
//	
//	/**
//	 * En este caso el fichero no contiene un certificado válido
//	 */
//	@Test
//	public void testGetFingerDesdeFicheroError() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		URL path = this.getClass().getResource("/certificado_operador8_error.crt");
//		try {
//			String finger = utilidad.getFingerPrint(new FileInputStream(path.getFile()));
//			assertTrue("Esperaba una excepción porque el certificado no es correcto!", false);
//		} catch (Exception e) {
//			assertTrue(true);
//		}
//	}
//	
//	/**
//	 * En este caso el certificado es válido
//	 */
//	@Test
//	public void testGetFingerCorrecto() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String certificado = "-----BEGIN CERTIFICATE-----\r\n" +
//			"MIID2DCCA0GgAwIBAgIEPNWk8jANBgkqhkiG9w0BAQUFADA2MQswCQYDVQQGEwJF\r\n" +
//			"UzENMAsGA1UEChMERk5NVDEYMBYGA1UECxMPRk5NVCBDbGFzZSAyIENBMB4XDTEx\r\n" +
//			"MTAzMTE0MDk1OFoXDTE1MTAzMTE0MDk1OFoweDELMAkGA1UEBhMCRVMxDTALBgNV\r\n" +
//			"BAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xhc2UgMiBDQTERMA8GA1UECxMIUFVC\r\n" +
//			"TElDT1MxEjAQBgNVBAsTCTUwMDA3MDAxNTEZMBcGA1UEAxQQKi5DTkpVRUdPLkdP\r\n" +
//			"Qi5FUzCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAqFVAJpqcKOkAgJQSo6tU\r\n" +
//			"mehRoj3iLX0IDKgVzxCXlrxug713DVYB+OT8yPYKZ6cwNwJem7UK2I4FtIW6fGi4\r\n" +
//			"FJVctGIgjEeel860OZ1RsicOwRo4h88JQIXS3AOH+AT93AhXUUBOIVP0wOsn53Ga\r\n" +
//			"v90p1H4Ku+lA6iedJnPOujsCAwEAAaOCAa8wggGrMIGeBgNVHREEgZYwgZOkfzB9\r\n" +
//			"MRcwFQYJKwYBBAGsZgEPEwhTMjgwMTE5RjE4MDYGCSsGAQQBrGYBDhQpRGlyZWNj\r\n" +
//			"afNuIEdlbmVyYWwgZGUgT3JkZW5hY2nzbiBkZWwgSnVlZ28xKDAmBgkrBgEEAaxm\r\n" +
//			"AQgUGXdpbGRjYXJkICouQ05KVUVHTy5HT0IuRVOCECouQ05KVUVHTy5HT0IuRVMw\r\n" +
//			"CQYDVR0TBAIwADArBgNVHRAEJDAigA8yMDExMTAzMTE0MDk1OFqBDzIwMTUxMDMx\r\n" +
//			"MTQwOTU4WjALBgNVHQ8EBAMCBaAwEwYDVR0lBAwwCgYIKwYBBQUHAwEwEQYJYIZI\r\n" +
//			"AYb4QgEBBAQDAgZAMB0GA1UdDgQWBBSvk1EWqGg8224PUw1RrvCS0TqgOzAfBgNV\r\n" +
//			"HSMEGDAWgBRAmnZEl3QHxKwUyx6NTzpFfDDXYTBbBgNVHR8EVDBSMFCgTqBMpEow\r\n" +
//			"SDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xh\r\n" +
//			"c2UgMiBDQTEQMA4GA1UEAxMHQ1JMOTI4ODANBgkqhkiG9w0BAQUFAAOBgQBaJpeI\r\n" +
//			"Y0CF3QSDbjgGWAOIx6tGBgdJLih5sNhslQiHR9alQM9PZGbuMBFl6oUTjm2hR481\r\n" +
//			"OUOBI/Jzv96ro/UrXwW9786scfbmBdCryiFumKjAH50jqnEnj3EQ4QrRzbpKzC4d\r\n" +
//			"8Hr5fLEqkwhUlHWlYdd9e+6qt3POnkvrm/FBQQ==\r\n" +
//			"-----END CERTIFICATE-----"; 
//		String finger = utilidad.getFingerPrint(certificado);
//		String expected = "5C:4C:CC:D1:05:6F:69:21:80:73:5D:28:99:7E:B8:DB:87:32:B4:99";
//		assertEquals(expected, finger);
//	}
//	
//	/**
//	 * En este caso el certificado no es válido
//	 */
//	@Test
//	public void testGetFingerError() throws Exception {
//		UtilidadCertificados utilidad = new UtilidadCertificados();
//		String certificado = "-----BEGIN CERTIFICATE-----\r\n" +
//				"????????ZZZZZZZ@@@@@@+++++13DVYB+OT8yPYKZ6cwNwJem7UK2I4FtIW6fGi4\r\n" +
//				"????????ZZZZZZZ0OZ1RsicOwRo4h88JQIXS3AOH+AT93AhXUUBOIVP0wOsn53Ga\r\n" +
//				"????????ZZZZZZZdJnPOujsCAwEAAaOCAa8wggGrMIGeBgNVHREEgZYwgZOkfzB9\r\n" +
//				"MRcwFQYJKwYBBAGsZgEPEwhTMjgwMTE5RjE4MDYGCSsGAQQBrGYBDhQpRGlyZWNj\r\n" +
//				"afNuIEdlbmVyYWwgZGUgT3JkZW5hY2nzbiBkZWwgSnVlZ28xKDAmBgkrBgEEAaxm\r\n" +
//				"AQgUGXdpbGRjYXJkICouQ05KVUVHTy5HT0IuRVOCECouQ05KVUVHTy5HT0IuRVMw\r\n" +
//				"CQYDVR0TBAIwADArBgNVHRAEJDAigA8yMDExMTAzMTE0MDk1OFqBDzIwMTUxMDMx\r\n" +
//				"MTQwOTU4WjALBgNVHQ8EBAMCBaAwEwYDVR0lBAwwCgYIKwYBBQUHAwEwEQYJYIZI\r\n" +
//				"AYb4QgEBBAQDAgZAMB0GA1UdDgQWBBSvk1EWqGg8224PUw1RrvCS0TqgOzAfBgNV\r\n" +
//				"HSMEGDAWgBRAmnZEl3QHxKwUyx6NTzpFfDDXYTBbBgNVHR8EVDBSMFCgTqBMpEow\r\n" +
//				"SDELMAkGA1UEBhMCRVMxDTALBgNVBAoTBEZOTVQxGDAWBgNVBAsTD0ZOTVQgQ2xh\r\n" +
//				"c2UgMiBDQTEQMA4GA1UEAxMHQ1JMOTI4ODANBgkqhkiG9w0BAQUFAAOBgQBaJpeI\r\n" +
//				"Y0CF3QSDbjgGWAOIx6tGBgdJLih5sNhslQiHR9alQM9PZGbuMBFl6oUTjm2hR481\r\n" +
//				"OUOBI/Jzv96ro/UrXwW9786scfbmBdCryiFumKjAH50jqnEnj3EQ4QrRzbpKzC4d\r\n" +
//				"8Hr5fLEqkwhUlHWlYdd9e+6qt3POnkvrm/FBQQ==\r\n" +
//				"-----END CERTIFICATE-----"; 
//		try {
//			String finger = utilidad.getFingerPrint(certificado);
//			assertTrue("Esperaba una excepción porque el certificado no es correcto!", false);
//		} catch (Exception e) {
//			assertTrue(true);
//		}
//	}
//	
//	
//}
