package de.unitrier.st.soposthistorygt.util.anchorsURLs;

import java.util.regex.Pattern;

public class AnchorTextAndUrlPair {
    String fullMatch;
    String fullMatch2;
    String anchor;
    String reference;
    String url;
    String title;
    AnchorRefUrlType type;


    public enum AnchorRefUrlType{               // https://stackoverflow.com/editing-help#code
        // spanClassWithAnchorTextAndDirectURL,    // Here's a <span class="hi">[poorly-named link](http://www.google.com/ "Google")</span>. // TODO for Sebastian: ignore this case because it never appeared yet?
        type_markdownLinkBareTags,              // Have you ever seen <http://example.com>?
        type_anchorLink,                        // <a href="http://example.com" title="example">example</a>
        type_markdownLinkInline,                // e.g. Here's an inline link to [Google](http://www.google.com/).
        type_markdownLinkReference,             // e.g. Here's a reference-style link to [Google][1].   ...     and later   ...     [1]: http://www.google.com/
        type_bareURL,                                // I often visit http://example.com.
    }

    public static Pattern getRegexWithEnum(AnchorRefUrlType type){
        switch (type){
            // case spanClassWithAnchorTextAndDirectURL:
            //    return null;
            case type_markdownLinkBareTags:
                return MarkdownLinkBareTags.regex;
            case type_anchorLink:
                return AnchorLink.regex;
            case type_markdownLinkInline:
                return MarkdownLinkInline.regex;
            case type_markdownLinkReference:
                return MarkdownLinkReference.regex;
            case type_bareURL:
                return Link.regex;

            default:
                return null;
        }
    }


    AnchorTextAndUrlPair(String fullMatch, String anchor, String reference, String url, String title, AnchorRefUrlType anchorRefUrlType) {
        this.fullMatch = fullMatch;
        this.anchor = anchor;
        this.reference = reference;
        this.url = url;
        this.title = title;
        this.type = anchorRefUrlType;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "full match: " + fullMatch + "\n"
                + ((fullMatch2 != null)? "full match bottom: " + fullMatch2 + "\n" : "")
                + "anchor text: " + anchor + "\n"
                + "reference: " + reference + "\n"
                + "URL: " + url + "\n"
                + "Title: " + title + "\n"
                + "Type: " + type + "\n"
                + "\n";
    }
}
