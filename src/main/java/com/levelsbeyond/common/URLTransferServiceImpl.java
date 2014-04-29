package com.levelsbeyond.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ericcobb on 4/28/14.
 */
public class URLTransferServiceImpl implements URLTransferService {

	@Override
	public void downloadFromUrl(URL url, String path) {
		try {
			URLConnection connection = url.openConnection();
			int fileSize = connection.getContentLength();
			System.out.println(fileSize);

			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(new File(path));
			int total = 0;
			int count;
			while ((count = connection.getInputStream().read(buf)) != -1)
			{
				if (Thread.interrupted())
				{
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
				total += count;
				int pctComplete = new Double(new Double(total) / new Double(fileSize) * 100).intValue();
				System.out.print("\r");
				System.out.print(String.format("PCT Complete: %d", pctComplete));
			}

			System.out.println();
			out.close();
			connection.getInputStream().close();
			System.out.println("Completed copy.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void uploadToUrl(URL url, File file) {

		HttpURLConnection connection;
		try {
			InputStream inputStream = new FileInputStream(file);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			OutputStream out =
					connection.getOutputStream();

			byte[] buf = new byte[1024];
			int count;
			int total = 0;
			long fileSize = file.length();

			while ((count =inputStream.read(buf)) != -1)
			{
				if (Thread.interrupted())
				{
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
				total += count;
				int pctComplete = new Double(new Double(total) / new Double(fileSize) * 100).intValue();

				System.out.print("\r");
				System.out.print(String.format("PCT Complete: %d", pctComplete));
			}
			System.out.println();
			out.close();
			inputStream.close();

			System.out.println("Finishing...");
			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				System.out.printf("Successfully uploaded.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
