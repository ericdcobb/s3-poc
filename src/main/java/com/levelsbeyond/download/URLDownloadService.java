package com.levelsbeyond.download;

import java.net.URL;

/**
 * Created by ericcobb on 4/28/14.
 */
public interface URLDownloadService {

	public void downloadFromUrl(URL url, String path);
}
