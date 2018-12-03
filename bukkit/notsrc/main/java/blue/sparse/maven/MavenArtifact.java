package blue.sparse.maven;

import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class MavenArtifact {
	
	public static final String REPO_MAVEN_CENTRAL = "http://repo1.maven.org/maven2/";
	
	public final String repo;
	public final String group;
	public final String id;
	
	private final String url;
	
	public MavenArtifact(String group, String id) {
		this(REPO_MAVEN_CENTRAL, group, id);
	}
	
	public MavenArtifact(String repo, String group, String id) {
		this.repo = repo;
		this.group = group;
		this.id = id;
		
		this.url = repo + group.replace('.', '/') + '/' + id + '/';
	}
	
	public File downloadLatest(File folder) throws IOException {
		return download(getLatestVersion(), folder);
	}
	
	public File download(String version, File folder) throws IOException {
		final String url = this.url + version + '/' + id + '-' + version + ".jar";
		final File target = new File(folder, getFileName(version));
		downloadFile(url, target);
		return target;
	}
	
	@Nullable
	public String getLatestVersion() throws IOException {
		final String xmlString = downloadText(url + "maven-metadata.xml");
		final int begin;
		final int end;
		
		final int latestIndex = xmlString.indexOf("<latest>");
		if(latestIndex == -1) {
			begin = xmlString.indexOf("<release>") + 9;
			end = xmlString.indexOf("</release>");
			if(end == -1)
				return null;
		}else {
			begin = latestIndex + 8;
			end = xmlString.indexOf("</latest>");
		}
		
		return xmlString.substring(begin, end);
	}
	
	public String getFileName(String version) {
		return group + '-' + id + '$' + version + ".jar";
	}
	
	private static void downloadFile(String urlString, File target) throws IOException {
		final URL url = new URL(urlString);
		final URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "sparse-mc-api");
		target.getAbsoluteFile().getParentFile().mkdirs();
		try(final InputStream in = conn.getInputStream()) {
			Files.copy(in, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	private static String downloadText(String urlString) throws IOException {
		final URL url = new URL(urlString);
		final URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "sparse-mc-api");
		
		final StringWriter result = new StringWriter();
		try(final InputStream in = conn.getInputStream()) {
			IOUtils.copy(in, result);
		}
		return result.toString();
	}
	
	public String getLatestFileName() throws IOException {
		return getFileName(getLatestVersion());
	}
	
}
