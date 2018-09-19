package blue.sparse.kmc.bukkit;

import blue.sparse.maven.MavenArtifact;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

public final class KotlinLoader {
	
	private static final String KOTLIN_GROUP    = "org.jetbrains.kotlin";
	private static final String KOTLIN_EAP_REPO = "http://dl.bintray.com/kotlin/kotlin-eap/";
	
	private static final MavenArtifact ANNOTATIONS = new MavenArtifact("org.jetbrains", "annotations");
	
	private static final MavenArtifact COROUTINES_CORE = new MavenArtifact("org.jetbrains.kotlinx", "kotlinx-coroutines-core");
	
	private static final MavenArtifact STDLIB      = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-stdlib");
	private static final MavenArtifact STDLIB_JDK8 = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-stdlib-jdk8");
	private static final MavenArtifact STDLIB_JDK7 = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-stdlib-jdk7");
	private static final MavenArtifact REFLECT     = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-reflect");
	
	private static final MavenArtifact COMPILER = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-compiler-embeddable");
	private static final MavenArtifact SCRIPT   = new MavenArtifact(KOTLIN_EAP_REPO, KOTLIN_GROUP, "kotlin-script-runtime");
	
	private static final List<MavenArtifact> ARTIFACTS = Arrays.asList(
			ANNOTATIONS,
			COROUTINES_CORE,
			STDLIB,
			STDLIB_JDK8,
			STDLIB_JDK7,
			REFLECT,
			COMPILER,
			SCRIPT
	);
	
	private KotlinLoader() {}
	
	public static void downloadAndLoad(File folder) throws IOException, ReflectiveOperationException {
		final URLClassLoader classLoader = getClassLoader();
		
		for(MavenArtifact artifact : ARTIFACTS) {
			final String latestVersion = artifact.getLatestVersion();
			
			final File file = new File(folder, artifact.getFileName(latestVersion));
			if(!file.exists())
				artifact.download(latestVersion, folder);
			
			load(classLoader, file);
		}
		
	}
	
	private static void load(URLClassLoader classLoader, File jar) throws MalformedURLException, ReflectiveOperationException {
		addURL(classLoader, jar.toURI().toURL());
	}
	
	private static void addURL(URLClassLoader loader, URL url) throws ReflectiveOperationException {
		final Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
		addURL.setAccessible(true);
		addURL.invoke(loader, url);
	}
	
	private static URLClassLoader getClassLoader() {
		final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		if(systemClassLoader instanceof URLClassLoader)
			return (URLClassLoader) systemClassLoader;
		
		final ClassLoader classLoader = KotlinLoader.class.getClassLoader();
		final ClassLoader parent = classLoader.getParent();
		if(parent instanceof URLClassLoader)
			return (URLClassLoader) parent;
		
		if(classLoader instanceof URLClassLoader)
			return (URLClassLoader) classLoader;
		
		return null;
	}
}
