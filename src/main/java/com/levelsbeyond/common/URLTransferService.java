package com.levelsbeyond.common;

import java.io.File;
import java.net.URL;

/**
 * Created by ericcobb on 4/28/14.
 */
public interface URLTransferService {

	public void downloadFromUrl(URL url, String path);
	public void uploadToUrl(URL url, File inputStream);
}
