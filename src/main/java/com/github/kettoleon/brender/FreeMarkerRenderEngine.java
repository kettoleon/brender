package com.github.kettoleon.brender;

import com.github.kettoleon.brender.model.CommunicationBody;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerRenderEngine implements RenderEngine {

    private final Configuration cfg;

    public FreeMarkerRenderEngine() throws IOException {
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.25) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_25);

        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources/freemarker"));

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);
    }

    public String render(String template, MimeType mimeType, CommunicationBody communicationBody) {
        try {
            Template temp = cfg.getTemplate(template + ".ftlh");
            Writer out = new StringWriter();
            temp.process(model(communicationBody), out);
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, Object> model(CommunicationBody communicationBody) {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("communicationBody", communicationBody);
        return root;
    }
}
