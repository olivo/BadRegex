import java.io.*;
import java.util.regex.*;

class AndroidTester {

    public static void test_DOMAIN_NAME(){

	Pattern p = AndroidPatterns.DOMAIN_NAME;	

	String hostName = generate_HOST_NAME();

	System.out.println(hostName.length());

	Matcher m = p.matcher(hostName);

	System.out.println(m.matches());
    }

    public static void test_WEB_URL(){

	Pattern p = AndroidPatterns.WEB_URL;	

	String hostName = generate_HOST_NAME();

	System.out.println(hostName.length());

	Matcher m = p.matcher(hostName);

	System.out.println(m.matches());
    }

    public static String generate_HOST_NAME(){

	StringBuilder res = new StringBuilder();

	int N = 600;

	StringBuilder sb;
	// Correct constructions of IRI.
	for(int k = 0; k < N - 1; k++) {
	    
	    sb = new StringBuilder();	

	    sb.append("a");

	    for(int i = 0; i < 61; i++) {
		sb.append("b");
	    }
	
	    sb.append("c");

	    sb.append(".");
	    
	    res.append(sb);
	}

	// Incorrect construction of the last IRI.
	sb = new StringBuilder();	

	sb.append("a");

	for(int i = 0; i < 61; i++) {
	    sb.append("b");
	}
	
	sb.append("c");

	//sb.append(".");
	    
	// GLTD
	sb.append("e");
	sb.append("f");

	res.append(sb);

	return res.toString();
    }

    public static void main(String[] args) {

	//test_DOMAIN_NAME();
	test_WEB_URL();
    }
}
