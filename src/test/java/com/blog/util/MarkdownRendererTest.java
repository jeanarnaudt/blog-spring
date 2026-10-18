package com.blog.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownRendererTest {

    private final MarkdownRenderer renderer = new MarkdownRenderer();

    @Test
    void rendersHeading() {
        assertEquals("<h1>Hi</h1>\n", renderer.toHtml("# Hi"));
    }

    @Test
    void rendersPipeTable() {
        String markdown = """
                | a | b |
                |---|---|
                | 1 | 2 |
                """;
        assertTrue(renderer.toHtml(markdown).contains("<table>"));
    }

    @Test
    void escapesRawHtml() {
        String html = renderer.toHtml("<script>alert(1)</script>");
        assertTrue(html.contains("&lt;script&gt;"));
        assertFalse(html.contains("<script>"));
    }

    @Test
    void returnsEmptyForNullOrBlank() {
        assertEquals("", renderer.toHtml(null));
        assertEquals("", renderer.toHtml("   "));
    }
}
