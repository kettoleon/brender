package com.github.kettoleon.brender;

import org.junit.Test;

import java.io.IOException;

import static com.github.kettoleon.brender.MimeType.TEXT;
import static com.github.kettoleon.brender.TestUtils.testRenderEngine;

public class RenderEngineTests {

    RenderEngine thymeleafRenderEngine = new ThymeleafRenderEngine();

    RenderEngine freemarkerRenderEngine = new FreeMarkerRenderEngine();

    public RenderEngineTests() throws IOException {
    }

    @Test
    public void testRenderEngines() throws IOException {

        /*testRenderEngine(thymeleafRenderEngine, "fixed", TEXT);
        testRenderEngine(thymeleafRenderEngine, "simple", TEXT);
        testRenderEngine(thymeleafRenderEngine, "list", TEXT);
*/
        testRenderEngine(freemarkerRenderEngine, "fixed", TEXT);
        testRenderEngine(freemarkerRenderEngine, "simple", TEXT);
        testRenderEngine(freemarkerRenderEngine, "list", TEXT);

    }


}
