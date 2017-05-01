package mypack.net;
 
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Pattern2 {
 
	private Pattern patternTag, patternLink;
	private Matcher matcherTag, matcherLink;
 
	private static final String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
	private static final String HTML_A_HREF_TAG_PATTERN = 
		"\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
 
 
	public Pattern2() {
		patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
		patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
	}
 
	/**
	 * Validate html with regular expression
	 * 
	 * @param html
	 *            html content for validation
	 * @return Vector links and link text
	 */
	public Vector<HtmlLink> grabHTMLLinks(final String html) {
 
		Vector<HtmlLink> result = new Vector<HtmlLink>();
 
		matcherTag = patternTag.matcher(html);
		
		while (matcherTag.find()) {
 
			String href = matcherTag.group(1); // href
			String linkText = matcherTag.group(2); // link text
 
			matcherLink = patternLink.matcher(href);
			
			while (matcherLink.find()) {
 
				String link = matcherLink.group(1); // link
				System.out.println(link);
				HtmlLink obj = new HtmlLink();
				obj.setLink(link);
				obj.setLinkText(linkText);
 
				result.add(obj);
 
			}
 
		}
 
		return result;
 
	}
	public static void main(String arr[])
	{
		Pattern2 p=new Pattern2();
		System.out.println(p.grabHTMLLinks("<a href=a.html>abjkdl fdklfj dkl jfkdjfdjkl kljc</a>" +
				"<a href=test.jsp>This is text of second tag</a>"));
	}
 
	class HtmlLink {
 
		String link;
		String linkText;
 
		HtmlLink(){};
 
		@Override
		public String toString() {
			return new StringBuffer("Link : ").append(this.link)
			.append(" Link Text : ").append(this.linkText).toString();
		}
 
		public String getLink() {
			return link;
		}
 
		public void setLink(String link) {
			this.link = replaceInvalidChar(link);
		}
 
		public String getLinkText() {
			return linkText;
		}
 
		public void setLinkText(String linkText) {
			this.linkText = linkText;
		}
 
		private String replaceInvalidChar(String link){
			link = link.replaceAll("'", "");
			link = link.replaceAll("\"", "");
			return link;
		}
 
	}
}