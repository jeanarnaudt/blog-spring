package com.blog.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkdownRenderer {
	private final Parser parser;
	private final HtmlRenderer renderer;

	public MarkdownRenderer() {
		List<Extension> extensions = List.of(TablesExtension.create());
		this.parser = Parser.builder().extensions(extensions).build();
		this.renderer = HtmlRenderer.builder()
			.extensions(extensions)
			.escapeHtml(true)
			.build();
	}

	public String toHtml(String markdown) {
		if (markdown == null || markdown.isBlank()) {
			return "";
		}
		Node document = parser.parse(markdown);
		return renderer.render(document);
	}
}
