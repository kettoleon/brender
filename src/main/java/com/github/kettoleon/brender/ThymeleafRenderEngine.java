package com.github.kettoleon.brender;

import com.github.kettoleon.brender.model.CommunicationBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

public class ThymeleafRenderEngine implements RenderEngine {

    private TemplateEngine htmlEngine;
    private TemplateEngine textEngine;

    public ThymeleafRenderEngine() {
        initHtmlEngine();
        initTxtEngine();
    }

    public String render(String template, MimeType mimeType, CommunicationBody communicationBody) {

        StringWriter writer = new StringWriter();
        Context context = new Context();
        context.setVariable("communicationBody", communicationBody);

        if(mimeType == MimeType.HTML){
            htmlEngine.process(template, context, writer);
        }else{
            textEngine.process(template, context, writer);
        }
        return writer.toString();
    }

    private void initHtmlEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("XHTML");
        resolver.setSuffix(".html");
        resolver.setPrefix("thymeleaf/");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        htmlEngine = engine;
    }

    private void initTxtEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("TEXT");
        resolver.setSuffix(".txt");
        resolver.setPrefix("thymeleaf/");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        textEngine = engine;
    }

}
