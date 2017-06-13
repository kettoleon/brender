package com.github.kettoleon.brender;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import java.io.File;
import java.io.IOException;

import static com.github.kettoleon.brender.ExampleModel.communicationBody;
import static com.github.kettoleon.brender.MimeType.HTML;
import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtils {

    public static String getExpectedValue(String template, MimeType mimeType) throws IOException {
        return readFileToString(new File("src/test/resources/expected/" + template + (mimeType == HTML ? ".html" : ".txt")));
    }

    public static void testRenderEngine(RenderEngine renderEngine, String template, MimeType mimeType) throws IOException {

        String actualValue = renderEngine.render(template, mimeType, communicationBody());
        String expectedValue = getExpectedValue(template, mimeType);

        assertThat(format("Render failed for template %s and mimetype %s", template, mimeType), actualValue, equalTo(expectedValue));
    }

}
