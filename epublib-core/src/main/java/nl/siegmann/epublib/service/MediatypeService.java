package nl.siegmann.epublib.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import nl.siegmann.epublib.domain.MediaType;
import nl.siegmann.epublib.util.StringUtil;


/**
 * Manages mediatypes that are used by epubs
 * 
 * @author paul
 *
 */
public class MediatypeService {

	public static final MediaType XHTML = new MediaType("application/xhtml+xml", ".xhtml", new String[] {".htm", ".html", ".xhtml"});
	public static final MediaType EPUB = new MediaType("application/epub+zip", ".epub");
	public static final MediaType NCX = new MediaType("application/x-dtbncx+xml", ".ncx");
	
	public static final MediaType JAVASCRIPT = new MediaType("text/javascript", ".js");
	public static final MediaType CSS = new MediaType("text/css", ".css");


	// images
	public static final MediaType JPG = new MediaType("image/jpeg", ".jpg", new String[] {".jpg", ".jpeg"});
	public static final MediaType PNG = new MediaType("image/png", ".png");
	public static final MediaType GIF = new MediaType("image/gif", ".gif");
	
	public static final MediaType SVG = new MediaType("image/svg+xml", ".svg");

	// fonts
	public static final MediaType OPENTYPE = new MediaType("application/vnd.ms-opentype", ".otf");
	public static final MediaType TTF = new MediaType("application/x-truetype-font", ".ttf");
	public static final MediaType WOFF = new MediaType("application/font-woff", ".woff");
	
	// audio
	public static final MediaType OGG = new MediaType("audio/ogg", ".ogg", new String[] {".ogg", ".oga"});
	public static final MediaType MP3 = new MediaType("audio/mpeg", ".mp3");
	public static final MediaType MP4 = new MediaType("audio/mp4", ".mp4");

	public static final MediaType SMIL = new MediaType("application/smil+xml", ".smil");
	public static final MediaType XPGT = new MediaType("application/adobe-page-template+xml", ".xpgt");
	public static final MediaType PLS = new MediaType("application/pls+xml", ".pls");

	
	//Additional media types
	public static final MediaType M4V = new MediaType("video/x-m4v", ".m4v");
	public static final MediaType WEBM = new MediaType("video/webm", ".webm");
	public static final MediaType WMV = new MediaType("video/wmv", ".wmv");
	public static final MediaType MOV = new MediaType("video/quicktime", ".mov", Arrays.asList(".mov", "qt"));
//	public static final MediaType MP4 = new MediaType("video/mp4", ".mp4");
	public static final MediaType MPEG_VIDEO = new MediaType("video/mpeg", ".mpeg", Arrays.asList(".mpeg", ".mpg", ".mpe"));
	public static final MediaType MIDI = new MediaType("audio/midi", ".midi", Arrays.asList(".midi", ".mid"));
	public static final MediaType MPEG_AUDIO = new MediaType("audio/mpeg", ".mp3", Arrays.asList(".mp3", ".mp2", ".mpga"));
	public static final MediaType WAV = new MediaType("audio/x-wav", ".wav", Arrays.asList(".wav", ".wav"));
	
	public static MediaType[] mediatypes = new MediaType[] {
		XHTML, EPUB, JPG, PNG, GIF, CSS, SVG, TTF, NCX, XPGT, OPENTYPE, WOFF, SMIL, PLS, JAVASCRIPT, MP3, MP4, OGG, 
		M4V, WEBM, MOV, MPEG_VIDEO, WMV, MIDI, MPEG_AUDIO, WAV
	};
	
	public static Map<String, MediaType> mediaTypesByName = new HashMap<String, MediaType>();
	static {
		for(int i = 0; i < mediatypes.length; i++) {
			mediaTypesByName.put(mediatypes[i].getName(), mediatypes[i]);
		}
	}
	
	public static boolean isBitmapImage(MediaType mediaType) {
		return mediaType == JPG || mediaType == PNG || mediaType == GIF;
	}
	
	/**
	 * Gets the MediaType based on the file extension.
	 * Null of no matching extension found.
	 * 
	 * @param filename
	 * @return
	 */
	public static MediaType determineMediaType(String filename) {
		for(int i = 0; i < mediatypes.length; i++) {
			MediaType mediatype = mediatypes[i];
			for(String extension: mediatype.getExtensions()) {
				if(StringUtil.endsWithIgnoreCase(filename, extension)) {
					return mediatype;
				}
			}
		}
		return null;
	}

	public static MediaType getMediaTypeByName(String mediaTypeName) {
		return mediaTypesByName.get(mediaTypeName);
	}
}
