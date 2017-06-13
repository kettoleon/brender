package com.github.kettoleon.brender;

import com.github.kettoleon.brender.model.CommunicationBody;

public interface RenderEngine {

    String render(String template, MimeType mimeType, CommunicationBody communicationBody);
}
