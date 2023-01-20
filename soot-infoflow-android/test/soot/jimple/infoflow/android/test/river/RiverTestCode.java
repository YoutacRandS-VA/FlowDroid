package soot.jimple.infoflow.android.test.river;

import fj.data.IO;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;

public class RiverTestCode {
    public static String source() {
        return "secret";
    }

    public void riverTest1() {
        try {
            String src = source();

            URL url = new URL("http://some.url");
            URLConnection con = url.openConnection();

            OutputStream os = con.getOutputStream();

            OutputStream osb = new BufferedOutputStream(os);
            osb.write(src.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest2() {
        try {
            String src = source();

            OutputStream os = new ByteArrayOutputStream();

            OutputStream osb = new BufferedOutputStream(os);
            osb.write(src.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest3() {
        try {
            String src = source();

            URL url = new URL("http://some.url");
            URLConnection con = url.openConnection();

            OutputStream os = con.getOutputStream();

            BufferedOutputStream osb = new BufferedOutputStream(os);
            osb.write(src.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest4() {
        try {
            String src = source();

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            BufferedOutputStream osb = new BufferedOutputStream(os);
            osb.write(src.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest5() {
        try {
            String src = source();

            URL url = new URL("http://some.url");
            URLConnection con = url.openConnection();

            OutputStream os = con.getOutputStream();

            new BufferedWriter(new OutputStreamWriter(os)).write(src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest6() {
        try {
            String src = source();

            OutputStream os = new ByteArrayOutputStream();

            new BufferedWriter(new OutputStreamWriter(os)).write(src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void riverTest7() {
        try {
            String src1 = source();
            String src2 = source();

            URL url = new URL("http://some.url");
            URLConnection con = url.openConnection();

            OutputStream os1 = con.getOutputStream();
            OutputStream os2 = new ByteArrayOutputStream();

            OutputStream os1b = new BufferedOutputStream(os1);
            OutputStream os2b = new BufferedOutputStream(os2);

            os1b.write(src1.getBytes());
            os2.write(src2.getBytes());

            new BufferedWriter(new OutputStreamWriter(os1b)).write(src1);
            new BufferedWriter(new OutputStreamWriter(os2b)).write(src2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
