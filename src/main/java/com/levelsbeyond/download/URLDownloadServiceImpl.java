package com.levelsbeyond.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by ericcobb on 4/28/14.
 */
public class URLDownloadServiceImpl implements URLDownloadService {

	@Override
	public void downloadFromUrl(URL url, String path) {
		try {
			InputStream inputStream = url.openStream();
			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(new File(path));
			int count;
			while ((count = inputStream.read(buf)) != -1)
			{
				if (Thread.interrupted())
				{
					throw new InterruptedException();
				}
				out.write(buf, 0, count);
			}
			out.close();
			inputStream.close();
			System.out.println("Completed copy.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
